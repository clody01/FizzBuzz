# FizzBuzzWs

Fizz buzz est un jeu avec lequel les enfants apprennent les divisions. 
Ils énumèrent oralement les nombre entiers et, lorsque l'un d'eux est un multiple de trois, ils prononcent « Fizz » 
à la place de son nom. S'il est un multiple de 5, ils prononcent « Buzz ».

On se propose de développer un ensemble de services web basés sur ce jeu. 

Une base d’application vide est fournie avec l'ensemble des outils nécessaires sur ce dépôt GitHub. 
Il est possible de rajouter des dépendances à condition de savoir en expliquer la nécessité.

## `GET /fizz-buzz/{int}`

Ce service doit renvoyer du JSON sous le format `{ "result": XXX }` où `XXX` vaut :
* `Fizz` si `{int}` est multiple de 3
* `Buzz` si `{int}` est multiple de 5
* Une chaîne représentant la valeur passée sinon

Exemples :

    GET /fizz-buzz/1 => { "result": "1" }
    GET /fizz-buzz/3 => { "result": "Fizz" }
    GET /fizz-buzz/5 => { "result": "Buzz" }
    GET /fizz-buzz/7 => { "result": "7" }

## `POST /fizz-buzz`

On souhaite maintenant poster des paramètres au service : 
* un élément de début, `from`, optionnel et ayant pour valeur par défaut 1 ;
* un élément de fin (inclus), `to`, obligatoire.

Le service consomme du JSON et retourne du JSON. 

Le résultat contient une propriété results dont la valeur est le résultat d'un FizzBuzz sur l'intervalle demandé.

Exemples : 

    POST /fizz-buzz { "from": 2, "to": 3 }
        {
          "results": [ "2", "Fizz"] 
        }

    POST /fizz-buzz { "to": 5}
        { 
          "results": [ "1", "2", "Fizz", 4, "Buzz" ] 
        }


# Informations complémentaires

Le squelette d'application fourni déjà un serveur d'application embarqué. Pour le lancer : 
 
    mvn jetty:run
    
L'application est accessible par défaut sur le port 8080.
