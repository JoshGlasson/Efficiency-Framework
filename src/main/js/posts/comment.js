import React from 'react';
const client = require('../client');


//
//const Comment = (props) => {
//	return (
//		<div className='comment-main'>
//		    <div className='comment-time'>
//                <strong>{props.comment.userid}</strong>
//            </div>
//	    	<div className='comment-content'>
//				{props.comment.content.split("\n").map((i,key) => {
//                                               return <div key={key}>{i}</div>;
//                                           })}
//			</div>
//			<div className='comment-time'>
//                <small>{props.comment.time_stamp}</small>
//            </div>
//		</div>
//	)
//}
//
//export default Comment;
//

class Comment extends React.Component {
  constructor(props) {
    super(props)
    this.state = {commenter: null}

client({method: 'GET', path: '/api/users/'+ this.props.comment.userid}).then(response => {
                console.log("RESPONSE COMMENTS USERID"+ this.props.comment.userid);
                console.log(response.entity.name);
                this.setState({commenter: response.entity.name});
});

 }


 render () {
 return (
 		<div className='comment-main'>
 		    <div className='comment-time'>
                 <strong>{this.state.commenter}</strong>
             </div>
 	    	<div className='comment-content'>
 				{this.props.comment.content.split("\n").map((i,key) => {
                                                return <div key={key}>{i}</div>;
                                            })}
 			</div>
 			<div className='comment-time'>
                 <small>{this.props.comment.time_stamp}</small>
             </div>
 		</div>
 	)
 }


 }
 export default Comment;