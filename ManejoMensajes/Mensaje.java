/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoMensajes;

import java.io.Serializable;

public abstract class Mensaje implements Serializable{

    protected int codigo;
    protected String mensaje;
    protected static int ultimo = 1;
    

    public Mensaje(){
        
    }
    public Mensaje(String mensaje){
        
        this.mensaje = mensaje;
        this.codigo = ultimoMensaje();
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Mensaje.ultimo = ultimo;
    }
    
    public int ultimoMensaje(){
        
        return ultimo++;
    }
        
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "codigo=" + codigo + ", mensaje=" + mensaje + '}';
    }

}
