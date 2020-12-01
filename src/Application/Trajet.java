
/** Trajet.java	***********************************************************************************/
/**********			@Authors : ISMAEL COULIBALY & XUAYO HU & JOSUE LUBAKI					*******/
/**************************************************************************************************/
package Application;

public class Trajet {
	/* ENCAPSULATION DES VARIABLES COMPOSANTES DE LA CLASSE TRAJET */
	private final String villeDepart;
	private final String villeArrivee;
	private final double kilometrageArrivee;
	private final double kilometrageDepart;
	private final Limousine limousine;

	// CONSTRUCTOR
	public Trajet(String villeDepart, String villeArrivee, double kilometrageDepart, double kilometrageArrivee,
			Limousine limousine) {
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.kilometrageArrivee = kilometrageArrivee;
		this.kilometrageDepart = kilometrageDepart;
		this.limousine = limousine;

	}// Fin CONSTRUCTOR

	/**************************************************************************************************/
	/* LES GETTERS DE LA CLASSE TRAJET */
	public String getLimousine_info() {
		return limousine.toString();
	}

	/**************************************************************************************************/
	public String toString() {
		return "***********************************************************************************"
				+ "\n. Depart: " + villeDepart + "\n. Arrivee: " + villeArrivee + "\n. Kilometrage de depart: "
				+ kilometrageDepart + "\n. Kilometrage d'arrivee: " + kilometrageArrivee + "\n. Limousine Utilis�e : "
				+ limousine;
	}
}
