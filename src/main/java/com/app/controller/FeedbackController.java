package com.app.controller;

import com.app.dto.FeedbackDTO;
import com.app.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin("*")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping
	public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
		FeedbackDTO createdFeedback = feedbackService.createFeedback(feedbackDTO);
		return ResponseEntity.ok(createdFeedback);
	}

	@GetMapping
	public ResponseEntity<List<FeedbackDTO>> getAllFeedbacks() {
		List<FeedbackDTO> feedbacks = feedbackService.getAllFeedbacks();
		return ResponseEntity.ok(feedbacks);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable Long id) {
		Optional<FeedbackDTO> feedback = feedbackService.getFeedbackById(id);
		return feedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<FeedbackDTO> updateFeedback(@PathVariable Long id, @RequestBody FeedbackDTO feedbackDTO) {
		FeedbackDTO updatedFeedback = feedbackService.updateFeedback(id, feedbackDTO);
		if (updatedFeedback != null) {
			return ResponseEntity.ok(updatedFeedback);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
		feedbackService.deleteFeedback(id);
		return ResponseEntity.noContent().build();
	}
}