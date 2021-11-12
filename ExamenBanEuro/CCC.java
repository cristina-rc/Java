
package ExamenBanEuro;

import java.io.Serializable;

public class CCC implements Serializable{
    
    private String codigoEntidad;
    private String codigoOficina; 
    private int digitoControl1;
    private int digitoControl2;
    private String numeroCuenta;
    private static int ultimaCuenta = 0;
    
    
    public CCC (String codigoEntidad, String codigoOficina) {
    
        this.codigoEntidad = codigoEntidad;
        this.codigoOficina = codigoOficina;
        
        numeroCuenta = String.valueOf(ultimaCuenta);
        
        while(numeroCuenta.length()<10){   
            numeroCuenta = "0" + numeroCuenta;
        }
        
        ultimaCuenta++;
        
        this.digitoControl1 = obtenerDC1(codigoEntidad, codigoOficina);
        this.digitoControl2 = obtenerDC2(numeroCuenta);
        
    }
    
    public int obtenerDC1(String codigoEntidad, String codigoOficina){
        
        int[]numsToCheckDC1 = {4, 8, 5, 10, 9, 7, 3, 6};
        
        int sumaMultDC1 = 0;
        
        for(int i=0; i<4; i++){
            int multDC1 = numsToCheckDC1[i]*(Integer.parseInt(codigoEntidad.substring(i)));
            sumaMultDC1+=multDC1;
        }
        
        for(int j=0; j<4; j++){
            int multDC1 = numsToCheckDC1[j+4]*(Integer.parseInt(codigoOficina.substring(j)));
            sumaMultDC1+=multDC1;
        }
        
        
        int resto = sumaMultDC1%11;
        int resta = 11-resto;
        
        if(resta<10){
            digitoControl1 = resta;
        }else if(resta==10){
            digitoControl1 = 1;
        }else if(resta==11){
            digitoControl1 = 0;
        }else{
            System.out.println("Ha habido un error en el cálculo del DC1");
        }
        
        return digitoControl1;
                
    }
    
    public int obtenerDC2(String numeroCuenta){
        
        int[]numsToCheckDC2 = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        
        int sumaMultDC2 = 0;
        
        for(int i=0; i<10; i++){
            int mult2DC2 = numsToCheckDC2[i]*(Integer.parseInt(numeroCuenta.substring(i)));
            sumaMultDC2+=mult2DC2;
        }
        
        int resto = sumaMultDC2%11;
        int resta = 11-resto;
        
        if(resta<10){
            digitoControl2 = resta;
        }else if(resta==10){
            digitoControl2 = 1;
        }else if(resta==11){
            digitoControl2 = 0;
        }else{
            System.out.println("Ha habido un error en el cálculo del DC2");
        }
        
        return digitoControl2;
        
    }
    
    public boolean comprobarCCC(String numeroCuentaCompleta){
        
        boolean numeroOK = false;
        
        if(numeroCuentaCompleta.length()!=20){
            System.out.println("Introduzca un número de cuenta correcto");
            
        }else{
            String codigoEntidad = numeroCuentaCompleta.substring(0,3);
            String codigoOficina = numeroCuentaCompleta.substring(4,7);
            String numeroCuenta =  numeroCuentaCompleta.substring(10,19);
            
            int digitoControl1 = obtenerDC1(codigoEntidad, codigoOficina);
            int digitoControl2 = obtenerDC2(numeroCuenta);
            
            
            if(Integer.parseInt(numeroCuentaCompleta.substring(8))!=digitoControl1){
                System.out.println("El número de cuenta no es correcto");
                numeroOK = false;
                
            }else{
                System.out.println("El número de cuenta es correcto");
                numeroOK = true;
            }
        }
        
        return numeroOK;
    }
    
    public boolean comprobarIguales(String CCC){
        boolean cuentasIguales = false;
        
        if(CCC.equals(codigoEntidad+codigoOficina+digitoControl1+digitoControl2+numeroCuenta)){
            cuentasIguales=true;
        }
        
        return cuentasIguales;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public int getDigitoControl1() {
        return digitoControl1;
    }

    public void setDigitoControl1(int digitoControl1) {
        this.digitoControl1 = digitoControl1;
    }

    public int getDigitoControl2() {
        return digitoControl2;
    }

    public void setDigitoControl2(int digitoControl2) {
        this.digitoControl2 = digitoControl2;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public static int getUltimaCuenta() {
        return ultimaCuenta;
    }

    public static void setUltimaCuenta(int ultimaCuenta) {
        CCC.ultimaCuenta = ultimaCuenta;
    }

    @Override
    public String toString() {
        return codigoEntidad + codigoOficina + digitoControl1 + digitoControl2 + numeroCuenta;
    }
    
    
}
