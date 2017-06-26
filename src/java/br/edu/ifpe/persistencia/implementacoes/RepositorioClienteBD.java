/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.persistencia.implementacoes;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.negocio.Cliente;
import br.edu.ifpe.persistencia.comportamentos.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioClienteBD implements RepositorioGenerico<Cliente, Integer>{

    @Override
    public void inserir(Cliente t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Cliente t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Cliente recuperar(Integer g) {
        try{
            return (Cliente) DaoManagerHiber.getInstance().recover("from Cliente where codigo="+g);
            }catch
                    (IndexOutOfBoundsException e){
                return null;
    }
}

    @Override
    public void excluir(Cliente t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Cliente");
    }
    
}
