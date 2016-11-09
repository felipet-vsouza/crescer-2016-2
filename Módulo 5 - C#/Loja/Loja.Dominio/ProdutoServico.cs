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
            if(produto.Id == 0)
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
