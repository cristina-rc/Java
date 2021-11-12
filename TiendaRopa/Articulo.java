
import java.io.Serializable;


public abstract class Articulo implements Serializable{
    
    protected Referencia ref;
    protected String descripcion;
    protected int cantidad;
    protected double precio;
    
    public Articulo (String ref, String descripcion, int cantidad, double precio){
        
        this.ref = new Referencia(ref);
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
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
        return "Articulo{" + "ref=" + ref + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
    
    
}
