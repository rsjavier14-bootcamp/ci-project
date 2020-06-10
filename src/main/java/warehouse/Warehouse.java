package warehouse;

/**
 * This class defines Warehouse type objects with a parameter name
 * 
 * @author rsjav
 *
 */
public class Warehouse {

	private String _name;

	/**
	 * Constructor of the class. It receive a parameter of type String
	 * 
	 * @param name
	 */
	public Warehouse(String name) {
		assert name != null;

		if (name.trim().length() < 5 || name.trim().length() > 15)
			throw new IllegalArgumentException("Debe ingresar un minimo de 5 caracteres y un maximo de 15 caracteres");

		_name = name.trim();
	}

	/**
	 * Get warehouse name
	 * 
	 * @return _name Warehouse name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Set a name for the warehouse
	 * 
	 * @param name Name for the warehouse
	 */
	public void setName(String name) {
		_name = name;
	}

}
