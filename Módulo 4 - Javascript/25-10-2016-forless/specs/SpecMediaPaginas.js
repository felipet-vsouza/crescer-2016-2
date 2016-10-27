describe('mediaPaginas()', function() {
  
  it('Média de páginas inferior a 32', function() {
    expect(herois[3].mediaPaginas()).toEqual(28.125);
  });

  it('Média de páginas superior a 32', function() {
    expect(herois[2].mediaPaginas()).toEqual(37.875);
  });
});