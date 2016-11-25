/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author felipe.souza
 */
public class Exemplo3 {

    public static void main(String[] args) {
        try (
            final Writer writer = new FileWriter("aula2.txt", true);
            final BufferedWriter bw = new BufferedWriter(writer);
            )
        {
            bw.newLine();
            bw.append("Random says:");
            bw.flush();
            bw.newLine();
            bw.append("\tE ai");
            bw.flush();
            bw.newLine();
            bw.append("\tTudo na serenidade?");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
