const React = require('react');
const ReactDOM = require('react-dom');

import Sort from './graphs/sort'
import Test from './graphs/test'

class App extends React.Component {

  render() {
    return (
    <div>
    <h1>Sort Test</h1>
    <h2><a href="/sort">Re-do Sort</a></h2>
    <Sort />
    </div>
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)




