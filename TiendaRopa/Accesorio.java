
public class Accesorio extends Articulo implements iDevolucion{
  
    public Accesorio(String ref, String descripcion, int cantidad, double precio){
    
    super(ref, descripcion, cantidad, precio);
    
    }
    
    public double devolver (int diasTransc){
        
        final int maximoDias = 30;
        double importe = 0;
        
        if (diasTransc<maximoDias){
            importe = (diasTransc/10)+4;
            
        }else{
            System.out.println("Han transcurrido más de 30 días, por lo que no se puede proceder a su devolución");
           
        }
        
        return importe;
    }

    public Referencia getRef() {
        return ref;
    }

    public void setRef(Referencia ref) {
        this.ref = ref;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Accesorio{" + "ref=" + ref + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
}
