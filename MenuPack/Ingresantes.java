package MenuPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import EnumPack.Problematica;
import ExcepcionesPack.CampoImcompletoException;
import TablaPack.TablaIngresantes;
//import TablaPack.TablaIngresos;
import IngresoPack.Ingresante;
import IngresoPack.Ingreso;

public class Ingresantes extends JFrame  implements ActionListener,ChangeListener,ItemListener {
JButton botonOcho = new JButton("Siguiente");
    //ETIQUETAS
    JLabel labelCero = new JLabel("NUEVO INGRESANTE");
    JLabel labelUno = new JLabel("Nombre  ");
    JLabel labelDos = new JLabel("Apellido  ");
    JLabel labelTres = new JLabel("Direccion  ");
    JLabel labelCuatro = new JLabel("Nacimiento  ");
    JLabel labelCinco = new JLabel("Barrio  ");
    JLabel labelSeis = new JLabel("Dni  ");
    JLabel labelSiete = new JLabel("Edad ");
    //JTEXTFIELD
    JTextField textUno = new JTextField();
    JTextField textDos = new JTextField();
    JTextField textTres = new JTextField();
    JTextField textCuatro = new JTextField();
    JTextField textCinco = new JTextField();
    JTextField textSeis = new JTextField();
    JTextField textSiete = new JTextField();
    //JTEXT FIELDS PARA EL INGRESO
    JTextField ingreso_Uno = new JTextField();
    JTextField ingreso_Dos = new JTextField();
    JTextField ingreso_Tres = new JTextField();
    JTextField ingreso_Cuatro = new JTextField();
    JTextField ingreso_Cinco = new JTextField();
    JTextField ingreso_Seis = new JTextField();
    JTextField ingreso_Siete= new JTextField();
    JTextField ingreso_Ocho = new JTextField();
    // private JLabel mensajeLabel;
    private String dni_String="";
    private String edad_String="";  
    private int edad=0;
    private int dni=0;
    private String nombre="";
    private String apellido="";
    private String direccion="";
    private String nacimiento="";
    private String barrio="";
    private Ingreso in = null;
    private JComboBox<Problematica> comboUno = new JComboBox<>();
    private Problematica a= Problematica.VIOLENCIA;
    private Ingresante aux = new Ingresante();
    private File archi = new File("listado.json");
    private HashSet<Ingresante> listaIngresantes = new HashSet<>();


   
//Constructor
    public Ingresantes(HashSet<Ingresante> listaIngresantes) {
        this.listaIngresantes = listaIngresantes;
    }
//Metodos
//Menu principal para el ingreso de una persona
     public void menuPrincipalIngreso(){
        setLayout(null);
        
        JButton botonUno = new JButton("Agregar Ingresante");
        botonUno.setBackground(new Color(79,121,210));
        botonUno.setFocusPainted(false);
        botonUno.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonUno.setBounds(100, 100, 200, 40);
        add(botonUno);
        JButton botonDos = new JButton("Editar Ingresantes");
        botonDos.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonDos.setFocusPainted(false);
        botonDos.setBackground(new Color(79,121,210));
        botonDos.setBounds(100, 200, 200, 40);
        add(botonDos);
        JButton botonTres = new JButton("Mostrar Ingresantes");
        botonTres.setBackground(new Color(79,121,210));
        botonTres.setFocusPainted(false);
        botonTres.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonTres.setBounds(100, 300, 200, 40);
        add(botonTres);
        JButton boton_cuatro = new JButton("Mostrar Ingresos");
        boton_cuatro.setBackground(new Color(79,121,210));
        boton_cuatro.setFocusPainted(false);
        boton_cuatro.setFont(new Font("Palm Royale",Font.BOLD,12));
        boton_cuatro.setBounds(100, 400, 200, 40);
        add(boton_cuatro);
    
        JButton botonCinco = new JButton("Volver");
        botonCinco.setBackground(new Color(79,121,210));
        botonCinco.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonCinco.setFocusPainted(false);
        botonCinco.setBounds(100, 500, 200, 40);
        add(botonCinco);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (e.getActionCommand()) {
                    case "Agregar Ingresante":
                        // agregar X Teclado
                        agregarIngresanteXTeclado(archi);
                        break;
                      
                    case "Editar Ingresantes":

                        EditarIngresante editar = new EditarIngresante(archi,listaIngresantes);
                        
                        editar.getContentPane().setFont(new Font("Palm Royale",Font.ITALIC,12));
                        editar.setLayout(null);
                        editar.setBounds(0,0,800,700);
                        editar.setVisible(true);
                        editar.setLocationRelativeTo(null);
                        editar.setResizable(false);
                        editar.menuEditarIngresante();
                        editar.getContentPane().setBackground(new Color(174,206,244));
                        setVisible(false);
            



                        break;
                    case "Mostrar Ingresantes":
                        //Tengo que generar una tabla ingresantes
                        listaIngresantes = traerJson(archi);
                       TablaIngresantes tablaIngresantes = new TablaIngresantes(listaIngresantes);
                       
                       tablaIngresantes.interfazTabla();
                        break;

                        case"Mostrar Ingresos":
                      
                        //Tengo que realizar un menu en el que el usuario elija los ingresos de quien quiere visualizar
                        break;



                    case "Volver":
                    setVisible(false);
                    Funcionalidad sis = new Funcionalidad(listaIngresantes);
                    sis.getContentPane().setFont(new Font("Palm Royale",Font.BOLD,12));
                    sis.setLayout(null);
                    sis.setBounds(0,0,800,700);
                    sis.setVisible(true);
                    sis.setLocationRelativeTo(null);
                    sis.setResizable(false);
                    sis.menuPrincipal(); 
                    sis.getContentPane().setBackground(new Color(174,206,244));
                  
                        break;

                    default:
                        break;
                }

            }

        };
                    botonUno.addActionListener(listener);
                    botonDos.addActionListener(listener);
                    botonTres.addActionListener(listener);
                    botonCinco.addActionListener(listener);

}
   
