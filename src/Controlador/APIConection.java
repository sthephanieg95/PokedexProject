package Controlador;

import Modelo.Pokemon;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIConection {

    public String getJsonPokemon(String Url){
        try {
            URL enlace = new URL(Url);
            HttpURLConnection connection = (HttpURLConnection) enlace.openConnection();
            //Hacemos Peticion a la API
            connection.setRequestMethod("GET");
            connection.connect();

            int respondeCode = connection.getResponseCode();

            //Realizamos la verificacion de la Conexion
            if (respondeCode == 404){
                return null;
            }
            if(respondeCode != 200){
                throw new RuntimeException("Ocurrio Un Error: " + respondeCode);
            }else {
                StringBuilder jsonPokemonString = new StringBuilder();
                Scanner scanner = new Scanner(enlace.openStream());

                while (scanner.hasNext()){
                    jsonPokemonString.append(scanner.nextLine());
                }
                scanner.close();
                return jsonPokemonString.toString();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Crea el Pokemon con los Atributos del Objeto
    public Pokemon createPokemon(String URL){
        //Obtenemos el Archivo inicial
        String jsonString = getJsonPokemon(URL);

        //Creacion del Pokemon a Buscar
        Gson gson = new Gson();
        Pokemon pk = gson.fromJson(jsonString, Pokemon.class);

        try {
            //Pasamos el Archivo json a un JSONObject para utilizar los atributos
            JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);

            //Pasamos el JSONAray a un JSONObject para utilizar uss metodos
            JSONObject sprites = (JSONObject) jsonObject.get("sprites");
            JSONObject other = (JSONObject) sprites.get("other");
            JSONObject artWork = (JSONObject) other.get("official-artwork");
            String resourceImg = (String) artWork.get("front_default");

            pk.setUrlImg(resourceImg);

        }catch (Exception e){
            e.printStackTrace();
        }
        return pk;
    }
}
