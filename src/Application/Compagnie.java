
/** Compagnie.java	*******************************************************************************/
/**********			@Authors : ISMAEL COULIBALY & XUAYO HU & JOSUE LUBAKI					*******/
/**************************************************************************************************/
package Application;

import java.util.ArrayList;

public class Compagnie {
	/* ENCAPSULATION DES VARIABLES COMPOSANTES DE LA CLASSE TRAJET */
	private static ArrayList<Chauffeur> listChauffeurs;
	private static ArrayList<Limousine> listLimousines;
	private final ArrayList<Trajet> listTrajets;

	// CONSTRUCTOR
	public Compagnie(ArrayList<Chauffeur> listChauffeurs, ArrayList<Limousine> listLimousines,
			ArrayList<Trajet> listTrajets) {
		Compagnie.listChauffeurs = listChauffeurs;
		Compagnie.listLimousines = listLimousines;
		this.listTrajets = listTrajets;
	}// Fin CONSTRUCTOR

	public ArrayList<Trajet> getListTrajets() {
		return listTrajets;
	}

	/**************************************************************************************************/

	/**
	 * METHODES D'AJOUT POUR LES LIST_CHAUFFEURS, LISTE_LIMOUSINE ET LIST_TRAJET
	 * FONCTION PERMETTANT D'AJOUTER UN CHAUFFEUR DANS LA LISTE CHAUFFEUR FONCTION
	 * PERMETTANT D'AJOUTER UN LIMOUSINE DANS LA LISTE LIMOUSINE FONCTION PERMETTANT
	 * D'AJOUTER UN TRAJET DANS LA LISTE TRAJET
	 * 
	 * @see 'add()'
	 */
	public void ajout_chauffeur(Chauffeur chauffeur) {
		listChauffeurs.add(chauffeur);
	}

	public void ajout_Limousine(Limousine limousine) {
		listLimousines.add(limousine);
	}

	public void ajout_Trajet(Trajet trajet) {
		listTrajets.add(trajet);
	}

	/**************************************************************************************************/
	/**
	 * METHODE QUI PERMET DE RECHERCHER UNE LIMOUSINE � PARTIR DE SON
	 * IMMATRICULATION
	 * 
	 * @see 'isEmpty()'
	 */
	public Limousine rechercheLimousine(String immatriculation) {
		int i = 0;
		if (listLimousines.isEmpty()) {
			System.out.println(" \t\t--- Oups ---\n\tLa Liste \"Limousines\" est vide !!! ");
		} else {
			for (i = 0; i < listLimousines.size(); i++) {

				if (listLimousines.get(i).getImmatriculation().equalsIgnoreCase(immatriculation)) {
					break;
				}
			}
		}
		return listLimousines.get(i);

	}

	/**************************************************************************************************/
	/*
	 * METHODE PERMETTANT DE VERIFIER SI LE CHAUFFEUR EXISTE DANS LA LISTE
	 */
	public boolean validationChauffeurListe(String numeroIdentification) {
		boolean answer = false;

		for (Chauffeur listChauffeur : listChauffeurs) {
			if (listChauffeur.getIdentification().equalsIgnoreCase(numeroIdentification)) {
				answer = true;
				break;
			}
		}

		return answer;
	}

	/**************************************************************************************************/
	/**
	 * METHODE QUI PERMET DE RECHERCHER UN CHAUFFEUR � PARTIR DE SON NUMERO
	 * D'IDENTIFICATION
	 * 
	 * @see 'isEmpty()'
	 */
	public Chauffeur rechercheChauffeur(String numeroIdentification) {
		int i = 0;
		if (listChauffeurs.isEmpty()) {
			System.out.println(" \t\t--- Oups ---\n\tLa Liste \"Chauffeurs\" est vide !!! ");
		} else {

			for (i = 0; i < listChauffeurs.size(); i++) {

				if (listChauffeurs.get(i).getIdentification().equalsIgnoreCase(numeroIdentification)) {
					break;
				}
			}
		}
		return listChauffeurs.get(i);

	}

	/**************************************************************************************************/
	/*
	 * METHODE PERMETTANT D'AFFICHER LE NOM ET LE NUMERO D'IDENTIFICATION DU
	 * CHAUFFEUR
	 */
	public void print_info_driver() {
		System.out.println("--------------------------");
		System.out.println("-- LISTE DES CHAUFFEURS --");
		System.out.println("--------------------------");
		for (int i = 0; i < listChauffeurs.size(); i++) {
			System.out.println((i + 1) + ". " + listChauffeurs.get(i).getNomChauffeur_ID());
		}
		System.out.println();
	}
}
