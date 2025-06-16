/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Brayan
 */
public class Funcionario extends Pessoa {
    
    private Long idFuncionario;
    private String cargo;
    
    public Funcionario(){
        
    }
    
    public Funcionario (Long idFuncionario, String nome, String cpf, LocalDate dataNascimento, String email, String telefone, String senhaHash, String cargo){
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senhaHash = senhaHash;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
    
    public Long getIdFuncionarioc() {
        return idFuncionario;
    }
    
    public void setIdFuncionario (Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    public String getCargo () {
        return cargo;
    }
    
    public void setCargo (String cargo) {
        this.cargo = cargo;
    }
}
