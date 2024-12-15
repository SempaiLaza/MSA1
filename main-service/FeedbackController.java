package bsuir.laza.main.controllers;

import bsuir.laza.main.dto.FeedbackDto;
import bsuir.laza.main.dto.ResponseWrapper;
import bsuir.laza.main.service.FeedbackService;
import bsuir.laza.main.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping(value = {"/api/send-feedback"})
    public void sendFeedback(@RequestBody String message) {
        feedbackService.saveFeedback(message);
    }

    @GetMapping("/api/get-all-feedbacks")
    public ResponseWrapper<FeedbackDto> getAllFeedbacks(@RequestParam Integer page) {
        return Converter.convertFeedback(feedbackService.getFeedbacks(PageRequest.of(page, 10)));
    }

    @DeleteMapping("/api/delete-feedback")
    public void deleteFeedback(@RequestParam Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }
}