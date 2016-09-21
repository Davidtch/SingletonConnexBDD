package controler;

/**

@author david Giordani

 */

public class MonProg {

	public static void main(String[] args) {
		//OUVERTURE DE MA CONNEXION
		ConnexSingleton monSingleton = ConnexSingleton.geInstanceDuSingleton ();

		//LANCER UNE QUERY/REQUETE SUR LA BDD
		monSingleton.ReqBDD("SELECT * FROM QUESTION WHERE DIFFICULTE_QUESTION =2");

		//FERMER MA REQUETE
		//monSingleton.FermetureRequete();
		//FERMER MA CONNEXION
		monSingleton.FermetureConnexion();
	}

}