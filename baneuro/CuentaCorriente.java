/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baneuro;

/**
 *
 * @author anusk
 */
public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(String n, String a, String entidad, String oficina, double saldo)
    {
        super(n, a, entidad, oficina, saldo);
    }
    
    @Override
    public boolean ingresar(double cant) {
        saldo+=cant;
        return true;
    }

    @Override
    public boolean retirar(double cant) {
        if (saldo >= cant)
        {
            saldo-=cant;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Cuenta: "+cuenta+"\nCliente: "+nombre+" "+apellidos+"\nSaldo: "+saldo+"€";
    }
    
}
