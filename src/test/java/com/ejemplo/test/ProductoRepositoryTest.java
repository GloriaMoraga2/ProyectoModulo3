package com.ejemplo.test;
import com.ejemplo.model.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.repository.ProductoRepository;

public class ProductoRepositoryTest {
    @Test
    void deberiaEliminarProductoId(){
        ProductoRepository repo = new ProductoRepository();
        repo.guardar(new Producto(1,"Pantalon", 15.990));
        repo.guardar(new Producto(2, "Poleron", 29.990));

        repo.eliminar(1);

        assertEquals(1, repo.obtenerTodos().size());
        assertEquals(2, repo.obtenerTodos().get(0).getId());
    }
}
