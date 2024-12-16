package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomModel;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    List<RoomModel> findAllRooms();

    RoomModel findRoomById(UUID id);

    RoomModel addRoom(RoomModel room);

    RoomModel updateRoom(RoomModel room);

    void deleteRoom(UUID id);

}