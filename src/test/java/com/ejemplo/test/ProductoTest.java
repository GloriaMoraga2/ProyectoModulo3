package com.ejemplo.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.model.Producto;
import  com.ejemplo.repository.ProductoRepository;

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
    @Test
    void deberiaActualizarProductoExistente(){
        ProductoRepository repo = new ProductoRepository();
        Producto original = new Producto(1, "Pantalon", 15.990);
        repo.guardar(original);

        Producto actualizado = new Producto(1, "Pantalon Sastrero", 16.990);
        repo.actualizar(actualizado);

        Producto resultado = repo.obtenerTodos().get(0);
        assertEquals("Pantalon Sastrero", resultado.getNombre());
        assertEquals(16.990, resultado.getPrecio());
    }


}