//INGRESO Y INTERFAZ PARA INGRESAR
    public void menuIngreso (){
        //CAUSA, FECHA INGRESO, FECHA EGRESO, DESCRIPCION Y PROBLEMATICA
     
            botonOcho.setText("Ingresar");
            labelCero.setText("GENERAR INGRESO");
            labelUno.setText("Escriba la causa del ingreso ");
            labelDos.setText("Fecha de ingreso ");
            labelTres.setText("Fecha de egreso ");
            labelCuatro.setText("Descripcion ");
            labelCinco.setText("Escriba la direccion del hecho ");
            labelSeis.setText("Problematica ");
            labelCuatro.setVisible(true);
            labelCinco.setVisible(true);
            labelSeis.setVisible(true);
            labelSiete.setVisible(false);
            //JtextField 
            textUno.setVisible(false);
            textDos.setVisible(false);
            textTres.setVisible(false);
            textCuatro.setVisible(false);
            textCinco.setVisible(false);
            textSeis.setVisible(false);
            textSiete.setVisible(false);
        //----------------------------------------------------------------------
            ingreso_Uno.setBounds(600, 100, 100, 30);
            ingreso_Uno.setBackground(new Color(80,150,210));
            ingreso_Uno.setFont(new Font("Palm Royale",Font.ITALIC,12));
            add(ingreso_Uno);
        //----------------------------------------------------------------------
            ingreso_Dos.setBounds(600, 150, 100, 30);
            ingreso_Dos.setBackground(new Color(80,150,210));
            ingreso_Dos.setFont(new Font("Palm Royale",Font.ITALIC,12));
            add(ingreso_Dos);
         //----------------------------------------------------------------------
            ingreso_Tres.setBounds(600, 200, 100, 30);
            ingreso_Tres.setBackground(new Color(80,150,210));
            ingreso_Tres.setFont(new Font("Palm Royale",Font.ITALIC,12));
            add(ingreso_Tres);
        //---------------------------------------------------------------------- 
            ingreso_Cuatro.setBounds(600, 250, 100, 30);
            ingreso_Cuatro.setBackground(new Color(80,150,210));
            ingreso_Cuatro.setFont(new Font("Palm Royale",Font.ITALIC,12));
            add(ingreso_Cuatro);
         //----------------------------------------------------------------------
            ingreso_Cinco.setBounds(600, 300, 100, 30);
            ingreso_Cinco.setBackground(new Color(80,150,210));
            ingreso_Cinco.setFont(new Font("Palm Royale",Font.ITALIC,12));
            add(ingreso_Cinco);
          

            comboUno.setBounds(600,350,100, 30);
            comboUno.setBackground(new Color(80,150,210));
            comboUno.setFont(new Font("Palm Royale",Font.ITALIC,12));
            add(comboUno);
            comboUno.addItem(Problematica.VIOLENCIA);    
            comboUno.addItem(Problematica.ROBO);    
            comboUno.addItem(Problematica.ABUSO);
            comboUno.addItemListener(this);
           }
    public void itemStateChanged(ItemEvent e){
            if (e.getSource()==comboUno){
               a = (Problematica)comboUno.getSelectedItem();

            }
           }
    public void generarIngreso (int edad,String barrio){ 
        menuIngreso();
        botonOcho.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                if (!ingreso_Uno.getText().isEmpty() &&!ingreso_Dos.getText().isEmpty()  && !ingreso_Tres.getText().isEmpty() && !ingreso_Cuatro.getText().isEmpty()){
                    String causa_Ingreso = ingreso_Uno.getText();
                    String fechaIngreso = ingreso_Dos.getText();
                    String fecha_Egreso = ingreso_Tres.getText();
                    String descripcion = ingreso_Cuatro.getText();
                    String direccion_del_hecho = ingreso_Cinco.getText();
                    a = (Problematica)comboUno.getSelectedItem();

                    in = new Ingreso(causa_Ingreso, fechaIngreso, fecha_Egreso, descripcion, edad, a, direccion_del_hecho, barrio);
                    listaIngresantes = traerJson(archi);
                    aux = new Ingresante(nombre, apellido, dni, direccion, edad, nacimiento,in, barrio);
                    listaIngresantes = traerJson(archi);            
                    agregarIngresante(aux);
                    guardarListaIngresantes(archi, listaIngresantes);
                    System.out.println("Se ha agregado "+nombre+" a la lista");
                    
                    
                    
                    
                }else{

                    throw new CampoImcompletoException("Complete todos los campos.");
                }



            }catch(CampoImcompletoException j){
                JLabel jl_seis_excepcion= new JLabel (""+j.getMessage());
                add(jl_seis_excepcion);
                jl_seis_excepcion.setBounds(350, 350, 300, 30);


            }
            

        }});

    }
    
