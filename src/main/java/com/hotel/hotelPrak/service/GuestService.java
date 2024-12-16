package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.GuestModel;

import java.util.List;
import java.util.UUID;

public interface GuestService {
    List<GuestModel> findAllGuests();

    GuestModel findGuestById(UUID id);

    GuestModel addGuest(GuestModel guest);

    GuestModel updateGuest(GuestModel guest);

    void deleteGuest(UUID id);
}