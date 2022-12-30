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
import com.example.models.EventoAvverso;
import com.example.models.Indirizzo;
import com.example.models.Qualificatore;
import com.example.models.SigleProvince;
import com.example.models.TipoCentro;
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

    public synchronized boolean isConnectionOpen() throws RemoteException, SQLException {
        return connection != null;
    }

    public synchronized void ChiudiConnessioneDB() throws SQLException, RemoteException {
        System.out.println("Chiudo connessione db...");
        connection.close();
    }

    public synchronized ArrayList<CentroVaccinale> getCentriVaccinaliByName(String nomeCentro) throws RemoteException {
        ArrayList<CentroVaccinale> centriVaccinali = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT nome, (indirizzo).via, (indirizzo).nome, (indirizzo).numero_civico, (indirizzo).comune, (indirizzo).sigla_provincia, (indirizzo).\"CAP\", tipologia FROM public.\"CentriVaccinali\" WHERE nome LIKE '%" + nomeCentro + "%'";

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

        String query = "SELECT nome, (indirizzo).via, (indirizzo).nome, (indirizzo).numero_civico, (indirizzo).comune, (indirizzo).sigla_provincia, (indirizzo).\"CAP\", tipologia FROM public.\"CentriVaccinali\" WHERE tipologia='" + tipoCentro + "' AND (indirizzo).comune LIKE '%" + comune + "%'";

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

    public synchronized ArrayList<String> getCittadiniVaccinati(String centro) throws RemoteException {
        ArrayList<String> cittadiniVaccinati = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT cod_fiscale FROM public.\"CittadiniRegistrati_" + centro + "\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                cittadiniVaccinati.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(cittadiniVaccinati);
        return cittadiniVaccinati;
    }

    public synchronized ArrayList<String> getCittadiniVaccinatiId(String centro) throws RemoteException {
        ArrayList<String> cittadiniVaccinati = new ArrayList<>();
        System.out.println("Recupero elenco centri vaccinali...");

        String query = "SELECT id_vaccinazione FROM public.\"CittadiniRegistrati_" + centro + "\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                cittadiniVaccinati.add(rs.getString(1));
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
                                "'"+ datiVaccinato.get(8) +"'::character varying," + 
                                "'"+ datiVaccinato.get(7) +"'::character varying)";
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
                       "  CONSTRAINT \"CittadiniRegistratiNome"+datiVaccinato.get(8)+"p_key\" FOREIGN KEY(nome_centro) REFERENCES public.\"CentriVaccinali\" (nome))"+
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

    public synchronized void registraCittadino(CittadinoRegistrato registrato) throws RemoteException {

        System.out.println("Registro cittadino...");

        String query = "INSERT INTO public.\"CittadiniRegistrati\" (codice_fiscale, nome, cognome, id_vaccinazione, email, \"user\", password) VALUES ('" + registrato.getCodiceFiscale() + "'::character varying, \'" + registrato.getNome() + "\'::character varying, '" + registrato.getCognome() + "'::character varying, '" + registrato.getIdVaccinazione() + "', '" + registrato.getEmail() + "'::character varying, '" + registrato.getUserid() + "'::character varying, '" + registrato.getPassword() + "'::character varying);";

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public synchronized void registraEventiAvversi(ArrayList<EventoAvverso> eventiAvversi, String codiceFiscale) throws RemoteException {

        System.out.println("Registro eventi avversi...");

        eventiAvversi.forEach((ev) -> {
            String query = "INSERT INTO public.\"EventiAvversi\" (evento, note, \"severità\", codice_fiscale) VALUES ('" + ev.getEvento() + "'::character varying, '" + ev.getNoteOpzionali() + "'::character varying, '" + ev.getSeverità() + "'::integer, '" + codiceFiscale + "'::character varying);";

            try{
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }catch(SQLException e){
                e.printStackTrace();
            }
        });
    }

    public synchronized ArrayList<EventoAvverso> getEventiAvversi(String codiceFiscale) throws RemoteException {
        ArrayList<EventoAvverso> eventiAvversi = new ArrayList<>();
        System.out.println("Recupero eventi avversi...");

        String query = "SELECT * FROM public.\"EventiAvversi\" WHERE codice_fiscale='" + codiceFiscale + "' AND severità > 1";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                eventiAvversi.add(new EventoAvverso(rs.getString(2), rs.getInt(4), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(eventiAvversi);

        return eventiAvversi;
    }
}
