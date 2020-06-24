const express = require("express");
const bodyParser = require("body-parser");
const mongodb = require("mongodb"); //import mongodb native drivers
const MongoClient = mongodb.MongoClient;  //khai bao bien MongoClient để sử dụng mongodb
var url = 'mongodb://localhost:27017/DBQuanLyCay';

const app = express();

let db;

MongoClient.connect(url, function (err, client) {
    if (err) {
        console.log('Khong the ket noi toi mongoDB server. Loi la', err)
    } else {
        console.log('da ket noi duoc', url);
        db = client.db("DBQuanLyCay");
    }
})

// let plant = [{
//     "plantImg": "https://mrhoa.com/wp-content/uploads/2018/09/cay-kim-tien-phong-thuy.jpg",
//     "plantName": "Cay phat tai - cay kim tien"
// }, {
//     "plantImg": "https://mrhoa.com/wp-content/uploads/2018/09/cay-kim-ngan-trong-trong-nha.jpg",
//     "plantName": "Cay kim ngan"
// }, {
//     "plantImg": "https://mrhoa.com/wp-content/uploads/2018/09/cay-phong-thuy-thiet-moc-lan.jpg",
//     "plantName": "Cay thiet moc lan"
// }, {
//     "plantImg": "https://mrhoa.com/wp-content/uploads/2018/09/cay-phong-thuy-ngoc-ngan.jpg",
//     "plantName": "Cay ngoc ngan"
// }, {
//     "plantImg": "https://mrhoa.com/wp-content/uploads/2018/09/cay-thanh-lan-phong-thuy.jpg",
//     "plantName": "Cay thanh lan"
// }, {
//     "plantImg": "https://mrhoa.com/wp-content/uploads/2018/09/cay-tai-loc-phong-thuy.jpg",
//     "plantName": "Cay tai loc"
// }]

app.use(bodyParser.urlencoded({ extended: true }));

app.set("view engine", "ejs");

app.listen(3000, function () {
    console.log("running on port 3000");
})

//app.get là lấy dữ liệu từ sever mỗi khi user send req
app.get("/index", function (req, res) {
    let plantList = db.collection("QuanLyCay").find().toArray().then(result => { //database sẽ được trả về biến result và đc in ra console
        console.log(result);
        res.render("index.ejs", { result });
    }).catch(error => {
        console.error(error); //in lỗi ra màn hình console
    })
    // res.render("index.ejs", { result: plant }); // res. là syntax trả dữ liệu
})

app.use(express.static(__dirname));

//Thêm đối tượng
app.post("/newPlant", function (req, res) {
    console.log("da nhan req them obj", req.body)
    // let newPlantImg = req.body.plantImg;
    // let newPlantName = req.body.plantName;
    // let newPlant = { plantImg: newPlantImg, plantName: newPlantName };
    // plant.push(newPlant);
    db.collection("QuanLyCay").insertOne(req.body).then(result => { //database sẽ được trả về biến result và đc in ra console
        console.log(result);
    }).catch(error => {
        console.error(error); //in lỗi ra màn hình console
    })
    res.redirect("/index");
})

app.get('/index/:plantId', function (req, res) {
    let id = req.params['plantId'];
    let objId = require('mongodb').ObjectID
    db.collection("QuanLyCay").findOne({ _id: new mongodb.ObjectID(id) }).then(result => { //database sẽ được trả về biến result và đc in ra console
        console.log(result);
        res.render("plant.ejs", { plant: result })
    }).catch(error => {
        console.error(error); //in lỗi ra màn hình console
    })
    // res.send('id của plant là' + id);
})

app.post("/updatePlant", function (req, res) {
    console.log("da nhan req update", req.body)
    let objId = require('mongodb').ObjectID
    db.collection("QuanLyCay").findOneAndUpdate(
        { _id: new objId(req.body._id) },
        { $set: { plantImg: req.body.plantImg, plantName: req.body.plantName } },
    ).then(result => { //database sẽ được trả về biến result và đc in ra console
        console.log(result);
    }).catch(error => {
        console.error(error); //in lỗi ra màn hình console
    })
    res.redirect("/index");
})

app.post("/deletePlant", function (req, res) {
    console.log("da nhan req delete", req.body)
    let objId = require('mongodb').ObjectID
    db.collection("QuanLyCay").deleteOne(
        { _id: new objId(req.body._id) },
    ).then(result => { //database sẽ được trả về biến result và đc in ra console
        console.log(result);
    }).catch(error => {
        console.error(error); //in lỗi ra màn hình console
    })
    res.redirect("/index");
})

// //Xoá đối tượng
// app.post("/removePlant", function (req, res) { //req là biến để lưu thông tin user gửi lên
//     console.log("da nhan req xoa");             //res là biến để lưu thông tin sever gửi về
//     for (var i = 0; i < plant.length; i++) {
//         if (plant[i].plantName === req.body.plantName) {
//             plant.splice(i, 1);
//         }
//     }
//     res.redirect("/index");
// })


// app.post("/editPlantName", function (req, res) {
//     console.log("da nhan req edit name");
//     for (var i = 0; i < plant.length; i++) {
//         if (plant[i].plantName === req.body.plantName) {
//             plant[i].plantName = req.body.newPlantName
//         }
//     }
//     res.redirect("/index");//lệnh sau khi thực hiện xong vòng lặp thì trả về luôn trang /index
// })

// app.post("/editPlantImg", function (req, res) {
//     console.log("da nhan req edit img");
//     for (var i = 0; i < plant.length; i++) {
//         if (plant[i].plantImg === req.body.plantImg) {
//             plant[i].plantImg = req.body.newPlantImg
//         }
//     }
//     res.redirect("/index");
// })

