/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pessoa = {};
$(function(){pessoa.iniciar()});

pessoa.iniciar = function() {
    pessoa.registrarBinds();
}

pessoa.registrarBinds = function() {
    $('#submitter').submit()
}

