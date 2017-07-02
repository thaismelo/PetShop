/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.dao;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.model.TipoServico;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.model.TipoServico;
import br.edu.ifpe.model.TipoServico;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioTipoServicoBD implements RepositorioGenerico<TipoServico, Integer>{
    
    @Override
    public void inserir(TipoServico t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(TipoServico t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public TipoServico recuperar(Integer g) {
        try{
            return (TipoServico)DaoManagerHiber.getInstance().recover("from TipoServico where codigo="+g).get(0);
        }catch(IndexOutOfBoundsException in){
            return null;
        }
    }

    @Override
    public void excluir(TipoServico t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<TipoServico> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from TipoServico");
    }

}
