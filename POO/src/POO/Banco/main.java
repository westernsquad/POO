/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Banco;

import POO.Banco.PaqueteDeAcciones;
import POO.Bolsa.BolsaDeValores;
import POO.Bolsa.Empresa;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author guill
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        BolsaDeValores bolsa=new BolsaDeValores();
        Empresa empresa = new Empresa("gas", 50, 50, 50);
        Empresa empresa2 = new Empresa("gas2", 25, 25, 25);
        Empresa empresa3 = new Empresa("gas3", 12, 12, 2);
        ArrayList<PaqueteDeAcciones> acciones = null;
        Cliente cliente ;
        Banco banco = new Banco();
        cliente = new Cliente(1000,acciones,"luis","012548967X",false);
        Cliente cliente2 = new Cliente(1500,acciones,"maria","012548969X",false);
        banco.add(cliente);
        banco.add(cliente2);
        System.out.println(banco.tamaño());
        banco.remove(cliente);
        banco.comprobarPremium(cliente2);
        banco.copiaSeguridad("copia.ser");
        banco.deserializa("copia.ser");
        //banco.deserializar2("copia.ser");
        banco.mostrar();
        //bolsa.añadirEmpresa(empresa2);
        //bolsa.añadirEmpresa(empresa3);
       //bolsa.añadirEmpresa(empresa);
        //bolsa.gestordeValores();
       
  
        
        }
    
}