package MenuPack;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import EnumPack.Modificar;
import EnumPack.Problematica;
import ExcepcionesPack.CampoImcompletoException;
import ExcepcionesPack.IngresanteNoEncontradoException;
import ExcepcionesPack.ListaVaciaException;
import IngresoPack.Ingresante;
import IngresoPack.Ingreso;
public class EditarIngresante extends JFrame implements ActionListener,ItemListener{
//JTEXTFIELDS (espacio de texto)
private JTextField textUno = new JTextField ();
private JTextField textDos = new JTextField ();
private JTextField textTres = new JTextField ();
private JTextField textCuatro = new JTextField ();
private JTextField textCinco = new JTextField ();
private JTextField textSeis = new JTextField();
//JBUTTON (Botones)
private JButton botonUno = new JButton("Buscar");
private JButton botonDos = new JButton("Volver");
//JLABEL (ETIQUETAS)
private JLabel labelUno = new JLabel();
private JLabel labelDos = new JLabel();
private JLabel labelTres = new JLabel();
private JLabel labelCuatro = new JLabel();
private JLabel labelCinco = new JLabel();
private JLabel labelSeis = new JLabel();
private JLabel labelSiete = new JLabel();
JLabel labelAux= new JLabel("");

//var
private JComboBox<Modificar> comboUno = new JComboBox<>();
private JComboBox<Problematica> comboDos = new JComboBox<>();
private File archi = new File ("listado.json");
private HashSet<Ingresante> listaIngresantes;
private int edad=0;

//Constructor
public EditarIngresante (File archi, HashSet<Ingresante>lista){
    this.listaIngresantes = lista;
    this.archi = archi;

}
//GETTERS AND SETTERS
public JTextField getTextUno() {
    return textUno;
}
public void setTextUno(JTextField textUno) {
    this.textUno = textUno;
}
public JTextField getTextDos() {
    return textDos;
}
public void setTextDos(JTextField textDos) {
    this.textDos = textDos;
}
public JTextField getTextTres() {
    return textTres;
}
public void setTextTres(JTextField textTres) {
    this.textTres = textTres;
}
public JTextField getTextCuatro() {
    return textCuatro;
}
public void setTextCuatro(JTextField textCuatro) {
    this.textCuatro = textCuatro;
}
public JTextField getTextCinco() {
    return textCinco;
}
public void setTextCinco(JTextField textCinco) {
    this.textCinco = textCinco;
}
public JButton getBotonUno() {
    return botonUno;
}
public void setBotonUno(JButton botonUno) {
    this.botonUno = botonUno;
}
public JLabel getLabelUno() {
    return labelUno;
}
public void setLabelUno(JLabel labelUno) {
    this.labelUno = labelUno;
}
public JLabel getLabelDos() {
    return labelDos;
}
public void setLabelDos(JLabel labelDos) {
    this.labelDos = labelDos;
}
public JLabel getLabelTres() {
    return labelTres;
}
public void setLabelTres(JLabel labelTres) {
    this.labelTres = labelTres;
}
public JLabel getLabelCuatro() {
    return labelCuatro;
}
public void setLabelCuatro(JLabel labelCuatro) {
    this.labelCuatro = labelCuatro;
}
public JLabel getLabelCinco() {
    return labelCinco;
}
public void setLabelCinco(JLabel labelCinco) {
    this.labelCinco = labelCinco;
}
public JLabel getLabelSeis() {
    return labelSeis;
}
public void setLabelSeis(JLabel labelSeis) {
    this.labelSeis = labelSeis;
}
public JLabel getLabelSiete() {
    return labelSiete;
}
public void setLabelSiete(JLabel labelSiete) {
    this.labelSiete = labelSiete;
}
public File getArchi() {
    return archi;
}
public void setArchi(File archi) {
    this.archi = archi;
}
public HashSet<Ingresante> getListaIngresantes() {
    return listaIngresantes;
}
public void setListaIngresantes(HashSet<Ingresante> listaIngresantes) {
    this.listaIngresantes = listaIngresantes;
}
public JButton getBotonDos() {
    return botonDos;
}
public void setBotonDos(JButton botonDos) {
    this.botonDos = botonDos;
}



//METODOS
//Modificar ingresante
    public void menuEditarIngresante (){
       

        labelUno.setBounds(150, 100, 200, 30);
        labelUno.setFont(new Font("Palm Royale",Font.ITALIC,12));
        labelUno.setText("Dni");
        textUno.setFont(new Font("Palm Royale",Font.ITALIC,12));
        textUno.setBounds(190, 100, 100, 30);
        textUno.setBackground(new Color(80,150,210));
        textUno.setVisible(true);
        add(labelUno);
        add(textUno);
        
        botonUno.setText("Buscar");
        botonUno.setBackground(new Color(79,121,210));
        botonUno.setFocusPainted(false);
        botonUno.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonUno.setBounds(500, 550, 200, 40);
        add(botonUno);
        botonDos.setBounds(100, 550, 200, 40);
        botonDos.setFocusPainted(false);
        botonDos.setBackground(new Color(79,121,210));
        botonDos.setFont(new Font("Palm Royale",Font.BOLD,12));
        add(botonDos);

        //Volver
        botonDos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                Ingresantes menu_Ingresantes = new Ingresantes(listaIngresantes);
                menu_Ingresantes.setLayout(null);
                menu_Ingresantes.setBounds(0,0,800,700);
                menu_Ingresantes.setVisible(true);
                menu_Ingresantes.setLocationRelativeTo(null);
                menu_Ingresantes.setResizable(false);
                menu_Ingresantes.menuPrincipalIngreso();
                menu_Ingresantes.getContentPane().setBackground(new Color(174,206,244));
                setVisible(false);

            }
        });
        //Busca el dni
        botonUno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                try{
                    if (!textUno.getText().isEmpty() && esNum(textUno.getText())){
                        int dniModificar =Integer.parseInt(textUno.getText());
                        modificar(archi, dniModificar);
                      
                    }else{
                        throw new CampoImcompletoException("NO ES UN DNI VALIDO");
                    }
                }catch (CampoImcompletoException j){
                    labelAux.setText(""+j.getMessage());
                    labelAux.setBounds(getBounds());
                    
                    add(labelAux);
                }
            }
        });
        
    
    }
    public void modificar(File archi, int dni) {
      setLayout(null);

        try {
            if (archi.exists()) {
    
                listaIngresantes = traerJson(archi);
                Ingresante persona_buscada = buscarIngresante(archi, dni);
                listaIngresantes.remove(persona_buscada);

                if (persona_buscada != null) {
                    labelUno.setText("Elija la operacion ");
                    
                    if (labelAux.isVisible()){
                        labelAux.setVisible(false);
                    }
                    //------------------------------------------------------------
                    comboUno.setBounds(300, 100, 200, 30);
                    comboUno.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    add(comboUno);
                    comboUno.addItem(Modificar.NOMBRE);  
                    comboUno.addItem(Modificar.APELLIDO);    
                    comboUno.addItem(Modificar.NACIMIENTO);
                    comboUno.addItem(Modificar.EDAD);
                    comboUno.addItem(Modificar.DIRECCION);
                    comboUno.addItem(Modificar.AGREGAR);
                    comboUno.addItem(Modificar.MODIFICAR);
                    comboUno.addItem(Modificar.BORRAR);
                    comboUno.addItemListener(this);
                    comboUno.setBackground(new Color(80,150,210));
                    labelSiete.setVisible(true);
                    

                    labelSiete.setBounds(150, 200, 500, 30);
                    labelSiete.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    labelSiete.setText("Editar");
                    labelSiete.setVisible(false);
                    add(labelSiete);
                    textUno.setText("");
                    textUno.setBounds(400, 200, 100, 30);
                    textUno.setVisible(false);
        
                    botonUno.setText("Siguiente");
                    //------------------------------------------------------------
                    botonUno.addActionListener(new ActionListener() {
                        
                        @Override
                        public void actionPerformed (ActionEvent e){ 
   
                        
                    
                                switch (comboUno.getSelectedItem().toString()) {
                                    case "NOMBRE":
                                        // Nombre
                                  
                                        labelSiete.setText("Escriba el nuevo nombre de' "+persona_buscada.getNombre()+" '");
                                        textUno.setVisible(true);
                                        labelSiete.setVisible(true);
                                        botonUno.setText("Cambiar");
                                        if (labelAux.isVisible()){
                                            labelAux.setVisible(false);
                    
                                        }
                                        botonUno.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                try{
                                           
                                                    if (!textUno.getText().isEmpty()){
                                                        String nombre = textUno.getText();
                                                        persona_buscada.setNombre(nombre);
                                                        listaIngresantes.add(persona_buscada);
                                                        guardarListaIngresantes(archi, listaIngresantes);
                                                        JLabel label_operacion = new JLabel("Se ha modificado correctamente.");
                                                        label_operacion.setFont(new Font("Palm Royale",Font.ITALIC,12));
                                                        label_operacion.setBounds(500,500,300,80);
                                                        add(label_operacion);
                                                    }else{
                                                        throw new CampoImcompletoException("Complete los campos");
                                                   
                                                    }
    
                                                }catch (CampoImcompletoException j){
                                                    labelAux.setVisible(true);
                                                    labelAux.setText (""+j.getMessage());
                                                    labelAux.setBounds(getBounds());
                                                    add(labelAux);
                                                    
                                                }
                                            }
                                        });
                                       
                                       
            
                                        break;
            
                                    case "APELLIDO":
                                      labelSiete.setText("Escriba el nuevo apellido de' "+persona_buscada.getNombre()+" '");
                                        textUno.setVisible(true);
                                        labelSiete.setVisible(true);
                                        botonUno.setText("Cambiar");
                                        botonUno.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                try{
                                                    if (!textUno.getText().isEmpty()){
                                                        String apellido = textUno.getText();
                                                        persona_buscada.setApellido(apellido);

                                                        listaIngresantes.add(persona_buscada);
                                                        System.out.println("Se ha modificado correctamente.");
                                                        guardarListaIngresantes(archi, listaIngresantes);
                                                    
                                                    }else{
                                                        throw new CampoImcompletoException("Complete los campos");
                                                   
                                                    }
    
                                                }catch (CampoImcompletoException j){
                                                    
                                                    labelAux.setText (""+j.getMessage());
                                                    labelAux.setBounds(getBounds());
                                                    add(labelAux);
                                                    labelAux.setVisible(true);
                                                }
                                            }
                                        });
                                    break;
                                    case "DIRECCION":
                                        // direccion
                                        labelSiete.setText("Escriba la nueva direccion de' "+persona_buscada.getNombre()+" '");
                                        textUno.setVisible(true);
                                        labelSiete.setVisible(true);
                                        botonUno.setText("Cambiar");
                                        botonUno.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                try{
                                                    if (!textUno.getText().isEmpty()){
                                                        String direccion = textUno.getText();
                                                        persona_buscada.setDireccion(direccion);

                                                        listaIngresantes.add(persona_buscada);
                                                        System.out.println("Se ha modificado correctamente.");
                                                        guardarListaIngresantes(archi, listaIngresantes);
                                                    
                                                    }else{
                                                        throw new CampoImcompletoException("Complete los campos");
                                                   
                                                    }
    
                                                }catch (CampoImcompletoException j){
                                                    labelAux.setText (""+j.getMessage());
                                                    labelAux.setBounds(getBounds());
                                                    add(labelAux);
                                                    labelAux.setVisible(true);
                                                }
                                            }
                                        });
                                       
                                    
                                        break;
                                    case "NACIMIENTO":
                                        // fecha de nacimiento
                                        labelSiete.setText("Escriba el nacimiento de ' "+persona_buscada.getNombre()+" '");
                                        textUno.setVisible(true);
                                        labelSiete.setVisible(true);
                                        botonUno.setText("Cambiar");
                                        botonUno.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                try{
                                                    if (!textUno.getText().isEmpty()){
                                                        String fecha_nacimiento =  textUno.getText();
                                                        persona_buscada.setFecha_nacimiento(fecha_nacimiento);
                                                        
                                                        listaIngresantes.add(persona_buscada);
                                                    
                                                        labelDos.setText("Se ha modificado correctamente.");
                                                        labelDos.setVisible(true);
                                                        guardarListaIngresantes(archi, listaIngresantes);
                                                    
                                                    }else{
                                                        throw new CampoImcompletoException("Complete los campos");
                                                   
                                                    }
    
                                                }catch (CampoImcompletoException j){
                                                    labelAux.setVisible(true);
                                                    labelAux.setText (""+j.getMessage());
                                                    labelAux.setBounds(getBounds());
                                                    add(labelAux);
                                                    
                                                }
                                            }
                                        });
                                        break;
                                    case "EDAD":
                                        // edad
                                        labelSiete.setText("Escriba la edad de ' "+persona_buscada.getNombre()+" '");
                                        textUno.setVisible(true);
                                        labelSiete.setVisible(true);
                                        botonUno.setText("Cambiar");
                                        botonUno.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                try{
                                                    if (!textUno.getText().isEmpty() && esNum(textUno.getText())){
                                                        edad = Integer.parseInt(textUno.getText());
                                                        persona_buscada.setEdad(edad);

                                                        listaIngresantes.add(persona_buscada);
                                                        System.out.println("Se ha modificado correctamente.");
                                                        guardarListaIngresantes(archi, listaIngresantes);
                                                        
                                                    
                                                    }else{
                                                        throw new CampoImcompletoException("Complete los campos correctamente.");
                                                   
                                                    }
    
                                                }catch (CampoImcompletoException j){
                                                    labelAux.setText (""+j.getMessage());
                                                    labelAux.setBounds(getBounds());
                                                    add(labelAux);
                                                    labelAux.setVisible(true);
                                                }
                                            }
                                        });
                                       
                                      
                                       
            
                                        break;
                                    case "AGREGAR":
                                    menuGenerarIngreso();
                                             botonUno.addActionListener(new ActionListener() {
                                  
                                               @Override
                                                public void actionPerformed(ActionEvent e){
                                                    try{
                                                        if (!textCinco.getText().isEmpty() && esNum(textCinco.getText()) && 0 < Integer.parseInt(textCinco.getText())){
                                                           
                                                            String causa = textUno.getText();
                                                            String fecha_Ingreso = textDos.getText();
                                                            String fecha_Egreso = textTres.getText();
                                                            String descripcion = textCuatro.getText();
                                                            int edad = Integer.parseInt(textCinco.getText());
                                                            String direccion = textSeis.getText();
                                                            Problematica prob_Aux = (Problematica)comboDos.getSelectedItem();
                                                            Ingreso in_Aux = new  Ingreso(causa,fecha_Ingreso,fecha_Egreso,descripcion,edad,prob_Aux,direccion,persona_buscada.getBarrio());
                                                            listaIngresantes = traerJson(archi);
                                                            persona_buscada.getHistorial_de_Ingresos().add(in_Aux);
                                                            persona_buscada.setEdad(edad);
                                                            listaIngresantes.remove(persona_buscada);
                                                            listaIngresantes.add(persona_buscada);
                                                            
                                                            guardarListaIngresantes(archi, listaIngresantes);
                                                            System.out.println("Se actualizo la lista de ingresos correctamente. ");
                                                       
                                                        }else{

                                                            throw new CampoImcompletoException ("Escriba bien la edad");
                                                        }




                                                    }catch (CampoImcompletoException j){

                                                        labelAux.setText(""+j.getMessage());
                                                        labelAux.setBounds(getBounds());
                                                        labelAux.setVisible(true);
                                                       add(labelAux);

                                                    }
                                                
                                                }
                                            });
                                        break;

                                    
                                    case "MODIFICAR":
                                    menuGenerarIngreso();
                                    botonUno.addActionListener(new ActionListener() {
                                        @Override
                                    public void actionPerformed(ActionEvent e){
                                     if (Integer.parseInt(textCinco.getText())>0 &&!textCinco.getText().isEmpty() && esNum(textCinco.getText())){
                                       
                                       
                                        ArrayList<Ingreso>listaIngresos = persona_buscada.getHistorial_de_Ingresos();
                                        Ingreso ingreso_aux =(Ingreso) listaIngresos.get(0);
                                        listaIngresos.remove(ingreso_aux);
                                        listaIngresantes.remove(persona_buscada);
                                        ingreso_aux.setCausa_Ingreso(textUno.getText());
                                        ingreso_aux.setFecha_Ingreso(textDos.getText());
                                        ingreso_aux.setFecha_egreso(textTres.getText());
                                        ingreso_aux.setDescripcion(textCuatro.getText());
                                        ingreso_aux.setProblematica((Problematica)comboDos.getSelectedItem());
                                        ingreso_aux.setDireccion_del_hecho(textCinco.getText());
                                        ingreso_aux.setBarrio(persona_buscada.getBarrio());
                                        ingreso_aux.setEdad(persona_buscada.getEdad());
                                        listaIngresos.add(ingreso_aux);
                                        listaIngresantes.add(persona_buscada);
                                        guardarListaIngresantes(archi, listaIngresantes);
                                     } 
                                    }
                                    });
                                    break;
                                    case "BORRAR":
                                    break;
                         
                                        default:
                                        System.out.println("Esta opción es invalida.");
                                        break;
                                    }
                         

                            
            
                            }

                        
                    });

             
            } else {
                throw new ListaVaciaException("No se ha encontrado a la persona");
            }
        }

        } catch (ListaVaciaException e) {
            labelAux.setVisible(true);
            labelAux.setText (""+e.getMessage());
            labelAux.setBounds(getBounds());
            add(labelAux);
            
            

        }
        

    }

    public void menuGenerarIngreso (){
        
        setBounds(0,0,800,800);
        botonUno.setBounds(500, 600, 200, 40);
        botonDos.setBounds(100, 600, 200, 40);
        setLocationRelativeTo(null);
        comboUno.setVisible(false);
        //-------------------------------------------------------------------
        labelUno.setText("Causa ");
        labelUno.setBounds(200, 100, 200, 30);
        add(labelUno);
        textUno.setVisible(true);
        textUno.setText("");
        textUno.setBounds(350, 100, 200, 30);
         //-------------------------------------------------------------------
        labelDos.setText("Fecha Ingreso ");
        labelDos.setBounds(200, 150, 200, 30);
        labelDos.setFont(new Font("Palm Royale",Font.ITALIC,12));
        add(labelDos);
        textDos.setVisible(true);
        textDos.setText("");
        textDos.setBounds(350, 150, 200, 30);
        textDos.setBackground(new Color(80,150,210));
        add(textDos);
         //-------------------------------------------------------------------
        labelTres.setText("Fecha Egreso ");
        labelTres.setBounds(200, 200, 200, 30);
        labelTres.setFont(new Font("Palm Royale",Font.ITALIC,12));
        add(labelTres);
        textTres.setVisible(true);
        textTres.setText("");
        textTres.setBounds(350, 200, 200, 30);
        textTres.setBackground(new Color(80,150,210));
        add(textTres);
         //-------------------------------------------------------------------
        labelCuatro.setText("Descripcion ");
        labelCuatro.setFont(new Font("Palm Royale",Font.ITALIC,12));
        labelCuatro.setBounds(200, 250, 200, 30);
        add(labelCuatro);
        textCuatro.setVisible(true);
        textCuatro.setText("");
        textCuatro.setBounds(350, 250, 200, 30);
        textCuatro.setBackground(new Color(80,150,210));
        add(textCuatro);
         //-------------------------------------------------------------------
        labelCinco.setText("Edad ");
        labelCinco.setFont(new Font("Palm Royale",Font.ITALIC,12));
        labelCinco.setBounds(200, 300, 200, 30);
        add(labelCinco);
        textCinco.setVisible(true);
        textCinco.setText("");
        textCinco.setBounds(350, 300, 200, 30);
        textCinco.setBackground(new Color(80,150,210));
        add(textCinco);
         //-------------------------------------------------------------------
        labelSeis.setText("Direccion ");
        labelSeis.setFont(new Font("Palm Royale",Font.ITALIC,12));
        labelSeis.setBounds(200, 350, 200, 30);
        add(labelSeis);
        textSeis.setVisible(true);
        textSeis.setText("");
        textSeis.setBounds(350, 350, 200, 30);
        textSeis.setBackground(new Color(80,150,210));
        add(textSeis);
         //-------------------------------------------------------------------
        labelSiete.setText("Problematica ");
        labelSiete.setFont(new Font("Palm Royale",Font.ITALIC,12));
        labelSiete.setBounds(200, 400, 200, 30);
        labelSiete.setVisible(true);
        add(labelSiete);
        comboDos.setBounds(350, 400, 200, 30);
        comboDos.addItem (Problematica.VIOLENCIA);
        comboDos.addItem (Problematica.ROBO);
        comboDos.addItem (Problematica.ABUSO);
        comboDos.setFont(new Font("Palm Royale",Font.ITALIC,12));
        comboDos.setBackground(new Color(80,150,210));
        add(comboDos); 
    }
   
