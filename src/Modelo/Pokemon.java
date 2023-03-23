package Modelo;

public class Pokemon {

    //Definimos los Objetos de la misma manera en la que aparece en la PokeAPI
    private String id, name, height, weight, base_experience, order, urlImg;

    public Pokemon(String id, String name, String height, String weight, String base_experience, String order, String urlImg){
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.base_experience = base_experience;
        this.order = order;
        this.urlImg = urlImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}

