using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System.Collections.Generic;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListaPersonagens(string filtro = null)
        {
            return repositorio.ListaPersonagens(filtro);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.IncluirPersonagem(personagem);
            else
                repositorio.EditarPersonagem(personagem);
        }

        public Personagem BuscarPeloId(int id)
        {
            return this.ListaPersonagens()
                       .Find(personagem => personagem.Id == id);
        }
    }
}
