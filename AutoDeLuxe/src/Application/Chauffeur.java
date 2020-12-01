
/** Chauffeur.java	*******************************************************************************/
/**********			@Authors : ISMAEL COULIBALY & XUAYO HU & JOSUE LUBAKI					*******/
/**************************************************************************************************/
package Application;

import java.util.ArrayList;

public class Chauffeur {
	/* ENCAPSULATION DES VARIABLES COMPOSANTES DE LA CLASSE CHAUFFEUR */
	private final String nomChauffeur;
	private final String prenomChauffeur;
	private final int anneeEmbauche;
	private final String adresse;
	private final ArrayList<Trajet> listTrajets;
	private final String numeroIdentification;

	// CONSTRUCTOR
	public Chauffeur(String nomChauffeur, String prenomChauffeur, int anneeEmbauche, String adresse,
			ArrayList<Trajet> listTrajets, String numeroIdentification) {
		this.nomChauffeur = nomChauffeur;
		this.prenomChauffeur = prenomChauffeur;
		this.anneeEmbauche = anneeEmbauche;
		this.adresse = adresse;
		this.listTrajets = listTrajets;
		this.numeroIdentification = numeroIdentification;
	} // FIN CONSTRUCTOR

	/**************************************************************************************************/

	/* FONCTION genererNumeroIdentification() */
	/**
	 * METHODE QUI PERMET DE GENERER LE NUMERO D'IDENTIFICATION A PARTIR DU NOM,
	 * PRENOM ET DE L'ANNEE D'EMBAUCHE
	 * 
	 * @see 'substring()'
	 */
	public static String genererNumeroIdentification(String nomChauffeur, String prenomChauffeur, int anneeEmbauche) {

		String reponse = "";

		nomChauffeur = supprimerCaractereSpecialNom(nomChauffeur);
		prenomChauffeur = supprimerCaractereSpecialNom(prenomChauffeur);

		/*
		 * ON VEUT L'ANNEE D'EMBAUCHE EN STRING POUR POUVOIR LA MANIPULER AVEC
		 * SUBSTRING() D'OU L'UTILISATION DE LA CONVERSION Integer.toString()
		 */
		String anneeEmbauche_String = Integer.toString(anneeEmbauche);
		if (nomChauffeur.length() < 3 || prenomChauffeur.length() < 1 || anneeEmbauche_String.length() < 1) {
			System.out.println();
		} else {
			/* DECOUPAGE DE NOM, PRENOM ET ANNEE D'EMBAUCHE */
			reponse = nomChauffeur.substring(0, 3) + prenomChauffeur.charAt(0)
					+ anneeEmbauche_String.substring(2);
		}

		return reponse;
	}

	/**************************************************************************************************/
	/* FONCTION supprimerCaractereSpecialNom() */
	/**
	 * @see 'VERIFICATION' ET SUPPRESSION DES CARACTERES SPECIAUX; UTILE POUR LA
	 *      FONCTION genererNumeroIdentification()
	 * @see 'isLetter()' : VERIFIE SI L'ELEMENT EST UNE LETTRE
	 */
	public static String supprimerCaractereSpecialNom(String word) {
		StringBuilder nomSansCaractere = new StringBuilder(); // VARIABLE DESIGNANT LE NOM DU CHAUFFEUR SANS CARACTERE SPECIAL

		for (int i = 0; i < word.length(); i++) {
			/*
			 * POUR CHAQUE CARACTERE DU MOT, ON VERIFIE SI C'EST UNE LETTRE OU UN CARACT�RE
			 * SPECIAL
			 */
			if (Character.isLetter(word.charAt(i))) {
				/* ON CONCATENE POUR OBTENIR LE NOM SANS CARACTERE SEPCIAL */
				nomSansCaractere.append(word.charAt(i));
			}
		}
		return nomSansCaractere.toString();
	}

	/**************************************************************************************************/
	/**
	 * LA FONCTION getLimousine_Chauffeur()
	 *
	 * METHODE PERMETTANT D'AFFICHER LA OU LES LIMOUSINE(S) CONDUIT PAR UN CHAUFFEUR
	 * 
	 * @see 'isEmpty()'
	 */
	public void getLimousine_Chauffeur() {

		if (listTrajets.isEmpty()) {
			System.out.println("\nCe chauffeur ne conduit aucune Limousine.");
		} else {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("\nLimousines conduitent par " + nomChauffeur + " " + prenomChauffeur + ":\n");
			for (Trajet t : listTrajets) {
				System.out.println("\t*" + t.getLimousine_info());
			}
			System.out.println("----------------------------------------------------------------------");
		}

	}

	/**************************************************************************************************/
	/**
	 * FONCTION ajouterTrajetListe() FONCTION QUI PERMET D'AJOUTER UN OBJET DU TYPE
	 * TRAJET DANS LA LISTE DE TRAJET PAR RAPPORT � UN CHAUFFEUR
	 * 
	 * @see 'add()'
	 */
	public void ajouterTrajetListe(Trajet unTrajet) {
		listTrajets.add(unTrajet);
	}

	/**************************************************************************************************/
	/**
	 * LES GETTERS DE LA CLASSE CHAUFFEUR
	 * 
	 * @see 'PAS BESOIN DES SETTERS PUISQUE LE PROGRAMME NE CONSISTE QU'� LA LECTURE
	 *      DES FICHIERS ET NON L'ECRITURE'
	 */
	public String getNomChauffeur() {
		return nomChauffeur;

	}

	public String getPrenomChauffeur() {
		return prenomChauffeur;

	}

	public int getAnneeEmbauche() {
		return anneeEmbauche;

	}

	public String getAdresse() {
		return adresse;

	}

	public String getIdentification() {
		return numeroIdentification;

	}

	public String getNomChauffeur_ID() {
		return nomChauffeur + "    \t" + numeroIdentification;

	}

	/**************************************************************************************************/
	public String toString() {

		return "\n**************************************************************************************************"
				+ "\nNom: " + getNomChauffeur() + "\nprenom: " + getPrenomChauffeur() + "\nAnnee d'embauche : "
				+ getAnneeEmbauche() + "\nAdresse : " + getAdresse();
	}

}