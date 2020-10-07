//sever.js
const express = require("express");
const app = express();
var port = process.env.PORT || 8080;
// var mongoose = require('mongoose');
// var passport = require('passport');
// var flash = require('connect-flash');

// var morgan = require('morgan');
// var cookieParser = require('cookie-parser');
const bodyParser = require("body-parser");
// var session = require('express-session');

// var configDB = require('./config/database.js');

// mongoose.connect(configDB.url);//connect toi database

// require('./config/passport')(passport)

var mysql = require('mysql');







const con = mysql.createConnection({
    host: '127.0.0.1',
    user: 'root',
    password: 'techmaster',
    database: 'dbplant'
});

// app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.set("view engine", "ejs");

app.listen(3000, function () {
    console.log("running on port 3000");
})
app.use(express.static(__dirname)); //link voi css


// Truy xuất tất cả dữ liệu plants
app.get('/index', function (req, res) {
    con.query('SELECT * FROM plants', function (error, results, fields) {
        if (error) throw error;
        return res.render('index.ejs', { plants: results });
    });
});

//Thêm user mới
app.post('/newPlant', function (req, res) {
    let plantImg = req.body.plantImg;
    let plantName = req.body.plantName;
    let idplant = req.body.idplant;
    if (!plantImg || !plantName || !idplant) {
        return res.status(400).send({ error: true, message: 'Please provide plant' });
    }
    con.query("INSERT INTO plants SET ? ", { plantImg: plantImg, plantName: plantName, idplant: idplant }, function (error, results, fields) {
        if (error) throw error;
        return res.redirect("/index");
    });

});


app.get('/index/:idplant', function (req, res) {
    let idplant = req.params.idplant;
    var sql = 'SELECT * FROM plants WHERE idplant = ?';
    con.query(sql, idplant, function (error, results, fields) {
        if (error) throw error;
        return res.render('plant.ejs', { plants: results });
    });
});

//Cập nhật plant với id
app.post('/updatePlant', function (req, res) {
    let idplant = req.body.idplant;
    let plantImg = req.body.plantImg;
    let plantName = req.body.plantName;
    if (!idplant || !plantImg || !plantName) {
        return res.status(400).send({ error: plantName, message: 'Please provide enough information' });
    }
    con.query("UPDATE plants SET plantImg = ? ,plantName = ? WHERE idplant = ?", [plantImg, plantName, idplant], function (error, results, fields) {
        if (error) throw error;
        return res.redirect('/index');
    });
});


//  Xóa user
app.post('/deletePlant', function (req, res) {
    let idplant = req.body.idplant;
    if (!idplant) {
        return res.status(400).send({ error: true, message: 'Please provide idplant' });
    }
    con.query('DELETE FROM plants WHERE idplant = ?', [idplant], function (error, results, fields) {
        if (error) throw error;
        return res.redirect('/index');
    });
});

//tim kiem du lieu
app.post('/plantDetail', function (req, res) {
    let plantName = req.body.plantName;
    if (!plantName) {
        return res.status(400).send({ error: true, message: 'Please provide idplant' });
    }
    var sql = 'SELECT * FROM plants WHERE plantName = ?'
    con.query(sql, plantName, function (error, results, fields) {
        if (error) throw error;
        if (results.length < 1) {
            return res.status(400).send({ error: true, message: 'Ban viet sai ten cay roi!' });
        }
        return res.render('plantDetail.ejs', { plants: results });
    });
})

