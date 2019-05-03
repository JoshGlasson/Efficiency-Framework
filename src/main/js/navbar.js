import React from 'react';

class NavBar extends React.Component {
    constructor(props) {
        super(props)
        this.buttons = this.buttons.bind(this);
        console.log("In Navbar the user id is:"+this.props.userid);
    }

    render () {
        return (
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
              <a class="navbar-brand" href="#">Acebook</a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                  <li class="nav-item active">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                  </li>
                    {this.buttons()}
                </ul>
              </div>
            </nav>
        )
       }

       buttons() {
        return (

          <li class="nav-item">
                            <a class="nav-link" href="/user/signin/">Log in</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link" href="/user/signout">Log Out</a>
                          </li>


        )
       }
}

export default NavBar;