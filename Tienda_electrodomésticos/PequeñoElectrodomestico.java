package TiendaElectrodomesticos;

public class Peque�oElectrodomestico extends Electrodomestico {

	
	public Peque�oElectrodomestico (String codigo, String descripcion, String fabricante, String modelo, int stock, double precioUnitario) {
	
		super(codigo, descripcion, fabricante, modelo, stock, precioUnitario);
		
	}
	
	
	public double CalcularPrecio () {
		
		double precio = this.precioUnitario;
		
		return precio;
		
	}

	@Override
	public String toString() {
		return "Peque�oElectrodomestico [codigo=" + codigo + ", descripcion=" + descripcion + ", fabricante="
				+ fabricante + ", modelo=" + modelo + ", stock=" + stock + ", precioUnitario=" + precioUnitario + "]";
	}
	
	
}
