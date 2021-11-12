package ExamenBanEuro;

import java.io.Serializable;

public abstract class Cuenta implements Serializable{
    
    protected CCC cuenta;
    protected String nombre;
    protected String apellidos;
    protected double saldo;

    
    public Cuenta(String nombre, String apellidos, double saldo, String codigoEntidad, String codigoOficina){
    
        this.cuenta = new CCC(codigoEntidad, codigoOficina);
        this.nombre = nombre;
        this.apellidos = apellidos;
        
        if(saldo>0){
           this.saldo = saldo;
        }
    }
    
    public abstract boolean ingresar(double importe);
    
    public abstract boolean retirar(double importe);

    @Override
    public String toString() {
        return "Cuenta{" + "cuenta=" + cuenta + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo + '}';
    }

         
    public boolean comprobarIguales(String CCC){
        
        boolean cuentasIguales=false;
        
        if(cuenta.comprobarIguales(CCC)){
            cuentasIguales=true;
        
        }else{
            cuentasIguales=false;    
        }
        
        return cuentasIguales;
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
    
    
    
}