// traer lista
    public HashSet<Ingresante> traerJson(File archi) {
       
        try {
            if (!archi.exists()){
                archi.createNewFile();
                guardarListaIngresantes(archi, listaIngresantes);

            }
            
            ObjectMapper mapper = new ObjectMapper();
            HashSet<Ingresante> listaIngresantes = mapper.readValue(archi, new TypeReference<HashSet<Ingresante>>() {
            });

            return listaIngresantes;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        
    }
// AÑADIR .JSON AL NOMBRE DEL ARCHIVO AL ENVIARLO POR PARAMETRO
    public void guardarListaIngresantes(File archi, HashSet<Ingresante> lista_Ingresantes) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(archi, lista_Ingresantes);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }


// agregar
    public void agregarIngresante(Ingresante x) {

        listaIngresantes.add(x);

    }
    public void agregarIngresanteXTeclado(File archi) {
       
       
    //Verifico que los campos contengan los datos para habilidar el boton
        textUno.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate (DocumentEvent e){
                    actualizarBoton();
            }
            public void insertUpdate (DocumentEvent e){
                    actualizarBoton();
            }
            public void removeUpdate (DocumentEvent e){
                    actualizarBoton();
            }
        });      
        textDos.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void insertUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void removeUpdate (DocumentEvent e){
                actualizarBoton();
        }
        });
        textTres.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void insertUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void removeUpdate (DocumentEvent e){
                actualizarBoton();
        }
        });
        textCuatro.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void insertUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void removeUpdate (DocumentEvent e){
                actualizarBoton();
        }
        });
        textCinco.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void insertUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void removeUpdate (DocumentEvent e){
                actualizarBoton();
        }
        });
        textSeis.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void insertUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void removeUpdate (DocumentEvent e){
                actualizarBoton();
        }
        });
        textSiete.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void insertUpdate (DocumentEvent e){
                actualizarBoton();
        }
        public void removeUpdate (DocumentEvent e){
                actualizarBoton();
        }
        });
                    
        
        
                    botonOcho.setBounds(600, 560, 100, 30);
                    botonOcho.setBackground(new Color(79,121,210));
                    botonOcho.setFont(new Font("Palm Royale",Font.BOLD,12));
                    add(botonOcho);
         
                    botonOcho.setEnabled(false);
                    // -----------------------------------------------
                    add(labelUno);
                    labelUno.setBounds(350, 100, 200, 30);
                    
                    labelUno.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    add(textUno);
                    textUno.setBounds(600, 100, 100, 30);
                    textUno.setBackground(new Color(80,150,210));
                    textUno.setFont(new Font("Palm Royale",Font.ITALIC,12));
                 

                // -----------------------------------------------
                    add(labelDos);
                    labelDos.setBounds(350, 150, 200, 30);
                    labelDos.setFont(new Font("Palm Royale",Font.ITALIC,12));

                    add(textDos);
                    textDos.setBounds(600, 150, 100, 30);
                    textDos.setBackground(new Color(80,150,210));
                    textDos.setFont(new Font("Palm Royale",Font.ITALIC,12));

                    // -----------------------------------------------
                    add(labelTres);
                    labelTres.setBounds(350, 200, 300, 30);
                    labelTres.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    add(textTres);
                    textTres.setBounds(600, 200, 100, 30);
                    textTres.setBackground(new Color(80,150,210));
                    textTres.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    // -----------------------------------------------
                    add(labelCuatro);
                    labelCuatro.setBounds(350, 250, 300, 30);
                    labelCuatro.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    add(textCuatro);
                    textCuatro.setBounds(600, 250, 100, 30);
                    textCuatro.setBackground(new Color(80,150,210));
                    textCuatro.setFont(new Font("Palm Royale",Font.ITALIC,12));
              
                    // -----------------------------------------------
                    add(labelCinco);
                    labelCinco.setBounds(350, 300, 300, 30);
                    labelCinco.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    add(textCinco);
                    textCinco.setBounds(600, 300, 100, 30);
                    textCinco.setBackground(new Color(80,150,210));
                    textCinco.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    // Opciones predefinidas
                    
                    // -----------------------------------------------
                    add(labelSeis);
                    labelSeis.setBounds(350, 350, 300, 30);
                    labelSeis.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    add(textSeis);
                    textSeis.setBounds(600, 350, 100, 30);
                    textSeis.setBackground(new Color(80,150,210));
                    textSeis.setFont(new Font("Palm Royale",Font.ITALIC,12));
                   

                    // -------------------------------------------------
                    add(labelSiete);
                    labelSiete.setBounds(350, 400, 300, 30);
                    labelSiete.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    add(textSiete);
                    textSiete.setBounds(600, 400, 100, 30);
                    textSiete.setBackground(new Color(80,150,210));
                    textSiete.setFont(new Font("Palm Royale",Font.ITALIC,12));
                    // --------------------------------------------------
                        
               
                   
                       botonOcho.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){
                            try{
                                nombre = textUno.getText();
                                apellido = textDos.getText();
                                direccion = textTres.getText();
                                nacimiento = textCuatro.getText();
                                barrio = textCinco.getText();
                                dni_String = textSeis.getText();
                                edad_String = textSiete.getText();
                                if (dni_String != null && !dni_String.isEmpty() && edad_String != null && !edad_String.isEmpty() && esNum(edad_String)&&esNum(dni_String)){
                                    dni = Integer.parseInt(dni_String);
                                    edad = Integer.parseInt(edad_String); 
                                     generarIngreso(edad,barrio);

                                }else{

                                    throw new CampoImcompletoException("Complete todos los campos correctamente");
                                }

                                
                            }catch (CampoImcompletoException j){
                                    JLabel label_excep = new JLabel(""+j.getMessage());
                                    label_excep.setFont(new Font("Palm Royale",Font.ITALIC,12));
                                    add(label_excep);
                                    label_excep.setBounds(400,450,250,30);
                                    

                            }catch (NumberFormatException j){
                                System.out.println("Campo no valido.");
                        
                            }

                        }
                       });           
                    
                    
        
  

 }


//BOTONES
    @Override
    public void stateChanged (ChangeEvent e){
    
        botonOcho.setEnabled(!textUno.getText().isEmpty());

    }

    @Override
    public void actionPerformed (ActionEvent e){
    if (e.getSource() == botonOcho){
    
        
    }
}
    private void actualizarBoton() {
       
            botonOcho.setEnabled(!textUno.getText().isEmpty()&& !textDos.getText().isEmpty()&& !textTres.getText().isEmpty()&&
             !textCuatro.getText().isEmpty() && !textCinco.getText().isEmpty() && !textSeis.getText().isEmpty() && !textSiete.getText().isEmpty());
        
            
        
    }
    public boolean esNum (String x){
        for (char letra : x.toCharArray()) {
            if (!Character.isDigit(letra)) {
                return false;
            }
        }
        return true;
    }

}
