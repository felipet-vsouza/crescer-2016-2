using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {

        public Corredor(string Nome, NivelHabilidade Habilidade)
        {
            this.Nome = Nome;
            this.Habilidade = Habilidade;
        }

        public NivelHabilidade Habilidade { get; private set; }
        public string Nome { get; private set; }
    }
}
