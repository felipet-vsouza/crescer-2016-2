describe('participouDaGuerraCivil()', function() {
  
  it('Homem Aranha participou da Guerra Civil', function() {
    expect(herois[7].participouDaGuerraCivil()).toEqual(true);
  });

  it('Guardiões da Galáxia NÃO participaram da Guerra Civil', function() {
    expect(herois[0].participouDaGuerraCivil()).toEqual(false);
  });
});