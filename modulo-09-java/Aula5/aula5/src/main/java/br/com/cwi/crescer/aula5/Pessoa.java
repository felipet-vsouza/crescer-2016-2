package br.com.cwi.crescer.aula5;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    @Override
    public String toString() {
        return String.format("O nome da pessoa é %s e o sobrenome é %s. Sua idade é %d.", 
                this.nome, this.sobrenome, this.idade);
    }
}
