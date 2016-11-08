using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorio
    {
        public static List<Usuario> ListaUsuarios()
        {
            var filepath = @"C:\Users\Felps\github\crescer-2016-2\Módulo 5 - C#\StreetFighter.Web\StreetFighter.Web\data\usuarios.csv";
            var lista = new List<Usuario>();
            var usuarios = File.ReadLines(filepath);
            foreach (var usuario in usuarios)
            {
                var parametros = usuario.Split(';');
                Usuario p = new Usuario()
                {
                    Nome = parametros[0],
                    Senha = parametros[1]
                };
                var listaPermissoes = new List<string>();
                for (int i = 2; i < parametros.Count(); i++)
                    listaPermissoes.Add(parametros[i]);
                p.Permissoes = listaPermissoes.ToArray();
                lista.Add(p);
            }
            return lista;
        }
    }
}
