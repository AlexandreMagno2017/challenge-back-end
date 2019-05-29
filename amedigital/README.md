# Getting Started

### Reference Documentation

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Rodar script de criação de base
script_amedigital.sql

### List api's:

* Method : POST
* http://localhost:8080/apis/planets
* Body:
{"name" : "xyz", "climate" : "temperate", "terrain": "grasslands, mountains" }

* Method : GET
* http://localhost:8080/apis/planets

* Method : GET
* http://localhost:8080/apis/planets/1
	{
	    "id": 1,
	    "name": "Alderaan",
	    "climate": "temperate",
	    "terrain": "grasslands, mountains",
	    "films": null,
	    "totalFilms": 2
	}

* Method : GET
* http://localhost:8080/apis/planets?name=Eriadu
{
    "id": 21,
    "name": "Eriadu",
    "climate": "polluted",
    "terrain": "cityscape",
    "films": null,
    "totalFilms": 0
}

* Method : GET
* http://localhost:8080/apis/planets/database

[
    {
        "id": 0,
        "name": "Alderaan",
        "climate": "temperate",
        "terrain": "grasslands, mountains",
        "films": null,
        "totalFilms": 0
    },
    {
        "id": 0,
        "name": "Yavin IV",
        "climate": "temperate, tropical",
        "terrain": "jungle, rainforests",
        "films": null,
        ...

* Method : GET
* http://localhost:8080/apis/planets/starwarsapi

[
    {
        "id": 0,
        "name": "Alderaan",
        "climate": "temperate",
        "terrain": "grasslands, mountains",
        "films": [
            "https://swapi.co/api/films/6/",
            "https://swapi.co/api/films/1/"
        ],
        "totalFilms": 0
    },
    {
        "id": 0,
        "name": "Yavin IV",
        "climate": "temperate, tropical",
        ....
