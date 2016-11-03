using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using FakeItEasy;
using StreetFighter.Aplicativo;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class PersonagemAplicativoTest
    {
        [TestMethod]
        public void PersonagemComId0DeveSerIncluido()
        {
            var repositorio = A.Fake<IPersonagemRepositorio>();
            var personagem = new Personagem("Blanka", "Rio Negro e Solimões");
            var aplicativo = new PersonagemAplicativo(repositorio);

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorio.IncluirPersonagem(personagem)).MustHaveHappened();
        }
    }
}