//Busca en el archivo la lista de ingresantes
    public HashSet<Ingresante> traerJson(File archi) {
       
        try {
            
            ObjectMapper mapper = new ObjectMapper();
            HashSet<Ingresante> listaIngresantes = mapper.readValue(archi, new TypeReference<HashSet<Ingresante>>() {
            });

            return listaIngresantes;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
//Guarda la lista de ingresantes en el archivo
    public void guardarListaIngresantes(File archi, HashSet<Ingresante> lista_Ingresantes) {

        try {
            if (!archi.exists()){
                archi.createNewFile();
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(archi, lista_Ingresantes);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
// BUSCAR INGRESANTES
    public Ingresante buscarIngresante(File archi, int dni) {

    Ingresante aux = null;
    try {

        HashSet<Ingresante> lista = traerJson(archi);

        if (!lista.isEmpty()) {
            for (Ingresante ingresante : lista) {
                if (ingresante.getDni() == dni) {
                    aux = ingresante;
                    return aux;
                }
            }
        } else {
            throw new IngresanteNoEncontradoException("No se ha encontrado esa persona");

        }
    } catch (IngresanteNoEncontradoException e) {
        System.out.println("" + e.getMessage());

    }

    return aux;
}
    public void añadirIngresante (Ingresante aux){

    listaIngresantes.add(aux);

}

//lee un string para saber si todas corresponden a un numero
    public boolean esNum (String x){
        for (char letra : x.toCharArray()) {
            if (!Character.isDigit(letra)) {
                return false;
            }
        }
        return true;
    }
    @Override 
    public void actionPerformed (ActionEvent e){
        
    }
    public void itemStateChanged(ItemEvent e){

       }


}
