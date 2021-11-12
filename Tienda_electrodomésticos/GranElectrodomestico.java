package TiendaElectrodomesticos;

public class GranElectrodomestico extends Electrodomestico implements InterfazGranElectrodomestico{

	private double peso;
	private double alto;
	private double ancho;
	private double fondo;
	private boolean instalacion;
	
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getFondo() {
		return fondo;
	}

	public void setFondo(double fondo) {
		this.fondo = fondo;
	}

	public boolean isInstalacion() {
		return instalacion;
	}

	public void setInstalacion(boolean instalacion) {
		this.instalacion = instalacion;
	}

	public GranElectrodomestico (String codigo, String descripcion, String fabricante, String modelo, int stock, double precioUnitario, double peso, double alto, double ancho, double fondo, boolean instalacion) {
		
		super(codigo, descripcion, fabricante, modelo, stock, precioUnitario);
		
		this.peso = peso;
		this.alto = alto;
		this.ancho = ancho;
		this.fondo = fondo;
		this.instalacion = instalacion;
		
	}
	
	public double CalcularPrecio () {
		
		if (instalacion = false){
			
			double precio = this.precioUnitario + CalcularGastosEnvio();
			
			return precio;
			
		}else{
			
			double precio = this.precioUnitario + CalcularGastosEnvio()+15;
			
			return precio;
			
		}
	}
	
	public double CalcularGastosEnvio() {
		
		double gastosEnvio = 0;
		
		double metrosCubicos = (ancho*alto*fondo)/1000000;
		
		gastosEnvio = metrosCubicos*peso;
		
		if (gastosEnvio>50) {
			
			gastosEnvio = 50;
		}
		
		return gastosEnvio;
	}

	@Override
	public String toString() {
		return "GranElectrodomestico [peso=" + peso + ", alto=" + alto + ", ancho=" + ancho + ", fondo=" + fondo
				+ ", instalacion=" + instalacion + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", fabricante=" + fabricante + ", modelo=" + modelo + ", stock=" + stock + ", precioUnitario="
				+ precioUnitario + "]";
	}
	
	
	
}
