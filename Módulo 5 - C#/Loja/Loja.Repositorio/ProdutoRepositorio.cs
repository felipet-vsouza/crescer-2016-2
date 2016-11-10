using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public List<Produto> BuscarProdutosPorFiltro(string filtro)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto
                              .Where(p => String.IsNullOrEmpty(filtro) || p.Nome.Equals(filtro))
                              .ToList();
            }
        }

        public Produto BuscarProdutoPorId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto
                              .FirstOrDefault(p => p.Id == id);
            }
        }

        public void Criar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public void Editar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void Excluir(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }

        public Produto BuscarProdutoPorNome(string nome)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto
                              .FirstOrDefault(p => p.Nome.Equals(nome));
            }
        }
    }
}
