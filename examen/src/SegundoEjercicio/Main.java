package examen.src.SegundoEjercicio;

import java.util.ArrayList;
import java.util.List;

abstract class Mision {
    private String nombre;
    private String dificultad;
    private int puntosExRecompensa;
    protected int minimoPuntosExRequeridos;
    
    public Mision(String nombre, String dificultad, int puntosExRecompensa, int minimoPuntosExRequeridos) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.puntosExRecompensa = puntosExRecompensa;
        this.minimoPuntosExRequeridos = minimoPuntosExRequeridos;
    }
    public boolean superaMision(Jugador jugador) {
        return minimoPuntosExRequeridos <= jugador.getPuntosExperienciaAcumulados();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntosEXdeRecompensa() {
        return puntosExRecompensa;
    }
}
class MisionCasiImposible extends Mision {
    private List<String> accionesRequeridas;

    public MisionCasiImposible(String nombre, String dificultad, int puntosEXdeRecompensa, int minimoPuntosEXRequeridos) {
        super(nombre, dificultad, puntosEXdeRecompensa, minimoPuntosEXRequeridos);
        this.accionesRequeridas = new ArrayList<>();
    }

    public boolean superaMision(Jugador jugador) {
        if (!super.superaMision(jugador)) {
            return false;
        }
        int accionesFaltantes = 0;
        for (String accion : accionesRequeridas) {
            if (!jugador.realizoAccion(accion)) {
                accionesFaltantes++;
            }
        }
        return accionesFaltantes < jugador.getCantidadMisionesSuperadas();
    }

    public boolean addAccionRequerida(String accion) {
        if (!accionesRequeridas.contains(accion)) {
            accionesRequeridas.add(accion);
            return true;
        }
        return false;
    }
}

class Jugador {
    private String nombre;
    private int puntosExperienciaAcumulados;
    private List<String> accionesRealizadas;
    private int cantidadMisionesSuperadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosExperienciaAcumulados = 0;
        this.accionesRealizadas = new ArrayList<>();
        this.cantidadMisionesSuperadas = 0;
    }

    public boolean realizoAccion(String elemento) {
        return accionesRealizadas.contains(elemento);
    }

    public void addAccion(String elemento) {
        if (!accionesRealizadas.contains(elemento)) {
            accionesRealizadas.add(elemento);
        }
    }

    public void incrementarPuntosExperiencia(int puntosEx) {
        puntosExperienciaAcumulados += puntosEx;
    }

    public int getPuntosExperienciaAcumulados() {
        return puntosExperienciaAcumulados;
    }

    public void addMisionSuperada() {
        cantidadMisionesSuperadas++;
    }

    public int getCantidadMisionesSuperadas() {
        return cantidadMisionesSuperadas;
    }
}

public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Pablo");

        MisionCasiImposible misionCasiImposible = new MisionCasiImposible("Mision", "Dificl", 500, 500);
        
        misionCasiImposible.addAccionRequerida("llegar al castillo");
        misionCasiImposible.addAccionRequerida("recoger la espada");

        jugador.addAccion("llegar al castillo");
        jugador.incrementarPuntosExperiencia(550);
        jugador.addMisionSuperada();
        
        if (misionCasiImposible.superaMision(jugador)) {
            System.out.println("¡Misión superada!");
        } else {
            System.out.println("Misión no superada.");
        }
    }
    
}
