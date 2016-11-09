using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        List<Produto> BuscarProdutosPorFiltro(string filtro);

        Produto BuscarProdutoPorId(int id);

        void Criar(Produto produto);

        void Editar(Produto produto);

        void Excluir(Produto produto);
    }
}
