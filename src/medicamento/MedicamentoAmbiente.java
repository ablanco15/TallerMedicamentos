/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 *
 * @author LAB_ING
 */
public class MedicamentoAmbiente extends Medicamento {
    ArrayList<String> lugaresNoAlmacenables;    
    
 
    public MedicamentoAmbiente( String codigo, String nombre, int costoEmpresa, int precioPublico, int unidades, int mesDeVencvimiento, int anoDeVencvimiento, int numeroDeLote, int vigencia) {
        super(codigo, nombre, costoEmpresa, precioPublico, unidades, mesDeVencvimiento, anoDeVencvimiento, numeroDeLote, vigencia);
        lugaresNoAlmacenables= new ArrayList<>();
                
    }
  
    public MedicamentoAmbiente() {
        lugaresNoAlmacenables = new ArrayList<>();
    }
    @Override
    public void comprarMedicamento(){
       
   }
    
    @Override
    public void leerDatos(String nombre){
        boolean continuarCiclo=true;
        int contador = 0;
        int opcion = 0;
        String lugar = ""; 
        super.leerDatos(nombre);
        in.nextLine();
        do{//mientras hayan menos de 3 lugares que no se pueden almacenar se repie el ciclo
            //luego cuando hay mas 3 o mas se le pregunta si desean agregar otros lugares
            System.out.println("Indicar un lugar donde no se puede almacenar el medicamento");//agregar parametro donde solo pueden ser caracteres
            lugar= in.nextLine();
            lugaresNoAlmacenables.add(lugar);
            contador++;
            System.out.println("relajado cara de perro");
            if(contador>=3){
                do{
                    try{
                        System.out.println("¿Desea agregr otro lugar?");
                        System.out.println("1)si");
                        System.out.println("2)no");
                        opcion=in.nextInt();
                        if(opcion==2){
                            continuarCiclo=false;
                        }
                    }catch(InputMismatchException e1){                        
                        System.out.println("Dato equivocado, vuelve a intentarlo");
                        in.nextLine();
                        }
                    if(opcion<1||opcion>2){
                        System.out.println("Opcion no Disponible, vuelve a intentarlo");
                    }
                }while(continuarCiclo);
            }
            
        }while((contador<3)||(continuarCiclo));
   }
    
    
    @Override
    public void mostrarInformacion(String nombre){
        super.mostrarInformacion(nombre);
        System.out.println("lugar en el que no se puede almacenar el medicamento ");
        Iterator<String> it = lugaresNoAlmacenables.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
}    
