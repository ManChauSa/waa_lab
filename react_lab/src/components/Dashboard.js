import React, { useState,useEffect } from 'react';
import Posts from './post/Posts';
import '../css/post.css';
import PostDetail from './post/PostDetail';
import AddPost from './post/AddPost';
import {SelectedPostId } from "../context/SelectedPostId";

export default function Dashboard() {
    const [fetchFlag, setFetchflag] = useState(true);
    const [selectedPostIdState, setselectedPostIdState] = useState(0);

    const changeFetchFlag = () => {
        setFetchflag(!fetchFlag);
    }
    useEffect(() => {
        return () => {
          console.log("Something was unmounted");
        };
      }, [fetchFlag]);

    return (
        <SelectedPostId.Provider value = {{ selectedPostIdState, setselectedPostIdState }}>
            <div className='dashboard'>
                <div className='list_post'>        
                    <Posts  
                    fetchFlag ={fetchFlag}
                    />   
                </div>
                <div className='post_detail'>   
                    <PostDetail 
                        changeFetchFlag={changeFetchFlag} />
                </div>
                <div className='add_post'>
                    <AddPost/>
                </div>
            </div>
        </SelectedPostId.Provider>
    );
};

