package TiendaElectrodomesticos;

import java.util.*;

public class PrincipalElectrodomesticos {
	
	private static ArrayList<Electrodomestico> lista = new ArrayList<Electrodomestico>();

	public static void a�adirPeque�oElectrodomestico (){
		
		Scanner sc = new Scanner (System.in);
			
		System.out.println("Introduzca el c�digo del electrodom�stico");
		String codigo = sc.nextLine();
		
		
		System.out.println("Introduzca la descripci�n: ");
		String descripcion = sc.nextLine();
		
		
		System.out.println("Introduzca el fabricante: "); 
		String fabricante = sc.nextLine();
		
			
		System.out.println("Introduzca el modelo: "); 
		String modelo = sc.nextLine();
			
		System.out.println("Introduzca el stock: ");
		int stock = sc.nextInt();
		
		System.out.println("Introduzca el precio unitario: ");
		double precioUnitario = sc.nextDouble();
			
		Peque�oElectrodomestico pequeelectro1 = new Peque�oElectrodomestico(codigo, descripcion, fabricante, modelo, stock, precioUnitario);
		
		
		lista.add(pequeelectro1);
		
	}
	
	public static void a�adirGranElectrodomestico (){
		
		Scanner sc = new Scanner (System.in);
			
		System.out.println("Introduzca el c�digo del electrodom�stico");
		String codigo = sc.nextLine();
		
		
		System.out.println("Introduzca la descripci�n: ");
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
		
		System.out.println("�El producto precisa de instalaci�n? Si/No");
		String respuestaInst = sc.nextLine();		
		
		if(respuestaInst.equalsIgnoreCase("Si")) {
			
			instalacion = true;
			
		}else if (respuestaInst.equalsIgnoreCase("No")){
			
			instalacion = false;
		}
			
		GranElectrodomestico granelectro1 = new GranElectrodomestico(codigo, descripcion, fabricante, modelo, stock, precioUnitario, peso, alto, ancho, fondo, instalacion);
		
		lista.add(granelectro1);
	
	}
	
	public static void venderPeque�oElectrodomestico() {
			
			for(Electrodomestico object : lista) {
			
				if (object instanceof Peque�oElectrodomestico){
					
					System.out.println(object.toString());
					
//Incluir mensaje de 'No existe ning�n peque�o electrodom�stico
				}
					
			}	
			
			boolean existeStock = false;
			
			do {
				
				System.out.println("Introduzca el c�digo del producto que desea vender: ");
				
				Scanner oc = new Scanner(System.in);
				
				String codigoIntroducido;
				
				
				codigoIntroducido = oc.nextLine();
				
				for(Electrodomestico object: lista) {
				
					Peque�oElectrodomestico ref = (Peque�oElectrodomestico)object;
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
							
							System.out.println("No hay stock suficiente para la operaci�n");
							
							existeStock = false;
						}
						
					}else {
						
						System.out.println("No existe ning�n art�culo con ese c�digo");
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
					
					System.out.println("Introduzca el c�digo del producto que desea vender: ");
					
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
							
							System.out.println("No hay stock suficiente para la operaci�n");
							
							existeCodigo = false;
						}
						
					}else {
						
						System.out.println("No existe ning�n art�culo con ese c�digo");
					}	
			
				}while(!existeCodigo);
				
			}else {
				
				System.out.println("No existe ning�n gran electrodom�stico.");
			}
		}
	}
	
	public static void EliminarElectrodomestico() {
		
		for(Electrodomestico object: lista) {
			
			object.toString();
		}
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Introduzca el c�digo del producto que desea eliminar: ");
		
		String codigoIntroducido = sc.nextLine();
		
		for(Electrodomestico object2: lista) {
			
			if(object2.getCodigo().equals(codigoIntroducido)) {
				
				lista.remove(object2);
			}else {
				
				System.out.println("El c�digo no existe");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int opcionIntroducida;
		
		do {
			
		System.out.println("Bienvenido. Introduzca una opci�n del men�: \n1. A�adir electrodom�stico \n2. Vender electrodom�stico \n3. Eliminar electrodom�stico \n4. Salir");
		
		opcionIntroducida = sc.nextInt();
		
			switch (opcionIntroducida) {
		
				case 1: 
					
					Scanner mc = new Scanner (System.in);
					
					System.out.println("�Qu� tipo de electrodom�stico desea a�adir? 1. Peque�o Electrodom�stico  2. Gran Electrom�stico");
				
					int tipoElectrodomestico = mc.nextInt();
					
					if (tipoElectrodomestico == 1) {
						
						PrincipalElectrodomesticos.a�adirPeque�oElectrodomestico();
						
						break;
						
					}else if (tipoElectrodomestico ==2) {
						
						PrincipalElectrodomesticos.a�adirGranElectrodomestico();
						
						break;
						
					}else {
						
						System.out.println("Introduzca un c�digo v�lido");
						
					}
				
				break;

				case 2:
					
					Scanner rc = new Scanner (System.in);
				
					System.out.println("�Qu� tipo de electrodom�stico desea vender? 1. Peque�o Electrodom�stico  2. Gran Electrom�stico");
				
					int tipoElectrodomestico2 = rc.nextInt();
					
					if (tipoElectrodomestico2 == 1) {
						
						PrincipalElectrodomesticos.venderPeque�oElectrodomestico();
						
					}else if (tipoElectrodomestico2 ==2) {
						
						PrincipalElectrodomesticos.venderGranElectrodomestico();
						
					}else {
						
						System.out.println("Introduzca un c�digo v�lido");
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
