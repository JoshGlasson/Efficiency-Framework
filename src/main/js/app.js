const React = require('react');
const ReactDOM = require('react-dom');
import Plot from 'react-plotly.js';

class App extends React.Component {
constructor(props) {
  super(props);
    this.state = {title: "Refresh All Data", class: "list-group-item list-group-item-action", disablebutton: "", disabled: false, sortx: [], sorty: [], reversex: [], reversey: [], shufflex: [], shuffley: [], lastx: [], lasty: [], duplicatex: [], duplicatey: []};
    this.changeTitle= this.changeTitle.bind(this);
    this.onMouseEnterHandler= this.onMouseEnterHandler.bind(this);
    this.onMouseLeaveHandler= this.onMouseLeaveHandler.bind(this);
    fetch('/api/sorts', {
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
                       this.setState(state => ({sortx: json._embedded.sorts[0].arraySize, sorty: json._embedded.sorts[0].timeTaken}))
                       console.log(this.state.sortx + this.state.sorty);
                     });
    fetch('/api/shuffles', {
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
                       this.setState(state => ({shufflex: json._embedded.shuffles[0].arraySize, shuffley: json._embedded.shuffles[0].timeTaken}))
                       console.log(this.state.shufflex + this.state.shuffley);
                     });
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
                       this.setState(state => ({reversex: json._embedded.reverses[0].arraySize, reversey: json._embedded.reverses[0].timeTaken}))
                       console.log(this.state.reversex + this.state.reversey);
                     });
    fetch('/api/lasts', {
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
                       this.setState(state => ({lastx: json._embedded.lasts[0].arraySize, lasty: json._embedded.lasts[0].timeTaken}))
                       console.log(this.state.lastx + this.state.lasty);
                     });
    fetch('/api/duplicateses', {
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
                       this.setState(state => ({duplicatex: json._embedded.duplicateses[0].arraySize, duplicatey: json._embedded.duplicateses[0].timeTaken}))
                       console.log(this.state.duplicatex + this.state.duplicatey);
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
    return (
    <div>
    <h1>Testing Algorithmic Efficiency</h1>
    <h2><a href="/all" class={this.state.class} onClick={this.changeTitle} onMouseEnter={this.onMouseEnterHandler} onMouseLeave={this.onMouseLeaveHandler}>{this.state.title}</a></h2>
    <div class="form-inline">
    <h3><a href="/sortgraph" class={"btn btn-primary"+this.state.disablebutton}>Sort</a></h3>
    <h3><a href="/reversegraph" class={"btn btn-secondary"+this.state.disablebutton}>Reverse</a></h3>
    <h3><a href="/shufflegraph" class={"btn btn-info"+this.state.disablebutton}>Shuffle</a></h3>
    <h3><a href="/lastgraph" class={"btn btn-danger"+this.state.disablebutton}>Last</a></h3>
    <h3><a href="/duplicatesgraph" class={"btn btn-warning"+this.state.disablebutton}>Duplicates</a></h3>
    </div>
    <Plot
            data={[
              {
                x: this.state.sortx,
                y: this.state.sorty,
                type: 'scatter',
                mode: 'lines+points',
                name: "Sort",
              },
              {
                  x: this.state.reversex,
                  y: this.state.reversey,
                  type: 'scatter',
                  mode: 'lines+points',
                  name: "Reverse",
                },
                {
                  x: this.state.shufflex,
                  y: this.state.shuffley,
                  type: 'scatter',
                  mode: 'lines+points',
                  name: "Shuffle",
                },
                {
                  x: this.state.lastx,
                  y: this.state.lasty,
                  type: 'scatter',
                  mode: 'lines+points',
                  name: "Last",
                },
                {
                    x: this.state.duplicatex,
                    y: this.state.duplicatey,
                    type: 'scatter',
                    mode: 'lines+points',
                    name: "Duplicates",
                  },
            ]}
            layout={
            {
                width: 1000,
                height: 500,
                title: 'Algorithmic Complexity Comparison',
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
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)
