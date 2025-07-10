package com.ejemplo.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.model.Producto;

public class ProductoTest {

    @Test
    void deberiaCrearProductoConDatosValidos(){
        Producto producto = new Producto(1,"Camiseta", 19.990);

        //Assert

        assertEquals(1, producto.getId());
        assertEquals("Camiseta", producto.getNombre());
        assertEquals(19.990, producto.getPrecio());
    }

    @Test
    void noDeberiaCrearProductoNombreVacio(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
        new Producto(2,"", 29.990);
        });

        assertEquals("El nombre no puede estar vacio", exception.getMessage());
    }
}
