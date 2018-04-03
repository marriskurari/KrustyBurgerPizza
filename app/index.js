import "../styles.css"
import ReactDOM from "react-dom"
import React from "react"
import Body from "./Body"
import DataController from "./DataController"

class Application extends React.Component {
  render() {
    return (<Body />)
  }
}

const location = document.querySelector("#app")
const app = <Application />
ReactDOM.render(app, location)

const bla = async () => {
	var x = await DataController.hotel.getOne(20)
	console.log(x)
}
