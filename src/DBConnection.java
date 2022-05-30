import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	// Adresse der Datenbank
	// JDBC Aufbau jdbc : subprotokoll : datenquellennamen
	// Datenquellennamen : jdbc : mysql :// host[: port]/ database
	
	private final String url = "jdbc:mysql://127.0.0.1:3306";
	private String user = "root";
	private String passwort = "";
	private String db = "schule_2";
	private String command; // Users Befehl
	
	// Konstruktoren
	
	public DBConnection(String command) {
		this.command = command;
		
		try {
			// Treiber laden
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Verbindung aufbauen
			Connection my_connection = DriverManager.getConnection(url, user, passwort);
			System.out.println("Verbinding erfolgreich aufgebaut.");
			
			// Auf welche Datenbank wollen wir zugreifen?
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + db);
			
			ResultSet my_result = my_statement.executeQuery(command);
			
			// Egebnis bekommen
			String result = "";
			
			while (my_result.next()) {
				result = result.concat("\n" + my_result.getInt("ID_Lehrer") + " " + my_result.getString("Nachname") + " " + my_result.getString("Vorname"));
			}
			
			System.out.println(result);
			
			// 
			
			my_result.close();
			my_connection.close();
			my_statement.close();
			
		}
		catch (Exception e) {
			System.out.println("Fehler beim Laden des Treibers oder Verbindungsaufbaus.");
		}

	}
	
	public DBConnection(String vorname, String nachname) {
		
		this.command = "insert into schule_2.lehrer(Vorname, Nachname) values ('" + vorname + "','" + nachname + "')";
		System.out.println(command);
		
		try {
			// Treiber laden
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Verbindung aufbauen
			Connection my_connection = DriverManager.getConnection(url, user, passwort);
			System.out.println("Verbinding erfolgreich aufgebaut.");
			
			// Auf welche Datenbank wollen wir zugreifen?
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + db);
			
			my_statement.executeUpdate(command);
			System.out.println("Update");
			
			my_connection.close();
			my_statement.close();
			
		}
		catch (Exception e) {
			System.out.println("Fehler beim Laden des Treibers oder Verbindungsaufbaus.");
		}
		
	}
	
	// Getters und Setters
	
	public String getUrl() {
		return url;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPasswort() {
		return passwort;
	}
	
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	public String getDb() {
		return db;
	}
	
	public void setDb(String db) {
		this.db = db;
	}
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	
	
	
}
