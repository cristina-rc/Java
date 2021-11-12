/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baneuro;

import java.util.Scanner;

/**
 *
 * @author anusk
 */
public class Entrada {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static int leerInt()
    {
        boolean leido=false;
        int numero=0;
        while (!leido)
        {
            try
            {   
                numero = sc.nextInt();
                sc.nextLine();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static int leerInt(String texto)
    {
        boolean leido=false;
        int numero = 0;
        while (!leido)
        {
            try
            {
                System.out.println (texto);
                
                numero = sc.nextInt();
                sc.nextLine();

                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static int leerInt(String texto, int i, int j)
    {
        boolean leido=false;
        int numero = 0;
        while (!leido)
        {
            try
            {
                System.out.println (texto);
                
                numero = sc.nextInt();
                sc.nextLine();
                if (numero<i || numero>j)
                    throw new Exception();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static int leerInt(int i, int j)
    {
        boolean leido=false;
        int numero = 0;
        while (!leido)
        {
            try
            {
              
                numero = sc.nextInt();
                sc.nextLine();
                if (numero<i || numero>j)
                    throw new Exception();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static double leerDouble()
    {
        boolean leido=false;
        double numero=0;
        while (!leido)
        {
            try
            {   
                numero = sc.nextDouble();
                sc.nextLine();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static double leerDouble(String texto)
    {
        boolean leido=false;
        double numero = 0;
        while (!leido)
        {
            try
            {
                System.out.println (texto);
                
                numero = sc.nextDouble();
                sc.nextLine();

                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static double leerDouble(String texto, double i, double j)
    {
        boolean leido=false;
        double numero = 0;
        while (!leido)
        {
            try
            {
                System.out.println (texto);
                
                numero = sc.nextDouble();
                sc.nextLine();
                if (numero<i || numero>j)
                    throw new Exception();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static double leerDouble(double i, double j)
    {
        boolean leido=false;
        double numero = 0;
        while (!leido)
        {
            try
            {
              
                numero = sc.nextDouble();
                sc.nextLine();
                if (numero<i || numero>j)
                    throw new Exception();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
        public static double leerDouble(String texto, double i)
    {
        boolean leido=false;
        double numero = 0;
        while (!leido)
        {
            try
            {
                System.out.println (texto);
                
                numero = sc.nextDouble();
                sc.nextLine();
                if (numero<i)
                    throw new Exception();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static double leerDouble(double i)
    {
        boolean leido=false;
        double numero = 0;
        while (!leido)
        {
            try
            {
              
                numero = sc.nextDouble();
                sc.nextLine();
                if (numero<i)
                    throw new Exception();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println ("Número no válido");
                sc.nextLine();
            }
        }
        return numero;
    }
    
    public static String leerTexto()
    {
        return sc.nextLine();

    }
    
    public static String leerTexto(String s)
    {
        System.out.println(s);
        return sc.nextLine();
    }
    
}
