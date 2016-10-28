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
    }
}
