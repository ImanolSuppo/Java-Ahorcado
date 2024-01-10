package ar.edu.utn.frc.tup.lciii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ahorcado {

    private Scanner scanner;
    private Jugador jugador;
    private Integer puntajePartida;
    private List<Character> letrasUsadas;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Integer getPuntajePartida() {
        return puntajePartida;
    }

    public void setPuntajePartida(Integer puntajePartida) {
        this.puntajePartida = puntajePartida;
    }

    public Ahorcado() {
        this.scanner = new Scanner(System.in);
        this.jugador = new Jugador();
        this.puntajePartida = 0;
    }

    public void bienvenida() {
        System.out.println("------------------------------------");
        System.out.println("---------Welcome to Ahorcado---------");
        System.out.println("------------------------------------");
    }

    /**
     * Este metodo gestiona todo el proiceso de pedir los datos al jugador
     * y retornarlos al programa principal para poder Jugar
     *
     */
    public void cargarJugador() {
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        jugador.setNombre(nombre);
    }

    /**
     * Este metodo gestiona todo el proceso de pedir una letra al jugador,
     * validar que la entrada por panatañña sea una correcta y retornar
     * dicha entrada como un Character de Java.
     * @return el caracter ingresado por usuario
     */
    public Character pedirLetra() {
        Character letra = null;
        do {
            System.out.println(jugador.getNombre() + " ingrese una letra");
            String input = scanner.nextLine();
            if(validarInputLetra(input)) {
                letra = getCharacterFromInput(input);
            } else {
                System.out.println("-------------ERROR-------------");
            }
        } while (letra == null);
        return letra;
    }

    public void addPuntajePartida(Integer puntosJuego) {
        jugador.aumentarPuntos(puntosJuego);
    }

    /**
     * Este metodo retorna el string de input como un caracter que representa una letra
     * del idioma español en mayusculas.
     *
     * @param input
     * @return el caracter ingresado por usuario
     */
    private Character getCharacterFromInput(String input) {
        char[] inputChar = input.toCharArray();
        return inputChar[0];
    }

    /**
     * Este metodo retorna true si el input leido de scanner es traducible a una letra
     * del idioma español.
     * @param input
     * @return true si la entrda fue apropiada, o false si no lo fue
     */
    private Boolean validarInputLetra(String input) {
        if (input.length() == 1) {
            if(!letrasUsadas.contains(getCharacterFromInput(input))){
                letrasUsadas.add(getCharacterFromInput(input));
                return true;
            }
            else
                System.out.println("Esta letra ya fue elegida");
        }
        else
            System.out.println("Usted no ingresó una letra");
        return false;
    }

    /**
     * Este metodo gestiona todo el proceso para preguntar si se desea volver a jugar, si es así, retorna true
     * sino, retorna false
     *
     * @return la seleccion del jugador de volver a jugar
     */
    public Boolean getPlayAgain() {
        int playAgain = -1;
        do {
            System.out.println("Desea jugar de nuevo? (1: SI | 2: NO)");
            String validar = scanner.nextLine();
            if(isNumeric(validar))
                playAgain = Integer.parseInt(validar);
        } while (playAgain != 1 && playAgain != 0);
        return playAgain == 1 ? true : false;
    }
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    /**
     * Este metodo gestiona el proceso de despedia de la partida, muestra los puntajes y partidas jugadas
     * (ganadas y perdidas) y termina la aplicación.
     */
    public void despedida() {
        System.out.println("-------------------------------");
        System.out.println("Puntos: "+jugador.getPuntos());
        System.out.println("Partidas ganadas: "+jugador.getPartidasGanadas());
        System.out.println("Partidas perdidas: "+jugador.getPartidasPerdidas());
        System.out.println("-------------------------------");
    }

    public void addPartida(boolean partida) {
        if(partida)
            jugador.aumentarPartidasGanadas();
        else
            jugador.aumentarPartidasPerdidas();
    }

    public void reiniciar() {
        letrasUsadas = new ArrayList<>();
    }
}
