/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.model.TipoServico;
import br.edu.ifpe.model.TipoServico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Thais
 */
@ManagedBean
@RequestScoped
public class BuilderTipoServico {
    
    private int codigo;
    
    private String tipo;
    
    private double valor;
    
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoServico buildTipoServico(){
        return new TipoServico(codigo, tipo, valor, descricao);
    }
}


