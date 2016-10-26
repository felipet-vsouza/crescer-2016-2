describe('comicMaisCara()', function() {
  
  it('Comic mais caro de Guardians of the Galaxy é 3.99', function() {
    let maiorValorDeComic = herois[0].comicMaisCara().prices[0].price;
    expect(maiorValorDeComic).toEqual(3.99);
  });

  it('Comic mais caro de Spider-Man é 4.99', function() {
    let maiorValorDeComic = herois[7].comicMaisCara().prices[0].price;
    expect(maiorValorDeComic).toEqual(4.99);
  });

});