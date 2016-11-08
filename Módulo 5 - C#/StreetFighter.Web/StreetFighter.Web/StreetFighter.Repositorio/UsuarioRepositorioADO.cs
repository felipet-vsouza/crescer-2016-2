using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorioADO
    {
        private static string connectionString = ConfigurationManager.ConnectionStrings["sfwDB"].ConnectionString;
        public static List<Usuario> ListaUsuarios()
        {
            var lista = new List<Usuario>();
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = $"SELECT * FROM Usuario;";
                var command = new SqlCommand(sql, connection);
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    lista.Add(new Usuario()
                    {
                        Nome = reader["Username"].ToString(),
                        Senha = reader["Senha"].ToString(),
                        Permissoes = reader["Permissoes"].ToString().Split(';')
                    });
                }
                connection.Close();
            }
            return lista;
        }
    }
}
