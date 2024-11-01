import java.io.Serializable;

public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String modelo;
    private String placa;
    private String color;
    private float ano;

    public Carro(String modelo, String placa, String color, float ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.color = color;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getColor() {
        return color;
    }

    public float getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Carro{" + "modelo='" + modelo + '\'' + ", placa='" + placa + '\'' + ", color='" + color + '\'' + ", año=" + ano + '}';
    }
}

