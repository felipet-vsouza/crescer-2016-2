using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            var model = new FichaTecnicaModel();
            model.Nome = "Blanka";
            model.Imagem = "https://files.slack.com/files-pri/T2FVBENMS-F2RM5AKSL/blanka.png";
            model.Nascimento = "12/02/1966";
            model.Altura = 192;
            model.Peso = 96;
            model.Origem = "BR";
            model.GolpesEspeciais = "Electric Thunder, Rolling Attack";
            model.PersonagemOculto = false;
            return View(model);
        }

        public ActionResult Sobre()
        {
            var model = new SobreModel();
            model.Nome = "Felipe Thomas Vargas de Souza";
            model.DataNascimento = DateTime.Parse("02/06/1997", new CultureInfo("pt-BR"));
            model.JogosFavoritos = "CSGO, Fallout 4, Terraria";
            model.TipoSanguineo = "B-";
            model.HabilidadesEspeciais = "Programar, beber café";
            model.Gosta = "Doritos, goiabada, jogos";
            model.Desgosta = "Insônia";
            model.Origem = "Campo Bom / RS - Brasil";
            model.Nickname = "Felps";
            model.GolpesEspeciaisFamosos = "Strafe na varanda, rush b";
            return View(model);
        }

        public ActionResult Cadastro()
        {
            return View();
        }
    }
}