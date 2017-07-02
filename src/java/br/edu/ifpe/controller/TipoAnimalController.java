/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.model.TipoAnimal;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.dao.FactoryRepositorios;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 1860915
 */

@ManagedBean
@SessionScoped
public class TipoAnimalController {
    
    RepositorioGenerico<TipoAnimal, Integer> repositorioTipoAnimal = null;
    
    public TipoAnimalController(){
        this.repositorioTipoAnimal = FactoryRepositorios.fabricarRepositorio(
                FactoryRepositorios.TIPOANIMAL, FactoryRepositorios.BANCODADOS);
    }
    
     public String inserir(TipoAnimal tipoAnimal) {
        this.repositorioTipoAnimal.inserir(tipoAnimal);
        
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O Tipo Animal foi criado com sucesso!"));
        
        return "index.xhtml";
    }

    public void alterar(TipoAnimal tipoAnimal) {
        this.repositorioTipoAnimal.alterar(tipoAnimal);
    }

    public TipoAnimal recuperarTipoAnimal(int codigo) {
        return this.repositorioTipoAnimal.recuperar(codigo);
    }

    public void excluir(TipoAnimal tipoAnimal) {
        this.repositorioTipoAnimal.excluir(tipoAnimal);
    }

    public List<TipoAnimal> recuperarTodosTipoAnimal() {
        return this.repositorioTipoAnimal.recuperarTodos();
    }
    
}
