import React from 'react';

const Post = (props) => {
  return (
    <div class="post" onClick={props.onClick}>
        <h2>Id: {props.id}</h2>
      <h2>Title: {props.title}</h2>
      <p>Author: {props.author}</p>
    </div>
  );
};

export default Post;
