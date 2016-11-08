using StreetFighter.Dominio;
using StreetFighter.RepositorioEF;
using System.Collections.Generic;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorioEF();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListaPersonagens(string filtro = null)
        {
            return new PersonagemRepositorioEF().ListaPersonagens(filtro);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.IncluirPersonagem(personagem);
            else
                repositorio.EditarPersonagem(personagem);
        }

        public void Excluir(Personagem personagem)
        {
            this.repositorio.ExcluirPersonagem(personagem);
        }

        public Personagem BuscarPeloId(int id)
        {
            return this.ListaPersonagens()
                       .Find(personagem => personagem.Id == id);
        }
    }
}
