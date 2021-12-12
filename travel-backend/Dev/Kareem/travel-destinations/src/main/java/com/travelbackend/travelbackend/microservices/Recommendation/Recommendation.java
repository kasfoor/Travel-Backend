package com.travelbackend.travelbackend.microservices.Recommendation;

import javax.persistence.*;

@Entity
@Table
public class Recommendation {
    @Id
    @SequenceGenerator(
            name = "recommendation_sequence",
            sequenceName = "recommendation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "destination_sequence"
    )
    private Long destId;
    private String reviewld;
    private String author;
    private String subject;
    private Long content;

    public Recommendation() {
    }

    public Recommendation(Long destId, String reviewld, String author, String subject, Long content) {
        this.destId = destId;
        this.reviewld = reviewld;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

    public Recommendation(String reviewld, String author, String subject, Long content) {
        this.reviewld = reviewld;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

    public Long getDestId() {
        return destId;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public String getReviewld() {
        return reviewld;
    }

    public Long getContent() {
        return content;
    }


    public void setDestId(Long destId) {
        this.destId = destId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setReviewld(String reviewld) {
        this.reviewld = reviewld;
    }

    public void setLongitude(String author) {
        this.author = author;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "destId=" + destId +
                ", reviewld='" + reviewld + '\'' +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content +
                '}';
    }
}
