package TiendaElectrodomesticos;

import java.util.*;

public class PrincipalElectrodomesticos {
	
	private static ArrayList<Electrodomestico> lista = new ArrayList<Electrodomestico>();

	public static void añadirPequeñoElectrodomestico (){
		
		Scanner sc = new Scanner (System.in);
			
		System.out.println("Introduzca el código del electrodoméstico");
		String codigo = sc.nextLine();
		
		
		System.out.println("Introduzca la descripción: ");
		String descripcion = sc.nextLine();
		
		
		System.out.println("Introduzca el fabricante: "); 
		String fabricante = sc.nextLine();
		
			
		System.out.println("Introduzca el modelo: "); 
		String modelo = sc.nextLine();
			
		System.out.println("Introduzca el stock: ");
		int stock = sc.nextInt();
		
		System.out.println("Introduzca el precio unitario: ");
		double precioUnitario = sc.nextDouble();
			
		PequeñoElectrodomestico pequeelectro1 = new PequeñoElectrodomestico(codigo, descripcion, fabricante, modelo, stock, precioUnitario);
		
		
		lista.add(pequeelectro1);
		
	}
	
	public static void añadirGranElectrodomestico (){
		
		Scanner sc = new Scanner (System.in);
			
		System.out.println("Introduzca el código del electrodoméstico");
		String codigo = sc.nextLine();
		
		
		System.out.println("Introduzca la descripción: ");
		String descripcion = sc.nextLine();
		
		
		System.out.println("Introduzca el fabricante: "); 
		String fabricante = sc.nextLine();
		
			
		System.out.println("Introduzca el modelo: "); 
		String modelo = sc.nextLine();
			
		System.out.println("Introduzca el stock: ");
		int stock = sc.nextInt();
		
		System.out.println("Introduzca el precio unitario: ");
		double precioUnitario = sc.nextDouble();
		
		System.out.println("Introduzca el peso : ");
		double peso = sc.nextDouble();
		
		System.out.println("Introduzca el alto en cm : ");
		double alto = sc.nextDouble();
		
		System.out.println("Introduzca el ancho en cm : ");
		double ancho = sc.nextDouble();
		
		System.out.println("Introduzca el fondo en cm : ");
		double fondo = sc.nextDouble();
		
		boolean instalacion = false;
		
		System.out.println("¿El producto precisa de instalación? Si/No");
		String respuestaInst = sc.nextLine();		
		
		if(respuestaInst.equalsIgnoreCase("Si")) {
			
			instalacion = true;
			
		}else if (respuestaInst.equalsIgnoreCase("No")){
			
			instalacion = false;
		}
			
		GranElectrodomestico granelectro1 = new GranElectrodomestico(codigo, descripcion, fabricante, modelo, stock, precioUnitario, peso, alto, ancho, fondo, instalacion);
		
		lista.add(granelectro1);
	
	}
	
