// import React from 'react';
import React, { useState } from 'react';
import Post from './Post';
import PostDetail from './PostDetail';

const Posts = (props) => {
    const handlePostClick = (post) => {
        props.onPostClick(post);
    };
   const posts = props.posts.map(post =>{
     return <Post 
     id={post.id} 
     title={post.title} 
     author={post.author} 
     key={post.id}
     onClick={() => handlePostClick(post)}/>
    });
    return posts;
};

export default Posts;
