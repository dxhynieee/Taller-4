package Pokemons;

import Pokemons.Pokemon;
/**
 * Subclase para Pokemons en etapa Base
 * @extends Pokemon
 */
public class Basico extends Pokemon {



    private String primeraEvolucion;
    private String segundaEvolucion;


    /**
     * Constructor de la subclase Basico
     * @param id
     * @param nombre
     * @param etapa
     * @param tipo1
     * @param tipo2
     * @param primeraEvolucion
     * @param segundaEvolucion
     */
    public Basico(int id, String nombre, String etapa, String tipo1, String tipo2,String primeraEvolucion,String segundaEvolucion) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.primeraEvolucion=primeraEvolucion;
        this.segundaEvolucion=segundaEvolucion;
    }

    //Metodos Get de la subclase, ya que usa el resto de su clase padre.
    /**the getPrimeraEvolución
     *
     * @return primeraEvolución
     */
    public String getPrimeraEvolucion() {
        return primeraEvolucion;
    }

    /**
     *
     * @return segundaEvolución
     */
    public String getSegundaEvolucion() {
        return segundaEvolucion;
    }


}
