using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Filters;
using StreetFighter.Web.Models;
using StreetFighter.Web.Services;
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

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult FazerLogin(string username, string senha)
        {
            Usuario usuarioAutenticado = AutenticacaoAplicativo.BuscarUsuarioAutenticado(
                    username, senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(
                    usuarioAutenticado.Nome, usuarioAutenticado.Permissoes));
                return RedirectToAction("Index");
            }
            return RedirectToAction("Login");
        }

        public ActionResult Login()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Excluir(int idPersonagem)
        {
            var aplicativo = new PersonagemAplicativo();
            var personagem = aplicativo.BuscarPeloId(idPersonagem);
            aplicativo.Excluir(personagem);
            TempData["Mensagem"] = "Personagem excluído com sucesso.";
            return RedirectToAction("ListaPersonagens");
        }

        public ActionResult ListaPersonagens(FichaTecnicaModel personagem = null, string filtro = null)
        {
            if (ModelState.IsValid || personagem == null || personagem.Nome == null)
            {
                try
                {
                    var aplicativo = new PersonagemAplicativo();
                    if (personagem != null && personagem.Nome != null)
                        aplicativo.Salvar(this.ToPersonagem(personagem));
                    var model = new PersonagemAplicativo().ListaPersonagens(filtro);
                    return View(model);
                }
                catch (RegraNegocioException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                ViewData["ListaOrigens"] = this.ListaOrigens();
                return View("Cadastro", personagem);
            }
            else
            {
                return RedirectToAction("Cadastro");
            }
        }

        [HttpGet]
        public ActionResult FichaTecnica(int idPersonagem)
        {
            Personagem p = new PersonagemAplicativo().BuscarPeloId(idPersonagem);
            if (p != null)
                return View(this.ToFichaTecnicaModel(p));
            else
                return RedirectToAction("ListaPersonagens");
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

        [StreetFighterAutorizador]
        public ActionResult Cadastro(int idPersonagem = 0)
        {
            ViewData["ListaOrigens"] = this.ListaOrigens();
            var personagem = new PersonagemAplicativo().BuscarPeloId(idPersonagem);
            if (personagem == null)
            {
                return View();
            }
            else
            {
                TempData["Mensagem"] = "Personagem editado com sucesso.";
                return View(this.ToFichaTecnicaModel(personagem));
            }
        }

        private Personagem ToPersonagem(FichaTecnicaModel model)
        {
            return new Personagem(
                model.Id.GetValueOrDefault(),
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

        private FichaTecnicaModel ToFichaTecnicaModel(Personagem personagem)
        {
            return new FichaTecnicaModel()
            {
                Id = personagem.Id,
                Nome = personagem.Nome,
                Nascimento = personagem.Nascimento,
                Altura = personagem.Altura,
                Peso = personagem.Peso,
                Origem = personagem.Origem,
                Imagem = personagem.Imagem,
                GolpesEspeciais = personagem.GolpesEspeciais,
                PersonagemOculto = personagem.PersonagemOculto
            };
        }

        private List<SelectListItem> ListaOrigens()
        {
            return new List<SelectListItem>()
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
        }
    }
}