package product.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import product.Product;

/**
 * Test for Product class
 * 
 * @author rsjav
 *
 */
class ProductTest {

	// Test for constructor

	/**
	 * Check if the names are invalid
	 * 
	 * @param name Name of the product
	 */
	@ParameterizedTest
	@CsvSource({ "fail, 23000", "failfailfailfail, 28000", "'      ', 28562" })
	void testInvalidName(String name, int price) {
		Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Product(name, price);
		});

		assertEquals("Debe ingresar un minimo de 5 caracteres y un maximo de 15 caracteres", ex.getMessage());
	}

	/**
	 * Check if the names are valid
	 * 
	 * @param name Name of the product
	 */
	@ParameterizedTest
	@ValueSource(strings = { "valid", "product new01 ", "  valid2    " })
	void testValidName(String name) {
		assertEquals(name.trim(), new Product(name, 12000).getName());
	}

	/**
	 * Check if the name is null
	 */
	@Test
	void testNullName() {
		String name = null;
		Assertions.assertThrows(AssertionError.class, () -> {
			new Product(name, 12000);
		});
	}

	/**
	 * Check if the price are not valid
	 */
	@Test
	void testInvalidMaxPrice() {
		int max = Integer.MAX_VALUE;

		Exception ex = Assertions.assertThrows(ArithmeticException.class, () -> {
			new Product("product1", Math.addExact(max, 1));
		});

		assertEquals("integer overflow", ex.getMessage());
	}

	/**
	 * Check if the price are not valid
	 * 
	 * @param price Price of the product
	 */
	@ParameterizedTest
	@ValueSource(ints = { Integer.MIN_VALUE, 0, -1 })
	void testPriceZeroOrMinor(int price) {
		Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Product("product1", price);
		});

		assertEquals("Debe ingresar un precio mayor a 0 (cero)", ex.getMessage());
	}

	// Test for getName and getPrice method

	/**
	 * Check is the name and price are good
	 * 
	 * @param name  Name of the product
	 * @param price Price of the product
	 */
	@ParameterizedTest
	@CsvSource({ "product1, 23000", "product2, 28000" })
	void testGetNameAndGetPrice(String name, int price) {
		Product product = new Product(name, price);
		assertTrue(product.getName() != null || product.getPrice() > 0);
		assertEquals(name, product.getName());
		assertEquals(price, product.getPrice());
	}

	// Test for setName

	/**
	 * Check if the names are invalid
	 * 
	 * @param name
	 */
	@ParameterizedTest
	@ValueSource(strings = { "fail", "failfailfailfail", "      " })
	void testSetInvalidName(String name) {
		Product product = new Product("product", 80000);
		Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			product.setName(name);
		});

		assertEquals("Debe ingresar un minimo de 5 caracteres y un maximo de 15 caracteres", ex.getMessage());
	}

	/**
	 * Check if the names are valid
	 * 
	 * @param name Name of the Product
	 */
	@ParameterizedTest
	@ValueSource(strings = { "valid", "product new01 ", "  valid2    " })
	void testSetValidName(String name) {
		Product product = new Product("product", 80000);
		product.setName(name);
		assertEquals(name.trim(), product.getName());
	}

	/**
	 * Check if the name is null
	 */
	@Test
	void testSetNullName() {
		Product product = new Product("product", 80000);
		String name = null;
		Assertions.assertThrows(AssertionError.class, () -> {
			product.setName(name);
		});
	}
}
