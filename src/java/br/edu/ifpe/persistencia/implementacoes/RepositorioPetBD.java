/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.persistencia.implementacoes;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.negocio.Pet;
import br.edu.ifpe.persistencia.comportamentos.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author 20141D12GR0211
 */
public class RepositorioPetBD implements RepositorioGenerico<Pet, Integer>{

    @Override
    public void inserir(Pet t) {
        DaoManagerHiber.getInstance().persist(t);
        }

    @Override
    public void alterar(Pet t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Pet recuperar(Integer g) {
       try{
        return (Pet)DaoManagerHiber.getInstance().recover("from Pet where codigo=" +g).get(0);
    }catch(IndexOutOfBoundsException e){
        return null;
    }
    }

    @Override
    public void excluir(Pet t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Pet> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from pet");
    }
    
}
