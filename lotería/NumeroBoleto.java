import java.io.Serializable;

public class NumeroBoleto implements Serializable{
    
    protected static int codigoNumerico = 123456;
    
   
    public NumeroBoleto(){
        
        codigoNumerico++;
    }

    public int getCodigoNumerico() {
        return codigoNumerico;
    }

    public static void setCodigoNumerico(int codigoNumerico) {
        NumeroBoleto.codigoNumerico = codigoNumerico;
    }
    
    
    
    @Override
    public String toString() {
        return "Codigo " +codigoNumerico;
    }
    
    
}
    