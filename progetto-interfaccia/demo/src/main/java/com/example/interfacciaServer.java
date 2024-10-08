package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CittadinoRegistrato;
import com.example.models.CittadinoVaccinato;
import com.example.models.EventoAvverso;
import com.example.models.Qualificatore;
import com.example.models.SigleProvince;
import com.example.models.TipoCentro;
import com.example.models.loginCentro;



public interface interfacciaServer extends Remote{
    
    boolean ApriConnessioneDB(String url, String username, String password) throws RemoteException, ClassNotFoundException;
    boolean isConnectionOpen() throws RemoteException, SQLException;
    void ChiudiConnessioneDB() throws RemoteException, SQLException;
    ArrayList<String> getCittadiniVaccinati(String centro) throws RemoteException;
    ArrayList<String> getCittadiniVaccinatiId(String centro) throws RemoteException;
    ArrayList<CentroVaccinale> getCentriVaccinaliByName(String nomeCentro) throws RemoteException;
    ArrayList<CentroVaccinale> getCentriVaccinaliByType(String comune, TipoCentro tipoCentro) throws RemoteException;
    ArrayList <loginCentro> getDatiLogin() throws RemoteException;
    ArrayList<CittadinoRegistrato> getCittadiniRegistrati() throws RemoteException;
    void registraCittadino(CittadinoRegistrato registrato) throws RemoteException;
    void registraEventiAvversi(ArrayList<EventoAvverso> eventiAvversi, String codiceFiscale) throws RemoteException;
    void setCentroVaccinale(String string, String string2, String string3, String string4, String string5, Qualificatore qualificatore, SigleProvince sigleProvince, TipoCentro tipoCentro) throws RemoteException;
    ArrayList <CentroVaccinale> getCentriVaccinali() throws RemoteException;
    void setVaccinato(ArrayList<String> datiVaccinato) throws RemoteException;
    void createTableDinamica(ArrayList<String> datiVaccinato) throws RemoteException;
    ArrayList<EventoAvverso> getEventiAvversi(String codiceFiscale) throws RemoteException;
}
