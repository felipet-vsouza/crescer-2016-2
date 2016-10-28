using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Kart
    {
        public Kart(Corredor Corredor)
        {
            this.Corredor = Corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Corredor { get; set; }
        public List<IEquipamento> Equipamentos { get; set; }
        public int Velocidade
        {
            get
            {
                int velocidade = 0;
                int velocidadeBase = 3;

                velocidade += velocidadeBase;
                foreach(IEquipamento equipamento in this.Equipamentos)
                {
                    velocidade += equipamento.Bonus;
                }
                velocidade += this.BonusVelocidadePorCorredor();
                return velocidade;
            }
        }

        private int BonusVelocidadePorCorredor()
        {
            switch (this.Corredor.Habilidade)
            {
                case NivelHabilidade.Noob:
                    {
                        return 3;
                    }
                case NivelHabilidade.Mediano:
                    {
                        return 5;
                    }
                case NivelHabilidade.Profissional:
                    {
                        return 6 + this.Equipamentos.Count;
                    }
                default:
                    {
                        return 0;
                    }
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }
    }
}
