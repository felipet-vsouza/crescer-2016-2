using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor Corredor) : base(Corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + this.BonusVelocidade();
            }
        }

        private int BonusVelocidade()
        {
            switch (base.Corredor.Habilidade)
            {
                case NivelHabilidade.Noob:
                    {
                        return 3;
                    }
                case NivelHabilidade.Profissional:
                    {
                        return -1;
                    }
                default:
                    {
                        return 0;
                    }
            }
        }
    }
}
