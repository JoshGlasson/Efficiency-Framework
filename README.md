## Acebook

This is a java/springboot and react project to be developed on.

It uses:
  - `maven` to build the project
  - `webpack` to bundle the javascript
  - `thymeleaf` to serve `index.html`
  - `react` to make requests to the api and render the component views
  - `flyway` to manage `postgres` db migrations
  - 'travis' for CI
  - 'heroku' for deployment

### Card wall

https://trello.com/b/UnIqRe28/acebook-team-java

Team Java - [Josh](https://github.com/JoshGlasson), [Phil](https://github.com/Codeman15), [Jose](https://github.com/Saicam) and [Akua](https://github.com/AkuaAA)

### CI

Using Travis CI

![travis status](https://travis-ci.com/JoshGlasson/acebook-java-template.svg?branch=master)

### Heroku Depoloyed App

https://morning-journey-46166.herokuapp.com/


### Design

This app has a somewhat typical API structure: in this case a springboot API serving data which a react frontend consumes.


### Database

Flyway is being used to manage your database migrations. Use the flyway docs to become familiar how to migrate your data.


### Deployment

- Clone repo and import project into IntelliJ

- From the command line create a dev database `createdb acebook_springboot_development`

- Install Maven `brew install maven`

- Build the app and start the server, using the Maven command `mvn spring-boot:run` and go to `localhost:8080`

- Install Travis 'brew install travis'

- Add a `.travis.yml` file with `language: java`

- Install Heroku 'brew install Heroku'

- Create you Heroku app `heroku create`

- Run `travis setup heroku`

