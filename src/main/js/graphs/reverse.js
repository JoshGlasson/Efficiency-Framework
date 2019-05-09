const React = require('react');
const ReactDOM = require('react-dom');
import Plot from 'react-plotly.js';

class Reverse extends React.Component {
constructor(props) {
  super(props)
    this.state = {x: [], y: [], title: "Refresh Reverse Data", class: "list-group-item list-group-item-action", disabled: false, disablebutton: ""};
    this.changeTitle= this.changeTitle.bind(this);
    this.onMouseEnterHandler= this.onMouseEnterHandler.bind(this);
    this.onMouseLeaveHandler= this.onMouseLeaveHandler.bind(this);
    fetch('/api/reverses', {
              method: 'GET',
              headers: {
              'Content-Type': 'application/json',
              },
              credentials: 'same-origin'
              }).then((response) => {
                   if(response.ok) {
                     return response.json();
                   } else {
                     throw new Error('Server response wasn\'t OK');
                   }
                 })
                 .then((json) => {
                   this.setState(state => ({x: json._embedded.reverses[0].arraySize, y: json._embedded.reverses[0].timeTaken}))
                   console.log(this.state.x + this.state.y);
                 });
  }

    changeTitle(){
      this.setState({ title: ""});
      this.setState({ class: "spinner-border text-primary" });
      this.setState({ disabled: true });
      this.setState({ disablebutton: " disabled" });
        };

    onMouseEnterHandler() {
    if(this.state.disabled != true){
            this.setState({ class: "list-group-item list-group-item-action active" });
            }
        };
    onMouseLeaveHandler() {
    if(this.state.disabled != true){
        this.setState({ class: "list-group-item list-group-item-action" });
        }
        };

    render() {
    console.log("x " + this.state.x)
    console.log("y " + this.state.y)
    return (
    <div>
    <h3><a href="/" class={"btn btn-dark"+this.state.disablebutton}>Back</a></h3>
        <h1>Reverse Test</h1>
        <h2><a href="/reverse" class={this.state.class} onClick={this.changeTitle} onMouseEnter={this.onMouseEnterHandler} onMouseLeave={this.onMouseLeaveHandler}>{this.state.title}</a></h2>
      <Plot
        data={[
          {
            x: this.state.x,
            y: this.state.y,
            type: 'scatter',
            mode: 'lines+points',
            marker: {color: '#868e96'},
          },
        ]}
        layout={
        {
            width: 1000,
            height: 500,
            title: 'Reverse Algorithm',
            xaxis: {
             title: 'Items in Array',
             titlefont: {
                 family: 'Courier New, monospace',
                 size: 18,
                 color: '#7f7f7f'
             }
            },
            yaxis: {
              title: 'Time Taken (Milliseconds)',
              titlefont: {
                  family: 'Courier New, monospace',
                  size: 18,
                  color: '#7f7f7f'
               }
            },
        }
        }
      />
      </div>
    );
  }
}

ReactDOM.render(
	<Reverse />,
	document.getElementById('reverse')
)
