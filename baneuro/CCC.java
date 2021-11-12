/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baneuro;

import java.io.Serializable;

/**
 *
 * @author anusk
 */
public class CCC implements Serializable{
    
    private String entidad;
    private String oficina;
    private String dc;
    private String cuenta;
    private static long contador = 0;
    
    public CCC(String entidad, String oficina)
    {
        contador++;
        cuenta = String.valueOf(contador);
        while (cuenta.length()<10) cuenta="0"+cuenta;
        this.entidad = entidad;
        this.oficina = oficina;
        dc=String.valueOf(dc1(entidad+oficina))+String.valueOf(dc2(cuenta));
        
    }
    
    
    public static boolean comprobarCCC(String codigo)
    {
        try
        {
            if (codigo.length()!=20) return false;
            if (dc1(codigo.substring(0,8))!=Integer.valueOf(codigo.substring(8,9))) return false;
            if (dc2(codigo.substring(10))!=Integer.valueOf(codigo.substring(9, 10))) return false;
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public boolean igual(String s)
    {
        return s.equals(entidad+oficina+dc+cuenta);
    }
    
    @Override
    public String toString()
    {
        return entidad+" "+oficina+" "+dc+" "+cuenta;
    }
    
    private static int dc1(String s)
    {
        int[] factores = {4,8,5,10,9,7,3,6};
        return dc(s,factores);
    }
    
    private static int dc2(String s)
    {
        int[] factores = {1,2,4,8,5,10,9,7,3,6};
        return dc(s,factores);
    }
    
    private static int dc(String s, int[] factores)
    {
        int suma = 0;
        for (int i = 0; i<factores.length;i++)
            suma += Integer.valueOf(s.substring(i, i+1))*factores[i];
        int resto = suma%11;
        int dif = 11-resto;
        if (dif ==10) return 1;
        else if (dif == 11) return 0;
        else return dif;
    }
    
    public static long getContador()
    {
        return contador;
    }
    
    public static void setContador(long i)
    {
        contador = i;
    }

    
}
