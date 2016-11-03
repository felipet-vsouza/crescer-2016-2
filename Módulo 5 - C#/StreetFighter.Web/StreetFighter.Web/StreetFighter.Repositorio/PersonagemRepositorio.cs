using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {

        private string filepath;

        public PersonagemRepositorio()
        {
            filepath = @"~/data/personagens.csv";
        }

        public List<Personagem> ListaPersonagens(string filtro)
        {
            var lista = new List<Personagem>();
            var personagens = File.ReadLines(filepath);
            foreach(var personagem in personagens)
            {
                var parametros = personagem.Split(';');
                Personagem p = new Personagem(
                    parametros[0],
                    Convert.ToInt32(parametros[1]),
                    Convert.ToDecimal(parametros[2]),
                    parametros[3],
                    parametros[4],
                    parametros[5],
                    Convert.ToBoolean(parametros[6])
                );
                if(filtro == null || p.Nome.Contains(filtro))
                    lista.Add(p);
            }
            return lista;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            var conteudo = String.Format("{0};{1};{2};{3};{3};{4};{5};{6};{7}",
                personagem.Nome,
                personagem.Altura,
                personagem.Peso,
                personagem.Origem,
                personagem.Imagem,
                personagem.GolpesEspeciais,
                personagem.PersonagemOculto,
                Environment.NewLine);
            File.AppendAllText(filepath, conteudo);
        }

        public void EditarPersonagem(Personagem personagem)
        {
            var lista = this.ListaPersonagens(null);
            foreach(var item in lista)
            {
                bool deveEditar = false;
                if (deveEditar)
                {
                    lista.Remove(item);
                    lista.Add(personagem);
                }
            }
            File.Delete(filepath);
            foreach (var item in lista)
                this.IncluirPersonagem(item);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }
    }
}
