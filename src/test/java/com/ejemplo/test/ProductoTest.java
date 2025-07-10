package com.ejemplo.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.model.Producto;

public class ProductoTest {

    @Test
    void deberiaCrearProductoConDatosValidos() {
        Producto producto = new Producto(1, "Camiseta", 19.990);

        //Assert

        assertEquals(1, producto.getId());
        assertEquals("Camiseta", producto.getNombre());
        assertEquals(19.990, producto.getPrecio());
    }

    @Test
    void noDeberiaCrearProductoConNombreVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Producto(2, "", 29.99);
        });

        assertEquals("El nombre no puede estar vacío", exception.getMessage());
    }

    @Test
    void noDeberiaCrearProductoConPrecioNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Producto(3, "Zapatos", -15.990);
        });
        assertEquals("El precio no puede ser negativo", exception.getMessage());

    }
}
