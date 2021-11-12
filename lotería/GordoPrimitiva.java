
import java.util.ArrayList;
import java.util.Scanner;


public class GordoPrimitiva extends Boleto {
    
    private int numeroAdicional;

    public GordoPrimitiva(String fecha) {
        super(fecha);
    }

    public int getNumeroAdicional() {
        return numeroAdicional;
    }

    public void setNumeroAdicional(int numeroAdicional) {
        this.numeroAdicional = numeroAdicional;
    }

    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(int numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }
    
    
    
    public void elegirNumerosEscaner(){
        
       System.out.println("Introduzca los cinco números del boleto: ");
       
       do{
           
           Scanner sc = new Scanner (System.in);
           int numero = sc.nextInt();
           
           if(numero>=1 && numero<=54){
               
               if(numeros.contains(numero)){
                   
                   System.out.println("No pueden existir números repetidos");
               }
               
               else{
                   
                   numeros.add(numero);
               }
               
           }else{
               
               System.out.println("Introduzca un número entre el 1 y el 54");
           }
       }while(numeros.size()!=5);
       
       System.out.println("Introduzca el número adicional: ");
       
       boolean numCorrecto = false;
       
       do{
                      
            Scanner ac = new Scanner (System.in);

            int aux = ac.nextInt();

            if(aux>=0 && aux<=9){

                 numeroAdicional = aux;
                 numCorrecto = true;

            }else{

                System.out.println("Introduzca un número entre el 0 y el 9");
            }
            
        }while(!numCorrecto);
    }
    
    public void elegirNumerosAleatorios(){
        
        for(int i=0; i<5; i++){
           
           int numAleatorio = (int)(Math.random()*(54-1+1)+1);
           
           numeros.add(numAleatorio);
        }
        
        numeroAdicional = (int)(Math.random()*(9-0+1)+0);
    }

    @Override
    public String toString() {
        return "EL GORDO \nNúmero del boleto: "+numeroBoleto + "\nFecha del sorteo: "+fecha + "\nApuesta: " + numeros.toString() + "\nReintegro: " +numeroAdicional;
    }
    
    
    
}
