using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class PersonagemRepositorioEF : IPersonagemRepositorio
    {
        public void EditarPersonagem(Personagem personagem)
        {
            using (var context = new ContextoDatabase())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            using (var context = new ContextoDatabase())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using (var context = new ContextoDatabase())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public List<Personagem> ListaPersonagens(string filtro)
        {
            using (var context = new ContextoDatabase())
            {
                var lista = context.Personagem
                                   .Where(p => filtro == null || filtro.Equals("") || p.Nome.ToUpper().Contains(filtro.ToUpper()))
                                   .ToList();
                return lista;
            }
        }
    }
}
