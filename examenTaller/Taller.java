/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenTaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller {

    private static ArrayList<Trabajo> listaTrabajos = new ArrayList<Trabajo>();
    private static String archivoDatos = "trabajos.dat";
    
    
    public static void generarRepMecanica(){
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Introduzca una descripción del trabajo: ");
        
        String descripcion = sc.nextLine();
            
        ReparacionMecanica repMecanica1 = new ReparacionMecanica(descripcion);
        
        listaTrabajos.add(repMecanica1);
    }
    
    public static void generarRepChapaPintura(){
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Introduzca una descripción del trabajo: ");
        
        String descripcion = sc.nextLine();
            
        ReparacionChapaPintura repChapaPintura1 = new ReparacionChapaPintura(descripcion);
        
        listaTrabajos.add(repChapaPintura1);
    }
    
    public static void generarRevision(){
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Introduzca una descripción del trabajo: ");
        
        String descripcion = sc.nextLine();
            
        Revision revision1 = new Revision(descripcion);
        
        listaTrabajos.add(revision1);

    }
    
    //Estudiar deep and shallow copy
    
    public static Trabajo comprobarID(){
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Introduzca el ID del trabajo: ");
        
        Trabajo trabajoOut = null;
        
        do{
            String idTrabajo = sc.nextLine();
        
            for(Trabajo trabajo : listaTrabajos){
                if(trabajo.getIdTrabajo().equals(idTrabajo)){
                    trabajoOut = trabajo;
                }
            }
            
            if(trabajoOut == null){
                System.out.println("Código no encontrado, introduzca otro código existente: ");
            }
        }while(trabajoOut==null);
        
        return trabajoOut;
    }
    
    public static void añadirHoras(){
        
        Scanner sc = new Scanner (System.in);
                
        System.out.println("Introduzca el número de horas a incrementar: ");
        
        int horas = sc.nextInt();
        
        Trabajo trabajo = Taller.comprobarID();
        
        trabajo.incrementarHoras(horas);
        
        System.out.println(trabajo.toString());
        
    }
    
    public static void añadirMaterial(){
       
        Scanner sc = new Scanner (System.in);
                
        System.out.println("Introduzca el coste del material a incrementar: ");
        
        int precioMaterial = sc.nextInt();
        
        Trabajo trabajo = Taller.comprobarID();
        
        if(trabajo instanceof ReparacionMecanica){
        
            ReparacionMecanica reparacionMecanica = (ReparacionMecanica)trabajo;
            
            reparacionMecanica.usarMaterial(precioMaterial);
            
        }else if(trabajo instanceof ReparacionChapaPintura){
        /*
            ReparacionChapaPintura reparacionChapaPintura = (ReparacionChapaPintura)Taller.comprobarID();
            
            reparacionChapaPintura.usarMaterial(precioMaterial);
        */
            ReparacionChapaPintura reparacionChapa = (ReparacionChapaPintura)trabajo;
            
            reparacionChapa.usarMaterial(precioMaterial);
            
        }else{
            System.out.println("No se trata de una reparación, por lo que no se pueden añadir materiales al trabajo");
            
        }
        
        System.out.println(trabajo.toString());
    }
    
    public static void finalizarTrabajo(){
        
        Trabajo trabajo = Taller.comprobarID();
        
        trabajo.setFinalizado(true);
        
        trabajo.imprimir();
        
        System.out.println(trabajo.toString());
        
    }
    
    
    public static void listarTrabajos(){
        
        System.out.println(listaTrabajos.toString());
    }
    
    public static void guardarDatos(){
        
        File f = new File(archivoDatos);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try{
            
            oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(listaTrabajos);
            oos.writeObject(Trabajo.getUltimo());
            
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
            listaTrabajos = (ArrayList<Trabajo>) ois.readObject();
            Trabajo.setUltimo((int)ois.readObject());

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
        
        Taller.cargarDatos();
        
        int opcionIntroducida = 0; 
                
        do{
            System.out.println("Bienvenido. Introduzca una opción del menú: \n1. Nuevo trabajo \n2. Añadir horas \n3. Añadir material  \n4. Finalizar trabajo y generar factura \n5. Listar trabajos \n6. Salir");
            
            Scanner sc = new Scanner(System.in);
            
            opcionIntroducida = sc.nextInt();
            
            switch (opcionIntroducida){
                case 1:
                    
                    Scanner oi = new Scanner (System.in);
                    System.out.println("¿Qué tipo de trabajo desea añadir? \n1. Reparación mecánica \n2. Reparación de chapa y pintura \n3. Revisión");
                    
                    int opcionNT = oi.nextInt();
                    
                    switch(opcionNT){
                            
                        case 1: Taller.generarRepMecanica();
                                break;
                        case 2: Taller.generarRepChapaPintura();
                                break;
                        case 3: Taller.generarRevision();
                                break;
                        default: System.out.println("Introduzca una opción del menú válida");
                                break;
                    }
                break;
                
                case 2: Taller.añadirHoras();
                break;
                
                case 3: Taller.añadirMaterial();
                break;
                
                case 4: Taller.finalizarTrabajo();
                break;
                
                case 5: Taller.listarTrabajos();
                break;
                
                case 6: System.out.println("Gracias por su visita");
                break;
                
                default: System.out.println("Introduzca una opción del menú válida");
                break;
            }
            
        }while(opcionIntroducida != 6);
        
        Taller.guardarDatos();
    }
    
}
