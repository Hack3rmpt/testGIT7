package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.FeedbackModel;
import com.hotel.hotelPrak.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class inMemoryFeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<FeedbackModel> findAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public FeedbackModel findFeedbackById(UUID id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public FeedbackModel addFeedback(FeedbackModel feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public FeedbackModel updateFeedback(FeedbackModel feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(UUID id) {
        feedbackRepository.deleteById(id);
    }
}