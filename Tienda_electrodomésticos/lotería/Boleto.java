
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Boleto implements Serializable {
    
    
    protected int numeroBoleto;
    //protected NumeroBoleto numeroBoleto;
    protected String fecha;
    protected ArrayList<Integer> numeros = new ArrayList<Integer>();
    private static int ultimo=1;

    
    public Boleto (String fecha){
    
       //this.numeroBoleto = new NumeroBoleto();
        this.fecha = fecha; 
        this.numeroBoleto = ultimoBoleto();

    }
    public int ultimoBoleto(){
        
        return ultimo++;
    }

    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(int numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Boleto.ultimo = ultimo;
    }
    


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return "Boleto{" + "fecha=" + fecha + ", numeros=" + numeros + '}';
    }
    
    public abstract void elegirNumerosEscaner();
    
    public abstract void elegirNumerosAleatorios();
    
    public void imprimir(){
        
        String nb = numeroBoleto + ".bol";
        File f = new File(nb);
        
        if(f.exists()){
            
            System.out.println("Ya se ha generado anteriormente el boleto");
            
        }else{
            
            BufferedWriter bw = null;
            
            try{
                bw = new BufferedWriter(new FileWriter(f));
                bw.write(this.toString());
                
            }catch(IOException e){
                
                System.err.println("Error escribiendo el fichero"+nb);
                
            }finally{
                
                try{
                    if(bw != null){
                        bw.close();
                    }
                }catch (IOException e){
 
                }
            }
        }
    }
}

