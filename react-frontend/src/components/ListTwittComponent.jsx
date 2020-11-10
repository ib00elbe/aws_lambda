import React, { Component } from 'react'
import TwittService from '../services/TwittService'

class ListTwittComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            twitts: []
        }

    }

    componentDidMount(){
        TwittService.getTweets().then((res) => {
            this.setState({ twitts: res.data });
        });
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Twitts List</h2>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Twitt ID</th>
                                    <th> Twitt Post</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.twitts.map(
                                        twitt => 
                                        <tr>
                                            <td> { twitt.postId } </td>
                                            <td> { twitt.postContent} </td>  
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                 </div>

            </div>
        )
    }
}

export default ListTwittComponent
