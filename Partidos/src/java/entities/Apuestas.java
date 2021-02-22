/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Sara
 */
public class Apuestas {
    
    private Short glocal;
    private Short gvisitante;
    private Long cuantos;

    public Apuestas() {
    }

    public Apuestas(Short glocal, Short gvisitante, Long cuantos) {
        this.glocal = glocal;
        this.gvisitante = gvisitante;
        this.cuantos = cuantos;
    }

    public Short getGlocal() {
        return glocal;
    }

    public void setGlocal(Short glocal) {
        this.glocal = glocal;
    }

    public Short getGvisitante() {
        return gvisitante;
    }

    public void setGvisitante(Short gvisitante) {
        this.gvisitante = gvisitante;
    }

    public Long getCuantos() {
        return cuantos;
    }

    public void setCuantos(Long cuantos) {
        this.cuantos = cuantos;
    }

    @Override
    public String toString() {
        return "Apuestas{" + "glocal=" + glocal + ", gvisitante=" + gvisitante + ", cuantos=" + cuantos + '}';
    }

    
}
