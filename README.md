## Acebook

This is a java/springboot and react project to be developed on.

It uses:
  - `maven` to build the project
  - `webpack` to bundle the javascript
  - `thymeleaf` to serve `index.html`
  - `react` to make requests to the api and render the component views
  - `flyway` to manage `postgres` db migrations

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

**IMPORTANT:** Test your understanding by diagramming the request/response cycles that occur when you load the app by visiting `localhost:8080`

### Learning Plan

This project will ultimately be really rewarding if you follow these three points:
  1. **Work as a team.** Don't be tempted to split up to learn solo. At the very least pair on learning, and share knowledge as a team.
  2. As a team, **plan your learning**. There's a ton of new things in this project, purposefully so. That's ok. As always with everything, **take it slowly & in small steps**: ask a coach if you want more ideas how to plan your team learning.
  3. As an individual, **plan your learning**. Use `Diode` to keep yourself focused on setting and achieving your learning goals.


### Database

Flyway is being used to manage your database migrations. Use the flyway docs to become familiar how to migrate your data.

### Deployment

- This template application is hosted on heroku at https://springboot-react-template.herokuapp.com/
- Have a look at `application.properties`, `application-dev.properties` and `application-prod.properties`
- The first line in `application.properties` specifies that the application is run using the config in `application-dev.properties`.
- The config in `application-dev.properties` specifies that the development datebase be used.
- This ensures that you do not manipulate the production database whilst developing new features.
- Before deploying your application, you'll need to add some config to `application-prod.properties` so that the deployed application uses the production database.
- Then, make sure the deployed app will use `application-prod.properties` by using `spring.profiles.active=dev` in your deployment script.


