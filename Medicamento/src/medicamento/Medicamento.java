/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamento;




/**
 *
 * @ablanco.15
 */


import java.util.Scanner;
import java.time.*;


public abstract class Medicamento {
    protected String codigo;
    protected String nombre;
    protected double costoEmpresa;
    protected double precioPublico;
    protected int unidades;
    protected int numeroDeLote;
    protected int vigencia;
    protected YearMonth fechaVencimiento;
    
   Scanner in = new Scanner(System.in);
   
    public Medicamento(String codigo, String nombre, int costoEmpresa, int precioPublico, int unidades, int mesDeVencimiento, int anoDeVencimiento, int numeroDeLote, int vigencia) {
        //fecha = new Date();
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoEmpresa = costoEmpresa;
        this.precioPublico = precioPublico;
        this.unidades = unidades;
        this.fechaVencimiento = fechaVencimiento.of(mesDeVencimiento,anoDeVencimiento);
        this.numeroDeLote = numeroDeLote;
        this.vigencia = vigencia;
    }
   
   public Medicamento(){
        codigo = "";
        nombre = "";
        costoEmpresa = 0;
        precioPublico = 0;
        unidades = 0;
        fechaVencimiento = YearMonth.of(12, 2025);
        numeroDeLote = 0;
        vigencia =1;
   }

   public void leerDatos(String nombre){
           int mesDeVencimiento;
           int anoDeVencimiento;
           boolean continuarCiclo=true;
           this.nombre = nombre;
       System.out.println("Hola, a continuacion registraremos los datos del medicamento "+nombre+"\n");
       
       do{
           System.out.println("¿Cual es el codigo de "+nombre+"?");
           codigo = in.nextLine();
       }while(codigo.equals(""));
       System.out.println("\n");
       do{
           System.out.println("¿Cual es el costo de "+nombre+"?");
           costoEmpresa = in.nextInt();
       }while(costoEmpresa<0);
       precioPublico=costoEmpresa*1.30;
       System.out.println("Costo de manufactura: "+costoEmpresa);
       System.out.println("Precio de venta: "+precioPublico);
       System.out.println("\n");
       do{
           System.out.println("¿Cuantas unidades de "+nombre+" hay disponibles para la venta?");
           unidades = in.nextInt();
       }while(unidades<=0);
       System.out.println("\n");
       do{
           System.out.println("¿Cual es el año de vencimiento de "+nombre+" ?");
           anoDeVencimiento = in.nextInt();
       }while(anoDeVencimiento<YearMonth.now().getYear());
       System.out.println("\n");do{
           System.out.println("¿Cual es el mes de vencimiento de "+nombre+" ?");
           mesDeVencimiento = in.nextInt();
       }while((mesDeVencimiento<YearMonth.now().getMonthValue())||(mesDeVencimiento>12));
       fechaVencimiento= YearMonth.of(mesDeVencimiento,anoDeVencimiento);
       System.out.println("\n");
       do{
           System.out.println("¿Cual es el numero de lote de "+nombre+" ?");
           numeroDeLote = in.nextInt();
       }while(numeroDeLote<0);
       System.out.println("\n");
       do{
           System.out.println("¿Codigo de vigencia de "+nombre+"?\n");
           System.out.println("0)No disponible");
           System.out.println("1)Disponible");
           System.out.println("2)Retirado del mercado");
           vigencia = in.nextInt();
       }while((vigencia<0)||(vigencia>2));
       System.out.println("\n");
       
    }
   
   public void mostrarInformacion(String nombre){
       System.out.println("Informacion del producto "+nombre+":");
       System.out.println("Codigo: "+codigo+"\n");
       System.out.println("Costo de manufactura: "+costoEmpresa+"\n");
       System.out.println("Precio de venta al publico "+nombre+":");
       System.out.println("Unidades disponibles "+unidades+":");
       System.out.println("Numero de lote "+numeroDeLote+":");
       System.out.println("Fecha de Vencimiento: "+fechaVencimiento);
       System.out.print("Estado del producto: ");
       switch(vigencia){
           case 1: System.out.print("Disponible");
           case 2: System.out.print("No disponible");
           case 3: System.out.print("Retirado del mercado");
       }
       System.out.println();
   }
   public void precioAPagar(){
       final int porcentajeDeGanancia = 40;
       precioPublico= (costoEmpresa + (costoEmpresa*40)/100);
   }
   
   public void determinarVencido(){
       YearMonth.now().compareTo(fechaVencimiento);
       if(YearMonth.now().compareTo(fechaVencimiento)==1){
           System.out.println("El medicamento "+nombre+" se encuentra vigente");
       }else {
           System.out.println("El medicamento "+nombre+" se encuentra vencido");
           System.out.println("Fecha en la que vencio: "+fechaVencimiento);
           System.out.println("Codigo del producto: "+codigo);
       }
   }
   public int retirarLote(int numeroDeLote){
       int existe=0;
       if(this.numeroDeLote==numeroDeLote){
            vigencia=2;
            existe++;
       }
        return existe;
    }
   public void colocarOferta(){
       
       
    }  
   
   public void reponerInventario(){
       if(unidades<=5){
           System.out.println("Quedan "+unidades+" unidades, deberia reponer inventario");
           
       }else{
           System.out.println("Quedan "+unidades+" unidades en stock, todavia no es tiempo de reponer");
       }  
    }
         
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoEmpresa() {
        return costoEmpresa;
    }

    public void setCostoEmpresa(int costoEmpresa) {
        this.costoEmpresa = costoEmpresa;
    }

    public double getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(int precioPublico) {
        this.precioPublico = precioPublico;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    

    public int getNumeroDeLote() {
        return numeroDeLote;
    }

    public void setNumeroDeLote(int numeroDeLote) {
        this.numeroDeLote = numeroDeLote;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }
    
    public abstract void comprarMedicamento();

}
