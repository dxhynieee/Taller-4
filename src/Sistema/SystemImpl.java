package Sistema;

import Pokemons.*;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

/*the SystemImpl
*
*@param el System a implementar
*/
public class SystemImpl implements System {

 //Lista de arraylist delcarada en el sistema impl para poder utilizarla aquí
 ListaPokemons listaPokemons=new ListaPokemons();

 //Objeto auxiliar para comparativos
 Pokemon pokemonaux;

//Menu standart que pregunta cual de las opciones quiere realizar el usuario, invoca la que eli
 public void menuPrincipal() {

  StdOut.print("Bienvenido al menu principal de la Pokédex");
  StdOut.println("¿Que operación desea realizar?");
  StdOut.println("[1] - Desplegar dado un rango de números");
  StdOut.println("[2] - Desplegar todos los Pokémons conocidos en el sistema ordenados");
  StdOut.println("[3] - Desplegar los Pokémons según un tipo en particular");
  StdOut.println("[4] - Desplegar todos los Pokémons de primera evolución");
  StdOut.println("[5] - Búsqueda personalizada");
  StdOut.println("[6] - Terminar programa");

  int opciónIngresada = StdIn.readInt();

  while (opciónIngresada != 6) {

   switch (opciónIngresada) {

    case 1:
     desplegarSegunRango();
     break;
    case 2:
     this.desplegarAllPokemons();
     break;
    case 3:
     this.desplegarSegunTipo();
     break;
    case 4:
     desplegarPrimeraEvolucion();
     break;
    case 5:
     busquedaPersonalizada();
     break;
    case 6:
     terminarPrograma();
     break;
   } // Switch Menu

  } // While Menu Infinito

 } // Menu Principal Fin


 /*the desplegarSegunRango
  *
  *@param rango a desplegar
  */
@Override
 public void desplegarSegunRango() {listaPokemons.MostrarPokemonsPorRango(); menuPrincipal();}
 /*the desplegarAllPokemons
  *
  *@param Pokemons a desplegar
  */
@Override
 public void desplegarAllPokemons(){ listaPokemons.MostrarPokemonsOrdenadosAlfabeticamente(); menuPrincipal();}
 /*the desplegarSegunTipo
  *
  *@param Pokemons a desplegar
  */
@Override
 public void desplegarSegunTipo() {listaPokemons.MostrarPokemonsOrdenadosPorTipo(); menuPrincipal();}

 /*the desplegarPrimeraEvolucion
  *
  *@param PrimerasEvoluciones a desplegar
  */
 @Override
 public void desplegarPrimeraEvolucion() {listaPokemons.MostrarPokemonsOrdenadosPorPrimeraEvolucionDecreciente(); menuPrincipal();}

 /*the busquedaPersonalizada
  *
  *@param el Pokemon a buscar
  */

@Override
 public void busquedaPersonalizada() {listaPokemons.busquedaPersonalizada(); menuPrincipal();}

 /**the terminarPrograma
  *
  *@return salir del sistema
  */

 public void terminarPrograma(){
  StdOut.println("Programa Finalizado.");
  return;
 }
 /*The leerArchivo
  *@param el Sistema a utulizar
  *@throws IOException
  */

