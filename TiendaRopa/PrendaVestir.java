
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PrendaVestir extends Articulo implements iDevolucion{
    
    private String talla;
    private boolean ropaInterior;
    
    public PrendaVestir(String ref, String descripcion, int cantidad, double precio, String talla, boolean ropaInterior){
        
       super(ref, descripcion, cantidad, precio);
       
       this.ropaInterior = ropaInterior;       
       
       this.talla=talla;

    }
    
    public static boolean comprobarTalla(String talla){
        
        Pattern p=Pattern.compile("XS|S|M|L|XL|34|36|38|40|42|44");
        Matcher m=p.matcher(talla);
        if(m.matches()) {
            return true;
        }else {
            return false;
        }
    }
    
    public double devolver (int diasTransc){

    final int maximoDias = 30;
    double importe = 0;

    if ((diasTransc<maximoDias)&&(ropaInterior==false)){
        importe = (diasTransc/10)+4;

    }else{
        System.out.println("No se puede proceder a su devolución");
    }

    return importe;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public boolean isRopaInterior() {
        return ropaInterior;
    }

    public void setRopaInterior(boolean ropaInterior) {
        this.ropaInterior = ropaInterior;
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
        return "Prenda de vestir{" + "ref=" + ref + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio +  "talla=" + talla + ", ropaInterior=" + ropaInterior + '}';
    }
    
    
    
}
