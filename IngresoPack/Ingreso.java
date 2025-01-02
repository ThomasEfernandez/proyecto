package IngresoPack;

import EnumPack.Problematica;

public class Ingreso {
    //Atributos
   private String causa_Ingreso;
   private String fecha_Ingreso;
   private String fecha_egreso;
   private String descripcion;
   private int edad;
   private Problematica problematica;
   private String direccion_del_hecho;
   private String barrio;


//CONSTRUCTORES
public Ingreso() {
}
public Ingreso(String causa_Ingreso, String fecha_Ingreso, String fecha_egreso, String descripcion, int edad,
        Problematica problematica, String direccion_del_hecho,String barrio) {
    this.causa_Ingreso = causa_Ingreso;
    this.fecha_Ingreso = fecha_Ingreso;
    this.fecha_egreso = fecha_egreso;
    this.descripcion = descripcion;
    this.edad = edad;
    this.problematica = problematica;
    this.direccion_del_hecho = direccion_del_hecho;
    this.barrio = barrio;
}

//getters and setters
public String getCausa_Ingreso() {
    return causa_Ingreso;
}
public void setCausa_Ingreso(String causa_Ingreso) {
    this.causa_Ingreso = causa_Ingreso;
}
public String getFecha_Ingreso() {
    return fecha_Ingreso;
}
public void setFecha_Ingreso(String fecha_Ingreso) {
    this.fecha_Ingreso = fecha_Ingreso;
}
public String getFecha_egreso() {
    return fecha_egreso;
}
public void setFecha_egreso(String fecha_egreso) {
    this.fecha_egreso = fecha_egreso;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
public int getEdad() {
    return edad;
}
public void setEdad(int edad) {
    this.edad = edad;
}
public Problematica getProblematica() {
    return problematica;
}
public void setProblematica(Problematica problematica) {
    this.problematica = problematica;
}
public String getDireccion_del_hecho() {
    return direccion_del_hecho;
}
public void setDireccion_del_hecho(String direccion_del_hecho) {
    this.direccion_del_hecho = direccion_del_hecho;
}
public String getBarrio() {
    return barrio;
}
public void setBarrio(String barrio) {
    this.barrio = barrio;
}


@Override
public String toString() {
    return "Ingreso [causa_Ingreso=" + causa_Ingreso + ", fecha_Ingreso=" + fecha_Ingreso + ", fecha_egreso="
            + fecha_egreso + ", descripcion=" + descripcion + ", edad=" + edad + ", problematica=" + problematica
            + ", direccion_del_hecho=" + direccion_del_hecho + ", barrio=" + barrio + "]";
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fecha_Ingreso == null) ? 0 : fecha_Ingreso.hashCode());
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Ingreso other = (Ingreso) obj;
    if (fecha_Ingreso == null) {
        if (other.fecha_Ingreso != null)
            return false;
    } else if (!fecha_Ingreso.equals(other.fecha_Ingreso))
        return false;
    return true;
}
   


   


    
}