	public static void venderPequeñoElectrodomestico() {
			
			for(Electrodomestico object : lista) {
			
				if (object instanceof PequeñoElectrodomestico){
					
					System.out.println(object.toString());
					
//Incluir mensaje de 'No existe ningún pequeño electrodoméstico
				}
					
			}	
			
			boolean existeStock = false;
			
			do {
				
				System.out.println("Introduzca el código del producto que desea vender: ");
				
				Scanner oc = new Scanner(System.in);
				
				String codigoIntroducido;
				
				
				codigoIntroducido = oc.nextLine();
				
				for(Electrodomestico object: lista) {
				
					PequeñoElectrodomestico ref = (PequeñoElectrodomestico)object;
					String copia = ref.getCodigo().toString();
					
					if(copia.equals(codigoIntroducido)) {
						
						System.out.println("Introduzca la cantidad a vender: ");
						
						int cantidadaVender = oc.nextInt();
						
						if (cantidadaVender >= ref.getStock())  {
							
							int stock = ref.getStock()-cantidadaVender;
							ref.setStock(stock);
							System.out.println("El precio total es: "+(ref.CalcularPrecio()*cantidadaVender));
							
							existeStock = true;
							
						}else {
							
							System.out.println("No hay stock suficiente para la operación");
							
							existeStock = false;
						}
						
					}else {
						
						System.out.println("No existe ningún artículo con ese código");
					}	
				}
		
			}while(!existeStock);
				
		}
	
				
	public static void venderGranElectrodomestico() {
			
		for(Electrodomestico object: lista) {
			
			if(object instanceof GranElectrodomestico){
				
				GranElectrodomestico ref2 = (GranElectrodomestico)object;
				
				System.out.println(ref2.toString());
				
				boolean existeCodigo = false;
				
				do {
					
					System.out.println("Introduzca el código del producto que desea vender: ");
					
					Scanner oc = new Scanner(System.in);
					
					String codigoIntroducido;
					
					codigoIntroducido = oc.nextLine();
					
					GranElectrodomestico ref = (GranElectrodomestico)object;
					
					if(ref.getCodigo().equals(codigoIntroducido)) {
						
						System.out.println("Introduzca la cantidad a vender: ");
						
						int cantidadaVender = oc.nextInt();
						
						if (cantidadaVender >= ref.getStock())  {
							
							int stock = ref.getStock()-cantidadaVender;
							ref.setStock(stock);
							System.out.println("El precio total es: "+(ref.CalcularPrecio()*cantidadaVender));
							
							existeCodigo = true;
							
						}else {
							
							System.out.println("No hay stock suficiente para la operación");
							
							existeCodigo = false;
						}
						
					}else {
						
						System.out.println("No existe ningún artículo con ese código");
					}	
			
				}while(!existeCodigo);
				
			}else {
				
				System.out.println("No existe ningún gran electrodoméstico.");
			}
		}
	}
	
	public static void EliminarElectrodomestico() {
		
		for(Electrodomestico object: lista) {
			
			object.toString();
		}
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Introduzca el código del producto que desea eliminar: ");
		
		String codigoIntroducido = sc.nextLine();
		
		for(Electrodomestico object2: lista) {
			
			if(object2.getCodigo().equals(codigoIntroducido)) {
				
				lista.remove(object2);
			}else {
				
				System.out.println("El código no existe");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int opcionIntroducida;
		
		do {
			
		System.out.println("Bienvenido. Introduzca una opción del menú: \n1. Añadir electrodoméstico \n2. Vender electrodoméstico \n3. Eliminar electrodoméstico \n4. Salir");
		
		opcionIntroducida = sc.nextInt();
		
			switch (opcionIntroducida) {
		
				case 1: 
					
					Scanner mc = new Scanner (System.in);
					
					System.out.println("¿Qué tipo de electrodoméstico desea añadir? 1. Pequeño Electrodoméstico  2. Gran Electroméstico");
				
					int tipoElectrodomestico = mc.nextInt();
					
					if (tipoElectrodomestico == 1) {
						
						PrincipalElectrodomesticos.añadirPequeñoElectrodomestico();
						
						break;
						
					}else if (tipoElectrodomestico ==2) {
						
						PrincipalElectrodomesticos.añadirGranElectrodomestico();
						
						break;
						
					}else {
						
						System.out.println("Introduzca un código válido");
						
					}
				
				break;

				case 2:
					
					Scanner rc = new Scanner (System.in);
				
					System.out.println("¿Qué tipo de electrodoméstico desea vender? 1. Pequeño Electrodoméstico  2. Gran Electroméstico");
				
					int tipoElectrodomestico2 = rc.nextInt();
					
					if (tipoElectrodomestico2 == 1) {
						
						PrincipalElectrodomesticos.venderPequeñoElectrodomestico();
						
					}else if (tipoElectrodomestico2 ==2) {
						
						PrincipalElectrodomesticos.venderGranElectrodomestico();
						
					}else {
						
						System.out.println("Introduzca un código válido");
					}
					
				break;
						
				case 3: PrincipalElectrodomesticos.EliminarElectrodomestico();
				break;
					
				case 4: System.out.println("Gracias por su visita, hasta pronto!");
				break;
				
			}
		
		}while(opcionIntroducida!=4);

	}
	
	
}
