package TablaPack;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import IngresoPack.Ingreso;

public  class TablaIngresos extends JFrame {
    private ArrayList<Ingreso> historial_de_Ingresos=new ArrayList<>();

    public TablaIngresos() {
    }
    public TablaIngresos(ArrayList<Ingreso> historial_de_Ingresos) {
        this.historial_de_Ingresos = historial_de_Ingresos;
    }



    public ArrayList<Ingreso> getHistorial_de_Ingresos() {
        return historial_de_Ingresos;
    }

    public void setHistorial_de_Ingresos(ArrayList<Ingreso> historial_de_Ingresos) {
        this.historial_de_Ingresos = historial_de_Ingresos;
    }


public void interfazTabla (){
    String [] cabecera = {"causa","fecha ingreso", "fecha egreso","descrpcion","edad","problematica","direccion del hecho","barrio"};
    

    String[][] matriz = new String [historial_de_Ingresos.size()][cabecera.length] ;
        pasarDatoAMatriz(matriz, historial_de_Ingresos);
       
        
  


    DefaultTableModel mod = new DefaultTableModel(matriz,cabecera);
    JTable tabla = new JTable(mod);
    JScrollPane scroll = new JScrollPane(tabla);
    scroll.setBounds(40,40,400,200);
    JFrame ventana = new JFrame();
    ventana.setBounds(0,0,1200,800);
    ventana.setLocationRelativeTo(null);
    ventana.add(scroll);
    ventana.setVisible(true);
}



public void pasarDatoAMatriz(String[][] matriz,ArrayList<Ingreso>lista_Ingresos){

    int fila=0;
                    for (Ingreso ingresante : lista_Ingresos){
    
                        matriz[fila][0] = ingresante.getCausa_Ingreso();
                        matriz[fila][1] = ingresante.getFecha_Ingreso();
                        matriz[fila][2] = ingresante.getFecha_egreso();
                        matriz[fila][3] = ingresante.getDescripcion();
                        matriz[fila][4] = Integer.toString(ingresante.getEdad());
                        matriz[fila][6] = ingresante.getProblematica().toString();
                        matriz[fila][6] = ingresante.getDireccion_del_hecho();
                        matriz[fila][7] = ingresante.getBarrio();
    
                           fila++;
                        }
    
    
     
}
    
    
    }
    