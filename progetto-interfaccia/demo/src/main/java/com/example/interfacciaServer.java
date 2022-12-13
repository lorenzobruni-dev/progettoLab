package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CittadinoRegistrato;
import com.example.models.CittadinoVaccinato;
import com.example.models.TipoCentro;
import com.example.models.loginCentro;



public interface interfacciaServer extends Remote{
    
    boolean ApriConnessioneDB(String url, String username, String password) throws RemoteException, ClassNotFoundException;
    void ChiudiConnessioneDB() throws RemoteException, SQLException;
    ArrayList<CittadinoVaccinato> getCittadiniVaccinati(String centro) throws RemoteException;
    ArrayList<CentroVaccinale> getCentriVaccinaliByName(String nomeCentro) throws RemoteException;
    ArrayList<CentroVaccinale> getCentriVaccinaliByType(String comune, TipoCentro tipoCentro) throws RemoteException;
    ArrayList <loginCentro> getDatiLogin() throws RemoteException;
    ArrayList<CittadinoRegistrato> getCittadiniRegistrati() throws RemoteException;
    void registraCittadino(CittadinoRegistrato registrato) throws RemoteException;
}
