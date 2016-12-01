var pessoa = {};
$(function(){pessoa.iniciar()});

pessoa.iniciar = function() {
    pessoa.registrarBinds();
    pessoa.render();
}

pessoa.registrarBinds = function() {
    $('form').submit(function() {
        $.post('pessoa', $('form').serialize());
        pessoa.render();
    });
}

pessoa.render = function() {
    $.get('pessoa').then(result => $('#tabela').html(result));
}