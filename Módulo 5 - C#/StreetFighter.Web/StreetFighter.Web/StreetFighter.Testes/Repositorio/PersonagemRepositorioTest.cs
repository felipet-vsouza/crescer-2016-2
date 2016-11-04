using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Repositorio;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Repositorio
{
    [TestClass]
    public class PersonagemRepositorioTest
    {
        private readonly PersonagemRepositorio repositorio = new PersonagemRepositorio(@"C:\Users\Felps\github\crescer-2016-2\Módulo 5 - C#\StreetFighter.Web\StreetFighter.Web\StreetFighter.Testes\Repositorio\personagens.csv");
        
        [TestMethod]
        public void PersonagemRepositorioEhInstanciadoComListaVazia()
        {
            var lista = repositorio.ListaPersonagens();
            Assert.AreEqual(0, lista.Count);
        }

        [TestMethod]
        public void AdicionaUmPersonagemAoRepositorioEODeleta()
        {
            var personagem = new Personagem("Blanka", 178, 82, "Amazônia", "", "", false);
            repositorio.IncluirPersonagem(personagem);
            var lista = repositorio.ListaPersonagens();
            Assert.AreEqual(1, lista.Count);
            personagem = lista[0];
            repositorio.ExcluirPersonagem(personagem);
            lista = repositorio.ListaPersonagens();
            Assert.AreEqual(0, lista.Count);
        }

        [TestMethod]
        public void AdicionaEEditaUmPersonagemDoRepositorioEOExclui()
        {
            var personagem = new Personagem("Blanka", 178, 82, "Amazônia", "", "", false);
            repositorio.IncluirPersonagem(personagem);
            var lista = repositorio.ListaPersonagens();
            Assert.AreEqual(1, lista.Count);
            personagem = lista[0];
            personagem.Nome = "João Limão";
            repositorio.EditarPersonagem(personagem);
            Assert.AreEqual(1, lista.Count);
            personagem = lista[0];
            Assert.AreEqual(personagem.Nome, "João Limão");
            repositorio.ExcluirPersonagem(personagem);
            lista = repositorio.ListaPersonagens();
            Assert.AreEqual(0, lista.Count);
        }
    }
}
