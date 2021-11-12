/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoMensajes;

public class MensajeEncriptado extends Mensaje implements IEncriptable {
    
    public MensajeEncriptado(String mensaje){
        
        this.codigo = ultimoMensaje();
        this.mensaje = encriptar(mensaje);
    }
    
    
    public String encriptar(String men){
        
        char[] arrayMensaje = men.toCharArray();
        
        for(int i=0; i<arrayMensaje.length; i++){
            
            arrayMensaje[i] = (char)(arrayMensaje[i]+1);
        }
        
        return String.copyValueOf(arrayMensaje);
    }
    
    public String desencriptar(){
        
        char[] arrayMensaje = mensaje.toCharArray();
        
        for(int i=0; i<arrayMensaje.length; i++){
            
            arrayMensaje[i] = (char)(arrayMensaje[i]-1);
        
        }
        
        return String.copyValueOf(arrayMensaje);
    }
    
    @Override
    public String toString() {
        return "Mensaje{" + "codigo=" + codigo + ", mensaje=" + mensaje + '}';
    }
}

