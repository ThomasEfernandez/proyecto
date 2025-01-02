package IngresoPack;
import java.io.Serializable;
import java.util.ArrayList;

import PersonaPack.Persona;

public class Ingresante extends Persona implements Serializable{
    //Esta lista detalla todas las veces que ingresó y el porque
    private ArrayList<Ingreso> historial_de_Ingresos=new ArrayList<>();
    private String barrio;
    
    //Constructores
    public Ingresante() {
    }
    public Ingresante(String nombre, String apellido, int dni, String direccion, int edad, String fecha_nacimiento, Ingreso elIngreso, String barrio){
        super(nombre, apellido, dni,direccion, edad, fecha_nacimiento);
        agregarIngreso(elIngreso);
        this.barrio = barrio;
       
    }
    //getters and setters
    public ArrayList<Ingreso> getHistorial_de_Ingresos() {
        return historial_de_Ingresos;
    }
    public void setHistorial_de_Ingresos(ArrayList<Ingreso> historial_de_Ingresos) {
        this.historial_de_Ingresos = historial_de_Ingresos;
    }
    public String getBarrio() {
        return barrio;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    //METODOS
    public void agregarIngreso (Ingreso aux){

        historial_de_Ingresos.add(aux);

    }
    @Override
    public String toString() {
        return "["+"Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Barrio: " + getBarrio() + ", DNI: "+ getDni() + ", Direccion: " + 
        getDireccion() + ", Edad:" + getEdad() +"]";
    
   
    }

    

    


    

  


     
    
    





    


    
}
