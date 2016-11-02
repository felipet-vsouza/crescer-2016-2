using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        [Required]
        [DisplayName("URL Imagem")]
        public string Imagem { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public DateTime Nascimento { get; set; }

        [Required]
        public int Altura { get; set; }

        [Required]
        [Range(1, 300, ErrorMessage = "O peso deve ser entre 1 e 300 kg.")]
        public decimal Peso { get; set; }
        
        public string Origem { get; set; }

        [Required]
        [DisplayName("Golpes especiais")]
        public string GolpesEspeciais { get; set; }

        [DisplayName("É um personagem oculto?")]
        public bool PersonagemOculto { get; set; }
    }
}