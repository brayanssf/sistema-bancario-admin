/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.GerenteDao;
import com.unincor.sistema.bancario.admin.model.domain.Gerente;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class GerenteService {
    
    private final GerenteDao gerenteDao = new GerenteDao();
    
    public void salvarGerente(Gerente gerente) throws CadastroException {
        if (gerente.getNome() == null || gerente.getNome().isBlank()) {
            throw new CadastroException("O gerente deve possuir um nome!");
        }
        if (gerente.getCpf() == null || gerente.getCpf().isBlank()) {
            throw new CadastroException("O gerente deve possuir um CPF!");
        }
        
        gerenteDao.inserir(gerente);
    }
    
    public List<Gerente> buscarGerentes() {
        return gerenteDao.buscarTodosGerentes();
    }
    
}
