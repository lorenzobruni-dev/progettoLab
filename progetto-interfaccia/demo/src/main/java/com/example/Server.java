package com.example;

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
import com.example.models.CittadinoRegistrato;
import com.example.models.CittadinoVaccinato;
import com.example.models.Indirizzo;
import com.example.models.Qualificatore;
import com.example.models.TipoCentro;
import com.example.models.TipoVaccino;
import com.example.models.loginCentro;



public class Server extends UnicastRemoteObject implements interfacciaServer{
    
    public Server() throws RemoteException{
        super();
    }
    private static Connection connection = null;

    public static void main(String [] args) throws RemoteException {
        try{
            Server server = new Server();
            Registry registro = LocateRegistry.createRegistry(9090);
            registro.rebind("ServerCentro", server);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public synchronized boolean ApriConnessioneDB(String url,String user,String password) throws ClassNotFoundException, RemoteException {
        System.out.println("Provo a connettermi al db...");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connesso al db con successo");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public synchronized void ChiudiConnessioneDB() throws SQLException, RemoteException {
        System.out.println("Chiudo connessione db...");
        connection.close();
    }

    public synchronized ArrayList<CentroVaccinale> getCentriVaccinaliByName(String nomeCentro) throws RemoteException {
        ArrayList<CentroVaccinale> centriVaccinali = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT * FROM CentriVaccinali WHERE nome ='" + nomeCentro + "'";

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

    public synchronized ArrayList<CentroVaccinale> getCentriVaccinaliByType(String comune, TipoCentro tipoCentro) throws RemoteException {
        ArrayList<CentroVaccinale> centriVaccinali = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT * FROM CentriVaccinali WHERE ???";

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

    public synchronized ArrayList<CittadinoVaccinato> getCittadiniVaccinati(String centro) throws RemoteException {
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

    public synchronized ArrayList<loginCentro> getDatiLogin() throws RemoteException {
        System.out.println("Recupero dati login...");
        ArrayList<loginCentro> loginCentro = new ArrayList<>();

        String query = "SELECT * FROM public.\"Login\";";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                loginCentro.add(new loginCentro(rs.getString(1), rs.getString(2)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(loginCentro);
        return loginCentro;
    }

    public synchronized ArrayList<CittadinoRegistrato> getCittadiniRegistrati() throws RemoteException {
        System.out.println("Recupero dati registrati...");
        ArrayList<CittadinoRegistrato> cittadiniRegistrati = new ArrayList<>();

        String query = "SELECT * FROM public.\"CittadiniRegistrati\";";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                cittadiniRegistrati.add(new CittadinoRegistrato(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4),
                rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println(cittadiniRegistrati);
        return cittadiniRegistrati;
    }
    public synchronized ArrayList<CittadinoRegistrato> setCentroVaccinale() throws RemoteException {
        System.out.println("I'm setting up Center Data...");
        ArrayList<CittadinoRegistrato> cittadiniRegistrati = new ArrayList<>();

        String query = "INSERT INTO public.\"CentriVaccinali\" (username, password) VALUES ('{admin}', '{admin}')";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                cittadiniRegistrati.add(new CittadinoRegistrato(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4),
                rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println(cittadiniRegistrati);
        return cittadiniRegistrati;
    }
}
