/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.negocio;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1860915
 */
@Entity
@Table
public class Servico {
    
    @Id
    @GeneratedValue
    private int codigo;
    @ManyToOne
    private Pet pet;
    @ManyToMany
    private List<TipoServico> servicos;
    @Temporal(TemporalType.DATE)
    private Date dataRealizacao;

    public Servico(int codigo, Pet pet, List<TipoServico> servicos, Date dataRealizacao) {
        this.codigo = codigo;
        this.pet = pet;
        this.servicos = servicos;
        this.dataRealizacao = dataRealizacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public Pet getPet() {
        return pet;
    }

    public List<TipoServico> getServicos() {
        return servicos;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setServicos(List<TipoServico> servicos) {
        this.servicos = servicos;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
    
    
    
}
