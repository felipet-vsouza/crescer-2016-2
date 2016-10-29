using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor Corredor) : base(Corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + this.Bonus;
            }
        }

        public int Bonus
        {
            get
            {
                int bonusVelocidade = 0;
                bonusVelocidade += base.Equipamentos.Count;
                bonusVelocidade += this.BonusVelocidadePorNivelHabilidade();
                bool recebeBonusAdicional = base.Velocidade + bonusVelocidade > 12;
                if(recebeBonusAdicional)
                {
                    bonusVelocidade += 5;
                }
                return bonusVelocidade;
            }
        }

        private int BonusVelocidadePorNivelHabilidade()
        {
            switch (base.Corredor.Habilidade)
            {
                case NivelHabilidade.Noob:
                    {
                        return 1;
                    }
                case NivelHabilidade.Mediano:
                    {
                        return 2;
                    }
                case NivelHabilidade.Profissional:
                    {
                        return 3;
                    }
                default:
                    {
                        return 0;
                    }
            }
        }
    }
}
