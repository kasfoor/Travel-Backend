package com.travelbackend.travelbackend.microservices.Review;

import javax.persistence.*;

@Entity
@Table
public class Review {
    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private Long destId;
    private String recommendationid;
    private String author;
    private String rate;
    private Long content;

    public Review() {
    }

    public Review(Long destId, String recommendationid, String author, String rate, Long content) {
        this.destId = destId;
        this.recommendationid = recommendationid;
        this.author = author;
        this. rate = rate;
        this.content = content;
    }

    public Review(String recommendationid, String author, String rate, Long content) {
        this.recommendationid = recommendationid;
        this.author = author;
        this. rate = rate;
        this.content = content;
    }

    public Long getDestId() {
        return destId;
    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }

    public String getRecommendationid() {
        return recommendationid;
    }

    public void setRecommendationid(String recommendationid) {
        this.recommendationid = recommendationid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Destination{" +
                "destId=" + destId +
                ", recommendationid='" + recommendationid + '\'' +
                ", author='" + author + '\'' +
                ", rate='" + rate + '\'' +
                ", content='" + content +
                '}';
    }
}
