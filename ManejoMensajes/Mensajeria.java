/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoMensajes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Mensajeria {
    
    private static ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
    private static String archivoDatos = "mensajes.dat";
    
    public static void listarMensajes(){
        
        Scanner sc = new Scanner(System.in);
        
        int opcionListar = 0;
        
        System.out.println("¿Desea mostrar la lista de mensajes por pantalla (1), o guardarlos en un fichero de texto(2)?");
        
        opcionListar = sc.nextInt();
        
        if(opcionListar==1){
            
            System.out.println(listaMensajes.toString());
            
        }else if(opcionListar==2){
            
            Scanner nc = new Scanner(System.in);
            String nombreFichero = null;
            
            System.out.println("Introduzca un nombre para el fichero: ");
            
            nombreFichero = nc.nextLine();
            
            File f = new File(nombreFichero);
        
            if(f.exists()){
                System.out.println("Ya se ha generado anteriormente el fichero");

            }else{

                BufferedWriter bw = null;

                try{
                    bw = new BufferedWriter(new FileWriter(f));
                    bw.write(listaMensajes.toString());

                }catch(IOException e){
                    System.err.println("Error escribiendo el fichero");

                }finally{

                    try{
                        if(bw != null){
                            bw.close();
                        }
                    }catch (IOException e){

                    }
                System.out.println("Se ha generado correctamente el fichero");

                }
            }      
        }else{
            
            System.out.println("Por favor, introduzca una opción correcta");
        }
        
    }
    

    public static void mostrarMenNormales(){
        
        for(Mensaje mensaje:listaMensajes){
            
            if(mensaje instanceof MensajeSinEncriptar){
                System.out.println(mensaje.toString());
            }
        }
    }
    
    
    public static void mostrarMenEncriptados(){
        
        for(Mensaje mensaje:listaMensajes){
            
            if(mensaje instanceof MensajeEncriptado){
                System.out.println(mensaje.toString());
            }
        }
    }
    
    public static Mensaje buscarMensaje(){
        
        Mensaje mensajeRet = null; 
        
        boolean mensajeEncontrado = false;
        
        Scanner sc = new Scanner(System.in);
        int mensajeIntr = 0;
        
        System.out.println("Introduzca el código del mensaje: ");
        
        mensajeIntr = sc.nextInt();
       
        for(Mensaje mensaje:listaMensajes){
            
            if(mensaje.getCodigo() == mensajeIntr){
                mensajeRet = mensaje;
                mensajeEncontrado = true;
                
            }
        }
        
        if(mensajeEncontrado == false){
        
            System.out.println("El código introducido no existe");
        }
        
        return mensajeRet;
    }
    
    public static void añadirMenNormal(){
        
        String mensaje = null;
        
        Scanner ec = new Scanner (System.in);
        
        System.out.println("Introduzca el contenido del mensaje: ");
        
        mensaje = ec.nextLine();
        
        MensajeSinEncriptar mensajeNormal1 = new MensajeSinEncriptar(mensaje);
        
        listaMensajes.add(mensajeNormal1);
    }
    
    public static void añadirMenEncriptado(){
        
        String mensaje = null;
        
        Scanner ec = new Scanner (System.in);
        
        System.out.println("Introduzca el contenido del mensaje: ");
        
        mensaje = ec.nextLine();
        
        MensajeEncriptado mensajeEncriptado1 = new MensajeEncriptado(mensaje);
        
        listaMensajes.add(mensajeEncriptado1);
    }
    
    public static void desencriptarMensaje(){
        
        Mensaje mensaje = buscarMensaje();
        
        System.out.println(mensaje.getCodigo());
        
        if(mensaje instanceof MensajeEncriptado){
            
            System.out.println(((MensajeEncriptado) mensaje).desencriptar());
            
        }else{
            
            System.out.println("El mensaje no es de tipo encriptado");
        }
    }
    
    public static void eliminarMensaje(){
        
        Mensaje mensaje = buscarMensaje();
        
        listaMensajes.remove(mensaje);
        
        System.out.println("Se ha eliminado el mensaje "+mensaje.getCodigo());
        
        reorganizarCodigos();
        
        Mensaje.setUltimo(listaMensajes.size()+1);
    }
    
    
    public static void reorganizarCodigos(){
        
        int contador = 1;
        
        for(Mensaje mensaje:listaMensajes){
            
            mensaje.setCodigo(contador++);
        }
        
    }
    
    public static void guardarDatos(){
        
        File f = new File(archivoDatos);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try{
            
            oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(listaMensajes);
            oos.writeObject(Mensaje.getUltimo());
            
        }catch(IOException e){
            
            System.err.println("Error abriendo el fichero de datos para escritura");
            
        }finally{
            try{
                if(oos!=null)oos.close();
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
            listaMensajes = (ArrayList<Mensaje>) ois.readObject();
            Mensaje.setUltimo((int)ois.readObject());

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
                
        Scanner sc = new Scanner(System.in);
        int opcionIntroducida; 

        do{
            System.out.println("Bienvenido. Introduzca una opción del menú: ");
		
            opcionIntroducida = sc.nextInt();
            
            switch (opcionIntroducida){
                case 1: listarMensajes();
                break;
                case 2: mostrarMenNormales();
                break;
                case 3: mostrarMenEncriptados();
                break;
                case 4: buscarMensaje();
                break;
                case 5: 
                    
                    Scanner oc = new Scanner(System.in);
                    int opcionAñadir = 0;
                    
                    System.out.println("Introduzca el tipo de mensaje que desea añadir: 1. Normal 2. Encriptado");
                    
                    opcionAñadir = oc.nextInt();
                    
                    if(opcionAñadir == 1){
                        añadirMenNormal();
                    }else if(opcionAñadir == 2){
                        añadirMenEncriptado();
                    }else{
                        System.out.println("Introduzca una opción correcta");
                    }
                break;    
                case 6: desencriptarMensaje();
                break;
                case 7: eliminarMensaje();
                break;
                case 8: 
                    System.out.println("Gracias por su visita!");
            }
            
        }while(opcionIntroducida != 8);
        
        guardarDatos();
    }  
}
