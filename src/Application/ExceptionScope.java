
/** ExceptionScope.java	***************************************************************************/
/**********			@Authors : ISMAEL COULIBALY & XUAYO HU & JOSUE LUBAKI					*******/
/**************************************************************************************************/
package Application;

public class ExceptionScope extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor
	public ExceptionScope() {
		super("\nLe Numero d'Identification saisi ne correspond � aucun Chauffeur de la Compagnie");
	}
}
