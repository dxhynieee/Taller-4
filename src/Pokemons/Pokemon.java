package Pokemons;

import ucn.StdOut;

public abstract class Pokemon {

    private int id;
    private String nombre;
    private String etapa;
    private String tipo1;
    private String tipo2;

    /**
     * Constructor de la clase Pokemon
     * @param id
     * @param nombre
     * @param etapa
     * @param tipo1
     * @param tipo2
     */
    public Pokemon(int id, String nombre, String etapa, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    /**
     * ToString para tener los datos de los pokemons
     * @return
     */
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Etapa: " + etapa + ", Tipo 1: " + tipo1 + ", Tipo 2: " + tipo2;
    }

    //Getters de los atributos del Pokemon, no hacemos setters porque NO se puede cambiar la evolución, ni preevolución de un Pokemon
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }
}
