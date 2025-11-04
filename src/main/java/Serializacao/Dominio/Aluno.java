package Serializacao.Dominio;

import java.io.Serializable;

public class Aluno implements Serializable{
    private String nome;
    private Long id;
    private String password;
    
    public Aluno(Long id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;

    }
    public Long getid() {
        return id;
    }
    public void setid(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return super.toString() + "Aluno [nome=" + nome + ", id=" + id + ", password=" + password + "]";
    }
}
