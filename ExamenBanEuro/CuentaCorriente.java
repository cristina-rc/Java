
package ExamenBanEuro;

public class CuentaCorriente extends Cuenta {
    
    public CuentaCorriente(String nombre, String apellidos, double saldo, String codigoEntidad, String codigoOficina){
        
        super(nombre, apellidos, saldo, codigoEntidad, codigoOficina);
    }

    public CCC getCuenta() {
        return cuenta;
    }

    public void setCuenta(CCC cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "cuenta=" + cuenta + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo + '}';
    }
    
    public boolean ingresar(double importe){
        
        if(importe>0){
            saldo += importe;
            return true;
            
        }else{
            System.out.println("La cantidad a ingresar debe ser positiva");
            return false;
        }
    }
    
    public boolean retirar(double importe){
        
        if(importe<=saldo){
            saldo-=importe;
            return true;
        
        }else if(importe<0){
           System.out.println("La cantidad a retirar debe ser positiva"); 
           return false;
           
        }else{
            System.out.println("No existe saldo suficiente en la cuenta"); 
            return false;
        }
        
    }

    
    
}   

