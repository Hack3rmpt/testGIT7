package com.hotel.hotelPrak.controllers;



import com.hotel.hotelPrak.model.RoleEnum;
import com.hotel.hotelPrak.model.UserModel;
import com.hotel.hotelPrak.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registrationView(Model model){
        model.addAttribute("user", new UserModel());
        return "regis";
    }

    @PostMapping("/registration")
    public String registrationUser(UserModel user, Model model){
        if(user.getPassword().length() < 8 || !user.getPassword().matches(".*[a-z].*") || !user.getPassword().matches(".*[@#$!?%^&+=].*")){
            model.addAttribute("password_message","Пароль должен быть больше 8 символов, содержать хотя бы одну строчную букву и один спецсимвол");
            return "regis";
        }
        if (userRepository.existsByUsername(user.getUsername())){
            model.addAttribute("message", "Пользователь уже существует");
            return "regis";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(RoleEnum.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

}