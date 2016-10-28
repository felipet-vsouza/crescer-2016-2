using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor Corredor) : base(Corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + base.BonusVelocidadePorCorredor();
            }
        }
    }
}