 /*Logica explicada, lee el archivo, y dependiendo de la etapa evolutiva que se encuentre en Pokémon, ejecuta, llamemosle
  *Lectura A, para los básicos, Lectura B para los Primeras Evoluciones, y Lectura C para las segundas, ya que ambos formatos de archivos son distintos
  * tambien usa las funciones .trim() que borra los espacios
  * y la funcion continue para seguir leyendo en caso de toparse con un espacio en  blanco
  */
 public void leerArchivo(SystemImpl sistema) throws IOException {

  ArchivoEntrada arch1 = new ArchivoEntrada("kanto.txt");
  //while standart que lee los campos del archivo y los asigna a una variable para poder trabajarlos
  while (!arch1.isEndFile()) {
    Registro reg1 = arch1.getRegistro();
   String idPokemonString = reg1.getString();
   idPokemonString=idPokemonString.trim();
   if (idPokemonString.equals(""))continue;
   int idPokemons = Integer.parseInt(idPokemonString);

   String nombrePokemon = reg1.getString();
   nombrePokemon = nombrePokemon.trim();


   if (nombrePokemon.equals("Eevee")){
    String etapaPokemon=reg1.getString();
    etapaPokemon=etapaPokemon.trim();
    String primeraEvolucion = reg1.getString();
    primeraEvolucion=primeraEvolucion.trim();
    String segundaEvolucion=reg1.getString();
    segundaEvolucion=segundaEvolucion.trim();
    String terceraEvolucion=reg1.getString();
    terceraEvolucion=terceraEvolucion.trim();
    String tipo1 = reg1.getString();
    tipo1=tipo1.trim();
    String tipo2 = reg1.getString();
    tipo1=tipo2.trim();
    pokemonaux=new Eevee(idPokemons,nombrePokemon,etapaPokemon,primeraEvolucion,segundaEvolucion,terceraEvolucion,tipo1,tipo2);
    listaPokemons.agregarPokemon(pokemonaux);
    continue;
   }

   String etapaPokemon = reg1.getString();
   etapaPokemon=etapaPokemon.trim();

   /*Acá vamos a hacer varios IF's, porque pueden darse varios casos al leer un Pokémon
    *Primer Caso: Leemos un básico, estos Pokémones suelen tener comunmente 2 evoluciones más, aunque hay casos que tienen 1 más, o ninguna.
    *Segundo Caso : El pokemon se encuentra en 1ra etapa evolutiva, este tendría una pre-evolución y una etapa final.
    *Tercer Caso: El pokémon se encuentra en etapa final, tiene una etapa inicial y una pre-evolución.
    */

   if (etapaPokemon.equals("Basico")) {

    String primeraEvolucion = reg1.getString();
    primeraEvolucion=primeraEvolucion.trim();
    String segundaEvolucion=reg1.getString();
    segundaEvolucion=segundaEvolucion.trim();
    String tipo1 = reg1.getString();
    tipo1=tipo1.trim();
    String tipo2 = reg1.getString();
    if (tipo2 == null) {
     tipo1 = segundaEvolucion;
     tipo2 = tipo1;
     segundaEvolucion=null;
     tipo2=tipo2.trim();

    }
    pokemonaux=new Basico(idPokemons,nombrePokemon,etapaPokemon,tipo1,tipo2,primeraEvolucion,segundaEvolucion);
    listaPokemons.agregarPokemon(pokemonaux);

   }
   //En caso de que sea la Primera Evolución
   if (etapaPokemon.equals("Primera Evolucion")) {

    String siguienteEvolucion = reg1.getString();
    siguienteEvolucion = siguienteEvolucion.trim();

    String anteriorEvolucion = reg1.getString();
    anteriorEvolucion = anteriorEvolucion.trim();

    String tipo1 = reg1.getString();
    tipo1=tipo1.trim();
    String tipo2 = reg1.getString();
    if (tipo2 == null) {
     tipo2=tipo1;
     tipo1 = anteriorEvolucion;
     anteriorEvolucion = siguienteEvolucion;
     tipo2=tipo2.trim();
     siguienteEvolucion=null;
    }

    pokemonaux =new PrimeraEvolucion(idPokemons,nombrePokemon,etapaPokemon,tipo1,tipo2,anteriorEvolucion,siguienteEvolucion);
    listaPokemons.agregarPokemon(pokemonaux);

   }

   if (etapaPokemon.equals("Segunda Evolucion")) {

    String primeraEvolucion = reg1.getString();
    primeraEvolucion=primeraEvolucion.trim();
    String basico = reg1.getString();
    basico = basico.trim();

    String tipo1 = reg1.getString();
    tipo1=tipo1.trim();
    String tipo2 = reg1.getString();
    if (tipo2 == null) {
     primeraEvolucion = basico;
     tipo1 = basico;
     tipo2 = tipo1;
     tipo2=tipo2.trim();
    }
    pokemonaux=new SegundaEvolucion(idPokemons,nombrePokemon,etapaPokemon,tipo1,tipo2,basico,primeraEvolucion);
    listaPokemons.agregarPokemon(pokemonaux);

   }

  }

 }
}
