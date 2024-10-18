package main.java.console;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        inventario inventario = new inventario();
        Scanner scanner = new Scanner(System.in);
        inventario.cargarInventario();

        while (true) {
            System.out.println("Opciones: 1. Agregar 2. Eliminar 3. Mostrar 4. Guardar 5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre del producto:");
                    String nombre = scanner.nextLine();
                    System.out.println("Cantidad:");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    inventario.agregarProducto(new product(nombre, cantidad));
                    break;

                case 2:
                    System.out.println("Nombre del producto a eliminar:");
                    String nombreEliminar = scanner.nextLine();
                    inventario.eliminarProducto(nombreEliminar);
                    break;

                case 3:
                    inventario.mostrarProductos();
                    break;

                case 4:
                    inventario.guardarInventario();
                    break;

                case 5:
                    inventario.guardarInventario();
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
