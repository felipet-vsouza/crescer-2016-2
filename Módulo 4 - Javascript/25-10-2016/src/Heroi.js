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
        for(let url in urls) {
            this.urls.push(urls[url]);
        }
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