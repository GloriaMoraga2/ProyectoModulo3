package com.ejemplo.repository;

import com.ejemplo.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {

    private List<Producto> productos = new ArrayList<>();

    public void guardar(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public void actualizar(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == producto.getId()) {
                productos.set(i, producto);
                return;
            }
        }
        throw new IllegalArgumentException("Producto con ID " + producto.getId() + " no encontrado");
    }

    public void eliminar(int id) {
        productos.removeIf(p -> p.getId() == id);
    }
}
