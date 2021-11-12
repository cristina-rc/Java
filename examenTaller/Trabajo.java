
package examenTaller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public abstract class Trabajo implements Serializable {
    
    protected String idTrabajo;
    protected String descripcion;
    protected int horas = 0;
    protected boolean finalizado;
       
    private static int ultimo = 0;
    
    
    public Trabajo(String descripcion){
    
    this.descripcion = descripcion;
    
    this.idTrabajo = generarID();
    
    }
    
    private String generarID(){
        
        String iDceros = String.valueOf(ultimo);

        while(iDceros.length()<7){

           iDceros = "0" + iDceros;
        }
    
        ultimo++;
        
        return "T" + iDceros;
    }
    
    public void incrementarHoras(int horas){
    
        if(!finalizado){

            this.horas = horas;

        }else{

            System.out.println("El trabajo se encuentra finalizado, no se pueden aumentar las horas");
        }
    }
    
    public abstract double calcularPrecio();
    
    public void imprimir(){
        
        String nt = idTrabajo + ".fac";
        File f = new File(nt);
        
        if(f.exists()){
            System.out.println("Ya se ha generado anteriormente la factura");
            
        }else{
            BufferedWriter bw = null;
            
            try{
                bw = new BufferedWriter(new FileWriter(f));
                bw.write(this.toString());
                
            }catch(IOException e){
                System.err.println("Error generando la factura"+nt);
                
            }finally{
                
                try{
                    if(bw != null){
                        bw.close();
                    }
                }catch (IOException e){
 
                }
            }
        System.out.println("Se ha generado correctamente la factura");
        
        }
    }

    public String getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(String idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }


    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Trabajo.ultimo = ultimo;
    }

    @Override
    public String toString() {
        return "Trabajo{" + "idTrabajo=" + idTrabajo + ", descripcion=" + descripcion + ", horas=" + horas + ", finalizado=" + finalizado + "" + '}';
    }
    
}
