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
import com.example.models.SigleProvince;
import com.example.models.TipoCentro;
import com.example.models.TipoVaccino;
import com.example.models.loginCentro;


public class Server extends UnicastRemoteObject implements interfacciaServer {

    public Server() throws RemoteException {
        super();
    }

    private static Connection connection = null;

    public static void main(String[] args) throws RemoteException {
        try {
            Server server = new Server();
            Registry registro = LocateRegistry.createRegistry(9090);
            registro.rebind("ServerCentro", server);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public synchronized boolean ApriConnessioneDB(String url, String user, String password) throws ClassNotFoundException, RemoteException {
        System.out.println("Provo a connettermi al db...");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
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

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
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

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
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

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
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

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                loginCentro.add(new loginCentro(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(loginCentro);
        return loginCentro;
    }

    public synchronized ArrayList<CittadinoRegistrato> getCittadiniRegistrati() throws RemoteException {
        System.out.println("Recupero dati registrati...");
        ArrayList<CittadinoRegistrato> cittadiniRegistrati = new ArrayList<>();

        String query = "SELECT * FROM public.\"CittadiniRegistrati\";";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                cittadiniRegistrati.add(new CittadinoRegistrato(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(cittadiniRegistrati);
        return cittadiniRegistrati;
    }

    public synchronized void setCentroVaccinale(String nomCentro, String comuneCentro, String indirizzoCentroString,
                                                String civicoCentro, String capCentro, Qualificatore qualCentro, SigleProvince siglaCentro, TipoCentro tipoCentro) throws RemoteException {
        System.out.println("I'm setting up Center Data...");
        String query = "INSERT INTO public.\"CentriVaccinali\" (nome,indirizzo.via,indirizzo.nome,indirizzo.numero_civico,indirizzo.comune,indirizzo.sigla_provincia,indirizzo.\"CAP\",tipologia) VALUES ('"+ nomCentro +"'::character varying, '"+ qualCentro +"'::character varying, '"+ indirizzoCentroString +"' ::character varying, '"+ civicoCentro +"' , '"+ comuneCentro +"'::character varying, '"+ siglaCentro +"'::character varying, '"+ capCentro +"','"+ tipoCentro +"'::character varying);";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setVaccinato(ArrayList<String> datiVaccinato) throws RemoteException {
        System.out.println("I'm setting up Center Data...");
        String query = "INSERT INTO public.\"CittadiniRegistrati_"+datiVaccinato.get(8)+"\"(nome,cognome,data_nascita,genere,cod_fiscale,data_somministrazione,nome_vaccino,nome_centro,id_vaccinazione)"+
                       "VALUES ('"+ datiVaccinato.get(0) +"'::character varying," + 
                                "'"+ datiVaccinato.get(1) +"'::character varying," + 
                                "'"+ datiVaccinato.get(2) +"'::date," + 
                                "'"+ datiVaccinato.get(3) +"'::character varying," + 
                                "'"+ datiVaccinato.get(4) +"'::character varying," + 
                                "'"+ datiVaccinato.get(5) +"'::date," + 
                                "'"+ datiVaccinato.get(6) +"'::character varying," + 
                                "'"+ datiVaccinato.get(7) +"'::character varying," + 
                                "'"+ datiVaccinato.get(8) +"'::character varying)";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //TODO: Da inserire i dati del Vaccinato

    public synchronized void createTableDinamica(ArrayList<String> datiVaccinato) throws RemoteException {
        System.out.println("I'm setting up Center Data...");
        String query = "CREATE TABLE IF NOT EXISTS public.\"CittadiniRegistrati_"+datiVaccinato.get(8)+"\""+
                       "( nome character varying(30) COLLATE pg_catalog.\"default\" NOT NULL," +
                       "  cognome character varying(30) COLLATE pg_catalog.\"default\" NOT NULL," +
                       "  data_nascita date NOT NULL," +
                       "  genere character varying(30) COLLATE pg_catalog.\"default\" NOT NULL," +
                       "  cod_fiscale character varying(30) COLLATE pg_catalog.\"default\" NOT NULL," +
                       "  data_somministrazione date NOT NULL," +
                       "  nome_vaccino character varying(30) COLLATE pg_catalog.\"default\" NOT NULL," +
                       "  nome_centro character varying(30) COLLATE pg_catalog.\"default\" NOT NULL," +
                       "  id_vaccinazione character varying(30) COLLATE pg_catalog.\"default\" NOT NULL," +
                       "  CONSTRAINT \"CittadiniRegistrati"+datiVaccinato.get(8)+"p_key\" PRIMARY KEY(id_vaccinazione),"+
                       "  CONSTRAINT \"CittadiniRegistratiNome"+datiVaccinato.get(8)+"p_key\" FOREIGN KEY(nome_centro) REFERENCES public.\"CentriVaccinali\" (nome),"+
                       "  CONSTRAINT \"CittadiniRegistratiCF"+datiVaccinato.get(8)+"p_key\" FOREIGN KEY(cod_fiscale) REFERENCES public.\"CittadiniRegistrati\" (codice_fiscale))"+
                       "TABLESPACE pg_default;"+
                       "ALTER TABLE IF EXISTS public.\"CittadiniRegistrati_"+datiVaccinato.get(8)+"\"" + 
                       "OWNER to czofsewc;"; 
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    public synchronized ArrayList<CentroVaccinale> getCentriVaccinali() throws RemoteException {
        ArrayList<CentroVaccinale> centriVaccinali = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT nome, (indirizzo).via, (indirizzo).nome, (indirizzo).numero_civico, (indirizzo).comune, (indirizzo).sigla_provincia, (indirizzo).\"CAP\", tipologia FROM public.\"CentriVaccinali\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                centriVaccinali.add(new CentroVaccinale(rs.getString(1), new Indirizzo(Qualificatore.valueOf(rs.getString(2)), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)), TipoCentro.valueOf(rs.getString(8))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(centriVaccinali);
        return centriVaccinali;
    }

}
