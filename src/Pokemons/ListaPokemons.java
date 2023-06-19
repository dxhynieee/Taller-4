package Pokemons;

import Pokemons.Pokemon;
import Sistema.SystemImpl;
import ucn.StdIn;
import ucn.StdOut;

import java.awt.*;
import java.util.*;

public class ListaPokemons {

    public ArrayList<Pokemon> pokemonArrayList;
    public Iterator<Pokemon> iterador;

    public ListaPokemons() {
        pokemonArrayList = new ArrayList<>();
    }

    /**the agregarPokemon
     *
     * @param pokemon
     */
    public void agregarPokemon(Pokemon pokemon) {
        pokemonArrayList.add(pokemon);
    }

    /**
     * Muestra los pokemons en orden alfabetico
     */
    public void MostrarPokemonsOrdenadosAlfabeticamente() {
        int contador=0;
        Collections.sort(pokemonArrayList,new Comparator<Pokemon>() {
            @Override  //Metodo base de IntelIJ que ordena la lista
            public int compare(Pokemon p1, Pokemon p2) {
                return p1.getNombre().compareToIgnoreCase(p2.getNombre());
            }
        });

        iterador=pokemonArrayList.iterator();
        while (iterador.hasNext()){
            Pokemon pokemon=iterador.next();
            StdOut.println(pokemon);
            }

    }

