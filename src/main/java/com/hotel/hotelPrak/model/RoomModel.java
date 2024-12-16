package com.hotel.hotelPrak.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "room")
public class RoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String typeRoom;
    private String descriptionRoom;

    @OneToOne(mappedBy = "roomS", cascade = CascadeType.ALL)
    private GuestModel guest;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FeedbackModel> feedbacks = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "room_guest",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private Set<GuestModel> guests = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getDescriptionRoom() {
        return descriptionRoom;
    }

    public void setDescriptionRoom(String descriptionRoom) {
        this.descriptionRoom = descriptionRoom;
    }

    public GuestModel getGuest() {
        return guest;
    }

    public void setGuest(GuestModel guest) {
        this.guest = guest;
    }

    public Set<FeedbackModel> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<FeedbackModel> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Set<GuestModel> getGuests() {
        return guests;
    }

    public void setGuests(Set<GuestModel> guests) {
        this.guests = guests;
    }
}