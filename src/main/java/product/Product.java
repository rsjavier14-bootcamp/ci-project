package product;

/**
 * This class defines Product type objects with a parameter name and price
 * 
 * @author rsjav
 *
 */
public class Product {

	private String _name;
	private int _price;

	/**
	 * Constructor of the class. It receives two parameters, one of type int and the
	 * other of type string
	 * 
	 * @param name
	 * @param price
	 */
	public Product(String name, int price) {
		assert name != null;
		assert price <= Integer.MAX_VALUE;

		if (name.trim().length() < 5 || name.trim().length() > 15)
			throw new IllegalArgumentException("Debe ingresar un minimo de 5 caracteres y un maximo de 15 caracteres");

		if (price <= 0)
			throw new IllegalArgumentException("Debe ingresar un precio mayor a 0 (cero)");

		_name = name.trim();
		_price = price;
	}

	/**
	 * Get product name
	 * 
	 * @return _name Product name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Set a name for the product
	 * 
	 * @param name Name for the product
	 */
	public void setName(String name) {
		assert name != null;

		if (name.trim().length() < 5 || name.trim().length() > 15)
			throw new IllegalArgumentException("Debe ingresar un minimo de 5 caracteres y un maximo de 15 caracteres");

		_name = name.trim();
	}

	/**
	 * Get product price
	 * 
	 * @return price The product price
	 */
	public int getPrice() {
		return _price;
	}

	/**
	 * Set a price for the product
	 * 
	 * @param price Price for the product
	 */
	public void setPrice(int price) {
		assert price <= Integer.MAX_VALUE;

		if (price <= 0)
			throw new IllegalArgumentException("Debe ingresar un precio mayor a 0 (cero)");

		_price = price;
	}
}
