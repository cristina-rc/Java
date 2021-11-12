import java.util.*;

public class Primitiva extends Boleto{
    
   private int reintegro = (int)(Math.random()*(9-0+1))+0;

   public Primitiva(String fecha) {
        super(fecha);
   }

    public int getReintegro() {
        return reintegro;
    }

    public void setReintegro(int reintegro) {
        this.reintegro = reintegro;
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
       
       System.out.println("Introduzca los seis números del boleto: ");
       
       do{
           
           Scanner sc = new Scanner (System.in);
           int numero = sc.nextInt();
           
           if(numero>=1 && numero<=49){
               
               if(numeros.contains(numero)){
                   
                   System.out.println("No pueden existir números repetidos");
               }
               
               else{
                   
                   numeros.add(numero);
               }
               
           }else{
               
               System.out.println("Introduzca un número entre el 1 y el 49");
           }
       }while(numeros.size()!=6);
   }
   
   public void elegirNumerosAleatorios(){
       
       for(int i=0; i<6; i++){
           
           int numAleatorio = (int)(Math.random()*(49-1+1)+1);
           
           numeros.add(numAleatorio);
       }
   }

    @Override
    public String toString() {
        return "PRIMITIVA \nNúmero del boleto: "+numeroBoleto + "\nFecha del sorteo: "+fecha + "\nApuesta: " + numeros.toString() + "\nReintegro: " +reintegro;
    }
   
   
}
