﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Usuario
    {
        public Usuario()
        {

        }

        public int Id { get; set; }
        public string Nome { get; set; }
        public string Senha { get; set; }
        public string[] Permissoes { get; set; }
    }
}
