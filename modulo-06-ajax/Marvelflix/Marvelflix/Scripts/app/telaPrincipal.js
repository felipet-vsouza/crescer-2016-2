class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.registrarBindsEventos();
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos() {
    this.$btnNovoHeroi = $('#btn-novo-heroi');
    this.$btnNovoHeroi.click(this.cadastrarNovoHeroi);
  }

  cadastrarNovoHeroi() {
    console.log("Novo Herói! Arriba!");
  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();  
   
    let herois = $.get('/api/Herois/')
      .done((res) => {
        marvelflix.render('.tela', 'tela-principal', {
          chars: 
            res.map(item => {
              return {
                id: item.id,
                name: item.nome,
                thumbnail: item.urlThumbnail
              }
            })
        });
      });
  }

}
