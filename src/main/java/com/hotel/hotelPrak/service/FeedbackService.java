package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.FeedbackModel;

import java.util.List;
import java.util.UUID;

public interface FeedbackService {

    List<FeedbackModel> findAllFeedback();

    FeedbackModel findFeedbackById(UUID id);

    FeedbackModel addFeedback(FeedbackModel feedback);

    FeedbackModel updateFeedback(FeedbackModel feedback);

    void deleteFeedback(UUID id);

}