describe('personagemMaisPublicado()', function() {
  
  it('Personagem mais publicado como Guardians of the Galaxy', function() {
    expect(herois[0].personagemMaisPublicado()["name"]).toEqual("Guardians of the Galaxy");
  });

  it('Personagem mais publicado como Spider-Man', function() {
    expect(herois[7].personagemMaisPublicado()["name"]).toEqual("Spider-Man");
  });
});