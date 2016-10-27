describe('class Heroi', function() {
  
  var _comics = {available: 12, collectionURI:"http://google.com.br", items: [], returned: 20};
  var _description = "Teste 1";
  var _events = {};
  var _id = 123;
  var _modified = new Date().getTime().toLocaleString();
  var _name = "Felps";
  var _resourceURI = "https://github.com/felipet-vsouza";
  var _series = {};
  var _stories = {};
  var _thumbnails = {};
  var _urls = ["https://github.com/felipet-vsouza", "https://www.facebook.com/lipi.vargas.souza"];
  var her = new Heroi(_comics, _description, _events, _id, _modified, _name, _resourceURI, _series, _stories, _thumbnails, _urls);
  it('Herói tem comics', function() {
    expect(_comics === her.comics).toEqual(true);
  });
  
  it('Herói tem description', function() {
    expect(_description === her.description).toEqual(true);
  });
  it('Herói tem events', function() {
    expect(_events === her.events).toEqual(true);
  });
  it('Herói tem id', function() {
    expect(_id === her.id).toEqual(true);
  });
  it('Herói tem modified', function() {
    expect(_modified === her.modified).toEqual(true);
  });
  it('Herói tem name', function() {
    expect(_name === her.name).toEqual(true);
  });
  it('Herói tem resourceURI', function() {
    expect(_resourceURI === her.resourceURI).toEqual(true);
  });
  it('Herói tem series', function() {
    expect(_series === her.series).toEqual(true);
  });
  it('Herói tem stories', function() {
    expect(_stories === her.stories).toEqual(true);
  });
  it('Herói tem thumbnails', function() {
    expect(_thumbnails === her.thumbnail).toEqual(true);
  });
  it('Herói tem urls', function() {
    let sucesso = true;
    for(let pos in her.urls)
      if(her.urls[pos] !== _urls[pos])
        sucesso = false;
    expect(sucesso).toEqual(true);
  });
});