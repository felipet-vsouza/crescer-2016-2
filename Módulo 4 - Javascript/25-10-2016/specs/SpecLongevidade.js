describe('seriesPorLongevidade()', function() {
  
  it('Longevidade adequada', function() {
    let series = herois[0].seriesPorLongevidade();
    let s0 = series[0]["endYear"] - series[0]["startYear"];
    let s1 = series[1]["endYear"] - series[1]["startYear"];
    let s2 = series[2]["endYear"] - series[2]["startYear"];
    let s3 = series[3]["endYear"] - series[3]["startYear"];
    let s4 = series[4]["endYear"] - series[4]["startYear"];
    let s5 = series[5]["endYear"] - series[5]["startYear"];
    let s6 = series[6]["endYear"] - series[6]["startYear"];
    let s7 = series[7]["endYear"] - series[7]["startYear"];
    let resultado = s0 >= s1 && s1 >= s2 && s2 >= s3 && s3 >= s4 && s4 >= s5 && s5 >= s6 && s6 >= s7;
    expect(resultado).toEqual(true);
  });
});