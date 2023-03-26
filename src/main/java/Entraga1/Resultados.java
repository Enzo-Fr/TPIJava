/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Entraga1;

/**
*
* @author EnzoFr
*/
public class Resultados {
  private String equipo1;
  private String equipo2;
  private int gEquipo1;
  private int gEquipo2;
  
  public Resultados() {
  }

  public Resultados(String equipo1, String equipo2, int gEquipo1, int gEquipo2) {
    this.equipo1 = equipo1;
    this.equipo2 = equipo2;
    this.gEquipo1 = gEquipo1;
    this.gEquipo2 = gEquipo2;
  }

  public String getEquipo1() {
    return equipo1;
  }

  public void setEquipo1(String equipo1) {
    this.equipo1 = equipo1;
  }

  public String getEquipo2() {
    return equipo2;
  }

  public void setEquipo2(String equipo2) {
    this.equipo2 = equipo2;
  }

  public int getgEquipo1() {
    return gEquipo1;
  }

  public void setgEquipo1(int gEquipo1) {
    this.gEquipo1 = gEquipo1;
  }

  public int getgEquipo2() {
    return gEquipo2;
  }

  public void setgEquipo2(int gEquipo2) {
    this.gEquipo2 = gEquipo2;
  }
  
  public int partidoResultado() {
    if (gEquipo1>gEquipo2) {
      return 1;
    }else if (gEquipo2>gEquipo1) {
      return 2;
    } else {
      return 0;
    }
  }
  
}
