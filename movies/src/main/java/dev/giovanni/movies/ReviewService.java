package dev.giovanni.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ReviewRepository reviewRepository;
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));
        //We use template for complex query like update the property of a table when changing another one
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
