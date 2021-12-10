# admin-trello
Use this REST API for create tasks, issues & bugs in Trello Board.

Needs: 
Java 11, mvn 3.6.3

How to run:
$ mvn clean install -DskipTests
$ mvn spring-boot:run

#######################

Endpoint:
POST: /api/trello/card

Request example No. 1:
{
    "type":"issue",
    "title": "issue v1",
    "description":"description issue v1"
}

Request example No. 2:
{
    "type":"bug",
    "description":"description bug v1"
}

Request example No. 3:
{
    "type":"task",
    "title": "task v1",
    "category":"description task v1"
}

Common response example(it returns id new card):
61b2d8323b351c4bc3be4d24

#######################

Needs to change session:
You'll find the keys and ids in application.properties file.

Regards,

