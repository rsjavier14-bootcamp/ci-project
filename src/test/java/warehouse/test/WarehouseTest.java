package warehouse.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import warehouse.Warehouse;

/**
 * Test for the Warehouse class
 * 
 * @author rsjav
 *
 */
class WarehouseTest {

	/**
	 * Check if the names do not have the required characters
	 * 
	 * @param name Name of the Warehouse
	 */
	@ParameterizedTest
	@ValueSource(strings = { "fail", "failfailfailfail", "      " })
	void testInvalidNameLength(String name) {
		Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Warehouse(name);
		});

		assertEquals("Debe ingresar un minimo de 5 caracteres y un maximo de 15 caracteres", ex.getMessage());
	}

	/**
	 * Check if the names are valid
	 * 
	 * @param name Name of the Warehouse
	 */
	@ParameterizedTest
	@ValueSource(strings = { "valid", "warehouse new01 ", "  valid2    " })
	void testValidName(String name) {
		assertEquals(name.trim(), new Warehouse(name).getName());
	}

	/**
	 * Check if the name is not null
	 */
	@Test
	void testNotNullName() {
		String name = null;
		Assertions.assertThrows(AssertionError.class, () -> {
			new Warehouse(name);
		});
	}
}
