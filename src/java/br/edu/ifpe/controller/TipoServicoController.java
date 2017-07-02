/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.model.TipoServico;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.dao.FactoryRepositorios;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thais
 */
@ManagedBean
@SessionScoped
public class TipoServicoController {
    RepositorioGenerico<TipoServico, Integer> repositorioTipoServico= null;
    private TipoServico selected = null;
   

    public TipoServico getSelected() {
        return selected;
    }

    public void setSelected(TipoServico selected) {
        this.selected = selected;
    }
    
    public TipoServicoController(){
        this.repositorioTipoServico = FactoryRepositorios.fabricarRepositorio(FactoryRepositorios.TIPOSERVICO, FactoryRepositorios.BANCODADOS);
    }
    
    public String inserir(TipoServico t){
        this.repositorioTipoServico.inserir(t);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de serviço cadastrado com sucesso!"));
        return "ApresentarTipoServico.xhtml";
    }
    
    public String alterar(TipoServico t) {
        this.repositorioTipoServico.alterar(t);
        return "ApresentarTipoServico.xhtml";
     }
    
    public TipoServico recuperarTipoServico(int codigo) {
        return this.repositorioTipoServico.recuperar(codigo);
    }

    public void excluir(TipoServico t) {
        this.repositorioTipoServico.excluir(t);
    }
        
       public List<TipoServico> recuperarTodosTipoServico() {
        return this.repositorioTipoServico.recuperarTodos();
    }
}
