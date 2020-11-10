package net.aws2020course.fullstack.controller;

import net.aws2020course.fullstack.model.*;
import net.aws2020course.fullstack.repository.*;
import net.aws2020course.fullstack.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@EnableWebMvc
@Profile("lambda")
@RequestMapping("/api/v1")
public class TwitterController {

    @Autowired
    private TwitterService twitterService;
/*
    @Autowired
    private UserService userService;
    */
    
    @Autowired
	private TwitterRepository twitterRepository;


    /**
     * Forwards the login request to service layer
     * @param email: user's login email
     * @param password: user's login password
     * @return user in JSON format
     */
    /*
    @RequestMapping(value = "/login", method = POST)
    public ResponseEntity<?> login(@RequestParam(value = "email") String email,
                                   @RequestParam(value = "password") String password) {
        User user = userService.login(email, password);
        return ResponseEntity.ok(user);
    }
    */

    /**
     * Forward the post request to service layer
     * @param post: post content
     * @param userId: user's id
     * @return post in JSON format
     */
    
//  x-www-form-urlencoded
    
    @PostMapping(value = "/tweet")
    public ResponseEntity<?> tweet(@RequestParam (value = "post") String post,
                                   @RequestParam (value = "id") Long userId) {
        Post result = twitterService.post(userId, post);
        return ResponseEntity.ok(result);
    } 

    
	// get all twitts
	@GetMapping("/tweet")
	public List<Post> getAllPosts(){
		return twitterRepository.findAll();
	}
	

    /**
     * Forwards the get all posts request to service layer
     * @param id: user's id
     * @return list of posts in JSON format
     */
    @GetMapping(value = "/tweet/{id}")
    public ResponseEntity<?> getTweets(@PathVariable Long id) {
        return ResponseEntity.ok(twitterService.getAllPosts(id));
    }

}
