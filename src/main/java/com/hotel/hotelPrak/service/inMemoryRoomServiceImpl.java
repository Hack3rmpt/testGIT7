package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomModel;
import com.hotel.hotelPrak.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class inMemoryRoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomModel> findAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public RoomModel findRoomById(UUID id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public RoomModel addRoom(RoomModel room) {
        return roomRepository.save(room);
    }

    @Override
    public RoomModel updateRoom(RoomModel room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(UUID id) {
        roomRepository.deleteById(id);
    }
}