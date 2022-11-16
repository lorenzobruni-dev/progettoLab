package com.example.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CittadinoVaccinato;

public interface interfacciaServer extends Remote{
    
    boolean ApriConnessioneDB(String url, String username, String password) throws RemoteException;
    void ChiudiConnessioneDB() throws RemoteException, SQLException;
    ArrayList<CittadinoVaccinato> getCittadiniVaccinati(String centro) throws RemoteException;
    ArrayList<CentroVaccinale> getCentriVaccinali() throws RemoteException;

}
