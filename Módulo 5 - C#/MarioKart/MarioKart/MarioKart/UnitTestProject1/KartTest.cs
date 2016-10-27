using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void KartComCorredorNoobPossuiVelocidade6()
        {
            Kart kart = new Kart(new Corredor("Nemesis", NivelHabilidade.Noob));
            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void KartComCorredorMedianoEEquipamentosPossuiVelocidade11()
        {
            Kart kart = new Kart(new Corredor("BOT Gabe", NivelHabilidade.Mediano));
            kart.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void KartComCorredorProfissionalEEquipamentosPossuiVelocidade12()
        {
            Kart kart = new Kart(new Corredor("Sheena", NivelHabilidade.Profissional));
            kart.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(12, kart.Velocidade);
        }
    }
}
