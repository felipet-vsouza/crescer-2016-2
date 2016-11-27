package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MeuSQLUtils {

    public static void main(String[] args) {
        execute("SELECT * FROM FELIPE");
        executeToCSV("SELECT * FROM FELIPE", new File("C:/tmp/saisai.csv"));
    }

    public static ArrayList<HashMap> execute(String query) {
        ArrayList list = new ArrayList();
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {
                ResultSetMetaData meta = resultSet.getMetaData();
                int count = meta.getColumnCount();
                while (resultSet.next()) {
                    HashMap row = new HashMap(count);
                    for (int i = 1; i <= count; ++i) {
                        row.put(meta.getColumnName(i), resultSet.getObject(i));
                    }
                    list.add(row);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return list;
    }

    public static void executeToCSV(String query, File file) {
        ArrayList<HashMap> lista = execute(query);
        List<String> content = new ArrayList<>();
        MeuFileUtils.create(file);
        if (!lista.isEmpty()) {
            Set<String> colunas = lista.get(0).keySet();
            content.add(String.join(";", colunas));
            for (HashMap map : lista) {
                Collection rowCol = map.values();
                ArrayList<String> row = new ArrayList<>();
                for (Object obj : rowCol) {
                    row.add(obj.toString());
                }
                content.add(String.join(";", row));
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file));) {
            for (String linha : content) {
                writer.append(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Problema na escrita do arquivo CSV.");
        }
    }
}
