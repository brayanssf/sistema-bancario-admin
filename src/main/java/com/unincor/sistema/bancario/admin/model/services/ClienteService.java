/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.unincor.sistema.bancario.admin.model.dao.ClienteDao;
import com.unincor.sistema.bancario.admin.model.domain.Cliente;

/**
 *
 * @author Brayan
 */
public class ClienteService {

    private final ClienteDao clienteDao = new ClienteDao();

    public void salvarCliente(Cliente cliente) throws CadastroException {

        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new CadastroException("O cliente deve possuir um nome!");
        }

        if (cliente.getCpf() == null || cliente.getCpf().isBlank()) {
            throw new CadastroException("O cliente deve possuir um CPF!");
        }

        if (cliente.getDataNascimento() == null) {
            throw new CadastroException("O cliente deve possuir uma data de nascimento!");
        }

        if (cliente.getTelefone() == null || cliente.getTelefone().isBlank()) {
            throw new CadastroException("O cliente deve possuir um telefone!");
        }

        if (cliente.getEmail() == null || cliente.getEmail().isBlank()) {
            throw new CadastroException("O cliente deve possuir um e-mail!");
        }

        if (cliente.getSenhaHash() == null || cliente.getSenhaHash().isBlank()) {
            throw new CadastroException("O cliente deve possuir uma senha!");
        }

        clienteDao.inserirCliente(cliente);
    }

    public List<Cliente> buscarClientes() {
        return clienteDao.buscarTodosClientes();
    }

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        Cliente cliente = new Cliente();
        
        cliente.setNome("João");


        try {
            clienteService.salvarCliente(cliente);
        } catch (CadastroException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
