using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor Corredor) : base(Corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                return this.RecebeBonusVelocidade() ? base.Velocidade + 2 : base.Velocidade;
            }
        }

        private bool RecebeBonusVelocidade()
        {
            return base.Equipamentos.Count > 0;
        }

    }
}
