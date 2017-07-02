/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.model.TipoAnimal;
import br.edu.ifpe.model.TipoAnimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 1860915
 */
@ManagedBean(name="bTipoAnimal")
@RequestScoped
public class BuilderTipoAnimal {
     
    private int codigo;
    
    private String tipo;
   
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public TipoAnimal buildTipoAnimal(){
        return new TipoAnimal(codigo, tipo, descricao);
    }
}
