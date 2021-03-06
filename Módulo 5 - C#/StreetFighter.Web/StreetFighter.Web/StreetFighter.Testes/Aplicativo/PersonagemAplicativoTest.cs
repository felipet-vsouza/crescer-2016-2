﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using FakeItEasy;
using StreetFighter.Aplicativo;
using System.Globalization;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class PersonagemAplicativoTest
    {
        [TestMethod]
        public void PersonagemComId0DeveSerIncluido()
        {
            var repositorio = A.Fake<IPersonagemRepositorio>();
            var personagem = new Personagem("Blanka", DateTime.Parse("15/08/1967", new CultureInfo("pt-BR")), 172, 89, "Rio Negro e Solimões", "", "", false);
            var aplicativo = new PersonagemAplicativo(repositorio);

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorio.IncluirPersonagem(personagem)).MustHaveHappened();
        }
    }
}
