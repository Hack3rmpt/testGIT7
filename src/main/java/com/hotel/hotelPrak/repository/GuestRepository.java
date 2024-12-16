package com.hotel.hotelPrak.repository;

import com.hotel.hotelPrak.model.GuestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestRepository extends JpaRepository<GuestModel, UUID> {
}