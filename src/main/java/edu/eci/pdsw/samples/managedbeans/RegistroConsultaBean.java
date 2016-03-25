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
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name="beanRegistroConsulta")
@SessionScoped

public class RegistroConsultaBean{
    
    private ServiciosPacientes sp=ServiciosPacientes.getInstance();
    private Paciente pacienteConsulta;
    private String nombrePaciente="";
    private int id = 0;
    private String tipoId="";
    private Date fechaPaciente= null;
    private String resumenConsul="";
    private List<Consulta> consultasPaciente = new ArrayList<>();
    private List<Paciente> pacientes = sp.getPacientes();
    
    public void setPacienteConsulta(Paciente p){
        pacienteConsulta=p;
    }
    
    public Paciente getPacienteConsulta(){
        return pacienteConsulta;
    }
    
    public List<Paciente> getPacientes() {
        pacientes=sp.getPacientes();
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    private Date fechaConsul= null;
    
    public void agregarPaciente()throws ExcepcionServiciosPacientes{
        try{
            Paciente paciente1 = new Paciente(id,tipoId,nombrePaciente,fechaPaciente);
            sp.registrarNuevoPaciente(paciente1);
        }
        catch(ExcepcionServiciosPacientes e){
            e.printStackTrace();
        }
    }
    
    public void agregarConsulta() throws ExcepcionServiciosPacientes{
        try{
            sp.agregarConsultaAPaciente(pacienteConsulta.getId(), pacienteConsulta.getTipo_id(), new Consulta(new java.sql.Date( fechaConsul.getTime()), resumenConsul));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public Date getFechaConsul() {
        return fechaConsul;
    }

    public void setFechaConsul(Date fechaConsul) {
        this.fechaConsul = fechaConsul;
    }

    public List<Consulta> getConsultasPaciente() {
        consultasPaciente.clear();
        //System.out.println("El paciente de consulta es: "+pacienteConsulta.toString());
        for (Consulta consulta : pacienteConsulta.getConsultas()) {
            consultasPaciente.add(consulta);
        }
        return consultasPaciente;
    }

    public void setConsultasPaciente(List<Consulta> consultasPaciente) {
        this.consultasPaciente = consultasPaciente;
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

    public void setId(int id) {;
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

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setPacienteConsulta() {
        this.pacienteConsulta= new Paciente(id, tipoId, nombrePaciente, fechaPaciente);
    }

    
}
