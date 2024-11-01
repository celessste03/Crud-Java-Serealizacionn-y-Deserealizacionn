import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacionesTryCatch {
    public static String Letras(String input,String campo){
        Scanner scanner = new Scanner(System.in);
        while (input == null){
            System.out.print("Ingrese el "+campo+":");
            try {

                input = Validador.validarLetras(scanner.nextLine());

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Error no controlado ❌❌");
                System.out.println(e.getMessage());
            }
        }
        return input;

    }


}
