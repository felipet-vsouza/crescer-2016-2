using StreetFighter.Web.Models;
using StreetFighter.Web.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace StreetFighter.Web.Filters
{
    public class StreetFighterAutorizador : AuthorizeAttribute
    {
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            UsuarioLogadoModel usuario = ServicoDeAutenticacao.UsuarioLogado;
            if (usuario == null) return false;
            string[] permissoesRequidas = this.Roles.Split(',')
                                                    .Where(p => !String.IsNullOrEmpty(p))
                                                    .ToArray();
            foreach (string permissao in permissoesRequidas)
            {
                if (!usuario.Permissoes.Any(p => p.Equals(permissao)))
                {
                    return false;
                }
            }
            return true;
        }

        protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
        {
            filterContext.Result = new RedirectToRouteResult(
                                       new RouteValueDictionary
                                       {
                                       { "action", "Login" },
                                       { "controller", "StreetFighter" }
                                       });
        }
    }
}