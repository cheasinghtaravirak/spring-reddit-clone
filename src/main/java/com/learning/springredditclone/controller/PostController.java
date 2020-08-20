package com.learning.springredditclone.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springredditclone.dto.PostRequest;
import com.learning.springredditclone.dto.PostResponse;
import com.learning.springredditclone.service.PostService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping
	public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
		postService.save(postRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<PostResponse>> getAllPosts() {
		return status(HttpStatus.OK).body(postService.getAllPosts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
		return status(HttpStatus.OK).body(postService.getPost(id));
	}

//	@GetMapping("by-subreddit/{id}")
//	public ResponseEntity<List<PostResponse>> getPostsBySubreddit(Long id) {
//		return status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
//	}
	@GetMapping("by-subreddit/{id}")
	public ResponseEntity<List<PostResponse>> getPostsBySubreddit(@PathVariable Long id) {
		return ResponseEntity.status(OK).body(postService.getPostsBySubreddit(id));
	}

//	@GetMapping("by-user/{name}")
//	public ResponseEntity<List<PostResponse>> getPostsByUsername(String username) {
//		return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
//	}
	@GetMapping("by-user/{username}")
	public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String username) {
//		return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
		return ResponseEntity.status(OK).body(postService.getPostsByUsername(username));
	}
}

//@RestController
////@RequestMapping("/api/posts/")
////@RequestMapping("/api/posts/by-user/")
////@RequestMapping("api/posts/by-subreddit/")
////@RequestMapping("/")
//@AllArgsConstructor
//public class PostController {
//
//	private final PostService postService;
//
////	@PostMapping
//	@PostMapping("/api/posts/")
//	public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
//		postService.save(postRequest);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//
////	@GetMapping
//	@GetMapping("/api/posts/")
////	@RequestMapping(value = "/api/posts/", method = RequestMethod.GET)
////	@ResponseBody
//	public ResponseEntity<List<PostResponse>> getAllPosts() {
//		return status(HttpStatus.OK).body(postService.getAllPosts());
//	}
//
////	@GetMapping("/api/posts/")
////	public ResponseEntity<PostResponse> getPost(@RequestParam("id") Long id) {
////		return status(HttpStatus.OK).body(postService.getPost(id));
////	}
//
////
////	@GetMapping("/by-subreddit/{id}")
//	@GetMapping("/api/posts/by-subreddit/")
//	public ResponseEntity<List<PostResponse>> getPostsBySubreddit(@RequestParam("id") Long id) {
//		return status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
//	}
//
////	@GetMapping("{name}")
//	@GetMapping("/api/posts/by-user/")
////	@RequestMapping(value = "/api/posts/by-user/{name}", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<List<PostResponse>> getPostsByUsername(@RequestParam("name") String name) {
//		return status(HttpStatus.OK).body(postService.getPostsByUsername(name));
//	}
//}
