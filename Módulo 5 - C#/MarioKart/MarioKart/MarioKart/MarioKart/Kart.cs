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
                int velocidadeCorredor = 3;

                velocidade += velocidadeCorredor;
                foreach(IEquipamento equipamento in this.Equipamentos)
                {
                    velocidade += equipamento.Bonus;
                }
                switch(this.Corredor.Habilidade)
                {
                    case NivelHabilidade.Noob:
                        {
                            velocidade += 3;
                            break;
                        }
                    case NivelHabilidade.Mediano:
                        {
                            velocidade += 5;
                            break;
                        }
                    case NivelHabilidade.Profissional:
                        {
                            velocidade += 6 + this.Equipamentos.Count;
                            break;
                        }
                }
                return velocidade;
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }
    }
}
