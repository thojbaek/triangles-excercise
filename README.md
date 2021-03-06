triangles-exercise
==================
**Author:** Thomas Thisted Højbæk

The application consists of a server/RESTful API written in JAVA with Spring Boot, and a small nodejs client.

## Getting started

To run the application, first start the server from the `/server` dir with `gradle run`. The API will then run on `localhost:5555/`.

Then start the client from the `/client` dir by first running `npm install`, and then `npm start`. The client will then be accessible on `localhost:5000/`.

## Available enpoints

* `/triangle/sides?values=[side1],[side2],[side3]`
* `/triangle/angles?values=[angle1],[angle2],[angle3]`

Both endpoints will calculate the missing data, and return a JSON-object in the form of

```JSON
{
"type": [type],
"angles": { [angle1],[angle2],[angle3] },
"sides": { [side1], [side2], [side3] }
}
```