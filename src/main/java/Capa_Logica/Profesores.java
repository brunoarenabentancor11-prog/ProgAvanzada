/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Profesores {
  
  public ArrayList<Profesor> profesores = new ArrayList<>();
  
  public  void agregarProfesor (Profesor profesor) {
      profesores.add(profesor);
  }

    public ArrayList<Profesor> getProfesor() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }
      
}
