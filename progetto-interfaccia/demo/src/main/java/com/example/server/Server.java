package com.example.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CittadinoVaccinato;
import com.example.models.Indirizzo;
import com.example.models.Qualificatore;
import com.example.models.TipoCentro;
import com.example.models.TipoRuolo;
import com.example.models.TipoVaccino;
import com.example.models.loginCentro;

public class Server extends UnicastRemoteObject implements interfacciaServer{
    
    public Server() throws RemoteException{
        super();
        System.setProperty("java.rmi.server.hostname", "localhost");
    }
    private static Connection connection = null;

    public static void main(String[] args) {
        try{
            final int PORT = 9090;
            
            Server server = new Server();
            Registry registro = LocateRegistry.createRegistry(PORT);
            registro.rebind("server", server);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean ApriConnessioneDB(String url,String user,String password) throws ClassNotFoundException {
        System.out.println("Provo a connettermi al db...");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connesso al db con successo...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public void ChiudiConnessioneDB() throws SQLException {
        System.out.println("Chiudo connessione db...");
        connection.close();
    }

    public ArrayList<CentroVaccinale> getCentriVaccinali() {
        ArrayList<CentroVaccinale> centriVaccinali = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT * FROM CentriVaccinali";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                centriVaccinali.add(new CentroVaccinale(rs.getString(1), new Indirizzo(Qualificatore.valueOf(rs.getString(2)), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)), TipoCentro.valueOf(rs.getString(8))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(centriVaccinali);
        return centriVaccinali;
    }

    public ArrayList<CittadinoVaccinato> getCittadiniVaccinati(String centro) {
        ArrayList<CittadinoVaccinato> cittadiniVaccinati = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT * FROM CittadiniVaccinati WHERE nome_centro='" + centro + "'";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                cittadiniVaccinati.add(new CittadinoVaccinato(rs.getString(5), rs.getString(6), rs.getString(1), rs.getString(7), 
                rs.getString(3), TipoVaccino.valueOf(rs.getString(2)), rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(cittadiniVaccinati);
        return cittadiniVaccinati;
    }
    public ArrayList<loginCentro> getDatiLogin(){
        System.out.println("Recupero dati login...");
        ArrayList<loginCentro> loginCentro = new ArrayList<>();

        String query = "INSERT INTO public.Login (username, password, ruolo) VALUES ('{admin}', '{admin}', '{operatore}');";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                loginCentro.add(new loginCentro(rs.getString(0), rs.getString(1),TipoRuolo.valueOf(rs.getString(2))));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(loginCentro);
        return loginCentro;
    }
}
