import React from 'react';

const Post = (props) => {
  return (
    <div className="post" onClick={props.setSelected}>
        <h2>Id: {props.id}</h2>
      <h2>Title: {props.title}</h2>
      <p>Author: {props.author}</p>
    </div>
  );
};

export default Post;
