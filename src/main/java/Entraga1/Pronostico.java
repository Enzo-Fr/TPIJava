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
public class Pronostico {
    private String Nombre;
    private String Equipo1;
    private String Equipo2;
    private int ResltPronostico;
    public Pronostico() {
    }
    public Pronostico(String nombre, String equipo1, String equipo2, int resltPronostico) {
      Nombre = nombre;
      Equipo1 = equipo1;
      Equipo2 = equipo2;
      ResltPronostico = resltPronostico;
    }
    public String getNombre() {
      return Nombre;
    }
    public void setNombre(String nombre) {
      Nombre = nombre;
    }
    public String getEquipo1() {
      return Equipo1;
    }
    public void setEquipo1(String equipo1) {
      Equipo1 = equipo1;
    }
    public String getEquipo2() {
      return Equipo2;
    }
    public void setEquipo2(String equipo2) {
      Equipo2 = equipo2;
    }
    public int getPronostico() {
      return ResltPronostico;
    }
    public void setPronostico(int resltPronostico) {
      ResltPronostico = resltPronostico;
    }
    
    

}
