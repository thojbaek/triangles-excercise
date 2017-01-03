var express = require('express');
var flash = require('connect-flash');
var cookieParser = require('cookie-parser');
var session = require("express-session");
var bodyParser = require('body-parser');
var app = express();

var Client = require('node-rest-client').Client;
 
var client = new Client();

app.use(cookieParser('keyboard cat'));
app.use(session({ cookie: { maxAge: 60000 }}));
app.use(flash());

app.set('port', (process.env.PORT || 5000));

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(express.static(__dirname + '/public'));

// views is directory for all template files
app.set('views', __dirname + '/views');
app.set('view engine', 'pug');

app.get('/', function(req, res) {
    //var hasData = req.flash('result').length > 0;
    //console.info(req.flash('result'));
    //console.info(hasData);
    res.render('index', { result: req.flash('result') });
});

app.post('/gettypesides', function(req, res) {
    var side1 = req.body.side1;
    var side2 = req.body.side2;
    var side3 = req.body.side3;

    var endpoint = "http://localhost:5555/triangle/sides?values="+side1+","+side2+","+side3;

    client.get(endpoint, function (data, response) {
        // parsed response body as js object 
        console.log(data);
        console.info(data.type);
        req.flash('result', data.type);
        res.redirect('/');
        // raw response 
        //console.log(response);
    });
});

app.listen(app.get('port'), function() {
  console.log('Node app is running on port', app.get('port'));
});


