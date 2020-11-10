import React, { Component } from 'react'
import UserService from '../services/UserService'
import TwittService from '../services/TwittService'

class TwittUserComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            user: {},
            twitt: ''
        }
        this.changeTwittHandler = this.changeTwittHandler.bind(this);
    }

    componentDidMount(){
        UserService.getUserById(this.state.id).then( res => {
            this.setState({user: res.data});
        })
    }

    changeTwittHandler= (event) => {
        event.preventDefault();
        this.setState({twitt: event.target.value});
    }

    postTwitt = (e) => {
        e.preventDefault();
        let twitt = {twitt: this.state.twitt};
        console.log('twitt => ' + JSON.stringify(twitt));        

        TwittService.createTweet(twitt, this.state.id).then( res => {
                this.props.history.push('/');
            });
        
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Twitt Component </h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> User: </label>
                            <div> { this.state.user.firstName }</div>
                        </div>
                        <div>
                            <input placeholder="Twitt content" name="twitt" type="text" 
                            value={this.state.twitt} onChange={this.changeTwittHandler}/>
                        </div>
                        <div>
                            <button style={{marginLeft: "10px"}} onClick={this.postTwitt} className="btn btn-info">Twitt!</button>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default TwittUserComponent
