package main.java.console;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class inventario {
    private List<product> productos;
    private static final String ARCHIVO_JSON = "inventario.json";

    public inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(product producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombre));
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            productos.forEach(System.out::println);
        }
    }

    public void guardarInventario() {
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON)) {
            Gson gson = new Gson();
            gson.toJson(productos, writer);
            System.out.println("Inventario guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarInventario() {
        try (FileReader reader = new FileReader(ARCHIVO_JSON)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<product>>() {}.getType();
            productos = gson.fromJson(reader, listType);
            System.out.println("Inventario cargado correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo cargar el inventario. ¿El archivo existe?");
        }
    }
}
