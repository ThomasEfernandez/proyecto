import java.awt.Color;
import java.util.HashSet;

import IngresoPack.Ingresante;
import MenuPack.Funcionalidad;
    

public class Main {
    public static void main(String[] args) {
        
        HashSet<Ingresante> lista = new HashSet<>();
        Funcionalidad sis = new Funcionalidad(lista);
         sis.setLayout(null);
         sis.setBounds(0,0,800,700);
         sis.setVisible(true);
         sis.setLocationRelativeTo(null);
         sis.setResizable(false);
         sis.menuPrincipal(); 
         sis.getContentPane().setBackground(new Color(174,206,244));
         
         
            
    }
}