    /**the MostrarPokemonsOrdenadosPorTipo
     * Muestra la lista de los Pokemons ordenados por tipo
     * @param
     */
    public void MostrarPokemonsOrdenadosPorTipo() {
        Collections.sort(pokemonArrayList,new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return p1.getTipo1().compareToIgnoreCase(p2.getTipo1());
            }
        });
        iterador=pokemonArrayList.iterator();
        while (iterador.hasNext()){
            Pokemon pokemon=iterador.next();
            StdOut.println(pokemon);
        }
    }


    /*the MostrarPokemonsOrdenadosPorPrimeraEvolucionDecreciente
     * Muestra los pokemons ordenados por su primera etapa de evolucion de forma decreciente
     * @param los Pokemons a mostrar
     */
    public void MostrarPokemonsOrdenadosPorPrimeraEvolucionDecreciente() {

        Collections.sort(pokemonArrayList,new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return p2.getId() - p1.getId();
            }
        });
        iterador=pokemonArrayList.iterator();
        while (iterador.hasNext()){
            Pokemon pokemon=iterador.next();
            System.out.println(pokemon);
            if (pokemon instanceof Basico) {
                Basico basico = (Basico) pokemon;
                ///Comprueba si tiene primera evolucion, si no tiene despliega el mensaje
                if (basico.getPrimeraEvolucion() == null) {
                    StdOut.println("Primera evolucion:El Pokemon " + pokemon.getNombre() + " no tiene primera evolución");
                } else {
                    ///Despliega la primera evolucion
                    StdOut.println("Primera evolucion: " + basico.getPrimeraEvolucion());
                }
                ///comprueba si tiene seguna evolucion, si no tiene despliega el mensaje
                if (basico.getSegundaEvolucion() == null) {
                    StdOut.println("Segunda evolucion: El Pokemon " + pokemon.getNombre() + " no tiene segunda evolución");
                } else {
                    ///Despliega la segunda evolucion
                    StdOut.println("Segunda evolucion: " + basico.getSegundaEvolucion());
                }

            }
            if (pokemon instanceof PrimeraEvolucion) {
                PrimeraEvolucion primeraEvolucion = (PrimeraEvolucion) pokemon;

                StdOut.println("La evolucion anterior es: " + primeraEvolucion.getAnteriorEvolucion());

                if (primeraEvolucion.getSiguienteEvolucion() == null) {
                    StdOut.println("Segunda evolucion:El Pokemon " + pokemon.getNombre() + " no tiene segunda evolución");
                } else {
                    StdOut.println("Segunda evolucion:" + primeraEvolucion.getSiguienteEvolucion());
                }

                //Comprueba si es un pokémon básico con 1 sola evolución, de ser así, avisa despliega el siguiente mensaje.


            }
            //Al Segunda Evolución lo dejamos como está, porque por ejemplo, si es un Pokémon con Segunda Evolución, por ejemplo, Blastoise, si o si tuvo que haber pasado
            //por Wartortle y Squirtle
            if (pokemon instanceof SegundaEvolucion) {
                SegundaEvolucion segundaEvolucion = (SegundaEvolucion) pokemon;
                StdOut.println("Pre-evolución: " + segundaEvolucion.getPrimeraEvolucion() + ", Evolución básica:" + segundaEvolucion.getEvolucionBasica());
            }
            StdOut.println();

        }
    }

    /*the MostrarPokemonsPorRango
     *
     * @param rango a mostrar
     */
    public void MostrarPokemonsPorRango() {
        Collections.sort(pokemonArrayList,new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return p1.getId() - p2.getId();
            }
        });
        StdOut.println("A continuación deberá ingresar el rango de los Pokémons los cuales quiera desplegar, este tiene que estar entre 1 y 30");

        StdOut.println("Ingrese donde empieza el despliegue");
        int limiteInferior = StdIn.readInt();

        StdOut.println("Ingrese donde termina el despliegue");
        int limiteSuperior = StdIn.readInt();

        if(limiteInferior < 0 || limiteSuperior > 30){
            StdOut.println("Ingresó un rango inválido, por favor intentelo de nuevo.");
            while(true){

                StdOut.println("Ingrese donde empieza el despliegue");
                 limiteInferior = StdIn.readInt();

                StdOut.println("Ingrese donde termina el despliegue");
                limiteSuperior = StdIn.readInt();
                if(limiteInferior>=1 && limiteSuperior<=30){
                    StdOut.println("Lista de Pokemons según rango, en orden cresciente. ");
                    for (int i = limiteInferior; i <= limiteSuperior; i++) {
                        StdOut.println(pokemonArrayList.get(i - 1));
                    }
                    break;
                }
            }

        }else if(limiteSuperior<limiteInferior){

            int aux1 = 0;
            int aux0 = 0;

            aux1=limiteSuperior;
            aux0=limiteInferior;

            limiteInferior=aux1;
            limiteSuperior=aux0;

            StdOut.println("Lista de Pokemons según rango, en orden cresciente. ");
            for (int i = limiteInferior; i <= limiteSuperior; i++) {
                StdOut.println(pokemonArrayList.get(i - 1));
            }

        }else{
            StdOut.println("Lista de Pokemons según rango, en orden cresciente. ");
            for (int i = limiteInferior; i <= limiteSuperior; i++) {
                StdOut.println(pokemonArrayList.get(i - 1));
            }


        }
    }

    /* the busquedaPersonalizada
     * Busca a los pokemons de forma personalizada es decir por el nombre o ID
     * @param el Pokemon a buscar
     * @throws NullPointerException
     */
    public void busquedaPersonalizada() throws NullPointerException{

        StdOut.println("Bienvenido a la busqueda personalizada de Pokemons");
        StdOut.println("Desea buscar por Nombre o por ID");
        StdOut.println("[1] - Nombre");
        StdOut.println("[2] - ID ");
        int opcionEscogidaBusquedaPerso = StdIn.readInt();

        switch (opcionEscogidaBusquedaPerso) {

            case 1:
                StdOut.print("Ingrese el nombre del Pokémon: ");
                String nombrePokemonBusquedaPersonalizada = StdIn.readString(); //Nombre Pokemon Busqueda Personalizada
                iterador = pokemonArrayList.iterator();
                while (iterador.hasNext()) {
                    Pokemon pokemon = iterador.next();
                    if (pokemon.getNombre().equals(nombrePokemonBusquedaPersonalizada)) {
                        StdOut.println(pokemon);
                        if (pokemon.getNombre().equals("Eevee")) {
                            Eevee eevee = (Eevee) pokemon;
                            StdOut.println("-----Evoluciones-----");
                            StdOut.println("[1]Primera Evolucion");
                            StdOut.println("[2]Segunda Evolucion");
                            StdOut.println("[3]Tercera Evolucion");
                            StdOut.println("[4]Salir");
                            StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                            int numEvolucionEscogida = StdIn.readInt();
                            if (numEvolucionEscogida == 1) {
                                buscarEvolucionPokemon(eevee.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogidaEevee = StdIn.readInt();
                                while (true) {
                                    if (opcionEscogidaEevee == 1) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogidaEevee == 2) {
                                        return;
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida == 2) {
                                buscarEvolucionPokemon(eevee.getSegundaEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogidaEevee = StdIn.readInt();
                                while (true) {
                                    if (opcionEscogidaEevee == 1) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogidaEevee == 2) {
                                        return;
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida == 3) {
                                buscarEvolucionPokemon(eevee.getTerceraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogidaEevee = StdIn.readInt();
                                while (true) {
                                    if (opcionEscogidaEevee == 1) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogidaEevee == 2) {
                                        return;
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida == 4) {
                                return;
                            }
                        }
                        if (pokemon.getEtapa().equals("Basico") && !pokemon.getNombre().equals("Eevee")) {
                            Basico basico = (Basico) pokemon;
                            StdOut.println("-----Evoluciones-----");
                            StdOut.println("[1]Primera Evolucion");
                            StdOut.println("[2]Segunda Evolucion");
                            StdOut.println("[3]Salir");
                            StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                            int numEvolucionEscogida = StdIn.readInt();
                            //Inicio opción escogida básica
                            if (numEvolucionEscogida == 1 && pokemon.getEtapa().equals("Basico")) {
                                buscarEvolucionPokemon(basico.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {
                                    //Caso opción 1
                                    if (opcionEscogida == 1) {
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 2) {
                                        if (basico.getSegundaEvolucion() != null) {
                                            buscarEvolucionPokemon(basico.getSegundaEvolucion(), basico.getPrimeraEvolucion());
                                        } else {
                                            StdOut.println(pokemon.getNombre() + " no tiene segunda etapa evolutiva");
                                            return;
                                        }
                                    }
                                    if (opcionEscogida == 3) {
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Primera Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2 == 1) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2 == 3) {
                                        return;
                                    }
                                    if (opcionEscogida2 == 2) {
                                        buscarEvolucionPokemon(basico.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }//Fin opción escogida básica
                            if (numEvolucionEscogida == 2 && pokemon.getEtapa().equals("Basico") && basico.getSegundaEvolucion() != null) {
                                buscarEvolucionPokemon(basico.getSegundaEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Primera Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {

                                    //Caso opción 1
                                    if (opcionEscogida == 1) {
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 2) {
                                        buscarEvolucionPokemon(basico.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);

                                    }
                                    if (opcionEscogida == 3) {
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2 == 1) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2 == 3) {
                                        return;
                                    }
                                    if (opcionEscogida2 == 2) {
                                        buscarEvolucionPokemon(basico.getSegundaEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Primera Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida == 3 && pokemon.getEtapa().equals("Basico")) {
                                return;
                            }

                        }
                        if (pokemon.getEtapa().equals("Primera Evolucion")) {
                            PrimeraEvolucion primeraEvolucion = (PrimeraEvolucion) pokemon;
                            StdOut.println("-----Evoluciones-----");
                            StdOut.println("[1]Evolucion Basica");
                            StdOut.println("[2]Segunda Evolucion");
                            StdOut.println("[3]Salir");
                            StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                            int numEvolucionEscogida = StdIn.readInt();
                            //Inicio opción escogida básica
                            if (numEvolucionEscogida == 1 && pokemon.getEtapa().equals("Primera Evolucion")) {
                                buscarEvolucionPokemon(primeraEvolucion.getAnteriorEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Primera Evolucion");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {
                                    //Caso opción 1
                                    if (opcionEscogida == 1) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 2) {
                                        if (primeraEvolucion.getSiguienteEvolucion() != null) {
                                            buscarEvolucionPokemon(primeraEvolucion.getSiguienteEvolucion(), primeraEvolucion.getAnteriorEvolucion());
                                        } else {
                                            StdOut.println(pokemon.getNombre() + " no tiene segunda etapa evolutiva");
                                            return;
                                        }
                                    }
                                    if (opcionEscogida == 3) {
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Primera Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2 == 2) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2 == 3) {
                                        return;
                                    }
                                    if (opcionEscogida2 == 1) {
                                        buscarEvolucionPokemon(primeraEvolucion.getAnteriorEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }//Fin opción escogida básica
                            if (numEvolucionEscogida == 2 && pokemon.getEtapa().equals("Primera Evolucion") && primeraEvolucion.getSiguienteEvolucion() != null) {
                                buscarEvolucionPokemon(primeraEvolucion.getSiguienteEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Primera Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {

                                    //Caso opción 1
                                    if (opcionEscogida == 2) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 1) {
                                        buscarEvolucionPokemon(primeraEvolucion.getAnteriorEvolucion(), nombrePokemonBusquedaPersonalizada);
                                    }
                                    if (opcionEscogida == 3) {
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Primera Evolucion");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2 == 1) {
                                        iterador = pokemonArrayList.iterator();
                                        break;

                                    }
                                    if (opcionEscogida2 == 2) {
                                        buscarEvolucionPokemon(primeraEvolucion.getSiguienteEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Primera Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    if (opcionEscogida2 == 3) {
                                        return;
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida == 3) {
                                return;
                            }


                        }
                        if (pokemon.getEtapa().equals("Segunda Evolucion")) {
                            SegundaEvolucion segundaEvolucion = (SegundaEvolucion) pokemon;
                            StdOut.println("-----Evoluciones-----");
                            StdOut.println("[1]Evolucion Basica");
                            StdOut.println("[2]Primera Evolucion");
                            StdOut.println("[3]Salir");
                            StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                            int numEvolucionEscogida = StdIn.readInt();
                            //Inicio opción escogida básica
                            if (numEvolucionEscogida == 1 && pokemon.getEtapa().equals("Segunda Evolucion")) {
                                buscarEvolucionPokemon(segundaEvolucion.getEvolucionBasica(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Primera Evolucion");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {
                                    //Caso opción 1
                                    if (opcionEscogida == 2) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 1) {
                                        buscarEvolucionPokemon(segundaEvolucion.getPrimeraEvolucion(), segundaEvolucion.getEvolucionBasica());
                                    }
                                    if (opcionEscogida == 3) {
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2 == 2) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2 == 1) {
                                        buscarEvolucionPokemon(segundaEvolucion.getEvolucionBasica(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Primera Evolucion");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    if (opcionEscogida2 == 3) {
                                        return;
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }//Fin opción escogida básica
                            if (numEvolucionEscogida == 2 && pokemon.getEtapa().equals("Segunda Evolucion") && segundaEvolucion.getPrimeraEvolucion() != null) {
                                buscarEvolucionPokemon(segundaEvolucion.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {

                                    //Caso opción 1
                                    if (opcionEscogida == 2) {
                                        iterador = pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 1) {
                                        buscarEvolucionPokemon(segundaEvolucion.getEvolucionBasica(), nombrePokemonBusquedaPersonalizada);
                                    }
                                    if (opcionEscogida == 3) {
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Primera Evolucion");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2 == 2) {
                                        iterador = pokemonArrayList.iterator();
                                        break;

                                    }
                                    if (opcionEscogida2 == 1) {
                                        buscarEvolucionPokemon(segundaEvolucion.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alfuga de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    if (opcionEscogida2 == 3) {
                                        return;
                                    }
                                    iterador = pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida == 3) {
                                return;
                            }


                        }
                    }

                }


            case 2:
                StdOut.print("Ingrese el ID del Pokémon: ");
                int IDPokemonBusquedaPersonalizada = StdIn.readInt(); //Nombre Pokemon Busqueda Personalizada
                iterador = pokemonArrayList.iterator();
                while(iterador.hasNext()){
                    Pokemon pokemon = iterador.next();
                    if (pokemon.getId()==IDPokemonBusquedaPersonalizada) {
                        StdOut.println(pokemon);
                        if (pokemon.getEtapa().equals("Basico")) {
                            nombrePokemonBusquedaPersonalizada=pokemon.getNombre();
                            Basico basico = (Basico) pokemon;
                            StdOut.println("-----Evoluciones-----");
                            StdOut.println("[1]Primera Evolucion");
                            StdOut.println("[2]Segunda Evolucion");
                            StdOut.println("[3]Salir");
                            StdOut.println("Si desea saber sobre alfuna de sus evoluciones ingrese el numero correspondido");
                            int numEvolucionEscogida = StdIn.readInt();
                            //Inicio opción escogida básica
                            if (numEvolucionEscogida == 1 && pokemon.getEtapa().equals("Basico")) {
                                buscarEvolucionPokemon(basico.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alfuna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {
                                    //Caso opción 1
                                    if (opcionEscogida == 1) {
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 2) {
                                        if (basico.getSegundaEvolucion() != null) {
                                            buscarEvolucionPokemon(basico.getSegundaEvolucion(), basico.getPrimeraEvolucion());
                                        } else {
                                            StdOut.println(pokemon.getNombre() + " no tiene segunda etapa evolutiva");
                                            break;
                                        }
                                    }
                                    if (opcionEscogida==3){
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Primera Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alfuna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2==1){
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2==3){
                                        return;
                                    }
                                    if (opcionEscogida2==2){
                                        buscarEvolucionPokemon(basico.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alfuna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    iterador=pokemonArrayList.iterator();
                                }
                            }//Fin opción escogida básica
                            if (numEvolucionEscogida == 2 && pokemon.getEtapa().equals("Basico")&&basico.getSegundaEvolucion()!=null) {
                                buscarEvolucionPokemon(basico.getSegundaEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Primera Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alfuna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {

                                    //Caso opción 1
                                    if (opcionEscogida == 1) {
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 2) {
                                        buscarEvolucionPokemon(basico.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);

                                    }
                                    if (opcionEscogida==3){
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alfuna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2==1){
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2==3){
                                        return;
                                    }
                                    if (opcionEscogida2==2){
                                        buscarEvolucionPokemon(basico.getSegundaEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Primera Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alfuna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    iterador=pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida==3 && pokemon.getEtapa().equals("Basico")){
                                return;
                            }


                        }
                        if (pokemon.getEtapa().equals("Primera Evolucion")) {
                            PrimeraEvolucion primeraEvolucion = (PrimeraEvolucion) pokemon;
                            nombrePokemonBusquedaPersonalizada=pokemon.getNombre();
                            StdOut.println("-----Evoluciones-----");
                            StdOut.println("[1]Evolucion Basica");
                            StdOut.println("[2]Segunda Evolucion");
                            StdOut.println("[3]Salir");
                            StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                            int numEvolucionEscogida = StdIn.readInt();
                            //Inicio opción escogida básica
                            if (numEvolucionEscogida == 1 && pokemon.getEtapa().equals("Primera Evolucion")) {
                                buscarEvolucionPokemon(primeraEvolucion.getAnteriorEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Primera Evolucion");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {
                                    //Caso opción 1
                                    if (opcionEscogida == 1) {
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 2) {
                                        if (primeraEvolucion.getSiguienteEvolucion() != null) {
                                            buscarEvolucionPokemon(primeraEvolucion.getSiguienteEvolucion(), primeraEvolucion.getAnteriorEvolucion());
                                        } else {
                                            StdOut.println(pokemon.getNombre() + " no tiene segunda etapa evolutiva");
                                            break;
                                        }
                                    }
                                    if (opcionEscogida==3){
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Primera Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2==2){
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2==3){
                                        return;
                                    }
                                    if (opcionEscogida2==1){
                                        buscarEvolucionPokemon(primeraEvolucion.getAnteriorEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    iterador=pokemonArrayList.iterator();
                                }
                            }//Fin opción escogida básica
                            if (numEvolucionEscogida == 2 && pokemon.getEtapa().equals("Primera Evolucion")&&primeraEvolucion.getSiguienteEvolucion()!=null) {
                                buscarEvolucionPokemon(primeraEvolucion.getSiguienteEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Primera Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {

                                    //Caso opción 1
                                    if (opcionEscogida == 2) {
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 1) {
                                        buscarEvolucionPokemon(primeraEvolucion.getAnteriorEvolucion(), nombrePokemonBusquedaPersonalizada);
                                    }
                                    if (opcionEscogida==3){
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Primera Evolucion");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2==1){
                                        iterador=pokemonArrayList.iterator();
                                        break;

                                    }
                                    if (opcionEscogida2==2){
                                        buscarEvolucionPokemon(primeraEvolucion.getSiguienteEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Primera Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    if (opcionEscogida2==3){
                                        return;
                                    }
                                    iterador=pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida==3){
                                return;
                            }


                        }
                        if (pokemon.getEtapa().equals("Segunda Evolucion")) {
                            SegundaEvolucion segundaEvolucion = (SegundaEvolucion)pokemon;
                            nombrePokemonBusquedaPersonalizada=pokemon.getNombre();
                            StdOut.println("-----Evoluciones-----");
                            StdOut.println("[1]Evolucion Basica");
                            StdOut.println("[2]Primera Evolucion");
                            StdOut.println("[3]Salir");
                            StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                            int numEvolucionEscogida = StdIn.readInt();
                            //Inicio opción escogida básica
                            if (numEvolucionEscogida == 1 && pokemon.getEtapa().equals("Segunda Evolucion")) {
                                buscarEvolucionPokemon(segundaEvolucion.getEvolucionBasica(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Primera Evolucion");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {
                                    //Caso opción 1
                                    if (opcionEscogida == 2) {
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 1) {
                                        buscarEvolucionPokemon(segundaEvolucion.getPrimeraEvolucion(), segundaEvolucion.getEvolucionBasica());
                                    }
                                    if (opcionEscogida==3){
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Evolucion Basica");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2==2){
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    if (opcionEscogida2==1){
                                        buscarEvolucionPokemon(segundaEvolucion.getEvolucionBasica(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Primera Evolucion");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    if (opcionEscogida2==3){
                                        return;
                                    }
                                    iterador=pokemonArrayList.iterator();
                                }
                            }//Fin opción escogida básica
                            if (numEvolucionEscogida == 2 && pokemon.getEtapa().equals("Segunda Evolucion")&&segundaEvolucion.getPrimeraEvolucion()!=null) {
                                buscarEvolucionPokemon(segundaEvolucion.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                StdOut.println("-----Evoluciones-----");
                                StdOut.println("[1]Evolucion Basica");
                                StdOut.println("[2]Segunda Evolucion");
                                StdOut.println("[3]Salir");
                                StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                int opcionEscogida = StdIn.readInt();
                                while (true) {

                                    //Caso opción 1
                                    if (opcionEscogida == 2) {
                                        iterador=pokemonArrayList.iterator();
                                        break;
                                    }
                                    //Caso opción 2
                                    if (opcionEscogida == 1) {
                                        buscarEvolucionPokemon(segundaEvolucion.getEvolucionBasica(), nombrePokemonBusquedaPersonalizada);
                                    }
                                    if (opcionEscogida==3){
                                        return;
                                    }
                                    StdOut.println("-----Evoluciones-----");
                                    StdOut.println("[1]Primera Evolucion");
                                    StdOut.println("[2]Segunda Evolucion");
                                    StdOut.println("[3]Salir");
                                    StdOut.println("Si desea saber sobre alguna de sus evoluciones ingrese el numero correspondido");
                                    int opcionEscogida2 = StdIn.readInt();
                                    if (opcionEscogida2==2){
                                        iterador=pokemonArrayList.iterator();
                                        break;

                                    }
                                    if (opcionEscogida2==1){
                                        buscarEvolucionPokemon(segundaEvolucion.getPrimeraEvolucion(), nombrePokemonBusquedaPersonalizada);
                                        StdOut.println("-----Evoluciones-----");
                                        StdOut.println("[1]Evolucion Basica");
                                        StdOut.println("[2]Segunda Evolucion");
                                        StdOut.println("[3]Salir");
                                        StdOut.println("Si desea saber sobre alfuga de sus evoluciones ingrese el numero correspondido");
                                        opcionEscogida = StdIn.readInt();
                                    }
                                    if (opcionEscogida2==3){
                                        return;
                                    }
                                    iterador=pokemonArrayList.iterator();
                                }
                            }
                            if (numEvolucionEscogida==3){
                                return;
                            }


                        }
                    }

                }

        }






    }

    /**the buscarPokemonPorID
     *
     * @param idPokemonBusquedaPersonalizada a buscar
     * @return Pokemon si lo encontré
     */
    private Pokemon buscarPokemonPorID(int idPokemonBusquedaPersonalizada) {

        iterador=pokemonArrayList.iterator();
        while (iterador.hasNext()){
            Pokemon pokemon= iterador.next();
            if (pokemon.getId()==idPokemonBusquedaPersonalizada){
                return pokemon;
            }
        }
        return null;
    }

    /** the buscarEvolucionPokemon
     *
     * @param nombreEvolucion del Pokemon
     * @param nombrePokemon del Pokemon
     */
    private void buscarEvolucionPokemon(String nombreEvolucion,String nombrePokemon) {

        iterador=pokemonArrayList.iterator();
        while (iterador.hasNext()){
            Pokemon pokemon= iterador.next();
            if (pokemon.getNombre().equals(nombreEvolucion)) {
                if (pokemon instanceof Basico) {
                    Basico basico = (Basico) pokemon;
                    if (basico.getPrimeraEvolucion().equalsIgnoreCase(nombreEvolucion)&& basico.getPrimeraEvolucion()!=null||basico.getPrimeraEvolucion().equalsIgnoreCase(nombrePokemon)){
                        System.out.println("Datos de la evolución seleccionada:");
                        System.out.println(pokemon.toString());
                        break;
                    }
                    if (basico.getSegundaEvolucion().equalsIgnoreCase(nombreEvolucion)&&basico.getSegundaEvolucion()!=null||basico.getSegundaEvolucion().equalsIgnoreCase(nombrePokemon)) {
                        System.out.println("Datos de la evolución seleccionada:");
                        System.out.println(pokemon.toString());
                        break;
                    }
                } else if (pokemon instanceof PrimeraEvolucion) {
                    PrimeraEvolucion primeraEvolucion = (PrimeraEvolucion) pokemon;
                    if (primeraEvolucion.getAnteriorEvolucion().equalsIgnoreCase(nombrePokemon)&&primeraEvolucion.getAnteriorEvolucion()!=null||primeraEvolucion.getSiguienteEvolucion().equalsIgnoreCase(nombrePokemon)) {
                        System.out.println("Datos de la evolución seleccionada:");
                        System.out.println(pokemon.toString());
                        break;
                    }
                } else if (pokemon instanceof SegundaEvolucion) {
                    SegundaEvolucion segundaEvolucion = (SegundaEvolucion) pokemon;
                    if (segundaEvolucion.getEvolucionBasica().equalsIgnoreCase(nombreEvolucion)||segundaEvolucion.getPrimeraEvolucion().equalsIgnoreCase(nombrePokemon)){
                        System.out.println("Datos de la evolución seleccionada:");
                        System.out.println(pokemon.toString());
                        break;
                    }
                    if (segundaEvolucion.getPrimeraEvolucion().equalsIgnoreCase(nombreEvolucion)||segundaEvolucion.getEvolucionBasica().equalsIgnoreCase(nombrePokemon)) {
                        System.out.println("Datos de la evolución seleccionada:");
                        System.out.println(pokemon.toString());
                        break;
                    }
                }
            }

    }
    }


}
