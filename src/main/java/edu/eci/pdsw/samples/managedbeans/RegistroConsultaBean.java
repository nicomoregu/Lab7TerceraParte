/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean
@SessionScoped
public class RegistroConsultaBean implements Serializable{
    
    private ServiciosPacientes sp=ServiciosPacientes.getInstance();
    private Paciente pacienteConsulta = new Paciente(123, "CC", "Juan Perez", java.sql.Date.valueOf("2000-01-01"));
    private String nombrePaciente="";
    private int id=0;
    private String tipoId="";
    private Date fechaPaciente=null;
    private String resumenConsul="";
    private List<Consulta> consultasPaciente = new ArrayList<>();
    private Date fechaConsul=null;
    
    public void agregarConsulta() throws ExcepcionServiciosPacientes{
        try{
            sp.agregarConsultaAPaciente(id, tipoId, new Consulta(fechaConsul, resumenConsul));
            System.out.println("agrego consulta");
        }catch (EnumConstantNotPresentException e){
            
        }
        this.getConsultasPaciente();
    }
    
    public Date getFechaConsul() {
        return fechaConsul;
    }

    public void setFechaConsul(Date fechaConsul) {
        this.fechaConsul = fechaConsul;
    }

    public List<Consulta> getConsultasPaciente() {
        Iterator iterador = pacienteConsulta.getConsultas().iterator();
        consultasPaciente.clear();
        while(iterador.hasNext()){
            consultasPaciente.add((Consulta)iterador.next());
        }
        return consultasPaciente;
    }

    public void setConsultasPaciente(List<Consulta> consultasPaciente) {
        this.consultasPaciente = consultasPaciente;
    }

    public ServiciosPacientes getSp() {
        return sp;
    }

    public void setSp(ServiciosPacientes sp) {
        this.sp = sp;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public Date getFechaPaciente() {
        return fechaPaciente;
    }

    public void setFechaPaciente(Date fechaPaciente) {
        this.fechaPaciente = fechaPaciente;
    }

    public String getResumenConsul() {
        return resumenConsul;
    }

    public void setResumenConsul(String resumenConsul) {
        this.resumenConsul = resumenConsul;
    }

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public Paciente getPacienteConsulta() {
        return pacienteConsulta;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setPacienteConsulta() {
        this.pacienteConsulta= new Paciente(id, tipoId, nombrePaciente, fechaPaciente);
    }

    
}
