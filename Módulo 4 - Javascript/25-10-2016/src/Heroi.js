class Heroi {
    constructor(comics = {}, description, events = {}, id, modified, name, resourceURI, series = {},
                stories = {}, thumbnail = {}, urls = {}) {
        this.comics = comics;
        this.description = description;
        this.events = events;
        this.id = id;
        this.modified = modified;
        this.name = name;
        this.resourceURI = resourceURI;
        this.series = series;
        this.stories = stories;
        this.thumbnail = thumbnail;
        this.urls = Array();
        for(let url in urls) {
            this.urls.push(url);
        }
    }
}