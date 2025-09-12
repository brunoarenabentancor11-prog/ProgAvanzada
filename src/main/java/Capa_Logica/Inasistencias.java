/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import java.util.Date;

/**
 *
 * @author bruno
 */
public class Inasistencias {
    private int iD;
    private Date fechaInicio;
    private Date fechaFin;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }
    
    
    
    
      public Date getfechaInicio(){
        return fechaInicio;
    }
    
    public void setfechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
    }  
    
    
      public Date getfechaFin(){
        return fechaFin;
    }
    
    public void setfechaFin(Date fechaFin){
        this.fechaFin = fechaFin;
    }     
}
