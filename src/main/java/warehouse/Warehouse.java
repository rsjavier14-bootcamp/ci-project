package warehouse;

public class Warehouse {

	private String _name;

	public Warehouse(String name) {
		assert name != null;

		if (name.trim().length() < 5 || name.trim().length() > 15)
			throw new IllegalArgumentException("Debe ingresar un minimo de 5 caracteres y un maximo de 15 caracteres");

		_name = name.trim();
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

}
