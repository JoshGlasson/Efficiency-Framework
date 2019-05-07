import React from 'react';

class Sort extends React.Component {
  constructor(props) {
  super(props)
    this.state = {x: [], y: []};
  }

//  componentDidMount() {
//    client({method: 'GET', path: '/api/sorts'}).then(response => {
//      this.setState({x: response.entity._embedded.sorts[0].arraySize, y: response.entity._embedded.sorts[0].timeTaken});
//    });
//  }

	render() {
	console.log(this.state.x)
	console.log(this.state.y)
		return (
      <h1>Hi</h1>
		)
	}

	getData(){
	fetch('/api/likes', {
              method: 'POST',
              headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
              },
              body: JSON.stringify({
                postid: this.id,
                userid: this.state.userid,
              })
            })
    }
}

export default Sort;
