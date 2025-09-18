package Sistema;

import TDAStp.Conjunto.ConjuntoLD;
import TDAStp.Conjunto.ConjuntoAsistentesTDA;

public class Asistente {
    public String nombre;
    public int DNI;
    public String tipoEntrada;

    public Asistente(int DNI, String nombre, String tipoEntrada) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.tipoEntrada = tipoEntrada;
    }
}
