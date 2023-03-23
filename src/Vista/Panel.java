package Vista;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private Image fondo, imagenPokemon;
    private ImageIcon imageIconPokemon;
    private JTextField textBusqueda;
    private JButton botonBusqueda;
    private JLabel labelImgPokemon, labelaltura, labelbaseExperiencia, labelnombre, labelorden, labelpeso, labelId;
    public Panel(){
        setLocation(0, 0);
        setSize(750,570);
        setLayout(null);
        inicializar();
        setVisible(true);
    }

    public void inicializar(){
        fondo = new ImageIcon("imagenes/pokedex.png").getImage();

        iniciarText();
        iniciarBoton();
        inicializarLabels();
    }

    public void inicializarLabels(){
        //Label Id
        labelId = new JLabel();
        add(labelId);
        //Label Nombre
        labelnombre = new JLabel();
        add(labelnombre);
        //Label Altura
        labelaltura = new JLabel();
        add(labelaltura);
        //Label Peso
        labelpeso = new JLabel();
        add(labelpeso);
        //Label Experiencia
        labelbaseExperiencia = new JLabel();
        add(labelbaseExperiencia);
        //Label Orden
        labelorden = new JLabel();
        add(labelorden);
        //Label Imagen Pokemon
        labelImgPokemon = new JLabel();
        add(labelImgPokemon);
    }

    public void paint(Graphics g ){
        fondoPokeDex(g);
    }
    public void fondoPokeDex(Graphics g){
       g.drawImage(fondo,0,0,746,542,this);
       setOpaque(false);
       super.paint(g);
    }

    public void iniciarBoton(){
        botonBusqueda = new JButton("\uD83D\uDD0E");
        botonBusqueda.setBounds(242, 460, 70, 36);
        botonBusqueda.setContentAreaFilled(false);
        botonBusqueda.setFocusPainted(false);
        add(botonBusqueda);
    }
    public void iniciarText(){
        textBusqueda = new JTextField("Pokemon");
        textBusqueda.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 20));
        textBusqueda.setBounds(90,444,120,60);
        textBusqueda.setOpaque(false);
        add(textBusqueda);
    }
    public void actualizarLabels(){
        //Actualizacion del Id
        labelId.setBounds(60,90,150,150);
        labelId.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 17));
        //Actualizacion del Nombre
        labelnombre.setBounds(60,120,150,150);
        labelnombre.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 17));
        //Actualizacion de la Altura
        labelaltura.setBounds(60,150,150,150);
        labelaltura.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 17));
        //Actualizacion del Peso
        labelpeso.setBounds(60,180,150,150);
        labelpeso.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 17));
        //Actualizacion de la Experiencia Base
        labelbaseExperiencia.setBounds(60,210,150,150);
        labelbaseExperiencia.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 17));
        //Actualizacion de la Experiencia Base
        labelorden.setBounds(60,240,150,150);
        labelorden.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 17));

        //Actualizacion De Label de la Imagen
        Image newImg = imagenPokemon.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH);
        imageIconPokemon = new ImageIcon(newImg);
        labelImgPokemon.setBounds(450,150,250,250);
        labelImgPokemon.setIcon(imageIconPokemon);
    }

    public JLabel getLabelaltura() {
        return labelaltura;
    }

    public JLabel getLabelbaseExperiencia() {
        return labelbaseExperiencia;
    }

    public JLabel getLabelnombre() {
        return labelnombre;
    }

    public JLabel getLabelorden() {
        return labelorden;
    }

    public JLabel getLabelpeso() {
        return labelpeso;
    }

    public JLabel getLabelId() {
        return labelId;
    }

    public void setImagenPokemon(Image imagenPokemon) {
        this.imagenPokemon = imagenPokemon;
    }

    public JTextField getTextBusqueda() {
        return textBusqueda;
    }

    public void setTextBusqueda(JTextField textBusqueda) {
        this.textBusqueda = textBusqueda;
    }
    public JButton getBotonBusqueda() {
        return botonBusqueda;
    }

}
