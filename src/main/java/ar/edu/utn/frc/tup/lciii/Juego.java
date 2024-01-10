package ar.edu.utn.frc.tup.lciii;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private static PalabrasService palabrasService = new PalabrasService();

    private String palabraEnJuego;
    private String palabraModoOculto;
    private List<Character> letrasElegidas;
    private Integer vidasJugador;
    private Integer puntosJuego;

    public String getPalabraEnJuego() {
        return palabraEnJuego;
    }

    public void setPalabraEnJuego(String palabraEnJuego) {
        this.palabraEnJuego = palabraEnJuego;
    }

    public void setPalabraModoOculto(String palabraModoOculto) {
        this.palabraModoOculto = palabraModoOculto;
    }

    public List<Character> getLetrasElegidas() {
        return letrasElegidas;
    }

    public void setLetrasElegidas(List<Character> letrasElegidas) {
        this.letrasElegidas = letrasElegidas;
    }

    public Integer getVidasJugador() {
        return vidasJugador;
    }

    public void setVidasJugador(Integer vidasJugador) {
        this.vidasJugador = vidasJugador;
    }

    public Integer getPuntosJuego() {
        if (vidasJugador != 0){
            puntosJuego = 10 + palabraEnJuego.length() * 2 - (6 - vidasJugador);
        }
        else {
            char[] palabraEnJuegoChar = palabraEnJuego.toCharArray();
            for (char letra:letrasElegidas) {
                if(palabraEnJuegoChar.equals(letra))
                    puntosJuego += 2;
            }
            puntosJuego -= 6;
        }
        return puntosJuego;
    }

    public void setPuntosJuego(Integer puntosJuego) {
        this.puntosJuego = puntosJuego;
    }

    public Juego() {
        this.letrasElegidas = new ArrayList<>();
        this.palabraEnJuego = palabrasService.getPalabra();
        this.palabraModoOculto = this.getPalabraModoOculto(palabraEnJuego);
        this.vidasJugador = 6;
        this.puntosJuego = 0;
    }

    public void addLetra(Character letra) {
        boolean encontroLetra = false;
        letrasElegidas.add(letra);
        char[] palabraEnLetras = palabraEnJuego.toCharArray();
        for (int i = 0; i < palabraEnJuego.length(); i++) {
            if (letra.equals(palabraEnLetras[i]))
                encontroLetra = true;
        }
        if (!encontroLetra)
            vidasJugador--;
    }

    /**
     * Este metodo debe verificar si el juego termnó porque ganó el jugador o porque se acabaron las vidas.
     * Cuando se lo llama y el juego no terminó, debe descontar las vidas y calcular el puntaje de este juego.
     *
     * @return si el juego ha terminado o no
     */
    public Boolean calcularEstadoDelJuego() {
        if(vidasJugador != 0){
            char[] palabraEnJuegoChar = palabraEnJuego.toCharArray();
            for (char letra:palabraEnJuegoChar) {
                if(!getLetrasElegidas().contains(letra))
                    return false;
            }
        }
        System.out.println("----------------GAME OVER----------------");
        if(vidasJugador == 0)
            System.out.println("Perdiste :(");
        else
            System.out.println("Ganaste :D");
        System.out.println("-----------------------------------------");
        return true;
    }

    /**
     * Este metodo genera la palabra en modo oculto, es decir, muestra las
     * letras encontradas, sino, muestra guones bajos
     *
     * @return La palabra en juego en modo oculto
     */
    public String getPalabraModoOculto(String palabra) {
        palabraModoOculto = "";
        char[] palabraEnJuegoChar = palabra.toCharArray();
        for (int i = 0; i < palabra.length(); i++) {
            if(letrasElegidas.contains(palabraEnJuegoChar[i]))
                palabraModoOculto += palabraEnJuegoChar[i];
            else
                palabraModoOculto += "_";
        }
        return palabraModoOculto;
    }

    /**
     * Este metodo dibuja el juego por cada iteracion, es decir, pinta la palabra oculta
     * con sus espacios en blanco (guiones bajos) y sus espacios ocupados por las letras ya elegidas;
     * y el resto de la informacion referente al juego, cantidad de vidas que restan por ejemplo.
     *
     */
    public void dibujar() {
        System.out.println(getPalabraModoOculto(palabraEnJuego));
        System.out.println("Vidas: " + vidasJugador);
    }

    public boolean getPartida() {
        if(vidasJugador == 0)
            return false;
        return true;
    }
}
