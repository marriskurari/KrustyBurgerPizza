import React from "react"
import Jumbotron from "./Components/Jumbotron"
import DCtrl from "../DataController"

export default class SearchMain extends React.Component {
  constructor(props) {
    super(props)
    this.getAllAndPushToCardHolder = this.getAllAndPushToCardHolder.bind(this)
  }

  async getAllAndPushToCardHolder() {
    console.log("the correct one :)")
    const data = await DCtrl.hotel.getAll()
    console.log(data)
  }

  render() {
		return(
      <React.Fragment>
        <Jumbotron getAll={this.getAllAndPushToCardHolder}/>
      </React.Fragment>
    )
  }
}
