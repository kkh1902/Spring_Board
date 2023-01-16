package com.example.springboot.data.dao;

import com.example.springboot.data.entity.Posts;

public interface PostsDAO {

    Posts insertPosts(Posts posts);

    Posts selectPosts(Long number);

    Posts updatePostsName(Long number, String name) throws Exception;

    void deletePosts(Long number) throws Exception;
}
