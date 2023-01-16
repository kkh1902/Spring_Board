package com.example.springboot.data.dao.impl;

import com.example.springboot.data.dao.PostsDAO;
import com.example.springboot.data.entity.Posts;
import com.example.springboot.data.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PostsDAOImpl implements PostsDAO {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsDAOImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public Posts insertPosts(Posts posts) {
        Posts savedPosts = postsRepository.save(posts);
        return savedPosts;
    }

    @Override
    public Posts selectPosts(Long number) {
        Posts selectedPosts = postsRepository.getReferenceById(number);
        return selectedPosts;
    }

    @Override
    public Posts updatePostsName(Long number, String name) throws Exception {
        Optional<Posts> selectedPosts = postsRepository.findById(number);

        Posts updatedPosts;
        if (selectedPosts.isPresent()){
            Posts posts = selectedPosts.get();

//            posts.setName(name);
//            posts.setUpdatedAt(LocalDateTime.now());

            updatedPosts = postsRepository.save(posts);
        }else {
            throw new Exception();
        }
        return updatedPosts;
    }

    @Override
    public void deletePosts(Long number) throws Exception {
        Optional<Posts> selectedPosts = postsRepository.findById(number);

        if (selectedPosts.isPresent()){
            Posts posts = selectedPosts.get();

            postsRepository.delete(posts);
        }else {
            throw new Exception();
        }

    }
}
