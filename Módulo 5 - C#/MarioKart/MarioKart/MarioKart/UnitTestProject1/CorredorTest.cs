using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;

namespace MarioKartTest
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorNasceComNomeEHabilidade()
        {
            var corredor = new Corredor("Mariano", NivelHabilidade.Mediano);
            Assert.AreEqual("Mariano", corredor.Nome);
            Assert.AreEqual(NivelHabilidade.Mediano, corredor.Habilidade);
        }
    }
}
