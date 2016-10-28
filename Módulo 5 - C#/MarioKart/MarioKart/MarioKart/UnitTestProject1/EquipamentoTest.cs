using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace UnitTestProject1
{
    [TestClass]
    public class EquipamentoTest
    {
        [TestMethod]
        public void FogueteABaseDePlutonioNivel2Da2DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new FogueteDePlutonio());
            Assert.AreEqual(10, kart.Velocidade);
        }

        [TestMethod]
        public void FogueteABaseDePlutonioNivel5Da5DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new FogueteDePlutonio(5));
            Assert.AreEqual(13, kart.Velocidade);
        }

        [TestMethod]
        public void FogueteABaseDePlutonioComNivelInvalidoAssumeNivel2()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new FogueteDePlutonio(Int32.MaxValue));
            Kart boi = new Light(new Corredor("Peão de Guarulhos", NivelHabilidade.Mediano));
            boi.Equipar(new FogueteDePlutonio(0));
            Assert.AreEqual(10, kart.Velocidade);
            Assert.AreEqual(10, boi.Velocidade);
        }
    }
}
