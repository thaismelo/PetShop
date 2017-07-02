/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.dao;

import br.edu.ifpe.model.TipoAnimal;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.dao.RepositorioGenerico;
import br.edu.ifpe.model.TipoAnimal;
import br.edu.ifpe.model.TipoAnimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class RepositorioTipoAnimalImplMEMO implements RepositorioGenerico<TipoAnimal, Integer>{

    private List<TipoAnimal> listaTipoAnimal = null;
    
    protected RepositorioTipoAnimalImplMEMO(){
        this.listaTipoAnimal = new ArrayList<>();
    }
    
    @Override
    public void inserir(TipoAnimal t) {
        this.listaTipoAnimal.add(t);
    }

    @Override
    public void alterar(TipoAnimal t) {
        
        for(TipoAnimal ta:this.listaTipoAnimal){
            
            if(ta.getCodigo()==t.getCodigo()){
                ta.setDescricao(t.getDescricao());
                ta.setTipo(t.getTipo());
                return;
            }
            
        }
        
        /*TipoAnimal ta = null;
        for(int i = 0;i<this.listaTipoAnimal.size();i++){
            ta = this.listaTipoAnimal.get(i);
            if(ta.getCodigo()==t.getCodigo()){
                ta.setDescricao(t.getDescricao());
                ta.setTipo(t.getTipo());
                return;
            }
            
        }*/
        
    }

    @Override
    public TipoAnimal recuperar(Integer g) {
        for(TipoAnimal ta:this.listaTipoAnimal){
            if(ta.getCodigo()==g){
                return ta;
            }
        }
        return null;
    }

    @Override
    public void excluir(TipoAnimal t) {
        this.listaTipoAnimal.remove(t);
    }

    @Override
    public List<TipoAnimal> recuperarTodos() {
        return this.listaTipoAnimal;
    }
    
}
