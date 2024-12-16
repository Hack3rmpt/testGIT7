package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.RoomModel;
import com.hotel.hotelPrak.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/room")
@PreAuthorize("hasAnyAuthority('ADMIN', 'HOUSEKEEPER')")
public class RoomController {
    @Autowired
    public RoomService roomService;

    @GetMapping("/all")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("room", new RoomModel());
        return "roomList";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'HOUSEKEEPER')")
    public String addRoom(@Valid @ModelAttribute("room") RoomModel room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rooms", roomService.findAllRooms());
            return "roomList";
        }
        roomService.addRoom(room);
        return "redirect:/room/all";
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public String updateRoom(@Valid @ModelAttribute("room") RoomModel room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rooms", roomService.findAllRooms());
            return "roomList";
        }
        roomService.updateRoom(room);
        return "redirect:/room/all";
    }

    @PostMapping("/delete")
    public String deleteRoom(@RequestParam UUID id) {
        roomService.deleteRoom(id);
        return "redirect:/room/all";
    }

    @GetMapping("/all/{id}")
    public String getRoomById(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("room", roomService.findRoomById(id));
        return "roomDetails";
    }
}