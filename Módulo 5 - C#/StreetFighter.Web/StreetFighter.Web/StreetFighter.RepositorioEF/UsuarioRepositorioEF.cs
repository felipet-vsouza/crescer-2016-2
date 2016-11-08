using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class UsuarioRepositorioEF
    {
        public static List<Usuario> ListaUsuarios()
        {
            using (var context = new ContextoDatabase())
            {
                return context.Usuario
                              .ToList();
            }
        }
    }
}
