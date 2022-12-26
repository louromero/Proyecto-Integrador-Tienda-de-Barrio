import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Crear array bidimensional - Se coloca un absurdo
        String[][] inventario = new String[100][6];
        System.out.println("----------TIENDA DEL BARRIO----------");
        mostrarMenu(inventario);
    }
    static void mostrarMenu(String[][] inventario){
        System.out.println();
        System.out.println("MENU:");
        System.out.println("1_ Agregar Suministros");
        System.out.println("2_ Ver inventario completo");
        System.out.println("3_ Ver productos en falta");
        System.out.println("4_ Buscar en inventario");
        System.out.println("5_ Eliminar producto (se pone en 0 todo)");
        System.out.println("5_ Editar producto");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una opcion: ");
        int opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1 -> inventario = agregarSuministros(inventario);
            case 2 -> verInventarioCompleto(inventario);
            case 3 -> verProductosEnFalta(inventario);
            case 4 -> buscarEnInventario(inventario);
            case 5 -> inventario = eliminarProducto(inventario);
            case 6 -> inventario=editarProducto(inventario);
            default -> {
                System.out.println("Opcion no valida");
                mostrarMenu(inventario);
            }
        }
        mostrarMenu(inventario);
    }

    static String[][] agregarSuministros(String[][] inventario) {
        System.out.println("REGISTRAR VENTAS");
        Scanner scanner = new Scanner(System.in);
        int seguir =1;
        int cont = 0;
        while(inventario[cont][2] != null){
            cont++;
        }

        while(seguir==1 && cont<inventario.length){
            System.out.println();
            System.out.println("PRODUCTO N° "+(cont+1));

            System.out.print("Ingrese el nombre del producto: ");
            inventario[cont][0]=scanner.nextLine();

            System.out.print("Ingrese la categoria del producto: ");
            inventario[cont][1]=scanner.nextLine();

            System.out.print("Ingrese la etiqueta del producto: ");
            inventario[cont][2]=scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            inventario[cont][3]=scanner.nextLine();

            System.out.print("Ingrese URL del producto: ");
            inventario[cont][4]=scanner.nextLine();

            System.out.print("Es producto en falta (1 si - 0 no): ");
            inventario[cont][5]=scanner.nextLine();

            cont++;

            System.out.print("Para registrar otra venta marque 1 (para salir 0): ");
            seguir = scanner.nextInt();
            scanner.nextLine();

        }

        if(cont== inventario.length){
            System.out.println("    NO HAY ESPACIO EN EL ARRAY!!!   ");
        }

        return inventario;
    }

    static void verInventarioCompleto(String[][] inventario){
        System.out.println("INVENTARIO COMPLETO");
        System.out.println("ID | NOMBRE | CATEGORIA | ETIQUETAS | PRECIO | URL FOTO | EN FALTA");
        for(int i=0;i< inventario.length;i++){
            System.out.print((i+1)+": ");
            for(int j=0;j<inventario[i].length;j++){
                System.out.print(inventario[i][j]+" | ");
            }
            System.out.println();
        }
    }

    static void verProductosEnFalta(String[][] inventario){
        System.out.println("VER PRODUCTOS EN FALTA");
        System.out.println("ID | NOMBRE | CATEGORIA | ETIQUETAS | PRECIO | URL FOTO | EN FALTA");

        for(int i=0;i< inventario.length;i++){
            if (inventario[i][5]!=null){
                if(inventario[i][5].equals("1") || inventario[i][5].equals("si")){
                    System.out.print((i+1)+": ");
                    for(int j=0;j<inventario[i].length;j++){
                        System.out.print(inventario[i][j]+" | ");
                    }
                    System.out.println();
                }
            }
        }
    }

    static void buscarEnInventario(String[][] inventario){
        System.out.println("BUSCAR PALABRA EN INVENTARIO");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Buscar en: ");
        System.out.println(" 1. Id");
        System.out.println(" 2. Nombre");
        System.out.println(" 3. Categoria");
        System.out.println(" 4. Etiqueta");
        System.out.println(" 5. Precio");
        System.out.println(" 6. URL Foto");

        int opcion=scanner.nextInt();
        scanner.nextLine(); //Para que no se realicen saltos

        System.out.print("Ingrese palabra o ID a buscar: ");
        String palabra =scanner.nextLine();
        System.out.println();
        System.out.println("ID | NOMBRE | CATEGORIA | ETIQUETAS | PRECIO | URL FOTO | EN FALTA");

        if(opcion == 1){
            int num=Integer.parseInt(palabra);
            System.out.print((palabra)+": ");
            for(int j = 0; j<inventario[num-1].length; j++){
                System.out.print(inventario[num-1][j]+" | ");
            }
        }else{
            for(int i=0;i< inventario.length;i++){
                if (inventario[i][opcion-2]!=null){
                    if(inventario[i][opcion-2].equals(palabra)){
                        System.out.print((i+1)+": ");
                        for(int j=0;j<inventario[i].length;j++){
                            System.out.print(inventario[i][j]+" | ");
                        }
                        System.out.println();
                    }
                }
            }
        }

    }

    static String[][] eliminarProducto(String[][] inventario){
        System.out.println("ELIMINAR PRODUCTO");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del producto a eliminar: ");
        int num=scanner.nextInt();
        //Se completan todas las casillas con 0
        Arrays.fill(inventario[num], "0");
        return inventario;
    }

    static String[][] editarProducto(String[][] inventario){
        System.out.println("EDITAR PRODUCTO");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del producto a editar: ");
        int num=scanner.nextInt();
        int salir=0;
        while(salir==0){
            System.out.println("Que desearia editar: ");
            System.out.println(" 1. Nombre");
            System.out.println(" 2. Categoria");
            System.out.println(" 3. Etiqueta");
            System.out.println(" 4. Precio");
            System.out.println(" 5. URL Foto");
            int opcion= scanner.nextInt();
            System.out.print("Cambiar "+inventario[num-1][opcion-1]+" por: ");
            String nuevo=scanner.nextLine();
            inventario[num-1][opcion-1]=nuevo;
            System.out.println("Se guardo exitosamente!");
            System.out.println("Quiere seguir editando este producto? (1 para salir - 0 para editar): ");
            salir=scanner.nextInt();
        }

        return inventario;
    }
}