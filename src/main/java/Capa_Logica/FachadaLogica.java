/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import CapaPersistencia.Persistencia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bruno
 */
public class FachadaLogica {
      // Llama al método de persistencia para registrar
    public void registrarUsuario(Ingreso ing) throws Exception {
        Persistencia pers = new Persistencia();
        pers.registrar(ing);
    }

    // Llama al método de persistencia para iniciar sesión
    public boolean iniciarSesion(String ci, String contrasenia) throws Exception {
        Persistencia pers = new Persistencia();
        return pers.iniciarSesion(ci, contrasenia);
    }
    public void guardarProfesor(String ci, String nombre, String apellido, String grupo, String materia, String turno, Date fechaInicio, Date fechaFin) throws Exception {
    Persistencia pers = new Persistencia();
    pers.guardarProfesor(ci, nombre, apellido, grupo, materia, turno, fechaInicio, fechaFin);
}

    public void eliminarProfesor(String ci) throws Exception {
    Persistencia pers = new Persistencia();
    pers.eliminarProfesor(ci);
    }    
    public List<Profesor> listarProfesores() throws Exception {
    Persistencia pers = new Persistencia();
    return pers.listarProfesores();
}



    }
