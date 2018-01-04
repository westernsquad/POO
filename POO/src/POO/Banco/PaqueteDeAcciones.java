/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Banco;


import POO.Bolsa.BolsaDeValores;
import POO.Bolsa.Empresa;


/**
 *
 * @author guill
 */
public class PaqueteDeAcciones {
    private String nombreEmpresa;
    private int numerosTitulos;
    private double precioTotal;
    
    public PaqueteDeAcciones(String nombreEmpresa, int numerosTitulos, double precioTotal) {
        this.nombreEmpresa = nombreEmpresa;
        this.numerosTitulos = numerosTitulos;
        this.precioTotal = precioTotal;
    }
    

    

    public int getNumerosTitulos() {
        return numerosTitulos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    

    public void setNumerosTitulos(int numerosTitulos) {
        this.numerosTitulos = numerosTitulos;
    }

    public void setPrecioTotal(String nombreEmpresa) {
       BolsaDeValores bolsa = new BolsaDeValores();
       Empresa em;
       em=bolsa.devuelveEmpresa(nombreEmpresa);
       this.precioTotal= this.getNumerosTitulos() * em.getValorAccion();   
       }
       
    
 
    
    
}
