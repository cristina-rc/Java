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
public abstract class Cuenta implements Serializable{
    
    protected CCC cuenta;
    protected String nombre;
    protected String apellidos;
    protected double saldo;
    
    public Cuenta (String n, String a, String entidad, String oficina, double saldo)
    {
        cuenta = new CCC(entidad, oficina);
        nombre = n;
        apellidos = a;
        this.saldo = saldo;
    }
    
    public abstract boolean ingresar(double cant);
    public abstract boolean retirar(double cant);
    
    @Override
    public abstract String toString();
    
    public boolean igual(String c)
    {
        return cuenta.igual(c);
    }
    
}
