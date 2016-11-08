using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class PersonagemRepositorioEF : IPersonagemRepositorio
    {
        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
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
