package com.luiz.workshop_mongo.services;

import com.luiz.workshop_mongo.domain.Post;
import com.luiz.workshop_mongo.repository.PostRepository;
import com.luiz.workshop_mongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
