using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public void Salvar(Produto produto)
        {
            if (produto.Nome.Length < 2)
                throw new ProdutoInvalidoException("O nome do produto deve ter no mínimo 3 caracteres.");
            if (produtoRepositorio.BuscarProdutoPorNome(produto.Nome) != null)
                throw new ProdutoInvalidoException($"Um produto de nome {produto.Nome} já foi cadastrado.");
            if (produto.Valor > 0)
                throw new ProdutoInvalidoException("O valor do produto deve ser definido.");
            if (produto.Id == 0)
            {
                produtoRepositorio.Criar(produto);
            }
            else
            {
                produtoRepositorio.Editar(produto);
            }
        }

        public void Excluir(Produto produto)
        {
            produtoRepositorio.Excluir(produto);
        }

        public List<Produto> ListarProdutosPorFiltro(string filtro)
        {
            return produtoRepositorio.BuscarProdutosPorFiltro(filtro);
        }

        public Produto BuscarProdutoPorId(int id)
        {
            return produtoRepositorio.BuscarProdutoPorId(id);
        }
    }
}
