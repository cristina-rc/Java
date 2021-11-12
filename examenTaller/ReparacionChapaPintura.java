
package examenTaller;

public class ReparacionChapaPintura extends Trabajo{
    
    private double precioPintura = 0;
    
    public ReparacionChapaPintura(String descripcion){
        
        super(descripcion);
    }
    
    public void usarMaterial(double precioMaterial){
    
        if(!finalizado){
        
            this.precioPintura = precioPintura;
        
        }else{
            
        System.out.println("La reparación se encuentra finalizada, no se puede aumentar el precio del material");
            
        }
    }
    
    public double calcularPrecio(){
        
        double fijo = horas*30;
        double material = precioPintura*1.3;
        
        double precio = fijo + material;
        
        return precio;
    }       

    public double getPrecioPintura() {
        return precioPintura;
    }

    public void setPrecioPintura(double precioPintura) {
        this.precioPintura = precioPintura;
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


    @Override
    public String toString() {
        return "Trabajo{" + "idTrabajo=" + idTrabajo + ", descripcion=" + descripcion + ", horas=" + horas + ", finalizado=" + finalizado + "" + ", precio pintura=" + precioPintura +"}";
    }
    
    
    
}

