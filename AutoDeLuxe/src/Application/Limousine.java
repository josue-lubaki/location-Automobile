
/** Limousine.java	*******************************************************************************/
/**********			@Authors : ISMAEL COULIBALY & XUAYO HU & JOSUE LUBAKI					*******/
/**************************************************************************************************/
package Application;

public class Limousine {
	/* ENCAPSULATION DES VARIABLES COMPOSANTES DE LA CLASSE LINOUSINE */
	private final String immatriculation;
	private final double capaciteReservoir;
	private final String couleur;

	// CONSTRUCTOR
	public Limousine(String immatriculation, double capaciteReservoir, String couleur) {
		this.immatriculation = immatriculation;
		this.capaciteReservoir = capaciteReservoir;
		this.couleur = couleur;

	}// Fin CONSTRUCTOR

	/**************************************************************************************************/
	/* LES GETTERS ET SETTERS DE LA CLASSE TRAJET */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**************************************************************************************************/

	public String toString() {
		return "\n\t\t. Immatriculation: " + immatriculation + "\n\t\t. Capacite du Reservoir: "
				+ capaciteReservoir + " litres\n\t\t. Couleur: " + couleur;
	}

}
