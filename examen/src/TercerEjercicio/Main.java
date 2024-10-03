package examen.src.TercerEjercicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

class Jugador {
    private String nombre;
    private int experiencia;
    private List<String> misionesSuperadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.experiencia = 0;
        this.misionesSuperadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public boolean superaMision(Mision mision) {
        
        Random random = new Random();
        return random.nextBoolean(); // Supongamos que siempre la supera para este ejemplo.
    }

    public boolean addMisionSuperada(String nombreMision) {
        if (!misionesSuperadas.contains(nombreMision)) {
            misionesSuperadas.add(nombreMision);
            return true;
        }
        return false;
    }

    public void incrementarExperiencia(int puntos) {
        this.experiencia += puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

abstract class Mision {
    protected String nombre;
    protected int puntosExperiencia;

    public Mision(String nombre, int puntosExperiencia) {
        this.nombre = nombre;
        this.puntosExperiencia = puntosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosExperiencia() {
        return puntosExperiencia;
    }

    public abstract boolean completarMision(Jugador jugador);
}

class MisionFacil extends Mision {
    public MisionFacil(String nombre, int puntosExperiencia) {
        super(nombre, puntosExperiencia);
    }

    @Override
    public boolean completarMision(Jugador jugador) {
        return jugador.superaMision(this);
    }
}

class MisionCasiImposible extends Mision {
    public MisionCasiImposible(String nombre, int puntosExperiencia) {
        super(nombre, puntosExperiencia);
    }

    @Override
    public boolean completarMision(Jugador jugador) {
        return jugador.superaMision(this);
    }
}

class Aventura {
    private String nombre;
    private List<Mision> misiones;
    private List<Jugador> jugadores;

    public Aventura(String nombre) {
        this.nombre = nombre;
        this.misiones = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    public void agregarMision(Mision mision) {
        misiones.add(mision);
    }

    public boolean agregarJugador(Jugador jugador) {
        if (jugadores.contains(jugador)) {
            return false; 
        }

        jugadores.add(jugador);

        for (Mision mision : misiones) {
            if (jugador.superaMision(mision)) {
                if (jugador.addMisionSuperada(mision.getNombre())) {
                    jugador.incrementarExperiencia(mision.getPuntosExperiencia());
                }
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creamos una aventura y misiones
        Aventura aventura = new Aventura("Aventura Épica");

        Mision mision1 = new MisionFacil("Rescatar al Príncipe", 50);
        Mision mision2 = new MisionCasiImposible("Derrotar al Dragón", 100);

        // Agregamos las misiones
        aventura.agregarMision(mision1);
        aventura.agregarMision(mision2);

        Jugador jugador = new Jugador("Arthur");

        // agregamos aventura al jugador
        if (aventura.agregarJugador(jugador)) {
            System.out.println("El jugador ha sido agregado y ha ganado experiencia.");
            System.out.println("Experiencia del jugador: " + jugador.getExperiencia());
        } else {
            System.out.println("El jugador ya estaba en la aventura.");
        }
    }
}
