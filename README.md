# progettoLab
***********************************************************************************
PROGETTO APPLICAZIONE COVID-19
LABORATORIO B, CORSO DI LAUREA TRIENNALE IN INFORMATICA
UNIVERSITA' DEGLI STUDI DELL'INSUBRIA

PROGETTO REALIZZATO DA:
LORENZO BRUNI - MATRICOLA 744455 - lbruni@studenti.uninsubria.it
FRANCESCO CLARY - MATRICOLA 744768 - fclary@studenti.uninsubria.it
ANNA LUTSYSHYNA - MATRICOLA 745509 - alutsyshyna@studenti.uninsubria.it
ALESSIO PANARESE - MATRICOLA 750887 - apanarese@studenti.uninsubria.it
***********************************************************************************
++CONTENUTI DELL'ARCHIVIO++

	--> Server.java : crea connessione da rendere disponibile al client
	--> App.java : UI che interagisce con il server
	--> doc
        --> Directory UML : UML associati all'Applicazione
        --> Documentazione DB : documentazione del db
		--> TechnicalManual.pdf : manuale tecnico
		--> UserManual.pdf : manuale utente
    --> demo : directory principale
        --> .vscode : JSON di setup per mvn
	    --> bin : codice eseguibile del progetto
	    --> src : codice sorgente del progetto

++REQUISITI++
L'applicazione richiede :
- Java JDK 16
- Java FX SDK 19
- Sistema operativo Windows 10/11.
NOTA: l'applicazione è stata sviluppata e testata su Windows 10 e 11. 
Non è garantito il corretto funzionamento sui sistemi operativi Linux e Mac.

++AVVIARE L'APPLICAZIONE++
Per un corretto avvio:
	-aprire cmd (prompt dei comandi) x2
    - inserire con "cd" la cartella di destinazione bin
        --> con un prompt avviare il Server con il seguente comando : java -jar Server.jar
        --> con il secondo prompt avviare la Main Class (App) con il seguente comando : java --module-path [PATH_TO_FX]\lib --add-modules javafx.controls,javafx.fxml,java.sql,java.rmi -jar App.jar 

        N.B nella sezione [PATH_TO_FX] inserire il path di locazione della cartella javafx-sdk-19

++DATI DI ACCESSO++
Per accedere alla sezione operatore è necessario inserire le credenziali presenti a DB.
Per accedere al Postegres su pgAdmin inserire le seguenti credenziali: 
    - Server Name : mouse.db.elephantsql.com
    - Password : sK90CQy9Jjx3gA_En10TfRZbquo33E62
    - User/role : czofsewc --> (Database)
    - PORT : 5432


