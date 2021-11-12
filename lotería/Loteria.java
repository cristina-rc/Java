
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Loteria {

    private static ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
    private static String archivoDatos = "loteria.bin";
    
    public static boolean comprobarFecha (String fecha){

        boolean fechaCorrecta = false;

        Pattern p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
        Matcher m = p.matcher(fecha);

        if(m.matches()){

            fechaCorrecta = true;           

        }else{

            System.out.println("La fecha tiene que tener el siguiente formato: (dd/mm/aaaa)");
        }

        return fechaCorrecta;
    }
  
    public static void generarPrimitiva(){
        
        System.out.println ("Introduzca la fecha del sorteo: ");
        
        boolean fechaCorrecta = false;
        
        do{

            Scanner sc = new Scanner (System.in);

            String fecha = sc.nextLine();

            if (comprobarFecha(fecha)){
                   
                fechaCorrecta = true;
                
                Primitiva primitiva1 = new Primitiva(fecha);

                System.out.println ("Introduzca: \n1. Generar los números de forma aleatoria \n2. Generar los números de forma manual");

                int opcionGenerar = sc.nextInt();

                if(opcionGenerar==1){

                    primitiva1.elegirNumerosAleatorios();

                }else if(opcionGenerar==2){

                    primitiva1.elegirNumerosEscaner();

                }else{

                    System.out.println("Introduzca la opción 1 ó 2");
                }


                listaBoletos.add(primitiva1);

                System.out.println(primitiva1.toString());

            }else{

                System.out.println("Introduzca una fecha correcta");

            }
            
        }while(!fechaCorrecta);
    }
    
    public static void generarGordoPrimitiva(){
    
        System.out.println ("Introduzca la fecha del sorteo: ");
        
        boolean fechaCorrecta = false;
        
        do{
        
            Scanner sc = new Scanner (System.in);

            String fecha = sc.nextLine();

            if (comprobarFecha(fecha)){

                fechaCorrecta = true;
                
                GordoPrimitiva gordo1 = new GordoPrimitiva(fecha);


                System.out.println ("Introduzca: \n1. Generar los números de forma aleatoria \n2. Generar los números de forma manual");

                int opcionGenerar = sc.nextInt();

                if(opcionGenerar==1){

                    gordo1.elegirNumerosAleatorios();

                }else if(opcionGenerar==2){

                    gordo1.elegirNumerosEscaner();

                }else{

                    System.out.println("Introduzca la opción 1 ó 2");
                }


                listaBoletos.add(gordo1);

                System.out.println(gordo1.toString());
                
                   }else{

                System.out.println("Introduzca una fecha correcta");

            }
            
        }while(!fechaCorrecta);
    }
    
    public static void generarEuromillones(){
    
        System.out.println ("Introduzca la fecha del sorteo: ");
        
        boolean fechaCorrecta = false;
        
        do{

            Scanner sc = new Scanner (System.in);

            String fecha = sc.nextLine();

            if (comprobarFecha(fecha)){

                fechaCorrecta = true;
                
                Euromillones euromillones1 = new Euromillones(fecha);


                System.out.println ("Introduzca: \n1. Generar los números de forma aleatoria \n2. Generar los números de forma manual");

                int opcionGenerar = sc.nextInt();

                if(opcionGenerar==1){

                    euromillones1.elegirNumerosAleatorios();

                }else if(opcionGenerar==2){

                    euromillones1.elegirNumerosEscaner();

                }else{

                    System.out.println("Introduzca la opción 1 ó 2");
                }


                listaBoletos.add(euromillones1);

                System.out.println(euromillones1.toString());
                
            }
            
        }while(!fechaCorrecta);        
    }
    
    public static void buscarBoleto(){
        
        
        System.out.println("Introduzca el código para buscar el boleto: ");
        
        Scanner oc = new Scanner (System.in);
        
        int codigoIntroducido = oc.nextInt();
        
        for(Boleto boleto: listaBoletos){
            
              if (boleto.getNumeroBoleto()==codigoIntroducido){         
           // if(boleto.getNumeroBoleto().getCodigoNumerico() == codigoIntroducido){
                
                System.out.println(boleto.toString());
                
                /* NO ES NECESARIO, SE IMPRIME CORRECTAMENTE SIN NECESIDAD DE USAR INSTANCEOF
                
                if(object instanceof Primitiva){
                    
                    Primitiva primitivaaux = (Primitiva)object;
                    
                    System.out.println(primitivaaux.toString());
                    
                    
                }else if(object instanceof GordoPrimitiva){
                    
                    GordoPrimitiva gordoaux = (GordoPrimitiva)object;
                    
                    System.out.println(gordoaux.toString());
                    
                    
                }else if(object instanceof Euromillones){
                    
                    Euromillones euroaux = (Euromillones)object;
                    
                    System.out.println(euroaux.toString());
                }*/
            
                System.out.println("¿Desea imprimir en un archivo de texto el boleto seleccionado? 1. SI 2. NO");
                
                int opcionImprimir = oc.nextInt();
                
                if(opcionImprimir==1){
                 
                    boleto.imprimir();
                }
                
            }else{
                
                System.out.println("El código introducido no existe");
                
            }
        }
    }
    
    public static void cargarDatos(){
        
        File f = new File(archivoDatos);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        

        try{
            ois = new ObjectInputStream(new FileInputStream(f));
            listaBoletos = (ArrayList<Boleto>) ois.readObject();
            //Boleto.setUltimo(listaBoletos.size());
            Boleto.setUltimo((int)ois.readObject());

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
    
    public static void guardarDatos(){
        
        File f = new File(archivoDatos);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try{
            
            oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(listaBoletos);
            oos.writeObject(Boleto.getUltimo());
            
        }catch(IOException e){
            
            System.err.println("Error abriendo el fichero de datos para escritura");
            
        }finally{
            try{
                if(oos!=null)oos.close();
                if(fos!=null)fos.close();
            }catch(IOException e){}
        }

    }
    
    public static void main(String[] args) {
        
        cargarDatos();
        
        int opcionMenu = 0;
        int opcionMenuGenerar = 0;
        
        do{
        
            System.out.println("Elija una opción del menú: \n1. Generar Boleto \n2. Buscar boleto \n3. Salir");

            Scanner sc = new Scanner (System.in);

            opcionMenu = sc.nextInt();

            switch(opcionMenu){

                case 1: 

                    System.out.println("Seleccione el tipo de boleto a emitir: \n1. Primitiva \n2. El Gordo \n3. Euromillones \n4. Volver al menú anterior");

                    Scanner ac = new Scanner (System.in);

                    opcionMenuGenerar = ac.nextInt();

                    switch(opcionMenuGenerar){

                        case 1: Loteria.generarPrimitiva();
                                break;
                        case 2: Loteria.generarGordoPrimitiva();
                                break;
                        case 3: Loteria.generarEuromillones();
                                break;
                        case 4: break;
                        
                        default: System.out.println("No ha elegido una opción correcta");
                    }

                    break;

                case 2: Loteria.buscarBoleto();

                    break;

                case 3: System.out.println("Gracias por su visita, ¡hasta pronto!");

                    break;
                    
                default: System.out.println("No ha elegido una opción correcta");
            }
            
        }while(opcionMenu!=3 || opcionMenuGenerar==4);
        
        guardarDatos();
    }
}
