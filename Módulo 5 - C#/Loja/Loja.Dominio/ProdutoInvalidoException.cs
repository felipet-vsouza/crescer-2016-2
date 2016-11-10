using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoInvalidoException : Exception
    {
        public ProdutoInvalidoException(string message) : base(message)
        {

        }
    }
}
