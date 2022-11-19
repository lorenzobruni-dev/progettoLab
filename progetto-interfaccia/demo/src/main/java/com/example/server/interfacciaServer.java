package com.example.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CittadinoVaccinato;
import com.example.models.loginCentro;

public interface interfacciaServer extends Remote{
    
    boolean ApriConnessioneDB(String url, String username, String password) throws RemoteException, ClassNotFoundException;
    void ChiudiConnessioneDB() throws RemoteException, SQLException;
    ArrayList<CittadinoVaccinato> getCittadiniVaccinati(String centro) throws RemoteException;
    ArrayList<CentroVaccinale> getCentriVaccinali() throws RemoteException;
    ArrayList <loginCentro> getDatiLogin() throws RemoteException;

}
