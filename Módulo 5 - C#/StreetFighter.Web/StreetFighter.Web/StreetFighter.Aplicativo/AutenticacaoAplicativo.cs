using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class AutenticacaoAplicativo
    {
        public static Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            Usuario usuarioEncontrado = UsuarioRepositorioADO.ListaUsuarios().ToArray().FirstOrDefault(
                usuario => usuario.Nome.Equals(nome));
            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");
            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }
            return null;
        }
    }
}
