abstract class MetodoPago {
    public abstract void procesarPago(double monto);
}
// Clases 
class TarjetaCredito extends MetodoPago{
    @Override
    public void procesarPago(double monto){
        System.out.println("Su pago con tarjeta de crédito fue un éxito. Monto pagado: $" + monto);
    }
}

class Paypal extends MetodoPago{
    @Override
    public void procesarPago(double monto){
        System.out.println("Su pago con Paypal fue un éxito. Monto pagado: $" + monto);
    }
}

public class Main{
    public static void main(String[] args) {
      // Creamos instancias de los métodos de pago
        MetodoPago TarjetaCredito = new TarjetaCredito();
        MetodoPago paypal = new Paypal();

        //Procesamos pagos con diferentes metodos
        TarjetaCredito.procesarPago(100);
        paypal.procesarPago(325);
    }
}