package TiendaElectrodomesticos;

public abstract class Electrodomestico {
	
	protected Codigo codigo;
	protected String descripcion;
	protected String fabricante;
	protected String modelo;
	protected int stock;
	protected double precioUnitario;
	
	public Electrodomestico (String codigo, String descripcion, String fabricante, String modelo, int stock, double precioUnitario) {
		
		this.codigo = new Codigo(codigo);
		this.descripcion = descripcion;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
		
	}
	
	public abstract double CalcularPrecio ();

	public Codigo getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}


