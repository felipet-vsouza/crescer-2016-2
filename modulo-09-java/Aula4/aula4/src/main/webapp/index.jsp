<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="jquery.js"></script>
        <script src="pessoa.js"></script>
    </head>
    <body>
        <form action="pessoa" method="post">
            <input type="text" name="nome" placeholder="nome">
            <button type="submit" id="submitter">Cadastrar</button>
        </form>
        <div id="tabela">
        </div>
        <h1><%=title %></h1>
    </body>
</html>
