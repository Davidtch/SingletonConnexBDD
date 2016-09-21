package controler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**

@author david Giordani

 */
import model.ConnectionManager;

public class ConnexSingleton {

	//ATTRIBUTS
	//Pas d'accès aux attributs : private
	private Connection maConnection = null;
	private Statement monStatement = null;
	private ResultSet monResultatDeRequete = null;
	private static ConnexSingleton instanceUniqueDeConnexSingleton = new ConnexSingleton ();

	// CONSTRUCTEUR
	//Impossible d'instancier l'objet ConnexSingleton : constructeur private
	private ConnexSingleton() {
		ConnectionManager Connexion = new ConnectionManager();
		maConnection = Connexion.getMaConnexion();
	}

	//METHODE / getter accessible depuis MonProg
	//Méthode qui va retourner notre instance et la créer si elle n'existe pas
	public static ConnexSingleton geInstanceDuSingleton (){
		return instanceUniqueDeConnexSingleton;
		//je retoure ici mon objet instanceUniqueDeConnexSingleton déclaré plus haut

	}

	/*public void afficheMessageSingleton(){
		System.out.println("je suis dans l'instance unique du singleton");
	}*/


	/**********************************************/
	/******* LANCER DES REQUETES *****************/
	/********************************************/
	
	public void ReqBDD(String query) {

		PrepRequete();

		try {
			// execution de la Requete
			//String query = "SELECT * FROM QUESTION WHERE DIFFICULTE_QUESTION =2";
			monResultatDeRequete = monStatement.executeQuery(query);
			System.out.println("Execution de la Requete : Query ok");

			// Traitement du résultat de la requete while
			while (monResultatDeRequete.next()) {
				System.out.print(monResultatDeRequete.getString(1));
				System.out.println("\t "+monResultatDeRequete.getString(4));

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur lors de la connexion");
			e.printStackTrace();

		}
		// Fermeture du Resultset et du Statement
		FermetureRequete();
		System.out.println("Fermeture de la requete. Statut: ok");

	}

	public void PrepRequete() {
		// Prépa des elements necessaires à la REQT : Statement + resultset (qui
		// accueillera le resultat de la requete)
		try {
			monStatement = maConnection.createStatement();
			System.out.println("Préparation de la requette");
		} catch (SQLException e) {
			System.out.println("erreur lors du createStatement");
			e.printStackTrace();
		}
	}

	public void FermetureRequete() {
		/**
		 * Fermeture du resultset
		 * 
		 */
		try {
			monResultatDeRequete.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * Fermeture du Statement
		 * 
		 */
		try {
			monStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void FermetureConnexion() {

		/**
		 * Fermeture de la connexion
		 * 
		 */
		try {
			maConnection.close();
			System.out.println("Fermeture de la connexion. Statut: ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}