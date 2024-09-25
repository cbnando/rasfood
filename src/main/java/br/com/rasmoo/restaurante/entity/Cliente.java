package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf;
    private String nome;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();
    private String cep;

    public Cliente(String cpf, String nome, String cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.cep = cep;
    }

    public Cliente() {

    }

    public void addEndereco(Endereco endereco) {
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
