import module.Producto;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("TIENDA DE BARRIO");
        mostrarMenu();
    }

    static void mostrarMenu(){
        System.out.println();
        System.out.println(" MENU: ");
        System.out.println("1. Ver inventario completo");
        System.out.println("2. Buscar precio de un producto");
        System.out.println("3. Registrar venta");
        System.out.println("4. Buscar por:");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese opcion: ");
        int opcion = scanner.nextInt();

        switch (opcion){
            case 1 -> verInventario();
            case 2 -> mostrarPrecio();
            case 3 -> agregarProducto();
            default -> {
                System.out.println("Opción no valida");
                mostrarMenu();
            }
        }
        mostrarMenu();
    }

    //VER INVENTARIO COMPLETO
    static void verInventario(){
        System.out.println("INVENTARIO COMPLETO: ");
        System.out.println("NOMBRE  |  DESCRIPCION  |  CATEGORIA  |  ETIQUETA  |  PRECIO  |  URL");

        try {
            File file = new File("resources/Inventario.csv");
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //BUSCAR PRODUCTO Y MOSTRAR PRECIO
    static void mostrarPrecio(){
        System.out.println("BUSCAR PRECIO DE UN PRODUCTO: ");
        System.out.println("Ingrese nombre del producto: ");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        try {
            File file = new File("resources/Inventario.csv");
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] datos = line.split(",");
                if (datos[0].equals(nombre)){
                    System.out.println("El precio de " + nombre + " es " + datos[4]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //REGISTRAR VENTAS
    static void agregarProducto(){
        System.out.println("AGREGAR NUEVO PRODUCTO: ");
        System.out.println("Ingrese nombre del producto: ");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        System.out.println("Ingrese descripcion del producto: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese categoria del producto: ");
        String categoria = scanner.nextLine();
        System.out.println("Ingrese etiqueta del producto: ");
        String etiqueta = scanner.nextLine();
        System.out.println("Ingrese precio del producto: ");
        float precio = scanner.nextFloat();
        System.out.println("Ingrese url de la imagen del producto: ");
        String url = scanner.nextLine();

        //Agregar producto al archivo
        Producto producto = new Producto(nombre,descripcion, precio, categoria, etiqueta, url);

        //Agregar nuevo producto al archivo csv
        try {
            FileWriter fileWriter = new FileWriter("resources/Inventario.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("\r" + nombre + "," + descripcion + "," + precio+ "," + categoria + "," + etiqueta + "," + url);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}