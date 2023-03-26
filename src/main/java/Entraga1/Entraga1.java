/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Entraga1;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
*
* @author EnzoFr
*/
public class Entraga1 {
  
  /**
  * @param args the command line arguments
  */
  
  public static void main(String[] args) throws IOException {
    int cont=0;
    ArrayList<Pronostico> pronosticos = new ArrayList<>();
    ArrayList<Resultados> resultados = new ArrayList<>();
    pronosticos=obtrenerPronostico();
    resultados=obtrenerResultados();
    int tam= pronosticos.size()/resultados.size();
    
    int k=0;
    for (int i = 1; i <= tam; i++) {
      for (int j=k ; j < (resultados.size()+k); j++) {
        if (resultados.get(j-k).partidoResultado()==pronosticos.get(j).getPronostico()) {
          cont=cont+1;
        }
      }
      System.out.println("la puntuacion de "+pronosticos.get(k).getNombre()+" puntuacion es de: "+cont);
      cont=0;
      k=k+resultados.size();
    }
    
  }
  //funcion que optiene los resultados de un archivo CSV ,los ajusta a la class y luego lo retorna en un arrayList
  public static  ArrayList<Resultados> obtrenerResultados() throws NumberFormatException, IOException {
    ArrayList<Resultados> resultado = new ArrayList<>();
    String[] lin;
    List<String> lineas = Files.readAllLines(Paths.get("src/main/java/Entraga1/resultado.csv"));
    for (int i = 1; i < lineas.size(); i++){
      Resultados aux = new Resultados();
      lin=lineas.get(i).split(",");
      aux.setEquipo1(lin[1]);
      aux.setgEquipo1(Integer.parseInt(lin[2]));
      aux.setgEquipo2(Integer.parseInt(lin[3]));
      aux.setEquipo2(lin[4]);
      resultado.add(aux);
    }
    return resultado;
  }
  //Funcion que optiene los pronosticos de un archivo CSV ,los ajusta a la class y luego lo retorna en un arrayList
  public static  ArrayList<Pronostico> obtrenerPronostico() throws NumberFormatException, IOException {
    ArrayList<Pronostico> pronostico = new ArrayList<>();
    String[] lin;
    List<String> lineas = Files.readAllLines(Paths.get("src/main/java/Entraga1/pronostico.csv"));
    for (int i = 1; i < lineas.size(); i++) {
      Pronostico aux = new Pronostico();
      lin=lineas.get(i).split(",");
      aux.setNombre(lin[0]);
      aux.setEquipo1(lin[1]);
      aux.setEquipo2(lin[5]);
      if (lin[2].equals("x")||lin[2].equals("X")) {  
        aux.setPronostico(1);
      }else if ((lin[3].equals("x")||lin[3].equals("X"))) {
        aux.setPronostico(0);
      }else if ((lin[4].equals("x")||lin[4].equals("X"))){
        aux.setPronostico(2);
      }else {
        System.out.println("el pronostico de "+aux.getEquipo1()+" vs "+aux.getEquipo2()+" , no se a encontrado");
      }
      pronostico.add(aux);
    }
    return pronostico;
  }
  //Esta funcion crea archivos CSV con valores predefinidos
  public static  void crearArchivosCSV(){
    try (FileWriter archivo = new FileWriter("src/main/java/Entraga1/resultado.csv");
    PrintWriter escritor = new PrintWriter(archivo)) {
      
      // Escribir las cabeceras de las columnas
      escritor.println("Ronda,Equipo 1,Cant. goles 1,Cant. goles 2,Equipo 2");
      
      // Escribir la información de las personas
      escritor.println("1,Argentina,1,2,Arabia Saudita");
      escritor.println("1,Polonia,0,0,Mexico");
      escritor.println("1,Argentina,2,0,Mexico");
    } catch (IOException e) {
      System.out.println("Ocurrió un error al crear el archivo.");
      e.printStackTrace();
    }
    try (FileWriter archivo = new FileWriter("src/main/java/Entraga1/Pronostico.csv");
    PrintWriter escritor = new PrintWriter(archivo)) {
      
      // Escribir las cabeceras de las columnas
      escritor.println("Nombre,Equipo 1,Gana1,Empate,Gana 2,Equipo 2");
      
      // Escribir la información de las personas
      escritor.println("Mariana,Argentina,X, , ,Arabia Saudita");
      escritor.println("Mariana,Polonia, ,X, ,Mexico");
      escritor.println("Mariana,Argentina,X, , ,Mexico");
    } catch (IOException e) {
      System.out.println("Ocurrió un error al crear el archivo.");
      e.printStackTrace();
    }
  }
}
