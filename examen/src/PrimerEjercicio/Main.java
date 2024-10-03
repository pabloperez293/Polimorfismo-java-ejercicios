package examen.src.PrimerEjercicio;

import java.util.ArrayList;
import java.util.List;

class MisionCasiImposible {
    private String nombre;
    private String dificultad;
    private int puntosEXdeRecompensa;
    private int minimoPuntosEXRequeridos;
    private List<String> accionesRequeridas;

    // Constructores
    public MisionCasiImposible(String nombre, String dificultad, int puntosEXdeRecompensa,
            int minimoPuntosEXRequeridos) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.puntosEXdeRecompensa = puntosEXdeRecompensa;
        this.minimoPuntosEXRequeridos = minimoPuntosEXRequeridos;
        this.accionesRequeridas = new ArrayList<>();
    }

    public boolean addAccionRequerida(String accion) {
        if (!accionesRequeridas.contains(accion)) {
            accionesRequeridas.add(accion);
            return true; 
        }
        return false; 
    }

    // Métodos 
    public String getNombre() {
        return nombre;
    }
    public int getPuntosEXRecompensa() {
        return puntosEXdeRecompensa;
    }
    public boolean superaMision(int puntosExperiencia) {
        return puntosExperiencia >= minimoPuntosEXRequeridos;
    }
}

public class Main {
    public static void main(String[] args) {
        MisionCasiImposible m1 = new MisionCasiImposible("Mision", "dificil", 100, 200);

        boolean resultado = m1.addAccionRequerida("llegar al castillo");

        System.out.println("Tomar desiccion " + resultado);

        int puntosJugador = 150;
        boolean supera = m1.superaMision(puntosJugador);
        System.out.println("¿El jugador con " + puntosJugador + " puntos de experiencia supera la misión? " + supera);
    }
}