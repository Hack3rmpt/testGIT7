package com.hotel.hotelPrak.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Entity
@Table(name = "feedback")
public class FeedbackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestModel guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomModel room;

    private int evaluation;

    @Size(min = 3, message = "Слишком короткий комментарий, в нем нет смысла")
    private String comment;

    @Nullable
    private String picture;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GuestModel getGuest() {
        return guest;
    }

    public void setGuest(GuestModel guest) {
        this.guest = guest;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}