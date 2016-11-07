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
    public class PersonagemRepositorioADO : IPersonagemRepositorio
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

        public List<Personagem> ListaPersonagens(string filtro = "%")
        {
            string connectionString = ConfigurationManager.ConnectionStrings["sfwDB"].ConnectionString;
            var lista = new List<Personagem>();
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Nome like @filter_nome";
                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("filter_nome", $"%{filtro}%"));
                SqlDataReader reader = command.ExecuteReader();
                while(reader.Read())
                {
                    var p = new Personagem(
                        Convert.ToInt32(reader["Id"]),
                        reader["Nome"].ToString(),
                        Convert.ToDateTime(reader["Nascimento"]),
                        Convert.ToInt32(reader["Altura"]),
                        Convert.ToDecimal(reader["Peso"]),
                        reader["Origem"].ToString(),
                        reader["Imagem"].ToString(),
                        reader["GolpesEspeciais"].ToString(),
                        Convert.ToBoolean(reader["PersonagemOculto"])
                        );
                    lista.Add(p);
                }
                connection.Close();
            }

            return lista;
        }
    }
}
