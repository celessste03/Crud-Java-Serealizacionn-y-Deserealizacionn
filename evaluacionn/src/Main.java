import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        System.out.println("Concesionario de Carro 🚗🛻🚘");
        while (!salir) {
            System.out.println("1. Agregar Carro");
            System.out.println("2. Ver Carros");
            System.out.println("3. Actualizar Carro");
            System.out.println("4. Eliminar Carro");
            System.out.println("5. Generar Reporte");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion = validarEntrada(scanner);

            switch (opcion) {
                case 1:
                    agregarCarro(scanner,concesionario);
                    break;
                case 2:
                    concesionario.verCarros();
                    break;
                case 3:
                    concesionario.actualizarCarro();
                    break;
                case 4:
                   concesionario.eliminarCarro();
                    break;
                case 5:
                    concesionario.generarReporte();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige de nuevo.");
            }
        }
        scanner.close();
    }

    private static int validarEntrada(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingresa un número😑.");
            scanner.next();
        }
        return scanner.nextInt();
    }
   public static void Pausar(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dale enter para continuar🥰....");
        scanner.nextLine();
    }
    private static void agregarCarro(Scanner scanner, Concesionario concesionario) {
        String input = null;
        String modelo = ValidacionesTryCatch.Letras(input,"modelo del carro");

        System.out.print("Placa del carro: ");
        String placa = scanner.next();
        while (!placa.matches("[A-Z0-9]+")) {
            System.out.println("Placa inválida. Debe contener solo letras mayúsculas y números.");
            System.out.print("Placa del carro: ");
            placa = scanner.next();
        }
        String color = ValidacionesTryCatch.Letras(input," el color");

        System.out.print("Año del carro: ");
        int ano = scanner.nextInt();

        concesionario.agregarCarro(new Carro(modelo, placa, color, ano));
        System.out.println("Carro agregado🚗👌.");
        Pausar();

    }









    /*private static int validarAno(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingresa un año válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }*/


}