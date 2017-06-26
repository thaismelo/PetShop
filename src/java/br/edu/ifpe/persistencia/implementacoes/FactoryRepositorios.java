/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.persistencia.implementacoes;

import br.edu.ifpe.persistencia.comportamentos.RepositorioGenerico;

/**
 *
 * @author 1860915
 */
public class FactoryRepositorios {

    public static final int TIPOANIMAL = 1;
    public static final int TIPOSERVICO = 2;
    public static final int SERVICO = 3;
    public static final int PET = 4;
    public static final int CLIENTE = 5;
    public static final int BANCODADOS = 1;
    public static final int MEMORIA = 2;

    public static RepositorioGenerico fabricarRepositorio(int tipoNegocio, int tipoPersistencia) {
        if (tipoPersistencia == MEMORIA) {
            switch (tipoNegocio) {
                case TIPOANIMAL:
                    return new RepositorioTipoAnimalImplMEMO();
                case PET:
                    return null;
                case SERVICO:
                    return null;
                case CLIENTE:
                    return null;
                default:
                    break;
            }
        } else if (tipoPersistencia == BANCODADOS) {
            switch (tipoNegocio) {
                case TIPOANIMAL:
                    return new RepositorioTipoAnimalBD();
                case PET:
                    return new RepositorioPetBD();
           
                case SERVICO:
                    return new RepositorioServicoBD();
                case CLIENTE:
                    return new RepositorioClienteBD();
                    
                case TIPOSERVICO:
                    return new RepositorioTipoServicoBD();
                default:
                    break;
            }
        }
        return null;
    }
}
