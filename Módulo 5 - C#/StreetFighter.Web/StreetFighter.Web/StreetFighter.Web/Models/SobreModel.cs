using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class SobreModel
    {
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public string JogosFavoritos { get; set; }
        public string TipoSanguineo { get; set; }
        public string HabilidadesEspeciais { get; set; }
        public string Gosta { get; set; }
        public string Desgosta { get; set; }
        public string Origem { get; set; }
        public string Nickname { get; set; }
        public string GolpesEspeciaisFamosos { get; set; }
    }
}