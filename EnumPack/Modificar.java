package EnumPack;

public enum Modificar {
    
    NOMBRE("NM"),
    APELLIDO("AP"),
    DIRECCION("DIR"),
    NACIMIENTO("NA"),
    AGREGAR("AG"),
    MODIFICAR("MO"),
    BORRAR("BO"),
    EDAD("ED");
    private String modificar;
//Constructor
    Modificar(String modificar) {
        this.modificar = modificar;
    }
   
//Getters y Setter
    public String getModificar() {
        return modificar;
    }
    public void setModificar(String modificar) {
        this.modificar = modificar;
    }



    
    
    
}
