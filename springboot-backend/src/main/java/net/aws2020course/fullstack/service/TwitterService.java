package net.aws2020course.fullstack.service;

import net.aws2020course.fullstack.repository.*;
import net.aws2020course.fullstack.model.Post;
import net.aws2020course.fullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Sort;

import java.util.Calendar;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class TwitterService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TwitterRepository twitterRepository;

    /**
     * Post the message on the message board
     * @param userId
     * @param postContent
     * @return saved Post
     */
    public Post post(Long userId, String postContent) {
        // Get the user, if user not found, throw an exception
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "cannot find user"));
        // Create a post
        Post post = new Post();
        post.setUser(user);
        post.setPostContent(postContent);
        post.setPostTime(Calendar.getInstance());
        // Save the post into DB
        return twitterRepository.save(post);
    }

    /**
     * Get all post after user login
     * @return List of saved posts
     */
    public List<Post> getAllPosts(Long userId) {
        // Get the user, if user not found, return cannot find user;
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "cannot find user"));
        return user.getPosts();
    }
    
    /**
     * Get all post 
     * @return List of saved posts in ASC order
     */

    public List<Post> getAllPosts() {
        return twitterRepository.findAll(Sort.by(Sort.Direction.ASC, "post_id"));
    }

}
