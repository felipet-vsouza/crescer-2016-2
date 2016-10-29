using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        public UltraPack(IEquipamento equipamento)
        {
            this.Equipamento = equipamento;
        }

        public IEquipamento Equipamento { get; private set; }

        public int Bonus
        {
            get
            {
                return (int) Math.Ceiling(1.2 * this.Equipamento.Bonus);
            }
        }
    }
}
