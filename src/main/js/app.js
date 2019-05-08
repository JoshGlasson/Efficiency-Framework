const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {
constructor(props) {
  super(props)
    this.state = {title: "Refresh All Data", class: "list-group-item list-group-item-action", disabled: false};
    this.changeTitle= this.changeTitle.bind(this);
    this.onMouseEnterHandler= this.onMouseEnterHandler.bind(this);
    this.onMouseLeaveHandler= this.onMouseLeaveHandler.bind(this);
  }

    changeTitle(){
      this.setState({ title: "All Data Refreshing"});
      this.setState({ class: "list-group-item list-group-item-action disabled" });
      this.setState({ disabled: true });
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
    <h3><a href="/sortgraph" class="btn btn-primary">Sort</a></h3>
    <h3><a href="/reversegraph" class="btn btn-secondary">Reverse</a></h3>
    </div>
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)




