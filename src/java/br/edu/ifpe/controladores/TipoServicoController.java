/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controladores;

import br.edu.ifpe.negocio.TipoServico;
import br.edu.ifpe.persistencia.comportamentos.RepositorioGenerico;
import br.edu.ifpe.persistencia.implementacoes.FactoryRepositorios;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Thais
 */
@ManagedBean
@SessionScoped
public class TipoServicoController {
    RepositorioGenerico<TipoServico, Integer> repositorioTipoServico= null;
    
    public TipoServicoController(){
        this.repositorioTipoServico = FactoryRepositorios.fabricarRepositorio(FactoryRepositorios.TIPOSERVICO, FactoryRepositorios.BANCODADOS);
    }
    
    public String inserir(TipoServico t){
        this.repositorioTipoServico.inserir(t);
        return "index.html";
    }
     public void alterar(TipoServico tipoAnimal) {
        this.repositorioTipoServico.alterar(tipoAnimal);
    }

    public TipoServico recuperarTipoServico(int codigo) {
        return this.repositorioTipoServico.recuperar(codigo);
    }

    public void excluir(TipoServico tipoAnimal) {
        this.repositorioTipoServico.excluir(tipoAnimal);
    }

    public List<TipoServico> recuperarTodosTipoServico() {
        return this.repositorioTipoServico.recuperarTodos();
    }
}
