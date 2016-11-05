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
    public class PersonagemRepositorio : IPersonagemRepositorio
    {

        private readonly string filepath;

        public PersonagemRepositorio()
            : this(@"C:\Users\Felps\github\crescer-2016-2\Módulo 5 - C#\StreetFighter.Web\StreetFighter.Web\data\personagens.csv")
        {
        }

        internal PersonagemRepositorio(string filepath)
        {
            this.filepath = filepath;
            if (!File.Exists(filepath))
                File.Create(filepath).Close();
        }
        
        public List<Personagem> ListaPersonagens()
        {
            return this.ListaPersonagens(null);
        }

        public List<Personagem> ListaPersonagens(string filtro)
        {
            var lista = new List<Personagem>();
            var personagens = File.ReadLines(filepath);
            foreach(var personagem in personagens)
            {
                var parametros = personagem.Split(';');
                Personagem p = new Personagem(
                    Convert.ToInt32(parametros[0]),
                    parametros[1],
                    DateTime.ParseExact(parametros[2], "dd/MM/yyyy", new CultureInfo("pt-BR")),
                    Convert.ToInt32(parametros[3]),
                    Convert.ToDecimal(parametros[4]),
                    parametros[5],
                    parametros[6],
                    parametros[7],
                    Convert.ToBoolean(parametros[8])
                );
                if(filtro == null || p.Nome.Contains(filtro))
                    lista.Add(p);
            }
            return lista;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            var conteudo = String.Format("{0};{1};{2};{3};{4};{5};{6};{7};{8}{9}",
                this.NextId(),
                personagem.Nome,
                personagem.Nascimento.ToString("dd/MM/yyyy"),
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
            this.ExcluirPersonagem(personagem);
            var lista = this.ListaPersonagens();
            lista.Add(personagem);
            this.SobrescreveArquivo(lista);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            var lista = this.ListaPersonagens();
            foreach (var item in lista)
            {
                bool deveExcluir = personagem.Id == item.Id;
                if (deveExcluir)
                {
                    lista.Remove(item);
                    break;
                }
            }
            this.SobrescreveArquivo(lista);
        }

        private void SobrescreveArquivo(List<Personagem> lista)
        {
            if(File.Exists(filepath))
                File.Delete(filepath);
            using (File.Create(filepath));
            foreach (var item in lista)
                this.IncluirPersonagem(item);
        }

        private int NextId()
        {
            var lista = this.ListaPersonagens();
            if (lista.Count == 0)
                return 1;
            else
                return lista.OrderBy(p => p.Id)
                            .Last()
                            .Id + 1;
        }
    }
}
