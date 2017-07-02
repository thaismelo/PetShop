/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Thais
 */

@Entity
@Table(name = "tipoServico")
public class TipoServico implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="cod")
    private int codigo;
    @Column(name="tipo",length = 50)
    private String tipo;
    @Column(name="val")
    private double valor;
    @Column(name="descricao",length = 150)
    private String descricao;

    public TipoServico(int codigo, String tipo, double valor, String descricao) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }
    public TipoServico(){}
    
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
    
    
    
}
