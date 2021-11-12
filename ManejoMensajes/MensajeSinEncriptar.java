/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoMensajes;

public class MensajeSinEncriptar extends Mensaje{
    
    public MensajeSinEncriptar(String mensaje){
    
        super(mensaje);
    }
    
    @Override
    public String toString() {
        return "Mensaje{" + "codigo=" + codigo + ", mensaje=" + mensaje + '}';
    }
    
}
