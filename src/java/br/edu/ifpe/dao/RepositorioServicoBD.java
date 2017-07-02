/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.dao;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.model.Servico;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.model.Servico;
import br.edu.ifpe.model.Servico;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioServicoBD implements RepositorioGenerico<Servico, Integer>{

    @Override
    public void inserir(Servico t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Servico t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Servico recuperar(Integer g) {
        try{
           return (Servico) DaoManagerHiber.getInstance().recover("from Servico where codigo="+g);
        }catch
                (IndexOutOfBoundsException e){
            return null;
            
        }
    }

    @Override
    public void excluir(Servico t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Servico> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Servico");
    }
    
}
