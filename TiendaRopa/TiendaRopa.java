
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class TiendaRopa {

    private static ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    private static String archivoDatos = "tienda.bin";
    
    
    public static Articulo buscarArticulo(String referenciaIntr){
        
        Articulo articuloEncontrado = null;
        
        for(Articulo articulo: listaArticulos){
            String refGuiones = referenciaIntr.substring(0,2) + "-" + referenciaIntr.substring(2,4) + "-" + referenciaIntr.substring(4,8);
            System.out.println(refGuiones);
            if(articulo.getRef().toString().equals(refGuiones)){
                articuloEncontrado = articulo;
            
            }
        }
        
        return articuloEncontrado;
    }
    
    
    public static void añadirAccesorio(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca la referencia del artículo");
        
        String ref = sc.nextLine();
        
        Articulo articuloEncontrado = buscarArticulo(ref);
        
        if(articuloEncontrado!= null){
            System.out.println("El artículo ya existe en la base de datos, introduzca la cantidad que desea añadir del mismo: ");
            
            int cantidadAnadir = sc.nextInt();
            
            articuloEncontrado.setCantidad(cantidadAnadir);
            
            System.out.println("Se ha actualizado la cantidad. El stock total es de: " + articuloEncontrado.getCantidad());
        
        }else{
            
            System.out.println("El artículo no existe en la base de datos, por lo que se procederá a su creación");
            
            do{
                System.out.println("Introduzca de nuevo la referencia: ");
                ref = sc.nextLine();

                if(Referencia.comprobarReferencia(ref)){

                    System.out.println("Introduzca una descripción: ");
                    String descripcion = sc.nextLine();

                    System.out.println("Introduzca la cantidad existente: ");
                    int cantidad = sc.nextInt();

                    System.out.println("Introduzca su precio: ");
                    double precio = sc.nextDouble();

                    Accesorio accesorio1 = new Accesorio(ref, descripcion, cantidad, precio);

                    listaArticulos.add(accesorio1);   
                
                }else{
                    System.out.println("La referencia introducida no es correcta ");
                }
                
            }while(Referencia.comprobarReferencia(ref)==false);
        }    
    }
    
    public static void añadirPrendaVestir(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca la referencia del artículo");
        
        String ref = sc.nextLine();
        
        Articulo articuloEncontrado = buscarArticulo(ref);
        
        if(articuloEncontrado!= null){
            System.out.println("El artículo ya existe en la base de datos, introduzca la cantidad que desea añadir del mismo: ");
            

            int cantidadAnadir = sc.nextInt();
            
            articuloEncontrado.setCantidad(cantidadAnadir);
            
            System.out.println("Se ha actualizado la cantidad. El stock total es de: " + articuloEncontrado.getCantidad());
        
        }else{
            
            System.out.println("El artículo no existe en la base de datos, por lo que se procederá a su creación");
            
            do{
                System.out.println("Introduzca de nuevo la referencia: ");
                ref = sc.nextLine();
                
                if(Referencia.comprobarReferencia(ref)){

                    System.out.println("Introduzca una descripción: ");
                    String descripcion = sc.nextLine();

                    System.out.println("Introduzca la cantidad existente: ");
                    int cantidad = sc.nextInt();

                    System.out.println("Introduzca su precio: ");
                    double precio = sc.nextDouble();

                    boolean tallaComprobada = false;
                    String talla = null;

                    do{

                        System.out.println("Introduzca la talla");
                        String tallaProvisional = sc.nextLine();
                        tallaProvisional = tallaProvisional.toUpperCase();

                        if(PrendaVestir.comprobarTalla(tallaProvisional)){
                            talla = tallaProvisional;
                            tallaComprobada = true;

                        }else{
                            System.out.println("La talla introducida no es correcta");
                        }

                    }while(tallaComprobada==false);

                    System.out.println("¿Se trata de ropa interior? 1. SI 2. NO");
                    int opcionRopaInt = sc.nextInt();
                    boolean ropaInterior = false;

                    if(opcionRopaInt==1){
                        ropaInterior=true;                    
                    }

                    PrendaVestir prenda1 = new PrendaVestir(ref, descripcion, cantidad, precio, talla, ropaInterior);

                    listaArticulos.add(prenda1);   

                }else{
                    System.out.println("La referencia introducida no es correcta ");
                }

            }while(Referencia.comprobarReferencia(ref)==false);

            }
            
    }
    
    public static void devolver(){
        
        String ref = null;

        do{
            Scanner sc = new Scanner (System.in);
            System.out.println("Introduzca la referencia del artículo que desea devolver: ");
            
            ref = sc.nextLine();

            Articulo articuloEncontrado = buscarArticulo(ref);

            if(articuloEncontrado!= null){

                System.out.println("Introduzca los días que han transcurrido desde la compra: ");

                int diasTranscurridos = sc.nextInt();

                if(articuloEncontrado instanceof PrendaVestir){
                    System.out.println("El importe de la devolución es: " + ((PrendaVestir)articuloEncontrado).devolver(diasTranscurridos) + "euros");

                }else{
                    ((Accesorio)articuloEncontrado).devolver(diasTranscurridos);
                    System.out.println("El importe de la devolución es: " + ((Accesorio)articuloEncontrado).devolver(diasTranscurridos) + "euros");
                }
            }        

        }while(Referencia.comprobarReferencia(ref)==false);
        
    }
    
    public static void guardarDatos(){
        
        File f = new File(archivoDatos);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(listaArticulos);
        }catch(IOException e){
            System.err.println("Error abriendo el fichero de datos para escritura");
        }finally{
            try{if(oos!=null)oos.close();
                if(fos!=null)fos.close();
            }catch(IOException e){}
        }
    }
    
    public static void cargarDatos(){
        
    File f = new File(archivoDatos);
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    try{
        ois = new ObjectInputStream(new FileInputStream(f));
        listaArticulos = (ArrayList<Articulo>) ois.readObject();

    }catch (IOException e){
        System.err.println("Error abriendo el fichero de datos");
    }catch(ClassNotFoundException e){
        System.err.println("Error leyendo los datos del fichero");
    }finally{
        try{
            if(ois!=null) ois.close();
            if(fis!=null) fis.close();
        }catch(IOException e){}
    }
}
    
    
    public static void main(String[] args) {
        

        cargarDatos();
        
        
        System.out.println(listaArticulos.toString());
        
        guardarDatos();
        
    }
    
}
