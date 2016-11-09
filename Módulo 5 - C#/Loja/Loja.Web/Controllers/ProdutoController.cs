using Loja.Web.Filters;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        [LojaAutorizador]
        public ActionResult Lista(string filtro)
        {
            var produtoServico = ServicoDeDependencias.MontarProdutoServico();
            var lista = produtoServico.ListarProdutosPorFiltro(filtro);
            return View(lista);
        }

        [HttpGet]
        public ActionResult Cadastro(int? id)
        {
            if (id.HasValue)
            {
                var produtoServico = ServicoDeDependencias.MontarProdutoServico();
                var produto = produtoServico.BuscarProdutoPorId(id.Value).ConverterParaModel();
                return View(produto);
            }
            else
            {
                return View();
            }
        }
        
        [HttpGet]
        public ActionResult Excluir(int id)
        {
            var produtoServico = ServicoDeDependencias.MontarProdutoServico();
            var produto = produtoServico.BuscarProdutoPorId(id);
            produtoServico.Excluir(produto);
            TempData["MensagemLista"] = "Produto excluído com sucesso.";
            return View("Lista");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(ProdutoModel model)
        {
            if (ModelState.IsValid)
            {
                var produto = model.ConverterParaProduto();
                ServicoDeDependencias.MontarProdutoServico().Salvar(produto);
                return RedirectToAction("Lista");
            }
            TempData["MensagemCadastro"] = "Existem informações inválidas no cadastro.";
            return RedirectToAction("Cadastro");
        }
    }
}