package br.com.cwi.crescer.aula4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carlos H. Nonnemacher
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    @EJB
    private PessoaBean pessoaBean;

    List<String> nomes = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.append("<table>");
            out.append("<thead>");
            out.append("<th>Id</th>");
            out.append("<th>Nome</th>");
            out.append("</thead>");
            out.append("<tbody>");
            pessoaBean.findAll().stream().forEach((Pessoa pessoa) -> {
                out.append("<tr>");
                out.append("<th>");
                out.append(pessoa.getIdPessoa().toString());
                out.append("</th>");
                out.append("<th>");
                out.append(pessoa.getNmPessoa());
                out.append("</th>");
                out.append("</tr>");
                out.append("<br />");
            });
            out.append("</tbody>");
            out.append("</table>");
        } catch (Exception e) {
            System.err.println("Erro.");
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Pessoa p = new Pessoa();
        p.setNmPessoa(nome);
//        p.setIdPessoa(44l);
        pessoaBean.insert(p);
    }

}
