import Sistema.Asistente;
import TDAStp.Cola.ColaAsistente;
import TDAStp.Cola.ColaTDA;
import TDAStp.Conjuntoinfo.ConjuntoA;
import TDAStp.Conjuntoinfo.ConjuntoTDA;
import TDAStp.Diccionario.DiccionarioSimpleA;
import TDAStp.Diccionario.DiccionarioSimpleTDA;

public class Main {

    public static void main(String[] args) {

        int cantIngresos = 0;

        // Crear asistentes
        Asistente a1 = new Asistente(12345678, "Gustavo Sanchez", "VIP");
        Asistente a2 = new Asistente(23456789, "Katy Pérez", "General");
        Asistente a3 = new Asistente(34567890, "Noah López", "VIP");
        Asistente a4 = new Asistente(45678901, "Lucía Martínez", "General");
        Asistente a5 = new Asistente(56789012, "Tomás Fernández", "VIP");

        // Inicializar diccionario de asistentes
        DiccionarioSimpleTDA dicAsistente = new DiccionarioSimpleA();
        dicAsistente.InicializarDiccionario();

        dicAsistente.Agregar(a1.DNI, a1);
        dicAsistente.Agregar(a2.DNI, a2);
        dicAsistente.Agregar(a3.DNI, a3);
        dicAsistente.Agregar(a4.DNI, a4);
        dicAsistente.Agregar(a5.DNI, a5);

        // Inicializar estructuras auxiliares
        ConjuntoTDA predio = new ConjuntoA();
        predio.InicializarConjunto();

        ConjuntoTDA dniClaves = dicAsistente.Claves();

        ColaTDA colaPredio = new ColaAsistente();
        colaPredio.InicilizarCola();

        ColaTDA registroEgreso = new ColaAsistente();
        registroEgreso.InicilizarCola();

        // Pasar asistentes a la cola de ingreso
        while (!dniClaves.ConjuntoVacio()) {
            int dni = dniClaves.Elegir();
            colaPredio.Acolar(dicAsistente.Recuperar(dni));
            dniClaves.Sacar(dni);
        }

        // Simular ingreso (entran todos)
        while (!colaPredio.ColaVacia()) {
            Asistente asistente = colaPredio.Primero();
            predio.Agregar(asistente.DNI);
            cantIngresos++;
            colaPredio.Desacolar();
        }

        // Simular egresos por lo menos 2 "aleatorios "
        int egresos = 0;
        for (int i = 0; i < 2; i++) {
            // Para el ejemplo: sacamos directamente dos asistentes cualquiera
            int dni = predio.Elegir();
            predio.Sacar(dni);
            registroEgreso.Acolar(dicAsistente.Recuperar(dni));
            egresos++;
        }

        // Mostrar registro de egresos
        System.out.println("Orden de egreso del predio:");
        while (!registroEgreso.ColaVacia()) {
            Asistente asistente = registroEgreso.Primero();
            System.out.println(asistente.DNI + " " + asistente.nombre + " " + asistente.tipoEntrada);
            registroEgreso.Desacolar();
        }

        // Estadísticas
        int cantAsistentesPresentes = cantIngresos - egresos;

        System.out.println("\nEstadísticas:");
        System.out.println("Cantidad de ingresos : " + cantIngresos);
        System.out.println("Asistentes presentes: " + cantAsistentesPresentes );
        System.out.println("Asistentes egresados: " + egresos);


    }
}

