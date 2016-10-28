using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamento
    {
        public FogueteDePlutonio(int nivel = 2)
        {
            if(nivel < 1 || nivel > 5)
            {
                nivel = 2;
            }
            this.Nivel = nivel;
        }

        public int Nivel { get; private set; }

        public int Bonus
        {
            get
            {
                return this.Nivel;
            }
        }
    }
}
