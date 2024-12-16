package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.GuestModel;
import com.hotel.hotelPrak.service.GuestService;
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
@RequestMapping("/guest")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class GuestController {
    @Autowired
    public GuestService guestService;

    @Autowired
    public RoomService roomService;

    @GetMapping("/all")
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.findAllGuests());
        model.addAttribute("guest", new GuestModel());
        model.addAttribute("rooms", roomService.findAllRooms());
        return "guestList";
    }

    @PostMapping("/add")
    public String addGuest(@Valid @ModelAttribute("guest") GuestModel guest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("guests", guestService.findAllGuests());
            model.addAttribute("rooms", roomService.findAllRooms());
            return "guestList";
        }
        if (guest.getRoomS() == null || guest.getRoomS().getId() == null) {
            model.addAttribute("error", "Room must be selected");
            model.addAttribute("guests", guestService.findAllGuests());
            model.addAttribute("rooms", roomService.findAllRooms());
            return "guestList";
        }
        guestService.addGuest(guest);
        return "redirect:/guest/all";
    }

    @PostMapping("/update")
    public String updateGuest(@Valid @ModelAttribute("guest") GuestModel guest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("guests", guestService.findAllGuests());
            model.addAttribute("rooms", roomService.findAllRooms());
            return "guestList";
        }
        guestService.updateGuest(guest);
        return "redirect:/guest/all";
    }

    @PostMapping("/delete")
    public String deleteGuest(@RequestParam UUID id) {
        guestService.deleteGuest(id);
        return "redirect:/guest/all";
    }

    @GetMapping("/all/{id}")
    public String getGuestById(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("guest", guestService.findGuestById(id));
        model.addAttribute("rooms", roomService.findAllRooms());
        return "guestDetails";
    }
}