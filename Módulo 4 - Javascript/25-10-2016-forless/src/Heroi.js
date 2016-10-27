Array.prototype.contains = function (compareItem) {
    return !!this.find(a => a.equals(compareItem));
}

Object.prototype.equals = function (obj1, obj2) {
    if (obj1 !== null && typeof obj1 === "object" &&
        obj2 !== null && typeof obj2 === "object") {
        for (var prop in obj1) {
            if (!obj2.hasOwnProperty(prop) || !iguais(obj1[prop], obj2[prop]))
                return false;
        }
        for (var prop in obj2) {
            if (!obj1.hasOwnProperty(prop) || !iguais(obj1[prop], obj2[prop]))
                return false;
        }
        return true;
    } else {
        if (obj1 === obj2)
            return true;
        return false;
    }
}

class Heroi {
    constructor(comics = {}, description, events = {}, id, modified, name, resourceURI, series = {},
        stories = {}, thumbnail = {}, urls = {}) {
        this._comics = comics;
        this._description = description;
        this._events = events;
        this._id = id;
        this._modified = modified;
        this._name = name;
        this._resourceURI = resourceURI;
        this._series = series;
        this._stories = stories;
        this._thumbnail = thumbnail;
        this._urls = Array();
        for (let url in urls) {
            this.urls.push(urls[url]);
        }

    }

    foraDaGuerraCivil() {
        return !this._events.items.map(evento => evento.name).contains("Civil War");
    }

    personagemMaisPublicado() {
        let personagens = { "personagem": {}, "publicacoes": 0 };
        let publicacoes = Array();

        /*this._comics.items.reduce(
            (ant, atu) =>
                ant +
                atu.
        )*/

        for (let ed in this._comics["items"]) {
            let edition = this._comics["items"][ed];
            for (var pers in edition["characters"]["items"]) {
                let character = edition["characters"]["items"][pers];
                let pos = contemPersonagem(character);
                if (pos === -1)
                    publicacoes.push({ "personagem": character, "publicacoes": 0 })
                else
                    publicacoes[pos]["publicacoes"]++;
            }
        }

        let retorno = { "publicacoes": 0 };
        for (let pos in publicacoes) {
            if (publicacoes[pos]["publicacoes"] > retorno["publicacoes"])
                retorno = publicacoes[pos];
        }
        return retorno["personagem"];

    }

    mediaPaginas() {
        let paginas = this._comics.items.map(item => item.pageCount);
        let quantidade = paginas.reduce((a, b) => a + b);
        return quantidade / paginas.length;
    }

    seriesPorLongevidade() {    
        return this._series.items
            .map(a => a)
            .sort((ser1, ser2) => (ser2.endYear - ser2.startYear) - (ser1.endYear - ser1.startYear));
    }

    comicMaisCara() {
        return this._comics.items.reduce((a, b) => {
            if(a.prices[0].price > b.prices[0].price)
                return a;
            return b;
        });
    }

    get comics() {
        return this._comics;
    }
    set comics(comic) {
        this._comics = comics;
    }

    get description() {
        return this._description;
    }
    set description(description) {
        this._description = description;
    }

    get events() {
        return this._events;
    }
    set events(events) {
        this._events = events;
    }

    get id() {
        return this._id;
    }
    set id(id) {
        this._id = id;
    }

    get modified() {
        return this._modified;
    }
    set modified(modified) {
        this._modified = modified;
    }

    get name() {
        return this._name;
    }
    set name(name) {
        this._name = name;
    }

    get resourceURI() {
        return this._resourceURI;
    }
    set resourceURI(resourceURI) {
        this._resourceURI = resourceURI;
    }

    get series() {
        return this._series;
    }
    set series(series) {
        this._series = series;
    }

    get stories() {
        return this._stories;
    }
    set stories(stories) {
        this._stories = stories;
    }

    get thumbnail() {
        return this._thumbnail;
    }
    set thumbnail(thumbnail) {
        this._thumbnail = thumbnail;
    }

    get urls() {
        return this._urls;
    }
    set urls(urls) {
        this._urls = urls;
    }
}



// Representação de marvel como um array de Heroi
var herois = Array();
for (let heroi of marvel) {
    herois.push(new Heroi(heroi["comics"], heroi["description"], heroi["events"], heroi["id"], heroi["modified"],
        heroi["name"], heroi["resourceURI"], heroi["series"], heroi["stories"], heroi["thumbnail"], heroi["urls"]));
}