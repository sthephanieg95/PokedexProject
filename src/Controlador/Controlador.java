package Controlador;

import Modelo.Pokemon;
import Vista.Ventana;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Controlador {
    private Ventana ventana;
    private APIConection API = new APIConection();
    public Controlador(Ventana v){
        ventana = v;
    }

    public void unidadDeControl() {
        ventana.getPanel().getBotonBusqueda().addActionListener(e -> ingresarNombre());
    }

    public void ingresarNombre(){
        String nombrePokemon = ventana.getPanel().getTextBusqueda().getText();
        String ruta = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;

        if (API.getJsonPokemon(ruta) == null){
            JOptionPane.showMessageDialog(null, "El pokemon ingresado a buscar no existe",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                //Creamos la instancia Pokemon para poder obtener sus datos
                Pokemon pokemon = API.createPokemon(ruta);

                //Realizamos el cambio para Los Textos y las Variables
                ventana.getPanel().getLabelId().setText("Identificador: " + pokemon.getId());
                ventana.getPanel().getLabelnombre().setText("Nombre: " + pokemon.getName());
                ventana.getPanel().getLabelaltura().setText("Altura: " + pokemon.getHeight());
                ventana.getPanel().getLabelpeso().setText("Peso: " + pokemon.getWeight());
                ventana.getPanel().getLabelbaseExperiencia().setText("XP Base: " + pokemon.getBase_experience());
                ventana.getPanel().getLabelorden().setText("Orden: " + pokemon.getOrder());

                //Obtenemos el Link de la imagen
                URL linkImage = new URL(pokemon.getUrlImg());
                String identificador = pokemon.getId();
                Image image = ImageIO.read(linkImage);
                ventana.getPanel().setImagenPokemon(image);

                //Actualizamos Los Labels
                ventana.getPanel().actualizarLabels();
                //Actualizamos la Ventana
                ventana.getPanel().repaint();
                ventana.getPanel().getLabelId().setText("Identificador: " + identificador);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}