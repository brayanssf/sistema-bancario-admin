/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.AgenciaDao;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan
 */
public class AgenciaService {

    private final AgenciaDao agenciaDao = new AgenciaDao();

    public void salvarAgencia(Agencia agencia) throws CadastroException {

        if (agencia.getCodigoAgencia() == null || agencia.getCodigoAgencia().isBlank()) {
            throw new CadastroException("A agência não possui um código de agência!");
        }

        // Criar uma validação se o código da agência já está cadastrado.
        
        Agencia agenciaBusca = agenciaDao.buscarAgenciaPorCodigoAgencia(agencia.getCodigoAgencia());
        
        if (agenciaDao.buscarAgenciaPorCodigoAgencia(agencia.getCodigoAgencia()) != null) {
            throw new CadastroException("Código da Agnência já está cadastrado!");
        }

        if (agencia.getUf() == null) {
            throw new CadastroException("A agência não possui uma UF preenchida!");
        }

        if (agencia.getCidade() == null) {
            throw new CadastroException("A agência não possui uma cidade preenchida!");
        }

        agenciaDao.inserirAgencia(agencia);
        
    }
    
    public List<Agencia> buscarAgencias() {
        return agenciaDao.listarTodasAgencias();
    }
    
    public static void main(String[] args) {
        
        AgenciaService agenciaService = new AgenciaService();
        
        Agencia agencia = new Agencia (null, null, "Três Corações", "MG", "Av. Rei Pelé", "468798", "37410000");
        
        try {
            agenciaService.salvarAgencia(agencia);
        } catch (CadastroException ex) {
            Logger.getLogger(AgenciaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
