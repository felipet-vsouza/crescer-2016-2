using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKartTest
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void SonnarNaoRecebeBonusDeVelocidadeParaKartSemEquipamento()
        {
            Kart sonnar = new Sonnar(new Corredor("Bátima", NivelHabilidade.Noob));
            Assert.AreEqual(6, sonnar.Velocidade);
        }

        [TestMethod]
        public void SonnarRecebeMaisDoisDeBonusDeVelocidadeParaKartComUmItem()
        {
            Kart sonnar = new Sonnar(new Corredor("Barrichello", NivelHabilidade.Profissional));
            sonnar.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(15, sonnar.Velocidade);
        }

        [TestMethod]
        public void SonnarRecebeMaisDoisDeBonusDeVelocidadeParaKartComDoisItens()
        {
            Kart sonnar = new Sonnar(new Corredor("Barrichello", NivelHabilidade.Profissional));
            sonnar.Equipar(new MotorABaseDeLava());
            sonnar.Equipar(new PneusDeCouroDeDragao());
            int velocidade = sonnar.Velocidade;
            Assert.AreEqual(18, sonnar.Velocidade);
        }

        [TestMethod]
        public void LightRecebeMaisTresPorSerDirigidoPorCorredorNoob()
        {
            Kart light = new Light(new Corredor("Vanderlei", NivelHabilidade.Noob));
            Assert.AreEqual(9, light.Velocidade);
        }

        [TestMethod]
        public void QuantidadeDeEquipamentosNaoInfluenciaNoLightParaNoobs()
        {
            Kart light = new Light(new Corredor("Vanderlei", NivelHabilidade.Noob));
            light.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(11, light.Velocidade);
        }

        [TestMethod]
        public void LightNaoRecebeBonusDeVelocidadeParaCorredorMediano()
        {
            Kart light = new Light(new Corredor("Moisés", NivelHabilidade.Mediano));
            Assert.AreEqual(8, light.Velocidade);
        }

        [TestMethod]
        public void LightPerdeUmDeVelocidadePorSerDigiridoPorCorredorProfissional()
        {
            Kart light = new Light(new Corredor("Ragnar", NivelHabilidade.Profissional));
            Assert.AreEqual(8, light.Velocidade);
        }

        [TestMethod]
        public void DinamDaODobroDeBonusDeCorredorParaCorredorNoob()
        {
            Kart dinam = new Dinam(new Corredor("Vanderlei", NivelHabilidade.Noob));
            Assert.AreEqual(9, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDaApenasODobroDeBonusDeCorredorParaCorredorNoobCujoKartTemItens()
        {
            Kart dinam = new Dinam(new Corredor("Vanderlei", NivelHabilidade.Noob));
            dinam.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(11, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDaODobroDeBonusDeCorredorParaCorredorMediano()
        {
            Kart dinam = new Dinam(new Corredor("Moisés", NivelHabilidade.Mediano));
            Assert.AreEqual(13, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDaApenasODobroDeBonusDeCorredorParaCorredorMedianoCujoKartTemItens()
        {
            Kart dinam = new Dinam(new Corredor("Moisés", NivelHabilidade.Mediano));
            dinam.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(15, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDaODobroDeBonusDeCorredorParaCorredorProfissional()
        {
            Kart dinam = new Dinam(new Corredor("Ragnar", NivelHabilidade.Profissional));
            Assert.AreEqual(15, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDaApenasODobroDeBonusDeCorredorParaCorredorProfissionalCujoKartTemItens()
        {
            Kart dinam = new Dinam(new Corredor("Ragnar", NivelHabilidade.Profissional));
            dinam.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(19, dinam.Velocidade);
        }

        [TestMethod]
        public void SkyFusionNaoConcedeBonusAdicionalParaCorredorProfissional()
        {
            Kart skyFusion = new SkyFusion(new Corredor("Roberto Carlos", NivelHabilidade.Profissional));
            Assert.AreEqual(12, skyFusion.Velocidade);
        }

        [TestMethod]
        public void SkyFusionConcedeBonusAdicionalParaCorredorProfissionalComPneusDeCouroDeDragao()
        {
            Kart skyFusion = new SkyFusion(new Corredor("Roberto Carlos", NivelHabilidade.Profissional));
            skyFusion.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(21, skyFusion.Velocidade);
        }

        [TestMethod]
        public void SkuFusionNaoConcedeBonusAdicionalParaCorredorNoobComUltraPackDeFogueteDePlutonioNivel3()
        {
            Kart skyFusion = new SkyFusion(new Corredor("Ricardinho", NivelHabilidade.Noob));
            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(3)));
            Assert.AreEqual(12, skyFusion.Velocidade);
        }

        [TestMethod]
        public void SkuFusionConcedeBonusAdicionalParaCorredorNoobComUltraPackDeFogueteDePlutonioNivel4()
        {
            Kart skyFusion = new SkyFusion(new Corredor("Ricardinho", NivelHabilidade.Noob));
            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(4)));
            Assert.AreEqual(18, skyFusion.Velocidade);
        }

        [TestMethod]
        public void SkyFusionConcedeBonusAdicionalParaCorredorMedianoCom3Itens()
        {
            Kart skyFusion = new SkyFusion(new Corredor("Romário", NivelHabilidade.Mediano));
            skyFusion.Equipar(new UltraPack(new UltraPack(new MotorABaseDeLava())));
            skyFusion.Equipar(new FogueteDePlutonio(Int32.MaxValue));
            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(5)));
            Assert.AreEqual(31, skyFusion.Velocidade);
        }

        [TestMethod]
        public void SkyFusionConcedeBonusAdicionalParaCorredorProfissionalEquipadoComSkyFusionEUltraPack()
        {
            SkyFusion skyFusion = new SkyFusion(new Corredor("Romário", NivelHabilidade.Mediano));
            skyFusion.Equipar(new UltraPack(new UltraPack(new MotorABaseDeLava())));
            skyFusion.Equipar(new FogueteDePlutonio(Int32.MaxValue));
            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(5)));
            Kart skyFusionEquipadao = new SkyFusion(new Corredor("Roberto Carlos", NivelHabilidade.Profissional));
            skyFusionEquipadao.Equipar(skyFusion);
            skyFusionEquipadao.Equipar(new UltraPack(new UltraPack(new UltraPack(new PneusDeCouroDeDragao()))));
            Assert.AreEqual(36, skyFusionEquipadao.Velocidade);
        }

        [TestMethod]
        public void SkyFusionConcedeBonusAdicionalParaCorredorNoobEquipadoComDoisSkyFusionsEmUltraPacks()
        {
            SkyFusion skyFusion = new SkyFusion(new Corredor("Romário", NivelHabilidade.Mediano));
            skyFusion.Equipar(new UltraPack(new UltraPack(new MotorABaseDeLava())));
            skyFusion.Equipar(new FogueteDePlutonio(Int32.MaxValue));
            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(5)));
            SkyFusion skyFusionEquipadao = new SkyFusion(new Corredor("Roberto Carlos", NivelHabilidade.Profissional));
            skyFusionEquipadao.Equipar(skyFusion);
            skyFusionEquipadao.Equipar(new UltraPack(new UltraPack(new UltraPack(new PneusDeCouroDeDragao()))));
            SkyFusion skyFusionMaisQueEquipadao = new SkyFusion(new Corredor("Crash Bandicoot", NivelHabilidade.Noob));
            skyFusionMaisQueEquipadao.Equipar(new UltraPack(skyFusion));
            skyFusionMaisQueEquipadao.Equipar(new UltraPack(new UltraPack(skyFusionEquipadao)));
            Assert.AreEqual(41, skyFusionMaisQueEquipadao.Velocidade);
        }

        [TestMethod]
        public void SkyFusionBacanaoEquipaDoisSkyFusionsBuffadosERecebeBonus()
        {
            SkyFusion skyFusion = new SkyFusion(new Corredor("Romário", NivelHabilidade.Mediano));
            skyFusion.Equipar(new UltraPack(new UltraPack(new MotorABaseDeLava())));
            skyFusion.Equipar(new FogueteDePlutonio(Int32.MaxValue));
            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(5)));
            SkyFusion skyFusionEquipadao = new SkyFusion(new Corredor("Roberto Carlos", NivelHabilidade.Profissional));
            skyFusionEquipadao.Equipar(skyFusion);
            skyFusionEquipadao.Equipar(new UltraPack(new UltraPack(new UltraPack(new PneusDeCouroDeDragao()))));
            SkyFusion skyFusionMaisQueEquipadao = new SkyFusion(new Corredor("Crash Bandicoot", NivelHabilidade.Noob));
            skyFusionMaisQueEquipadao.Equipar(new UltraPack(skyFusion));
            skyFusionMaisQueEquipadao.Equipar(new UltraPack(new UltraPack(skyFusionEquipadao)));
            SkyFusion skyFusion1 = new SkyFusion(new Corredor("Romário", NivelHabilidade.Mediano));
            skyFusion1.Equipar(new UltraPack(new UltraPack(new MotorABaseDeLava())));
            skyFusion1.Equipar(new FogueteDePlutonio(Int32.MaxValue));
            skyFusion1.Equipar(new UltraPack(new FogueteDePlutonio(5)));
            SkyFusion skyFusionEquipadao1 = new SkyFusion(new Corredor("Roberto Carlos", NivelHabilidade.Profissional));
            skyFusionEquipadao1.Equipar(skyFusion);
            skyFusionEquipadao1.Equipar(new UltraPack(new UltraPack(new UltraPack(new PneusDeCouroDeDragao()))));
            SkyFusion skyFusionMaisQueEquipadao1 = new SkyFusion(new Corredor("Crash Bandicoot", NivelHabilidade.Noob));
            skyFusionMaisQueEquipadao1.Equipar(new UltraPack(skyFusion));
            skyFusionMaisQueEquipadao1.Equipar(new UltraPack(new UltraPack(skyFusionEquipadao)));
            SkyFusion skyFusionBacanao = new SkyFusion(new Corredor("Pelé", NivelHabilidade.Profissional));
            skyFusionBacanao.Equipar(new UltraPack(new UltraPack(skyFusionMaisQueEquipadao)));
            skyFusionBacanao.Equipar(new UltraPack(new UltraPack(skyFusionMaisQueEquipadao1)));
            Assert.AreEqual(45, skyFusionBacanao.Velocidade);
        }
    }
}
