package ExamenBanEuro;

public class CuentaAhorro extends Cuenta {
    
    public CuentaAhorro(String nombre, String apellidos, double saldo, String codigoEntidad, String codigoOficina){
        
         super(nombre, apellidos, saldo, codigoEntidad, codigoOficina);
    }
    
    public boolean ingresar(double importe){
        
        if(importe>0 && (importe%50==0)){
            saldo += importe;
            return true;
            
        }else{
            System.out.println("La cantidad a ingresar debe ser positiva y múltiplo de 50");
            return false;
        }
    }
    
    public boolean retirar(double importe){
        
        if(importe<=saldo && (importe%200==0)){
            saldo-=importe;
            return true;
        
        }else if(importe<0){
           System.out.println("La cantidad a retirar debe ser positiva"); 
           return false;
           
        }else if(importe>saldo){
            System.out.println("No existe saldo suficiente"); 
            return false;
            
        }else if(importe%200!=0){
            System.out.println("Únicamente se pueden retirar múltiplos de 200€"); 
            return false;
        }
        
      return false;
    }
    
    private int calcularInteres(){
        
        int interes;
        
        if(saldo<1000){
            interes = 1;
        }else if(saldo>=1000){
            interes = 3;
        }else{
            interes = 5;
        }
        
        return interes;
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
        return "Cuenta{" + "cuenta=" + cuenta + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo +  ", interes= " + calcularInteres()+ "%" + "}";
    }
    
}
