
package baneuro;


import java.io.*;

import java.util.ArrayList;
import java.util.Iterator;

import static baneuro.Entrada.*;


public class Baneuro {
    static ArrayList<Cuenta> lista;
    static String entidad;
    static String oficina;
    static String fichero = "cuentas.dat";
    static String ficheroTexto = "cuentas.txt";
    
    
    public static String leerEntidad()
    {
        boolean leido = false;
        String ent="";
        System.out.println ("Indique el código de la entidad");
        while (!leido)
        {
            try
            {
                ent = leerTexto();
                if (ent.length()!=4) throw new Exception();
                Integer.valueOf(ent);
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Código de la oficina incorrecto. Esríbalo de nuevo");
            }
            
        }
        return ent;
    }
    public static String leerOficina()
    {
        boolean leido = false;
        String of="";
        System.out.println ("Indique el código de la oficina");
        while (!leido)
        {
            try
            {
                of = leerTexto();
                if (of.length()!=4) throw new Exception();
                Integer.valueOf(of);
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Código de la oficina incorrecto. Esríbalo de nuevo");
            }
            
        }
        return of;
    }
    
    public static void nuevaCuenta()
    {

        int op = leerInt("Tipo de cuenta:\n1. Cuenta corriente\n2. Cuenta de ahorro",1,2);
        String n = leerTexto("Escriba el nombre del cliente");
        String a = leerTexto("Escriba los apellidos del cliente");
        double saldo = leerDouble("Escriba el saldo inicial de la cuenta",0);
             
        if (op == 1)
        {
            CuentaCorriente c = new CuentaCorriente(n,a,entidad, oficina,saldo);
            lista.add(c);
        }
        else
        {
            CuentaAhorro c = new CuentaAhorro(n,a,entidad,oficina,saldo);
            lista.add(c);
        }
    }
    
    public static boolean ingresar()
    {
        
        String n = leerTexto("Escriba los 20 dígitos de la cuenta sin espacios o pulse s para salir");        
        while (!CCC.comprobarCCC(n) && !n.equalsIgnoreCase("s"))
        {
            n = leerTexto("Cuenta no válida. Escríbala de nuevo o pulse s para salir");
        }
        if (n.equalsIgnoreCase("s")) return false;
        Iterator<Cuenta> it = lista.iterator();
        Cuenta c=null;
        boolean encontrado =false;
        while (it.hasNext() && !encontrado)
        {
            c = it.next();
            if (c.igual(n))
                encontrado=true;
        }
        if (!encontrado)
        {
            System.out.println("La cuenta no se encuentra en el sistema");
            return false;
        }
        else
        {
        
            double cant = leerDouble("Escriba la cantidad a ingresar",0);
            return c.ingresar(cant);
            
        }
        
    }
    
        public static boolean retirar()
    {
        String n = leerTexto("Escriba los 20 dígitos de la cuenta sin espacios o pulse s para salir");
        while (!CCC.comprobarCCC(n) && !n.equalsIgnoreCase("s"))
        {
            n = leerTexto("Cuenta no válida. Escríbala de nuevo o pulse s para salir");
        }
        if (n.equalsIgnoreCase("s")) return false;
        Iterator<Cuenta> it = lista.iterator();
        Cuenta c=null;
        boolean encontrado =false;
        while (it.hasNext() && !encontrado)
        {
            c = it.next();
            if (c.igual(n))
                encontrado=true;
        }
        if (!encontrado)
        {
            System.out.println("La cuenta no se encuentra en el sistema");
            return false;
        }
        else
        {
        
            double cant = leerDouble("Escriba la cantidad a retirar",0);
            return c.retirar(cant);
            
        }
        
    }
    
    public static void listar()
    {
        Iterator<Cuenta> it = lista.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
        
    }
        
    
    public static int menu()
    {
        
        int op = leerInt("1. Nueva cuenta\n2. Ingresar\n3. Retirar\n4. Listar\n"
                       + "5. Exportar cuentas\n6. Salir",1,6);
        
        return op;
    }
    
    public static void cargarFichero()
    {
        File f = new File(fichero);
        FileInputStream fis = null;
        ObjectInputStream ois=null;
        
        if (!f.exists())
        {
            
            System.out.println("No existe el ficherode datos. Se creará uno nuevo");
            entidad = leerEntidad();
            oficina = leerOficina();
            lista=new ArrayList();
        }
        else
        {
            try 
            {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                lista = (ArrayList<Cuenta>)ois.readObject();
                CCC.setContador((long)ois.readObject());
                entidad = (String)ois.readObject();
                oficina = (String)ois.readObject();
            }
            catch (IOException e)
            {
                System.out.println("Error abriendo el fichero. Se creará uno nuevo");
                lista=new ArrayList();
                entidad = leerEntidad();
                oficina = leerOficina();
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Los datos del fichero no son los esperados. Se creará fichero nuevo");
                lista=new ArrayList();
                entidad = leerEntidad();
                oficina = leerOficina();
            }
            finally
            {
                try
                {
                    if (fis!=null)
                        fis.close();
                    if (ois!=null)
                        ois.close();
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    }
    
    public static void guardarFichero()
    {
        File f = new File(fichero);
        FileOutputStream fos = null;
        ObjectOutputStream oos=null;
        
      
        try 
        {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.writeObject(CCC.getContador());
            oos.writeObject(entidad);
            oos.writeObject(oficina);
            System.out.println("Datos guardados correctamente en el fichero");
        }
        catch (IOException e)
        {
            System.out.println("Error abriendo el fichero para escritura.");
        }
        finally
        {
            try
            {
                if (fos!=null)
                    fos.close();
                if (oos!=null)
                    oos.close();
            }
            catch(Exception e)
            {

            }
        }
       
    }
    
    public static void exportarCuentas()
    {
        BufferedWriter bw = null;
        
        try 
        {
            bw = new BufferedWriter(new FileWriter(ficheroTexto));
            Iterator<Cuenta>it = lista.iterator();
            while(it.hasNext())
            {
                bw.write(it.next().toString());
                bw.newLine();
                bw.write("---------------------------------------");
                bw.newLine();
            }
            System.out.println("Datos exportados correctamente");
        }
        catch (IOException e)
        {
            System.out.println("Error abriendo el fichero para escritura.");
        }
        finally
        {
            try
            {
                if (bw!=null)
                    bw.close();
            }
            catch(Exception e)
            {

            }
        }
       
    }
    
    
    public static void main(String[] args) {
        
        
        cargarFichero();
        int op =menu();
        while (op != 6)
        {
            switch (op)
            {
                case 1: nuevaCuenta();break;
                case 2: if (ingresar())
                            System.out.println("Ingreso realizado correctamente");
                        else
                            System.out.println("Ingreso cancelado");
                        break;
                case 3: if (retirar())
                            System.out.println("Retirada realizada correctamente");
                        else
                            System.out.println("Retirada cancelada");
                        break;
                case 4: listar(); break;
                case 5: exportarCuentas(); break;

            }
            op=menu();
        }
        guardarFichero();
        
    }
    
}
