/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.model.Cliente;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.dao.FactoryRepositorios;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 1860915
 */
@ManagedBean
@SessionScoped
public class ClienteController {
    
    RepositorioGenerico<Cliente, Integer> repositorioCliente  = null;
    
    public ClienteController(){
        this.repositorioCliente = FactoryRepositorios.fabricarRepositorio(
                FactoryRepositorios.CLIENTE, FactoryRepositorios.BANCODADOS);
    }
    
     public void inserir(Cliente cliente) {
        this.repositorioCliente.inserir(cliente);
    }

    public void alterar(Cliente cliente) {
        this.repositorioCliente.alterar(cliente);
    }

    public Cliente recuperarCliente(int codigo) {
        return this.repositorioCliente.recuperar(codigo);
    }

    public void excluir(Cliente cliente) {
        this.repositorioCliente.excluir(cliente);
    }

    public List<Cliente> recuperarTodosCliente() {
        return this.repositorioCliente.recuperarTodos();
    }
    
}
