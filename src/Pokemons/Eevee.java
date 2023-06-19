package Pokemons;
   /**
    * Subclase para Eevee
    * @extends Pokemon
    */
public class Eevee extends Pokemon{

    // Una para Vaporeon, Jolteon, y Flareon.
    private String primeraEvolucion;
    private String segundaEvolucion;
    private String terceraEvolucion;

    /**
     * Constructor de la subclase Eevee
     * @return
     */
    public Eevee(int id, String nombre, String etapa,String primeraEvolucion,String segundaEvolucion,String terceraEvolucion, String tipo1, String tipo2) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.primeraEvolucion=primeraEvolucion;
        this.segundaEvolucion=segundaEvolucion;
        this.terceraEvolucion=terceraEvolucion;
    }


    /**the getPrimeraEvolucion
     * Esta hace tener la primera Evolucion de Eevee
     * @return la primeraEvolucion
     */

    public String getPrimeraEvolucion() {
        return primeraEvolucion;
    }


    /**the getSegundaEvolucion
     * Esto hace tener la segunda Evolucion de Eevee
     * @return la segundaEvolucion
     */
    public String getSegundaEvolucion() {
        return segundaEvolucion;
    }



    /**
     * Esto hace tener la tercera evolucion de Eevee
     * @return la terceraEvolución
     */
    public String getTerceraEvolucion() {
        return terceraEvolucion;
    }

}
