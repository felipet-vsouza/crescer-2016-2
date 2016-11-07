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
        private string connectionString = ConfigurationManager.ConnectionStrings["sfwDB"].ConnectionString;

        public void EditarPersonagem(Personagem personagem)
        {
            var sql = "UPDATE Personagem " +
                      "SET Nome = @param_nome, " +
                      "Nascimento = @param_nascimento, " +
                      "Altura = @param_altura, " +
                      "Peso = @param_peso, " +
                      "Origem = @param_origem, " +
                      "Imagem = @param_imagem, " +
                      "GolpesEspeciais = @param_golpes, " +
                      "PersonagemOculto = @param_oculto " +
                      "WHERE Id = @param_id;";
            this.ExecuteNonQuery(sql, personagem);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            var sql = "DELETE FROM Personagem " +
                      "WHERE Nome = @param_nome AND " +
                      "Nascimento = @param_nascimento AND " +
                      "Altura = @param_altura AND " +
                      "Peso = @param_peso AND " +
                      "Origem = @param_origem AND " +
                      "Imagem = @param_imagem AND " +
                      "GolpesEspeciais = @param_golpes AND " +
                      "PersonagemOculto = @param_oculto AND " +
                      "Id = @param_id;";
            this.ExecuteNonQuery(sql, personagem);
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            var sql = "INSERT INTO Personagem (Nome, Nascimento, Altura, Peso, Origem, Imagem, " +
                      "GolpesEspeciais, PersonagemOculto) " +
                      "VALUES Nome = @param_nome AND " +
                      "Nascimento = @param_nascimento AND " +
                      "Altura = @param_altura AND " +
                      "Peso = @param_peso AND " +
                      "Origem = @param_origem AND " +
                      "Imagem = @param_imagem AND " +
                      "GolpesEspeciais = @param_golpes AND " +
                      "PersonagemOculto = @param_oculto;";
            this.ExecuteNonQuery(sql, personagem);
        }

        public List<Personagem> ListaPersonagens(string filtro = "%")
        {
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
                    lista.Add(this.ToPersonagem(reader));
                }
                connection.Close();
            }

            return lista;
        }

        private void ExecuteNonQuery(string sqlCommand, Personagem personagem)
        {
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();
                var command = new SqlCommand(sqlCommand, connection);
                command.Parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                command.Parameters.Add(new SqlParameter("param_nascimento", personagem.Nascimento));
                command.Parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                command.Parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                command.Parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                command.Parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                command.Parameters.Add(new SqlParameter("param_golpes", personagem.GolpesEspeciais));
                command.Parameters.Add(new SqlParameter("param_oculto", personagem.PersonagemOculto));
                command.Parameters.Add(new SqlParameter("param_id", personagem.Id));
                command.ExecuteNonQuery();
                connection.Close();
            }
        }

        private Personagem ToPersonagem(SqlDataReader reader)
        {
            return new Personagem(
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
        }
    }
}
