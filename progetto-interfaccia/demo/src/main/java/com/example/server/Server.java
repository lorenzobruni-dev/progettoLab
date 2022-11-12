package com.example.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
import com.example.models.TipoVaccino;

public class Server {
    
    private static Connection connection = null;

    public static void main(String[] args) {
        try{
            Server server = new Server();
            Registry registro = LocateRegistry.createRegistry(5462);
            registro.rebind("", registro);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean ApriConnessioneDB(String url, String username, String password) {
        System.out.println("Provo a connettermi al db...");
        try {
            connection = DriverManager.getConnection(url, username, password);
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
}
