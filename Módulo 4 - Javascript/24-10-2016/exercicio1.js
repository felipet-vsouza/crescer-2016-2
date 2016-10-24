// 1. Pirâmide iluminatti
//    Escreva uma função gerarPiramide(niveis) que imprime com console.log uma pirâmide com uma quantidade de níveis 
//    informada por parâmetro, utilizando os caracteres R$.
var gerarPiramide = function (niveis) {
    for (var i = 1, len = niveis; i <= len; i++) {
        console.log(new Array(i + 1).join('R$'));
    }
};
//gerarPiramide(10);

/* 2. Escreva uma função diglettDig() que, utilizando console.log, imprime todos os números de 1 até 100, com duas exceções:
-> quando o número for divisível por 3, imprima 'Diglett dig' invés do número, e
-> quando o número for divisível por 5 (e não por 3), imprima 'trio trio trio' invés do número.
Após ter essa lógica funcionando, altere a função para imprimir 'Diglett dig, trio trio trio' para números que são divisíveis 
tanto por 3 quanto por 5 (e que continue imprimindo 'Diglett dig' ou 'trio trio trio' para os números divisíveis apenas 
por 3 ou 5). */
var diglettDig = function () {
    for (var i = 1; i <= 100; i++) {
        if (i % 3 === 0 && i % 5 === 0) {
            console.log('Diglett dig, trio trio trio')
        } else if (i % 3 === 0) {
            console.log('Diglett dig');
        } else if (i % 5 === 0) {
            console.log('trio trio trio');
        } else {
            console.log(i);
        }
    }
}
//diglettDig();

/* 3. Funções por parâmetro!?
Crie uma função chamada find que recebe um array e uma função por parâmetro. 
A função (passada por parâmetro) deverá informar um critério de busca de elementos dentro do array e a função find utilizará
este critério para retornar todos elementos do array que encontram-se dentro dele. NÃO SURTEM! */
var find = function (array, criterio) {
    if (typeof criterio !== "function") {
        return undefined;
    }
    var retorno = [];
    for (var i = 0, len = array.length; i < len; i++) {
        var pos = array[i];
        if (criterio(pos)) {
            retorno.push(pos);
        }
    }
    return retorno;
}

//TESTES
var maiorIgualADois = function (elemento) {
    return elemento >= 2;
};
console.log(find([1, 2, 3], maiorIgualADois));
// [ 2, 3 ]

console.log(find(['a', 5, null, false, 'false'], function (elem) {
    return typeof elem === 'string';
}));
// [ 'a', 'false' ]

console.log(find([{ nome: 'a' }, { nome: 'b' }], function (elem) {
    return typeof elem.nome === 'c';
}));
// []

console.log(find([1, 2, 3], 1));
// undefined