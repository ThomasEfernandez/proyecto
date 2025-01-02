package MenuPack;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import IngresoPack.Ingresante;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;







public abstract class Sistema extends JFrame  implements ActionListener,ChangeListener {
    // lista de ingresantes mediante hashset ya que no puede haber duplicados y por
    // orden de ingreso
    private HashSet<Ingresante> listaIngresantes = new HashSet<>();
    //botones
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


// Constructores
    public Sistema() {

    }
    public Sistema(HashSet<Ingresante> listaIngresantes) {

        this.listaIngresantes = listaIngresantes;
    }

// Getters and Setter
    public HashSet<Ingresante> getListaIngresantes() {
        return listaIngresantes;
    }
    public void setListaIngresantes(HashSet<Ingresante> listaIngresantes) {
        this.listaIngresantes = listaIngresantes;
    }

//Menu principal
     public void menuPrincipal (){
        
        setLayout(null);
        JButton botonUno = new JButton("Ingresantes");
        botonUno.setFocusPainted(false);
        botonUno.setBackground(new Color(79,121,210));
        botonUno.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonUno.setBounds(100, 180, 200, 40);
        add(botonUno);
        JButton botonDos = new JButton("Mapa");
        botonDos.setFocusPainted(false);
        botonDos.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonDos.setBackground(new Color(79,121,210));
       
        botonDos.setBounds(100, 280, 200, 40);
        add(botonDos);
        JButton botonTres = new JButton("Salir");
        botonTres.setBackground(new Color(79,121,210));
        botonTres.setFocusPainted(false);
        botonTres.setFont(new Font("Palm Royale",Font.BOLD,12));
        botonTres.setBounds(100, 380, 200, 40);
        add(botonTres);
     


      
       
     
       botonUno.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
           
            Ingresantes menu_Ingresantes = new Ingresantes(listaIngresantes);
        
            menu_Ingresantes.setLayout(null);
            menu_Ingresantes.getContentPane().setFont(new Font("Palm Royale",Font.ITALIC,12));
            menu_Ingresantes.setBounds(0,0,800,700);
            menu_Ingresantes.setVisible(true);
            menu_Ingresantes.setLocationRelativeTo(null);
            menu_Ingresantes.setResizable(false);
            menu_Ingresantes.menuPrincipalIngreso();
            menu_Ingresantes.getContentPane().setBackground(new Color(174,206,244));
            setVisible(false);

        }
       });
       //BOTON DOS
       botonTres.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){

           System.exit(0);
        }

        });
               

    }
//Limpia los jtextfield y labels de la pantalla principal
    public void limpiar (){

        //Limpio la pantalla para avanzar en el programa
        labelCero.setVisible(false);
        labelUno.setVisible(false);
        labelDos.setVisible(false);
        labelTres.setVisible(false);
        labelCuatro.setVisible(false);
        labelCinco.setVisible(false);
        labelSeis.setVisible(false);
        labelSiete.setVisible(false);

        //Limpieza de los jtextField en pantalla
        textUno.setVisible(false);
        textDos.setVisible(false);
        textTres.setVisible(false);
        textCuatro.setVisible(false);
        textCinco.setVisible(false);
        textSeis.setVisible(false);
        textSiete.setVisible(false);

    }
//Lee el string y corrobora que todas las posiciones sean numeros
    public boolean esNum (String x){
        for (char letra : x.toCharArray()) {
            if (!Character.isDigit(letra)) {
                return false;
            }
        }
        return true;
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
}