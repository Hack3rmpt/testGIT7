package com.hotel.hotelPrak.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "guest")
public class GuestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;

    @Pattern(regexp = "\\d+", message = "Серия паспорта должна содержать только цифры")
    private String passportNumber;

    @Size(min = 6, message = "Номер телефона слишком короткий")
    private String phoneNumber;

    @Nullable
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private RoomModel roomS;

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FeedbackModel> feedbacks = new HashSet<>();

    @ManyToMany(mappedBy = "guests")
    private Set<RoomModel> rooms = new HashSet<>();

    // Геттеры и сеттеры
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoomModel getRoomS() {
        return roomS;
    }

    public void setRoomS(RoomModel roomS) {
        this.roomS = roomS;
    }

    public Set<FeedbackModel> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<FeedbackModel> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Set<RoomModel> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomModel> rooms) {
        this.rooms = rooms;
    }
}