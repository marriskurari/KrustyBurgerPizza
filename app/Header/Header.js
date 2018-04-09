import React from "react"

export default class Header extends React.Component {
  constructor(props){
    super(props)
    this.state = {text: "a good Header"}
  }

  componentWillMount(){
    setTimeout(() => {
      this.setState({text: "MasterHeader"})
    }, 2000)
  }


  render() {
    return(
      <h1>This is {this.state.text}</h1>
    )
  }
}
