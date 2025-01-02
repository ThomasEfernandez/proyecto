package EnumPack;

public enum Problematica {
    //DIFERENTES PROBLEMATICAS
    VIOLENCIA("V"),
    ROBO("RO"),
    ABUSO("AB");
    private String nombreProblematica;
    
    //Constructor
    Problematica (String nombreProblematica){
        this.nombreProblematica = nombreProblematica;

    }
   
    public String getnombreProblematica() {
        return nombreProblematica;
    }
    public void setnombreProblematica(String nombreProblematica) {
        this.nombreProblematica = nombreProblematica;
    }
    
    
}
