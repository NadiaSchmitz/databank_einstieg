
public class Main {

	public static void main(String[] args) {
		
		DBConnection connection_1 = new DBConnection("SELECT * FROM schule_2.lehrer WHERE ID_Lehrer = 1;");
		
		DBConnection connection_2 = new DBConnection("SELECT * FROM schule_2.lehrer WHERE ort = 'Meschede'");
		
		DBConnection connection_3 = new DBConnection("Nadia", "Schmitz");
		
	}
	
}
