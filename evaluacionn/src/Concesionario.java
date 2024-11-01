import java.io.*;
        import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Concesionario {
    private static final String ARCHIVO_DATOS = "carros.dat";
    private List<Carro> listaCarros;

    public Concesionario() {
        listaCarros = new ArrayList<>();
        cargarCarros();
    }
    public static void Pausar(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dale enter para continuar🥰....");
        scanner.nextLine();
    }
    public void agregarCarro(Carro carro) {
        listaCarros.add(carro);
        guardarCarros();
    }

    public List<Carro> verCarros() {
        System.out.println("Carros🚗:");
        for (Carro carro : listaCarros) {
            System.out.println(carro);
        }
        Pausar();
        return listaCarros;

    }



    public void actualizarCarro() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Placa del carro: ");
        String placa = scanner.next();
        for (Carro carro : listaCarros) {
            if (carro.getPlaca().equals(placa)) {
                System.out.print("Nuevo color: ");
                String nuevoColor = scanner.next();
                Carro carroActualizado = new Carro(carro.getModelo(), placa, nuevoColor, carro.getAno());
                listaCarros.set(listaCarros.indexOf(carro), carroActualizado);

                guardarCarros();
                System.out.println("Carro actualizado exitosamente🚗👌.");
                Pausar();
                return;

            }
        }
        System.out.println("Carro con placa " + placa + " no encontrado😔❌.");
        Pausar();
    }


    public void eliminarCarro() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Placa del carro: ");
        String placa = scanner.nextLine();
        for (Carro carro : listaCarros) {
            if (carro.getPlaca().equals(placa)) {
                listaCarros.removeIf(carrito -> carrito.getPlaca().equalsIgnoreCase(placa));
                guardarCarros();
                System.out.println("Carro eliminado exitosamente🚗👌.");
                Pausar();
                return;
            }
        }
        System.out.println("Carro con placa " + placa + " no encontrado😔❌.");
        Pausar();
    }

    public void generarReporte() {

        System.out.println("Para crear un reporte debe indicar a partir de que año no deseas que se registre el carro🚗:");
        Scanner scanner = new Scanner(System.in);
        float ano = scanner.nextInt();
        List<Carro> filteredList = listaCarros.stream().filter(e -> e.getAno() >= ano).toList();
        String report = filteredList.toString();
        if (report.equals("[]")){
            System.out.println("No hay ninguna persona con las especificaciones que nos propocionaste ");
            Pausar();
        }else{
            try (PrintWriter writer = new PrintWriter(new FileWriter("reporte.txt"))) {
                for (Carro carro : filteredList) {
                    writer.println(carro);
                }
                System.out.println("Reporte generado📃👌.");
                Pausar();
            } catch (IOException e) {
                System.err.println("Error al escribir el reporte😔: " + e.getMessage());
                Pausar();
            }
    }   }

    private void guardarCarros() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS))) {
            oos.writeObject(listaCarros);

        } catch (IOException e) {
            System.err.println("Error al guardar los carros😔: " + e.getMessage());

        }
    }

    private void cargarCarros() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS))) {
            listaCarros = (List<Carro>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontraron datos previos, iniciando desde cero😔.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los carros❌: " + e.getMessage());
        }
    }
}
