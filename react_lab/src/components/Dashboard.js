import React, { useState } from 'react';
import Posts from './post/Posts';
import '../css/post.css';
import PostDetail from './post/PostDetail';

export default function Dashboard() {
    const [postsState, setPostsState]= useState(
        [
            { id: 1, title: "Post 1", author: "Author 1",content:"This is content of post 1"},
            { id: 2, title: "Post 2", author: "Author 2",content:"This is content of post 2" },
            { id: 3, title: "Post 3", author: "Author 3",content:"This is content of post 3" }
        ]
    )
    const [newTitle, setNewTitle] = useState('');

    const updateFirstPostTitle = () => {
        setPostsState((prevPosts) => [
        { ...prevPosts[0], title: newTitle },
        ...prevPosts.slice(1),
        ]);
    };

    const [selectedPost, setSelectedPost] = useState(null);

    return (
        <div className='dashboard'>
            <div className='list_post'>        
                <Posts posts={postsState} onPostClick={setSelectedPost} />   
            </div>
            <div className='update_title'>
                <input
                    type="text"
                    value={newTitle}
                    onChange={(e) => setNewTitle(e.target.value)}
                    placeholder="Enter new title"
                />
                <button onClick={updateFirstPostTitle}>Update First Post Title</button>
            </div>
            <div className='post_detail'>   
                {selectedPost && <PostDetail post={selectedPost} />}
            </div>
        </div>
    );
};

