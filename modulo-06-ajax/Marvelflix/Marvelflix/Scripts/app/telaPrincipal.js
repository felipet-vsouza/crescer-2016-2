class TelaPrincipal {

  constructor(seletor) {
    this.$elem = $(seletor);
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos(self) {
    self.$btnNovoHeroi = $('#btn-api');
    self.$btnNovoHeroi.on('click', self.cadastrarNovoHeroi);
  }

  cadastrarNovoHeroi() {
    console.log('Cadastrou!!!');
    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=0b3a95c65a73cd1107ecc94d41faf168&orderBy=-modified&limit=20';
    $.get(url).then(
      function (res) {
        res.data.results.forEach(p => {
          $.post('/api/herois', {
            nome: p.name,
            urlThumbnail: `${p.thumbnail.path}.${p.thumbnail.extension}`
          });
          console.log(p.name);
        })
      }
    );
  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();
    //let self = this;

    $.get('/api/herois')
      .done(function (res) {
        let renderizar = marvelflix.render('.tela', 'tela-principal', {
          chars: res.map(function (item) {
            return {
              id: item.id,
              name: item.nome,
              thumbnail: item.urlThumbnail
            }
          })
        });
        //renderizar.then(self.registrarBindsEventos.bind(self));
        renderizar.then(() => {
          this.registrarBindsEventos(this);
        })
      }.bind(this));
  }
}