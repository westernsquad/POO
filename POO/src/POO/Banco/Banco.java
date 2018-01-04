/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Banco;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class Banco implements Serializable {
    private ArrayList<Cliente> bancoCli;
    private ArrayList<String> bancoCli2 = new ArrayList<>();
    

    public Banco() {
        this.bancoCli = new ArrayList<Cliente>();
    }
    
public Cliente consultar (String numero){
  
for (Iterator it = bancoCli.iterator();it.hasNext();){
   Cliente cl = (Cliente) it.next();
   
   if (cl.getDNI().equals(numero)) {
       return cl; }
  }
  return null; 
 }
public Cliente comprobar (String nombre){
  boolean encontrado = false;
  Cliente cp = null;
for (Iterator it = bancoCli.iterator();it.hasNext();){
   Cliente cl = (Cliente) it.next();
   if (cl.getNombre().equals(nombre)) {
       encontrado =true;
       cp=cl;
       
   } 
}
    if (encontrado = true){
        return cp;
    }else{
            return null;
    }
}

 
 public Banco add (Cliente cliente){
     
          if(consultar(cliente.getDNI())!= null){
              System.out.println("Este cliente ya esta en el banco");
          } else {
               bancoCli.add(cliente);
               System.out.println("Este cliente esta en el banco");
                return this;
          }
     
  return this;
 }
 
 public Banco remove (Cliente cliente){
     if(consultar(cliente.getDNI())!=null){
        bancoCli.remove(cliente);
        System.out.println("Este cliente ha sido eliminado del banco");
        return this;
     }else{
         return this;
     }
     
 }
 
  public void mejorar (String nombre){
      for (Iterator it = bancoCli.iterator();it.hasNext();){
          Cliente cl = (Cliente) it.next();
          if (nombre.equals(cl.getNombre())) {
              cl.setPremium(true);
              System.out.println("Este cliente ahora es premium");
          }else {
              System.out.println("Este cliente no es premium");
          }
         
      }
  }
      
      
  public void comprobarPremium (Cliente clie){
 
        if (clie.isPremium()){
            System.out.println("Ya es un cliente premium");
        }else {
            clie.setPremium(true);
            System.out.println("ahora " + clie.getNombre() + " es cliente premium");
        }
       
  }
  
  
  public void copiaSeguridad (String fichero){
      ObjectOutputStream obj_out = null;
      
        try {
            FileOutputStream f_out = new FileOutputStream(fichero);
            obj_out = new ObjectOutputStream (f_out);
            obj_out.writeObject (bancoCli.toString());
        } catch (IOException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                obj_out.close();
            } catch (IOException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 }
  public void deserializa(String fichero){ //leer binario
        try{
                InputStream file = new FileInputStream(fichero);
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer);
            ArrayList<Cliente> bancoCl = (ArrayList<Cliente>) input.readObject();
            this.bancoCli=bancoCl;
        } catch (ClassNotFoundException ex){
            System.out.println("Error deserializando (class not found)");
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error deserializando (IO)");
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        } catch (Exception ex){
            System.out.println("Error deserializando (otros)");
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        }
    }
  public int tamaño(){
     int num = 0;
     num= bancoCli.size();
     return num;
    }  
 public void mostrar(){
     for (Iterator it = bancoCli.iterator();it.hasNext();){
          Cliente cl = (Cliente) it.next();
          System.out.println(cl.toString());
          }
 }

    @Override
    public String toString() {
        return "Banco{" + "bancoCli=" + bancoCli +'}';
    }
 
    
public void deserializar2 (String fichero) {
    try{
    FileInputStream s = new FileInputStream(fichero);
    ObjectInputStream o = new ObjectInputStream(s);
    bancoCli = (ArrayList<Cliente>) o.readObject();
    o.close();
   }catch(IOException e){
    System.out.println(e);
}       
    catch (ClassNotFoundException ex) {   
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }   
}
}