package TiendaElectrodomesticos;

public class PequeñoElectrodomestico extends Electrodomestico {

	
	public PequeñoElectrodomestico (String codigo, String descripcion, String fabricante, String modelo, int stock, double precioUnitario) {
	
		super(codigo, descripcion, fabricante, modelo, stock, precioUnitario);
		
	}
	
	
	public double CalcularPrecio () {
		
		double precio = this.precioUnitario;
		
		return precio;
		
	}

	@Override
	public String toString() {
		return "PequeñoElectrodomestico [codigo=" + codigo + ", descripcion=" + descripcion + ", fabricante="
				+ fabricante + ", modelo=" + modelo + ", stock=" + stock + ", precioUnitario=" + precioUnitario + "]";
	}
	
	
}
