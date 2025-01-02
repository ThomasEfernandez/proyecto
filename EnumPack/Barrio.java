package EnumPack;

public enum Barrio {
//Acá van todos los barrios posibles
    TRESDEFEBRERO("3 de Febrero");
//Pasar nombre del barrio
    private String nombre;

//Constructor
    Barrio (String nombre){
        this.nombre = nombre;
    
    }

//Getters y Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
