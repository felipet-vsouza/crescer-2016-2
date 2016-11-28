package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static void executeFromSQLFile(File file) {
        if (!MeuFileUtils.getExtension(file).equalsIgnoreCase("sql")) {
            System.err.println("Extensão inválida de arquivo.");
            return;
        }
        StringBuilder statement = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line = "";
            do {
                line = reader.readLine();
                if (line != null) {
                    statement.append(line).append(' ');
                }
            } while (line != null);
        } catch (IOException e) {
            System.err.println("Problema durante a leitura do arquivo CSV.");
        }
        ArrayList<HashMap> result = execute(statement.toString());
        for (HashMap map : result) {
            Collection values = map.values();
            List<String> list = new ArrayList<>();
            for (Object obj : values) {
                list.add(obj.toString());
            }
            System.out.println(String.join(" | ", list));
        }
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

    public static void importFromCSV(File file) {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line = "";
            do {
                line = reader.readLine();
                if (line != null) {
                    content.add(line);
                }
            } while (line != null);
        } catch (IOException e) {
            System.err.println("Problema durante a leitura do arquivo CSV.");
        }
        if (content.isEmpty() || content.size() <= 1) {
            System.err.println("O arquivo está vazio ou não possui a estrutura adequada.");
            return;
        }
        String tablename = file.getName().replaceAll("(\\.[^.]+)$", "");
        String columns = String.join(",", content.remove(0).split(";"));
        for (String rawRow : content) {
            String row = String.join(",", asSQLRow(rawRow.split(";")));
            String query = String.format("INSERT INTO %s(%s) VALUES(%s)", tablename, columns, row);
            insertQuery(query);
        }
    }

    private static String[] asSQLRow(String[] rawRow) {
        String[] row = rawRow.clone();
        for (int i = 0; i < rawRow.length; i++) {
            row[i] = String.format("'%s'", rawRow[i]);
        }
        return row;
    }

    private static void insertQuery(String query) {
        try (final PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
