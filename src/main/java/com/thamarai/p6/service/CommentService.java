package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Comment;
import com.thamarai.p6.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;	
	
	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<>();
		commentRepository.findAll()
		.forEach(comments::add);
		return comments;
	}
	
	public Optional<Comment> getComment(Long id) {
		return commentRepository.findById(id);
	}
	
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}
	
	public void updateComment(Long id, Comment comment) {
		commentRepository.save(comment);
	}
	
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}
}
