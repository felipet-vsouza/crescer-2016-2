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


/* 4. Você sabe subtrair?
Crie uma função chamada subtrair que realiza a subtração de dois números em duas chamadas de funções diferentes. NÃO SURTEM! */
var subtrair = function (num1) {
    return function(num2) {
        return num1 - num2;
    }
}
console.log(subtrair(2)(1)); // 1
console.log(subtrair(0)(0)); // 0
console.log(subtrair(-1)(2)); // -3

/* 5. Igualdade recursiva
Escreva uma função iguais que recebe dois parâmetros e retorna true apenas se os valores dos parâmetros forem 
iguais ou se eles forem objetos com as mesmas propriedades com valores iguais e assim recursivamente 
(ou seja, em até vários níveis de propriedades dentro dos objetos). */
var iguais = function(obj1, obj2) {
    if(obj1 !== null && typeof obj1 === "object" && 
       obj2 !== null && typeof obj2 === "object") {
        for(var prop in obj1) {
            if(!obj2.hasOwnProperty(prop) || !iguais(obj1[prop], obj2[prop]))
                return false;
        }
        for(var prop in obj2) {
            if(!obj1.hasOwnProperty(prop) || !iguais(obj1[prop], obj2[prop]))
                return false;
        }
        return true;
    } else {
        if(obj1 === obj2)
            return true;
        return false;
    } 
}

// TESTES
var obj = { a: { a: 'a' }, b: 2 };
console.log(iguais(obj, obj)); // true
console.log(iguais(obj, { a: 1, b: 2 })); // false
console.log(iguais(obj, { a: { a: 'a' }, b: 2 })); // true
console.log(iguais({ a: 1 }, { b: 1 })); // false
var goku = {
  nivel: 'SSJ4',
  golpes: [ { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 } ],
  nome: 'Goku',
}, sonGoku = {
  nome: 'Goku',
  nivel: 'SSJ4',
  golpes: [ { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 } ]
};
console.log(iguais(goku, sonGoku)); // true
console.log(iguais({ a: 1 }, { a: 1, b: 2 })); // false
goku = {
  nivel: 'SSJ4',
  golpes: [ { nome: 'kamehameha', dano: { precisao: 'milhar', valor: 56 } }, { nome: 'genki-dama', dano: 99 } ],
  nome: 'Goku',
}, sonGoku = {
  nivel: 'SSJ4',
  golpes: [ { nome: 'kamehameha', dano: { precisao: 'milhar', valor: 56 } }, { nome: 'genki-dama', dano: 99 } ],
  nome: 'Goku',
};
console.log(iguais(goku, sonGoku)); // true
goku = {
  nome: 'Goku',
  nivel: 'SSJ4',
  golpes: [
    { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 }
  ]
}, sonGoku = {
  nome: 'Goku',
  nivel: 'SSJ4',
  golpes: [
    { nome: 'genki-dama', dano: 99 }, { nome: 'kamehameha', dano: 45 }
  ]
};
console.log(iguais(goku, sonGoku)); // false

/* 6. Ctrl+Copyright
Escreva uma função ctrlC que recebe um parâmetro e realiza a cópia de todos seus valores e retorne o resultado. NÃO SURTEM!!  */
var ctrlC = function(objeto) {
    var ret = {};
    for(var property in objeto) {
        if(typeof objeto[property] === 'object')
            ret[property] = ctrlC(objeto[property]);
        else
            ret[property] = objeto[property];
    }
    return ret;
}

var origem = { a: '1' };
var destino = ctrlC(origem);
console.log(destino);
// { a: '1' }
console.log(origem === destino);
// false
console.log(iguais(origem, destino));
// true
destino = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
console.log(destino.a[2].e());
// 3

/*  7. Mesclar
Crie uma função chamada mesclar que recebe dois objetos como argumentos e mescla todas propriedades do segundo parâmetro dentro do primeiro. NÃO SURTEM!!!  */
var mesclar = function(obj1, obj2, recursiva) {
    for(var prop in obj2) {
        if(typeof obj2[prop] !== 'object')
            obj1[prop] = obj2[prop];
        else if(recursiva === true)
            mesclar(obj1[prop], obj2[prop]);
        else
            obj1[prop] = ctrlC(obj2[prop]);
    }
}

//TESTE
var objeto1 = {
  abacaxi: 0,
  banana: { peso: 52, preco: 100 },
  cereja: 97
};
var objeto2 = {
  banana: { preco: 200 },
  damasco: 100
};
mesclar(objeto1, objeto2);
console.log(objeto1);
// { abacaxi: 0, banana: { preco: 200 }, cereja: 97, damasco: 100 }

/* BÔNUS
Adicione um terceiro parâmetro na função mesclar que, quando for true, faça a operação de mescla ser recursiva */
var objeto1 = {
  abacaxi: 0,
  banana: { peso: 52, preco: 100, origem: { cidade: 'taquari', estado: 'rs' } },
  cereja: 97
};
var objeto2 = {
  banana: { preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs' } },
  damasco: 100
};
mesclar(objeto1, objeto2, true);
console.log(objeto1);
/*
{
  abacaxi: 0,
  banana: {
    peso: 52,
    preco: 200,
    origem: {
      cidade: 'cachoeira do sul', estado: 'rs'
    }
  },
  cereja: 97,
  damasco: 100
}
*/