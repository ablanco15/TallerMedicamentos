/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamento;

import java.util.InputMismatchException;

/**
 *
 * @author LAB_ING
 */
public class MedicamentoRefrigerado extends Medicamento{
    private int temperaturaMax;
    private int temperaturaMin;
    private int tiempoAbierto;
    private String tipoDeCadena;//ultracongelada(-70), congelada(-20), refrigerada(2-8)

    public MedicamentoRefrigerado(int temperaturaMax, int temperaturaMin, int tiempoAbierto, String tipoDeCadena, String codigo, String nombre, int costoEmpresa, int precioPublico, int unidades, int mesDeVencvimiento, int anoDeVencvimiento, int numeroDeLote, int vigencia) {
        super(codigo, nombre, costoEmpresa, precioPublico, unidades, mesDeVencvimiento, anoDeVencvimiento, numeroDeLote, vigencia);
        this.temperaturaMax = temperaturaMax;
        this.temperaturaMin = temperaturaMin;
        this.tiempoAbierto = tiempoAbierto;
        this.tipoDeCadena = tipoDeCadena;
    }

    public MedicamentoRefrigerado() {
        temperaturaMax = 0;
        temperaturaMin = 0;
        tiempoAbierto =0 ;
        tipoDeCadena ="refrigerada"; 
    }
    
    @Override
    public void leerDatos(String nombre){
        boolean continuarCiclo=true;
        super.leerDatos(nombre);
       do{
           try{
               System.out.println("¿Cual es la Temperatura Maxima?");
               temperaturaMax= in.nextInt();
               continuarCiclo=false;
           }catch(InputMismatchException e1){
               System.out.println("Dato equivocado, vuelve a intentarlo");
               continuarCiclo=true;
               in.nextLine();
           };
       }while(continuarCiclo);
       do{
           try{
               System.out.println("¿Cual es la Temperatura Minima?");
               temperaturaMin= in.nextInt();
               continuarCiclo=false;
           }catch(InputMismatchException e1){
               System.out.println("Dato equivocado, vuelve a intentarlo");
               continuarCiclo=true;
               in.nextLine();
           };
       }while(continuarCiclo);
       do{
           try{
               System.out.println("¿A que tipo de cadena pertenece este medicamento?\n");
               System.out.println("|ultracongelada|");
               System.out.println("|congelada|");
               System.out.println("|refrigerada|");
               System.out.println();
               tipoDeCadena = in.nextLine();;
               continuarCiclo=false;
           }catch(InputMismatchException e1){
               System.out.println("Dato equivocado, vuelve a intentarlo");
               continuarCiclo=true;
               in.nextLine();
           };
           
           if(tipoDeCadena!="ultracongelada"||tipoDeCadena!="congelada"||tipoDeCadena!="refrigerado");{
           System.out.println("Opcion no Disponible, vuelve a intentarlo");
           continuarCiclo=true; 
            }
       }while(continuarCiclo);
       
    }
    
    @Override
    public void precioAPagar(){
        super.precioAPagar();
        precioPublico+= precioPublico*25/100;
    }

   
    @Override
    public void comprarMedicamento(){
       
   }
    
    @Override
    public void mostrarInformacion(String nombre){
        super.mostrarInformacion(nombre);
        System.out.println("La temperatura maxima a la que puede estar el medicamento es: "+temperaturaMax);
        System.out.println("La temperatura minima a la que puede estar el medicamento es: "+temperaturaMin);
        System.out.println("Este medicamento pertenece al tipo de cadena: "+tipoDeCadena);
    }

    public int getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(int temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public int getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(int temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public int getTiempoAbierto() {
        return tiempoAbierto;
    }

    public void setTiempoAbierto(int tiempoAbierto) {
        this.tiempoAbierto = tiempoAbierto;
    }

    public String getTipoDeCadena() {
        return tipoDeCadena;
    }

    public void setTipoDeCadena(String tipoDeCadena) {
        this.tipoDeCadena = tipoDeCadena;
    }
    
    
    
    
    
}
