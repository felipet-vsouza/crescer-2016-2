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

        [TestMethod]
        public void UltraPackComFogueteDePlutonioNivel5Da6DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new FogueteDePlutonio(5)));
            Assert.AreEqual(14, kart.Velocidade);
        }

        [TestMethod]
        public void UltraPackComFogueteDePlutonioNivel1Da2DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new FogueteDePlutonio(1)));
            Assert.AreEqual(10, kart.Velocidade);
        }

        [TestMethod]
        public void UltraPackComFogueteDePlutonioNivel3Da4DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new FogueteDePlutonio(3)));
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void UltraPackComMotorABaseDeLavaDa4DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new MotorABaseDeLava()));
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void UltraPackComPneusDeCouroDeDragaoDa3DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new PneusDeCouroDeDragao()));
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void UltraPackEm2UltraPacksComFogueteDePlutonioNivel3Da6DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new UltraPack(new UltraPack(new FogueteDePlutonio(3)))));
            Assert.AreEqual(14, kart.Velocidade);
        }

        [TestMethod]
        public void UltraPackEm2UltraPacksComFogueteDePlutonioNivel5Da10DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new UltraPack(new UltraPack(new FogueteDePlutonio(5)))));
            Assert.AreEqual(18, kart.Velocidade);
        }


        [TestMethod]
        public void UltraPackEm20UltraPacksComFogueteDePlutonioNivel5Da10DeBonus()
        {
            Kart kart = new Light(new Corredor("Lula Molusco", NivelHabilidade.Mediano));
            kart.Equipar(new UltraPack(new UltraPack(new UltraPack(new UltraPack(new UltraPack
                (new UltraPack(new UltraPack(new UltraPack(new UltraPack(new UltraPack
                (new UltraPack(new UltraPack(new UltraPack(new UltraPack(new UltraPack
                (new UltraPack(new UltraPack(new UltraPack(new UltraPack(new UltraPack
                (new UltraPack(new FogueteDePlutonio(5)))))))))))))))))))))));
            Assert.AreEqual(316, kart.Velocidade);
        }
    }
}
