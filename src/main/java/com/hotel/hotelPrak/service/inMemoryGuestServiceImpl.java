package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.GuestModel;
import com.hotel.hotelPrak.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class inMemoryGuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<GuestModel> findAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public GuestModel findGuestById(UUID id) {
        return guestRepository.findById(id).orElse(null);
    }

    @Override
    public GuestModel addGuest(GuestModel guest) {
        if (guest.getRoomS() == null || guest.getRoomS().getId() == null) {
            throw new IllegalArgumentException("Room must be selected");
        }
        return guestRepository.save(guest);
    }

    @Override
    public GuestModel updateGuest(GuestModel guest) {
        return guestRepository.save(guest);
    }

    @Override
    public void deleteGuest(UUID id) {
        guestRepository.deleteById(id);
    }
}