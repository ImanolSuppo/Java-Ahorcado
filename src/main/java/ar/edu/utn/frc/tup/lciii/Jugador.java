package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

public class Jugador {

    private String nombre;
    private int puntos;
    private int partidasGanadas;

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    private int partidasPerdidas;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) { this.nombre = nombre;}
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) { this.puntos = puntos;}
    public int getPartidasGanadas() {
        return partidasGanadas;
    }
    public void setPartidasGanadas(int partidasGanadas) { this.partidasGanadas = partidasGanadas;}

    public Jugador() {
        nombre = "";
        puntos = 0;
        partidasGanadas =0 ;
        partidasPerdidas =0;
    }
    public Jugador(String nombre, int puntos, int partidasGanadas, int partidasPerdidas){
        this.nombre=nombre;
        this.puntos=puntos;
        this.partidasGanadas=partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
    }
    public void aumentarPuntos(int puntos){
        this.puntos += puntos;
    }
    public void aumentarPartidasGanadas(){
        partidasGanadas++;
    }

    public void aumentarPartidasPerdidas() {
        partidasPerdidas--;
    }
}
