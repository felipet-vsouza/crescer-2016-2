package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Run {

    public static void main(String[] args) {
        for(Pessoa p : PessoaFactory.findAll()) {
            System.out.format("ID: %d - Nome: %s\n", p.getId(), p.getNome());
        }
    }
}
