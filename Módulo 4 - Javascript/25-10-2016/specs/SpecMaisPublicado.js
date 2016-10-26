describe('personagemMaisPublicado()', function() {
  
  it('Homem Aranha participou da Guerra Civil', function() {
    expect(herois[0].personagemMaisPublicado()["name"]).toEqual("Guardians of the Galaxy");
  });

  it('Guardiões da Galáxia NÃO participaram da Guerra Civil', function() {
    expect(herois[7].personagemMaisPublicado()["name"]).toEqual("Spider-Man");
  });
});