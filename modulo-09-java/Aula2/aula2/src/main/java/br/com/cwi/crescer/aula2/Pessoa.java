package br.com.cwi.crescer.aula2;

public class Pessoa {

    public Pessoa(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
