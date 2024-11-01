public class Validador {
    public static String validarLetras(String str) throws IllegalArgumentException {
        if (!str.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IllegalArgumentException("Debe contener sólo letras .❌❌");
        }

        return str;
    }


}

