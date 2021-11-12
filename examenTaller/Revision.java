
package examenTaller;

public class Revision extends Trabajo{
    
    public Revision (String descripcion){
        
        super(descripcion);
    }
    
    public double calcularPrecio(){
        
        double fijo = horas*30;
        
        double precio = fijo + 20;
        
        return precio;
        
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

}
