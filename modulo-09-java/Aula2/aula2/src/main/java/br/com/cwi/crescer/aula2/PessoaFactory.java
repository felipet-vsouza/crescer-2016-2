package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaFactory {

    public static void main(String[] args) {
        
    }

    public static void insert() {
        final String insert = "INSERT INTO FELIPE("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";
        try (final PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(insert)) {
            for (int i = 5; i <= 15; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, String.format("%s pessoa de 10", i));
                preparedStatement.executeUpdate();
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void create() {
        final String ddl = "CREATE TABLE FELIPE ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            statement.executeUpdate(ddl);
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
    public static void delete(Pessoa p) {
        final String ddl = "DELETE FROM FELIPE WHERE ID_PESSOA = ?";
        try(final Connection connection = ConnectionUtils.getConnection();
            final PreparedStatement statement = connection.prepareStatement(ddl);) 
        {
            statement.setLong(1, p.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static List<Pessoa> findAll() {
        List<Pessoa> lista = new ArrayList<>();
        final String query = "SELECT * FROM FELIPE";
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) 
        {
            try (final ResultSet resultSet = statement.executeQuery(query)) {
                while(resultSet.next()) {
                    String nome = resultSet.getString("NM_PESSOA");
                    long id = resultSet.getLong("ID_PESSOA");
                    lista.add(new Pessoa(id, nome));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return lista;
    }
}
