const express = require("express")
const bodyParser = require("body-parser")
const MongoClient = require("mongodb").MongoClient
const app = express()

MongoClient.connect("mongodb://localhost:27017", (err, client) => {
    if (err) {
        return console.log(err)
    }
    console.log("Da ket noi toi database")
})

let quotes = ["Code HTML", 'Style CSS', "Day code len GITHUB"]

app.use(bodyParser.urlencoded({extended: true}))

app.set("view engine", "ejs")

app.get("/", function (req, res) {
    res.send("Hello from server")
})

app.get("/about", function (req, res) {
    res.send("<h1>This is the about function</h1>")
})

app.get("/todo", function (req, res) {
    res.render("index.ejs", {result: quotes})
})

app.post("/new-todo", function (req, res) {
    console.log("Da nhan request", req.body)
    let newTodo = req.body.title
    quotes.push(newTodo)
})

app.listen(3000, function () {
    console.log("hello nodejs running on port 3000")
})

