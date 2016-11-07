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

        public List<Personagem> ListaPersonagens(string filtro)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["sfwDB"].ConnectionString;
            var lista = new List<Personagem>();
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                connection.Close();
            }

            return lista;
        }
    }
}
