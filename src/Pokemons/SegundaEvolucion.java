package Pokemons;

/**
 * Subclase de los pokemons en etapa de Segunda Evolucion
 * @extends Pokemon
 */

public class SegundaEvolucion extends Pokemon{

    private String evolucionBasica;
    private String primeraEvolucion;

    /**
     * Constructor de la subclase
     * @param id
     * @param nombre
     * @param etapa
     * @param tipo1
     * @param tipo2
     * @param evolucionBasica
     * @param primeraEvolucion
     */
    public SegundaEvolucion(int id, String nombre, String etapa, String tipo1, String tipo2,String evolucionBasica,String primeraEvolucion) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evolucionBasica=evolucionBasica;
        this.primeraEvolucion=primeraEvolucion;
    }

    /**
     * Get para obtener la evolucion basica del pokemon
     * @return
     */

    public String getEvolucionBasica() {
        return evolucionBasica;
    }

    /**
     * get para tener la primera Evolucion del pokemon
     * @return
     */
    public String getPrimeraEvolucion() {
        return primeraEvolucion;
    }

}
