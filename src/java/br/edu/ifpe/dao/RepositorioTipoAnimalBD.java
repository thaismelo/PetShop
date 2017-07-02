/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.dao;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.model.TipoAnimal;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.model.TipoAnimal;
import br.edu.ifpe.model.TipoAnimal;
import java.util.List;

/**
 *
 * @author 20141D12GR0211
 */
public class RepositorioTipoAnimalBD implements RepositorioGenerico<TipoAnimal, Integer>{

    @Override
    public void inserir(TipoAnimal t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(TipoAnimal t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public TipoAnimal recuperar(Integer g) {
        try{
           
            return (TipoAnimal) ((List<TipoAnimal>)DaoManagerHiber.getInstance().recover("from TipoAnimal where codigo="+g)).get(0);
        }catch
            (IndexOutOfBoundsException e){
            return null;
                
            }
        }

    @Override
    public void excluir(TipoAnimal t) {
        DaoManagerHiber.getInstance().delete(t);
        }

    @Override
    public List<TipoAnimal> recuperarTodos() {
      return  DaoManagerHiber.getInstance().recover("from TipoAnimal");
    }

    
}
