package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
@author david Giordani
 */

public class ConnectionManager {
/**********************************************/
/** ------------- ATTRIBUTS ------------ *****/
/********************************************/	
		private  String SGBD 			= "oracle.jdbc.driver.OracleDriver";  
		private  String url 			= "jdbc:oracle:thin:@localhost:1521/XE";     
		private  String id 				= "cas_questionnaire";   
		private  String password 		= "azerty";
		private  Connection maConnexion = null;

/**********************************************/
/** ---------- CONSTRUCTOR ------------ *****/
/********************************************/	

		public ConnectionManager(){

		}

/**********************************************/
/******* ---------- GETTERS ------------ *****/
/********************************************/
		public String getUrl() {
			return url;
		}

		public String getId() {
			return id;
		}

		public String getPassword() {
			return password;
		}
		
/**********************************************/
		public Connection getMaConnexion() {
			if (maConnexion == null){
				//driver
				try {
					Class.forName(this.SGBD);
					System.out.println("Driver chargé");

				} catch (ClassNotFoundException ex) {
					System.out.println("Erreur lors du chargement du driver"); 
				}
				//Etablissement de ma connexion
				try {
					maConnexion = DriverManager.getConnection(url, id, password);
					System.out.println("Ouverture de ma connexion");
					System.out.println("Connexion effectuée à la BDD Cas_Questionnaire");
				} catch (SQLException ex) {
					System.out.println("erreur lors de la connexion"); 
					ex.printStackTrace();
				}
			}
			return maConnexion;
		}
/**********************************************/		
		
		public String getSGBD() {
			return SGBD;
		}

		/** SETTERS */
		public void setUrl(String url) {
			this.url = url;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setMaConnexion(Connection maConnexion) {
			this.maConnexion = maConnexion;
		}

		public void setSGBD(String sGBD) {
			this.SGBD = sGBD;
		}

}