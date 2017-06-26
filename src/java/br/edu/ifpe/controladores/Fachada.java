/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controladores;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.negocio.Cliente;
import br.edu.ifpe.negocio.Pet;
import br.edu.ifpe.negocio.Servico;
import br.edu.ifpe.negocio.TipoAnimal;
import br.edu.ifpe.persistencia.comportamentos.RepositorioGenerico;
import br.edu.ifpe.persistencia.implementacoes.FactoryRepositorios;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class Fachada {

    private static Fachada myself = null;

    private RepositorioGenerico<TipoAnimal, Integer> repositorioTipoAnimal = null;
    private RepositorioGenerico<Cliente, Integer> repositorioCliente = null;
    private RepositorioGenerico<Pet, Integer> repositorioPet = null;
    private RepositorioGenerico<Servico, Integer> repositorioServico = null;

    private Fachada() {
        this.repositorioTipoAnimal = FactoryRepositorios.fabricarRepositorio(
                FactoryRepositorios.TIPOANIMAL, FactoryRepositorios.MEMORIA);
        this.repositorioPet = FactoryRepositorios.fabricarRepositorio(
                FactoryRepositorios.PET, FactoryRepositorios.MEMORIA);
        this.repositorioCliente = FactoryRepositorios.fabricarRepositorio(
                FactoryRepositorios.CLIENTE, FactoryRepositorios.MEMORIA);
        this.repositorioServico = FactoryRepositorios.fabricarRepositorio(
                FactoryRepositorios.SERVICO, FactoryRepositorios.MEMORIA);
        this.repositorioTipoAnimal = FactoryRepositorios.fabricarRepositorio(FactoryRepositorios.TIPOANIMAL, FactoryRepositorios.BANCODADOS);
        this.repositorioCliente = FactoryRepositorios.fabricarRepositorio(FactoryRepositorios.CLIENTE, FactoryRepositorios.BANCODADOS);
        this.repositorioPet = FactoryRepositorios.fabricarRepositorio(FactoryRepositorios.PET, FactoryRepositorios.BANCODADOS);
        this.repositorioServico = FactoryRepositorios.fabricarRepositorio(FactoryRepositorios.SERVICO, FactoryRepositorios.BANCODADOS);

    }

    public static Fachada getInstance() {
        if (myself == null) {
            myself = new Fachada();
        }
        return myself;
    }

    public void inserir(TipoAnimal tipoAnimal) {
        this.repositorioTipoAnimal.inserir(tipoAnimal);
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

    public void inserir(Pet pet) {
        this.repositorioPet.inserir(pet);
    }

    public void alterar(Pet pet) {
        this.repositorioPet.alterar(pet);
    }

    public Pet recuperarPet(int codigo) {
        return this.repositorioPet.recuperar(codigo);
    }

    public void excluir(Pet pet) {
        this.repositorioPet.excluir(pet);
    }

    public List<Pet> recuperarTodosPet() {
        return this.repositorioPet.recuperarTodos();
    }

    public void inserir(Servico servico) {
        this.repositorioServico.inserir(servico);
    }

    public void alterar(Servico servico) {
        this.repositorioServico.alterar(servico);
    }

    public Servico recuperarServico(int codigo) {
        return this.repositorioServico.recuperar(codigo);
    }

    public void excluir(Servico servico) {
        this.repositorioServico.excluir(servico);
    }

    public List<Servico> recuperarTodosServico() {
        return this.repositorioServico.recuperarTodos();
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

    public void inserirPetBD(Pet t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    public void alterarPetBD(Pet t) {
        DaoManagerHiber.getInstance().update(t);
    }

    public Pet recuperarPetBD(Integer g) {
        try {
            return (Pet) DaoManagerHiber.getInstance().recover("from Pet where codigo=" + g).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void excluirPetBD(Pet t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    public List<Pet> recuperarTodosPetBD() {
        return DaoManagerHiber.getInstance().recover("from pet");
    }

    public void inserirClienteBD(Cliente t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    public void alterarClienteBD(Cliente t) {
        DaoManagerHiber.getInstance().update(t);
    }

    public Cliente recuperarClienteBD(Integer g) {
        try {
            return (Cliente) DaoManagerHiber.getInstance().recover("from Cliente where cpf=" + g);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void excluirClienteBD(Cliente t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    public List<Cliente> recuperarTodosClienteBD() {
        return DaoManagerHiber.getInstance().recover("from Cliente");
    }

    public void inserirServicoBD(Servico t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    public void alterarServicoBD(Servico t) {
        DaoManagerHiber.getInstance().update(t);
    }

    public Servico recuperarServicoBD(Integer g) {
        try {
            return (Servico) DaoManagerHiber.getInstance().recover("from Servico where codigo=" + g);
        } catch (IndexOutOfBoundsException e) {
            return null;

        }
    }

    public void excluirServicoBD(Servico t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    public List<Servico> recuperarTodosServicoBD() {
        return DaoManagerHiber.getInstance().recover("from Servico");
    }

    public void inserirTipoAnimalBD(TipoAnimal t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    public void alterarTipoAnimalBD(TipoAnimal t) {
        DaoManagerHiber.getInstance().update(t);
    }

    public TipoAnimal recuperarTipoAnimalBD(Integer g) {
        try {
            return (TipoAnimal) DaoManagerHiber.getInstance().recover("from TipoAnimal where codigo=" + g);
        } catch (IndexOutOfBoundsException e) {
            return null;

        }
    }

    public void excluirTipoAnimalBD(TipoAnimal t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    public List<TipoAnimal> recuperarTodosTipoAnimalBD() {
        return DaoManagerHiber.getInstance().recover("from TipoAnimal");
    }

    
}
