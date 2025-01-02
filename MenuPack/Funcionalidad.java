package MenuPack;
import java.util.HashSet;
import IngresoPack.Ingresante;

public class Funcionalidad extends Sistema {
private static final long serialVersioUID = 111L;
    
public Funcionalidad(HashSet<Ingresante>lista) {
    super(lista);
    }

public static long getSerialversiouid() {
    return serialVersioUID;
}

    
}
