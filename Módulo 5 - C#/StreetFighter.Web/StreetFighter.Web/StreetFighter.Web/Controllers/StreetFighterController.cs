using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
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

        public ActionResult ListaPersonagens(FichaTecnicaModel ficha = null, string filtro = null)
        {
            if (ModelState.IsValid)
            {
                var personagem = new PersonagemAplicativo();
                if (ficha != null)
                    personagem.Salvar(this.ToPersonagem(ficha));
                var model = new PersonagemAplicativo().ListaPersonagens(filtro);
                return View(model);
            }
            else
            {
                return RedirectToAction("Cadastro");
            }
        }

        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
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
            ViewData["ListaOrigens"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "JP", Text = "Japão" },
                new SelectListItem() { Value = "AC", Text = "Acre" },
                new SelectListItem() { Value = "MO", Text = "Mordor" },
                new SelectListItem() { Value = "US", Text = "Estados Unidos" },
                new SelectListItem() { Value = "CR", Text = "Costa Rica" },
                new SelectListItem() { Value = "AU", Text = "Austrália" },
                new SelectListItem() { Value = "MP", Text = "Morro da Pedra" }
            };
            return View();
        }

        private Personagem ToPersonagem(FichaTecnicaModel model)
        {
            return new Personagem(
                model.Nome,
                model.Nascimento,
                model.Altura,
                model.Peso,
                model.Origem,
                model.Imagem,
                model.GolpesEspeciais,
                model.PersonagemOculto
                );
        }
    }
}