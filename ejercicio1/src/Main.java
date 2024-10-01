abstract class Animal {
    public abstract void hacerSonido();
}

class Perro extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("El perro dice : Guau");
    }
}
// Clase Gato que hereda de Animal
class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El gato dice: Miau Miau!");
    }
}

// Clase Vaca que hereda de Animal
class Vaca extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("La vaca dice: Muuu Muuu!");
    }
}
// Clase principal donde se ejecuta el programa
public class Main {
    public static void main(String[] args) {
        // Instanciamos los objetos de tipo Animal
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        // Guardamos los animales en un array
        Animal[] animales = {perro, gato, vaca};
        // Recorremos el array y hacemos que cada animal haga su sonido
        for (Animal animal : animales) {
            animal.hacerSonido(); // Binding dinámico en tiempo de ejecución            
        }
    }
}