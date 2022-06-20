package medicamento;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB_ING
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.*;
import java.util.Iterator;

public class Main {  

    public static void main(String args[]){
      //Medicamento prueba = new Medicamento();
        Scanner in = new Scanner(System.in);
        MedicamentoAmbiente ibuprofeno=new MedicamentoAmbiente("6789","ibuprofeno",16,18,3,8,2022,11,3);
        MedicamentoAmbiente brugesic=new MedicamentoAmbiente("12345","brugesic",18,21,4,8,2025,10,2);
        MedicamentoAmbiente loratadina=new MedicamentoAmbiente("4321","loratadina",22,25,50,12,2028,10,0);
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(ibuprofeno);
        medicamentos.add(brugesic);
        medicamentos.add(loratadina);
        MedicamentoAmbiente xyz = new MedicamentoAmbiente();
        MedicamentoRefrigerado abc= new MedicamentoRefrigerado();
        int menu=1;
        int numeroDeLote=0;
        int numeroDeMedicamento=0;
        int cantidadDeMedicamentos = medicamentos.size();
        int existe=0;
        int opcion=0;
        int i=0;
        boolean esta=false;
        String nombre="";
        boolean continuarCiclo=true;
        Iterator<Medicamento> it = medicamentos.iterator();
        
        do{
            do{
                try{
                    System.out.println("Menu\n");
                    System.out.println("1) Deseo saber si un medicamento esta vencido\n");
                    System.out.println("2) Deseo retirar un lote\n");
                    System.out.println("3) Deseo conocer el inventario de un medicamento\n");
                    System.out.println("4) Colocar oferta\n");
                    System.out.println("6) Agregar medicamento\n");
                    System.out.println("7) eliminar medicamento\n");
                    System.out.println("0) Salir\n");
                    menu = in.nextInt();
                    continuarCiclo=false;
                    in.nextLine();
                    
                }catch(InputMismatchException e1){
                    System.out.println("Dato equivocado, vuelve a intentarlo");
                    continuarCiclo=true;
                    in.nextLine();
                }
                if((menu>6)||(menu<0)){
                         System.out.println("Opcion no Disponible, vuelve a intentarlo");
                         continuarCiclo=true;   
                    }
             }while(continuarCiclo);
                          
                
        
       switch(menu){
           case 1:
               
                   do{
                       try{
                           
                           System.out.println("¿Que medicamento desea verificar? \n");
                           System.out.println("1)Ibuprofeno; 2)Brugesic; 3)Loratadina");
                           numeroDeMedicamento = in.nextInt();  
                           continuarCiclo=false;
                       }catch(InputMismatchException e1){
                           System.out.println("Dato equivocado, vuelve a intentarlo");
                           continuarCiclo=true;
                           in.nextLine(); 
                       }
                       if((numeroDeMedicamento<0)||(numeroDeMedicamento>3)){
                       System.out.println("Numero erroneo,vuelva a intentar\n");
                       continuarCiclo=true;
                       }else{
                            medicamentos.get(numeroDeMedicamento-1).determinarVencido();
                        }
                   }while(continuarCiclo);
               break;
           case 2:
               do{
                   try{
                       System.out.println("Numero de lote que desea retirar");
                       numeroDeLote= in.nextInt();
                   }catch(InputMismatchException e1){
                       System.out.println("Dato equivocado, vuelve a intentarlo");
                       continuarCiclo=true;
                       in.nextLine();
                   }
                   
                   if(numeroDeLote<0){
                       System.out.println("Este lote no existe,vuelva a intentar\n");
                       continuarCiclo=true;
                   }else{
                       for( i=0; i<=cantidadDeMedicamentos-1; i++){ 
                         existe+=medicamentos.get(i).retirarLote(numeroDeLote);    
                       }
                       
                       if(existe==0){ 
                             System.out.println("Lo sentimos el numero de lote no existe o ya fue retirado\n");  
                       }else{
                             System.out.println("El numero de lote fue retirado, "+existe+" medicamentos pertenecian a este lote\n");
                            }     
                   }
                   
                  }while(continuarCiclo);
               
               break;
           case 3:
               do{
                  try{
                      System.out.println("¿Que medicamento desea verificar? \n");
                      System.out.println("1)Ibuprofeno; 2)Brugesic; 3)Loratadina");
                      numeroDeMedicamento = in.nextInt();
                  }catch(InputMismatchException e1){
                      System.out.println("Dato equivocado, vuelve a intentarlo");
                      continuarCiclo=true;
                      in.nextLine();                      
                  }
 
                   if((numeroDeMedicamento<0)||(numeroDeMedicamento>3)){
                       System.out.println("Numero erroneo,vuelva a intentar\n");
                       continuarCiclo=true;
                   }else{
                       medicamentos.get(numeroDeMedicamento-1).reponerInventario();
                   }
                   
                   }while(continuarCiclo);
               break;
           case 4:   
               it = medicamentos.iterator();
               while(it.hasNext()){
                     if(nombre.equals(it.next().getNombre()))
                         {
                         it.next().colocarOferta();
                        }
                    }
               
             //  break;
           //case 5:
               
               break;
             case 6:
                 i=0;
                 esta=false;
                 it = medicamentos.iterator();
                 do{
                    System.out.println("¿Cual es el nombre del medicamento que desea agregar?");
                    nombre = in.nextLine();
                }while(nombre.equals(""));
                 //Aqui estoy revisando que no exista el medicamento en la lista para podeer introducir otro
                  
                 while(it.hasNext()){
                     if(nombre.equals(it.next().getNombre()))
                         {
                         esta=true;
                        }
                    }
                 if(!esta){//si no esta entonces procede a introducir los datos
                     
                     do{                    
                        try{  
                            System.out.println("¿Que tipo de medicamento desea agregar? \n");
                            System.out.println("1)Medicamento Refrigerado \n");
                            System.out.println("2) Medicamento Común \n");
                            opcion = in.nextInt();                                                   
                        }catch(InputMismatchException e1){                      
                            System.out.println("Dato equivocado, vuelve a intentarlo");                      
                            continuarCiclo=true;                      
                            in.nextLine();                      
                        }
                     if((opcion<1)||(opcion>2)){
                        System.out.println("Numero erroneo,vuelva a intentar\n");
                        continuarCiclo=true;
                     }
                 }while(continuarCiclo);
                 if(opcion==1){
                     abc.leerDatos(nombre);
                     medicamentos.add(xyz);
                 }else{
                     xyz.leerDatos(nombre);
                     medicamentos.add(abc);
                 }
                     
                 }else{
                      System.out.println("Este medicamento ya se encuentra en la nuestros almacenes\n");
                 }
      
                 
               break;
             case 7:
                  it = medicamentos.iterator();
                  i=0;
                  esta=false;
                 do{
                    System.out.println("¿Cual es el nombre del medicamento que desea eliminar?\n");
                    nombre = in.nextLine();
                }while(nombre.equals(""));
                
                 while(it.hasNext()||esta){
                     if(nombre.equals(it.next().getNombre()))
                         {
                            medicamentos.remove(it.next()); 
                         esta=true;
                        }
                    }
               
                 if(!esta){
                     System.out.println("El medicamento no esta en nuestrs almacenes o ya fue elminado!\n");  
                 }
       
   }
       
    }while(menu!=0);    
   
   
    }

}
