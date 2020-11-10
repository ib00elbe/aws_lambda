import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-dark bg-primary">
                    <div><a href="http://localhost:3001" className="navbar-brand">Twaddle App</a></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent
