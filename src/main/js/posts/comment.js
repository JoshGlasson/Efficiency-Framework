import React from 'react';

const Comment = (props) => {
	return (
		<div className='comment-main'>
			<div className='comment-content'>
				{props.comment.content.split("\n").map((i,key) => {
                                               return <div key={key}>{i}</div>;
                                           })}
			</div>
			<div className='comment-time'>
                {props.comment.time_stamp}
            </div>
		</div>
	)
}

export default Comment;