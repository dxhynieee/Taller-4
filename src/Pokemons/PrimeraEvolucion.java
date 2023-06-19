package Pokemons;

import Pokemons.Pokemon;
/**
 * Subclase de todos los pokemons en primera evolucion
 * @extends Pokemon
 */
public class PrimeraEvolucion extends Pokemon {


    private String anteriorEvolucion;
    private String siguienteEvolucion;

    /**
     * Constructor de la subclase
     * @param id
     * @param nombre
     * @param etapa
     * @param tipo1
     * @param tipo2
     * @param anteriorEvolucion
     * @param siguienteEvolucion
     */
    public PrimeraEvolucion(int id, String nombre, String etapa, String tipo1, String tipo2,String anteriorEvolucion,String siguienteEvolucion) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.anteriorEvolucion=anteriorEvolucion;
        this.siguienteEvolucion=siguienteEvolucion;
    }

    /**
     * Permite llamar a la anterior Evolucion si es que tiene
     * @return evolución anterior
     */
    public String getAnteriorEvolucion() {
        return anteriorEvolucion;
    }

    /**
     * Permite llama a la suiguiente evolucion si es que tiene
     * @param
     */
    public String getSiguienteEvolucion() {
        return siguienteEvolucion;
    }



}
