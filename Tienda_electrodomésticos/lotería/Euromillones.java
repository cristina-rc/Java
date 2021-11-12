
import java.util.ArrayList;
import java.util.Scanner;


public class Euromillones extends Boleto{
    
    private int estrella1;
    private int estrella2;

    public Euromillones(String fecha) {
        super(fecha);
    }

    public int getEstrella1() {
        return estrella1;
    }

    public void setEstrella1(int estrella1) {
        this.estrella1 = estrella1;
    }

    public int getEstrella2() {
        return estrella2;
    }

    public void setEstrella2(int estrella2) {
        this.estrella2 = estrella2;
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
           
           if(numero>=1 && numero<=50){
               
               if(numeros.contains(numero)){
                   
                   System.out.println("No pueden existir números repetidos");
               }
               
               else{
                   
                   numeros.add(numero);
               }
               
           }else{
               
               System.out.println("Introduzca un número entre el 1 y el 50");
           }
       }while(numeros.size()!=5);
       
       
            System.out.println("Introduzca el número de la primera estrella: ");
            
             boolean numCorrecto = false;
       do{
            
            Scanner ac = new Scanner (System.in);

            int aux = ac.nextInt();

            if(aux>=1 && aux<=12){

                 estrella1 = aux;
                 
                 numCorrecto = true;

            }else{

                System.out.println("Introduzca un número entre el 1 y el 12");
            }

        }while (!numCorrecto);
       
        System.out.println("Introduzca el número de la segunda estrella: ");
        
        do{
            
            Scanner bc = new Scanner (System.in);
            
            int aux2 = bc.nextInt();

            if(aux2>=1 && aux2<=12){

                 estrella2 = aux2;
                 
                 numCorrecto = true;

            }else{

                System.out.println("Introduzca un número entre el 1 y el 12");
            }
            
        }while(!numCorrecto);
    }
    
    public void elegirNumerosAleatorios(){
        
        for(int i=0; i<5; i++){
           
           int numAleatorio = (int)(Math.random()*(54-1+1)+1);
           
           numeros.add(numAleatorio);
        }
        
        estrella1 = (int)(Math.random()*(12-1+1)+1);
        estrella2 = (int)(Math.random()*(12-1+1)+1);

    }

    @Override
    public String toString() {
        return "EUROMILLONES \nNúmero del boleto: "+numeroBoleto + "\nFecha del sorteo: "+fecha + "\nApuesta: " + numeros.toString() + "\nEstrellas: " + estrella1 + " ," + estrella2;
    }
    
}
