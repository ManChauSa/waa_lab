import React from "react";

const Comment =(props) =>{
    console.log(props)
    return (
        <div>
            {props.comment}
        </div>
    )
};

export default Comment;