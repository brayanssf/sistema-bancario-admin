/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.FuncionarioDao;
import com.unincor.sistema.bancario.admin.model.domain.Funcionario;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan
 */
public class FuncionarioService {

    private final FuncionarioDao funcionarioDao = new FuncionarioDao();

    public void salvarFuncionario(Funcionario funcionario) throws CadastroException {

        if (funcionario.getNome() == null || funcionario.getNome().isBlank()) {
            throw new CadastroException("O funcionário deve possuir um nome");
        }

        if (funcionario.getCpf() == null || funcionario.getCpf().isBlank()) {
            throw new CadastroException("O funcionário deve possuir um CPF!");
        }

        if (funcionario.getCargo() == null || funcionario.getCargo().isBlank()) {
            throw new CadastroException("O funcionário deve possuir um cargo!");
        }

        funcionarioDao.inserirFuncionario(funcionario);
    }

    public List<Funcionario> buscarFuncionarios() {
        return funcionarioDao.buscarTodosFuncionarios();
    }

    public static void main(String[] args) {
        FuncionarioService funcionarioService = new FuncionarioService();
        Funcionario funcionario = new Funcionario();

        funcionario.setNome("Ellen");
        funcionario.setCpf("12365498701");
        funcionario.setCargo("Analista Sênior");
        funcionario.setDataNascimento(LocalDate.of(1995, 5, 20));
        funcionario.setEmail("ellen@teste.com");
        funcionario.setTelefone("35999999999");
        funcionario.setSenhaHash("senhadeteste1200");

        try {
            funcionarioService.salvarFuncionario(funcionario);
        } catch (CadastroException ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
