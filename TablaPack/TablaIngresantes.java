package TablaPack;

import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import IngresoPack.Ingresante;

public class TablaIngresantes {
    private HashSet<Ingresante> listaIngresantes;

    public TablaIngresantes() {
    }
    public TablaIngresantes(HashSet<Ingresante> listaIngresantes) {
        this.listaIngresantes = listaIngresantes;
    }

    public HashSet<Ingresante> getListaIngresantes() {
        return listaIngresantes;
    }

    public void setListaIngresantes(HashSet<Ingresante> listaIngresantes) {
        this.listaIngresantes = listaIngresantes;
    }


    public void interfazTabla (){
    String [] cabecera = {"Nombre","Apellido","Edad","Dni","Barrio","Direccion","Fecha de nacimiento"};
    
    String[][] matriz = new String [listaIngresantes.size()][cabecera.length] ;

    
        pasarDatoAMatriz(matriz, listaIngresantes);
       
 
    

    DefaultTableModel mod = new DefaultTableModel(matriz,cabecera);
    JTable tabla = new JTable(mod);
    JScrollPane scroll = new JScrollPane(tabla);
    scroll.setBounds(40,40,400,200);
    JFrame ventana = new JFrame();
    ventana.setBounds(0,0,800,700);
    ventana.setLocationRelativeTo(null);
    ventana.add(scroll);
    ventana.setVisible(true);
}


public void pasarDatoAMatriz(String[][] matriz,HashSet<Ingresante>lista_Ingresantes){

int i=0;
                for (Ingresante ingresante : lista_Ingresantes){

                            matriz[i][0]= ingresante.getNombre();
                            matriz[i][1]= ingresante.getApellido();
                            matriz[i][2]= Integer.toString(ingresante.getEdad());
                            matriz[i][3]= Integer.toString(ingresante.getDni());
                            matriz[i][4]= ingresante.getBarrio();
                            matriz[i][5]= ingresante.getDireccion();
                            matriz[i][6]= ingresante.getFecha_nacimiento();

                        i++;
                    }


 
}


}


    
    
