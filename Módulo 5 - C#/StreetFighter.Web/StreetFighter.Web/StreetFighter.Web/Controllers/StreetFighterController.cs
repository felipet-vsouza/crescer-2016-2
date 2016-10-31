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
            model.PrimeiraAparicao = "Street Fighter II The World Warrior (1991)";
            model.DataNascimento = DateTime.Parse("12/02/1966", new CultureInfo("pt-BR"));
            model.Altura = 0;
            model.Peso = 0;
            model.Medidas = "";
            model.TipoSanguineo = "";
            model.HabilidadesEspeciais = "";
            model.Gosta = "";
            model.Desgosta = "";
            model.EstiloDeLuta = "";
            model.Origem = "";
            model.FalaDeVitoria = "";
            model.SSF2Nickname = "";
            model.SFA3Nickname = "";
            model.SF4Nickname = "";
            model.SFA3Stage = "";
            model.SF2Stage = "";
            model.GolpesEspeciaisFamosos = "";
            return View();
        }

        public ActionResult Sobre()
        {
            return View();
        }
    }
}