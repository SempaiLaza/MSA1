package bsuir.laza.main.controllers;

import bsuir.laza.main.dto.UserDto;
import bsuir.laza.main.service.UserService;
import bsuir.laza.main.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @PostMapping("/api/make-user-admin")
    public void makeUserAdmin(@RequestParam String username) {
        userService.makeUserAdmin(username);
    }

    @GetMapping("/api/get-all-admins")
    public List<UserDto> getAllAdmins() {
        return userService.getAllAdminUsers().stream().map(Converter::convertUser).toList();
    }

    @PostMapping("/api/delete-admin")
    public void deleteAdmin(@RequestParam String username) {
        userService.deleteAdmin(username);
    }
}