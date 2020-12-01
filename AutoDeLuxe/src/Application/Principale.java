
/** Principale.java	*******************************************************************************/
/**********			@Authors : ISMAEL COULIBALY & XUAYO HU & JOSUE LUBAKI					*******/
/**************************************************************************************************/
package Application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principale {
	/**
	 * UTILISATION DE LA VARIABLE "ARRET" SERVANT DE STOPPER TOUS LES BOUCLES OU
	 * CONDITIONS DU PROGRAMME
	 * 
	 * @see 'scan' : SCANNER SCAN (UTILISÉ POUR TOUS LES SCANNER DES VARIABLES
	 *      ENTIÈRES : INTEGER, DOUBLE, FLOAT,...)
	 * 
	 * @see 'scan2' : SCANNER SCAN2 (UTILISÉ POUR TOUS LES SCANNER DES VARIABLES DU
	 *      TYPE STRING)
	 */
	private static boolean arret = false;
	private static boolean ligneVide = false;
	private static final Scanner scan = new Scanner(System.in);
	private static final Scanner scan2 = new Scanner(System.in);

	/* CRÉATION D'INSTANCE DU TYPE ARRAYLIST */
	private static final ArrayList<Chauffeur> chauffeurSociety = new ArrayList<>();
	private static final ArrayList<Limousine> limousineSociety = new ArrayList<>();
	private static final ArrayList<Trajet> trajetSociety = new ArrayList<>();
	private static final Compagnie autoDeluxe = new Compagnie(chauffeurSociety, limousineSociety, trajetSociety);

	/**
	 * DECLARATION DES VARIABLES SERVANT À STOCKER LES DONNÉES LUES PAR LA
	 * FONCTION @Operation_ajout_limousine()
	 */
	private static String codeImmatriculation;
	/**
	 * DECLARATION DES VARIABLES SERVANT À STOCKER LES DONNÉES LUES PAR LA
	 * FONCTION @Operation_ajout_trajet()
	 */
	private static String code_identification;

	/**************************************************************************************************/
	/* FONCTION PRINCIPALE / METHODE MAIN() */
	public static void main(String[] args) {
		/* VERIFICATION DU NOMBRE D'ARGUMENT */
		/** Si vous utilse Eclipse, vous pouvez enlever les commentaires de la condition if et
		 * Inserer le chemin d'accès des 3 fichers sans le path d'argument de votre projet */
		/*if (args.length < 3) {
			// SANS ARGUMENTS, ON TERMINE LE PROGRAMME.
			System.out.println(String.format(
					"Il manque %d arguments, essayer de copier ceci : \n\t\"src\\Application\\Chauffeurs.txt\""
							+ "\n\t\"src\\Application\\Limousines.txt\"" + "\n\t\"src\\Application\\Trajets.txt\"",
					3 - args.length));
			return;
		}

		operation_ajout_chauffeur(args[0]);
		operation_ajout_limousine(args[1]);
		operation_ajout_trajet(args[2]);
		*/

		/** Si vous utilisez un autre editeur qu'Eclipse, le 3 chemins d'accès sont déjà correct pour vous
		 * APPEL DE LA FONCTION LECTURE() POUR CHACUN DES FICHIERS (CHAFFEUR,LIMOUSINE
		 * ET TRAJET)
		 */
		operation_ajout_chauffeur("src\\Application\\Chauffeurs.txt");
		operation_ajout_limousine("src\\Application\\Limousines.txt");
		operation_ajout_trajet("src\\Application\\Trajets.txt");

		/* IMPLEMENTATION DU MENU */
		int menu;
		try {

			while (!arret) {
				System.out.println("\n\n\n\t\t\t*****************\r\t\t\t* MENU D'OPTION *\r\t\t\t*****************");
				System.out.println("\tTapez le numero d'option dont vous souhaitez éxecuter\n");
				System.out.println("Option 1 : Trouver toutes les limousines conduites par un chauffeur");
				System.out.println("Option 2 : Afficher toutes les caractéristiques des trajets effectués\n"
						+ "\t   ainsi que les caractéristiques des limousines utilisées");
				System.out.println("Option 0 : Quitter");

				// SWITCH

				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {

				case 1: {
					limousine_by_chauffeur();
					break;
				}
				case 2: {
					information_trajet_limousine();
					break;
				}
				case 0: {
					leave();
					arret = true;// Condition d'arret de la boucle While
					break;
				}

				default: {
					System.out.print("\t\t   ------ !!! Oups !!! ------\r");
					System.out.println("\t   Faites un choix parmi les Options proposées");
					arret = false;
				}

				}// End Switch
			} // End While
		} // End Try
		catch (NumberFormatException e) {
			System.out.println("\t\tLe Format de Saisi est incorrect");
			System.out.println("   Pour le bon fonctionnement, Veuillez Rédemarrer l'Application");
			leave();
		} catch (ExceptionScope e) {
			System.out.println(); // Pour aérer l'affichage
			e.printStackTrace(System.out);
		}

	}// Fin Main()

	/* IMPLEMENTATION DE L'OPTION 1 */
	/*
	 * FONCTION QUI RENVOIE L'IMMITRICULATION DE LIMOUSINE CONDUITE PAR LE CHAUFFEUR
	 * ON ACCEDE A CES LIMOUSINES GRÂCE AU NUMERO D'IDENTIFICATION DU CHAUFFEUR
	 */
	public static void limousine_by_chauffeur() throws ExceptionScope {
		try {
			autoDeluxe.print_info_driver(); // AFFICHAGHE DE LA LISTE DE CHAUFFEUR
			System.out.println("Entrer le numero d'identification du Chauffeur");
			String identification_User = scan2.nextLine();

			boolean personnelVerifie = autoDeluxe.validationChauffeurListe(identification_User);
			/**
			 * VERIFIER D'ABORD SI LE CHAUFFEUR EXISTE OU PAS (TRUE/FALSE)
			 * 
			 * @see validationChauffeurListe();
			 */
			if (!personnelVerifie) {
				throw new ExceptionScope();
			} else {
				Chauffeur personnel = autoDeluxe.rechercheChauffeur(identification_User);
				personnel.getLimousine_Chauffeur();
			}
		}
		/*
		 * LORSQUE L'ERREUR EST ATTRAPÉE, ON AFFICHE LE MESSAGE DE NOTRE CLASSE
		 * ExceptionScope.java
		 */
		catch (ExceptionScope e) {
			System.out.print("\n\t\t\t   --- OUPS ---\r"); // Pour aérer l'affichage
			System.out.println(e.getMessage());
		}
	}

	/**************************************************************************************************/
	/* IMPLEMENTATION DE L'OPTION 2 */
	/*
	 * FONCTION QUI RENVOIE TOUTES LES CARACTERISTIQUES DE LA CLASSE TRAJETS AINSI
	 * QUE CELLE DE LA CLASSE LIMOUSINE ASSOCIÉE
	 */
	public static void information_trajet_limousine() {
		System.out.println("\t-----------------------------------------------------------------");
		System.out.println("\t-- LISTE DE TRAJET ET CARACTERISTIQUE DE LA LIMOUSINE UTILISÉE --");
		System.out.println("\t-----------------------------------------------------------------");

		for (Trajet liste : autoDeluxe.getListTrajets()) {
			System.out.println(liste);
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}

	/**************************************************************************************************/
	/* IMPLEMENTATION DE L'OPTION 3 */
	/**************** FONCTION leave() -- QUITTER -- ******************/
	private static void leave() {
		System.out.println("\n\n\t @Authors : Ismael Coulibaly & Xuayo Hu & Josue Lubaki");
		System.out.print("\t    Copyright 2020 - Toute Reproduction interdite �");
	}// End FONCTION leave()

	/**************************************************************************************************/
	/**
	 * FONCTION QUI PERMET DE LIRE LES CONTENUES DU FICHIER (CHAUFFEUR), PUIS
	 * L'AJOUTER DANS LA LISTE
	 * 
	 * @param filePath Chemin d'accès au fichier.
	 *
	 * @see FileInputStream
	 * 
	 * @see BufferedInputStream
	 * 
	 * @see Scanner
	 */
	private static void operation_ajout_chauffeur(String filePath) {
		File file = new File(filePath);
		ligneVide = false;

		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Scanner scan = new Scanner(bis)) {

			/* ON PARCOURS CHAQUE LIGNE AVEC LA BOUCLE WHILE() */
			while (scan.hasNextLine() && !ligneVide) {
				// LIRE LA LIGNE POUR ENSUITE VERIFIER
				String ligneLue = scan.nextLine();
				// VERIFIER SI LA LIGNE EST VIDE, SI "TRUE", ON SORT DE LA BOUCLE WHILE(ON
				// N'ARRETE DE LIRE LE FICHIER)
				if (ligneLue.equals("")) {
					ligneVide = true;
				} else {
					String[] infoChauffeur = ligneLue.split("\t");

					/* AFFECTATION DE CHAQUE OBJET DANS LA VARIABLE */
					/**
					 * DECLARATION DES VARIABLES SERVANT À STOCKER LES DONNÉES LUES PAR LA
					 * FONCTION @Operation_ajout_chauffeur()
					 */
					String name = infoChauffeur[0];
					String firstName = infoChauffeur[1];
					int anneeEmbauche = Integer.parseInt(infoChauffeur[2]);
					String address = infoChauffeur[3];

					/* AFFECTACTION OU CONSTRUICTION DU CODE CHAUFFEUR */
					code_identification = Chauffeur.genererNumeroIdentification(name, firstName, anneeEmbauche);
					ArrayList<Trajet> trajectoire = new ArrayList<>();

					/* INSTANCIER L'OBET CHAUFFEUR */
					Chauffeur driver = new Chauffeur(name, firstName, anneeEmbauche, address, trajectoire,
							code_identification);

					/* AJOUTER DANS LA LISTE */
					autoDeluxe.ajout_chauffeur(driver);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/********************************************************************************************/
	/**
	 * FONCTION QUI PERMET DE LIRE LES CONTENUES DU FICHIER (LIMOUSINE), PUIS
	 * L'AJOUTER DANS LA LISTE
	 *
	 * LIRE LES LIGNES DU FICHIER LIMOUSINE
	 * 
	 * @param filePath Chemin d'accès au fichier.
	 * 
	 * @see FileInputStream
	 * 
	 * @see BufferedInputStream
	 * 
	 * @see Scanner
	 */
	private static void operation_ajout_limousine(String filePath) {
		File file = new File(filePath);
		ligneVide = false;

		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Scanner scan = new Scanner(bis)) {

			/* ON PARCOURS CHAQUE LIGNE AVEC LA BOUCLE WHILE() */
			while (scan.hasNextLine() && !ligneVide) {
				// LIRE LA LIGNE POUR ENSUITE VERIFIER
				String ligneLue = scan.nextLine();
				// VERIFIER SI LA LIGNE EST VIDE, SI "TRUE", ON SORT DE LA BOUCLE WHILE(ON
				// N'ARRETE DE LIRE LE FICHIER)
				if (ligneLue.equals("")) {
					ligneVide = true;
				} else {

					String[] infoLimousine = ligneLue.split("\t");

					/* AFFECTATION DE CHAQUE OBJET DANS LA VARIABLE */
					codeImmatriculation = infoLimousine[0];
					double reservoir = Integer.parseInt(infoLimousine[1]);
					String color = infoLimousine[2];

					/* INSTANCIER L'OBJET LIMOUSINE */
					Limousine vehicule = new Limousine(codeImmatriculation, reservoir, color);

					/* AJOUTER DANS LA LISTE */
					autoDeluxe.ajout_Limousine(vehicule);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/********************************************************************************************/
	/**
	 * FONCTION QUI PERMET DE LIRE LES CONTENUES DU FICHIER (TRAJET), PUIS L'AJOUTER
	 * DANS LA LISTE
	 * 
	 * LIRE LES LIGNES DU FICHIER TRAJET
	 * 
	 * @param filePath Chemin d'accès au fichier.
	 * 
	 * @see FileInputStream
	 * 
	 * @see BufferedInputStream
	 * 
	 * @see Scanner
	 */
	private static void operation_ajout_trajet(String filePath) {
		File file = new File(filePath);
		ligneVide = false;

		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Scanner scan = new Scanner(bis)) {

			/* ON PARCOURS CHAQUE LIGNE AVEC LA BOUCLE WHILE() */
			while (scan.hasNextLine() && !ligneVide) {
				// LIRE LA LIGNE POUR ENSUITE VERIFIER
				String ligneLue = scan.nextLine();
				// VERIFIER SI LA LIGNE EST VIDE, SI "TRUE", ON SORT DE LA BOUCLE WHILE(ON
				// N'ARRETE DE LIRE LE FICHIER)
				if (ligneLue.equals("")) {
					ligneVide = true;
				} else {

					String[] infoLimousine = ligneLue.split("\t");

					/* AFFECTATION DE CHAQUE OBJET DANS LA VARIABLE */
					code_identification = infoLimousine[0];
					String villeDepart = infoLimousine[1];
					String villeArrivee = infoLimousine[2];
					double kilometrage_depart = Integer.parseInt(infoLimousine[3]);
					double kilometrage_arrivee = Integer.parseInt(infoLimousine[4]);
					codeImmatriculation = infoLimousine[5];
					Limousine limousine_find = autoDeluxe.rechercheLimousine(codeImmatriculation);

					/* INSTANCIER L'OBJET TRAJET */
					Trajet way = new Trajet(villeDepart, villeArrivee, kilometrage_depart, kilometrage_arrivee,
							limousine_find);

					/* AJOUT DANS LA CLASSE CHAUFFEUR */
					autoDeluxe.rechercheChauffeur(code_identification).ajouterTrajetListe(way);

					/* AJOUT DANS LA CLASSE COMPAGNIE */
					autoDeluxe.ajout_Trajet(way);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erreur : (Possibilité)\n\t1. Soit il y a une information manquante dans votre fichier\n"
					+ "\t2. Soit Votre Nom a moins de 3 lettres");
		}
	}

}
