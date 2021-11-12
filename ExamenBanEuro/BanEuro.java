
package ExamenBanEuro;

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


public class BanEuro {

    private static ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
    private static String archivoDatos = "cuentas.dat";
    private static String codigoEntidad;
    private static String codigoOficina;
    
    public static void crearCuentaCorriente(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca su nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Introduzca sus apellidos: ");
        String apellidos = sc.nextLine();
        
        System.out.println("Introduzca el saldo inicial");
        double saldo = sc.nextDouble();
        
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(nombre, apellidos, saldo, codigoEntidad, codigoOficina);
        
        listaCuentas.add(cuentaCorriente1);
    }
    
    public static void crearCuentaAhorro(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca su nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Introduzca sus apellidos: ");
        String apellidos = sc.nextLine();
        
        System.out.println("Introduzca el saldo inicial");
        double saldo = sc.nextDouble();
        
        CuentaAhorro cuentaAhorro1 = new CuentaAhorro(nombre, apellidos, saldo, codigoEntidad, codigoOficina);
        
        listaCuentas.add(cuentaAhorro1);
    }
    
    public static Cuenta comprobarCuenta(String cuentaABuscar){
      
        Cuenta cuentaEncontrada = null; 
        
        for(Cuenta cuenta: listaCuentas){
            if ((cuenta.getCuenta().toString()).equals(cuentaABuscar)){
                cuentaEncontrada = cuenta;
            }
        }    
        if(cuentaEncontrada==null){
            System.out.println("El número de cuenta no coincide con ninguno de la base de datos");
        }
        
        return cuentaEncontrada;
    }
    
    public static void ingresar(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca el código de cuenta en la cual desea realizar el ingreso: ");
        
        String cuentaABuscar = sc.nextLine();
        
        Cuenta cuentaEncontrada = comprobarCuenta(cuentaABuscar);
        
        if(cuentaEncontrada != null){
            System.out.println("Introduzca el importe que desea ingresar: ");
            
            double importe = sc.nextDouble();
            
            cuentaEncontrada.ingresar(importe);
            
            System.out.println("El saldo final es: "+ cuentaEncontrada.getSaldo());
        }
    }
    
    public static void retirar(){
        
        Scanner sc = new Scanner (System.in);
       
        System.out.println("Introduzca el código de cuenta en la cual desea realizar la retirada: ");
        
        String cuentaABuscar = sc.nextLine();
        
        Cuenta cuentaEncontrada = comprobarCuenta(cuentaABuscar);
        
        if(cuentaEncontrada != null){
            System.out.println("Introduzca el importe que desea retirar: ");
            
            double importe = sc.nextDouble();
            
            cuentaEncontrada.retirar(importe);
            
            System.out.println("El saldo final es: "+ cuentaEncontrada.getSaldo());
        }
    }
    
    public static void listar(){
        
        for(Cuenta cuenta: listaCuentas){
            System.out.println(cuenta.toString());
        }    
    }
    
    public static void exportarCuentas(){
      
        String nb = "cuentas.txt";
        File f = new File(nb);

        BufferedWriter bw = null;
            
        try{
            bw = new BufferedWriter(new FileWriter(f));
            bw.write(listaCuentas.toString());
        }catch(IOException e){
            System.err.println("Error escribiendo el fichero"+nb);
        }finally{
            try{
                if(bw != null){
                bw.close();
                }
            }catch (IOException e){
            }
        System.out.println("Se ha generado correctamente el archivo de texto");
        }            
    }
    
    public static void guardarFichero(){
        
        File f = new File(archivoDatos);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try{
            oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(codigoEntidad);
            oos.writeObject(codigoOficina);
            oos.writeObject(listaCuentas);
            oos.writeObject(CCC.getUltimaCuenta());
                       
        }catch(IOException e){
            System.err.println("Error abriendo el fichero de datos para escritura");
            
        }finally{
            try{if(oos!=null)oos.close();
                if(fos!=null)fos.close();
            }catch(IOException e){}
        }
    }
    
    
    public static void cargarFichero(){
        
        File f = new File(archivoDatos);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        if (!f.exists()){
            
            System.out.println("No existe el fichero de datos; se creará uno nuevo");
            codigoEntidad = leerEntidad();
            codigoOficina = leerOficina();
            listaCuentas = new ArrayList();
            
        }else{
            try{
                ois = new ObjectInputStream(new FileInputStream(f));
                codigoEntidad = (String)ois.readObject();
                codigoOficina = (String)ois.readObject();
                listaCuentas = (ArrayList<Cuenta>)ois.readObject();
                CCC.setUltimaCuenta((int)ois.readObject());

            }catch (IOException e){
                System.err.println("Error abriendo el fichero de datos");
                codigoEntidad = leerEntidad();
                codigoOficina = leerOficina();
                listaCuentas = new ArrayList();
                
            }catch(ClassNotFoundException e){
                System.err.println("Error leyendo los datos del fichero");
                codigoEntidad = leerEntidad();
                codigoOficina = leerOficina();
                listaCuentas = new ArrayList();
                
            }finally{
                try{
                    if(ois!=null) ois.close();
                    if(fis!=null) fis.close();
                    
                }catch(IOException e){}
            }
        }
    }
    
    public static String leerEntidad(){
        
        Scanner sc = new Scanner (System.in);

        System.out.println("Introduzca el código de la entidad: ");
        String codigoEntidad = sc.nextLine();
        
        return codigoEntidad;

    }
     
    public static String leerOficina(){

        Scanner sc = new Scanner (System.in);

        System.out.println("Introduzca el código de la oficina: ");
        String codigoOficina = sc.nextLine();

        return codigoOficina;

    }
    public static void main(String[] args) {
        
        cargarFichero();
        
        Scanner sc = new Scanner(System.in);
        int opcionIntroducida;
        
        do{
            System.out.println("Bienvenido. Introduzca una opción del menú: ");
            
            opcionIntroducida = sc.nextInt();
            
            switch (opcionIntroducida){
                case 1: crearCuentaCorriente();
                break;
                case 2: crearCuentaAhorro();
                break;
                case 3: ingresar();
                break;
                case 4: retirar();
                break;
                case 5: listar();
                break;
                case 6: exportarCuentas();
                break;
                case 7: System.out.println("Gracias por su visita");
                break;
                default: System.out.println("Introduzca una opción correcta");
            }
        }while(opcionIntroducida != 7);

        guardarFichero();
    }
}
    
