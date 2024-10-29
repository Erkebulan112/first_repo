package com.erkosh.controllers;

import com.erkosh.dto.PassportDTO;
import com.erkosh.repositories.PassportRepository;
import com.erkosh.services.PassportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passports")
public class PassportController {
    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping
    public List<PassportDTO> getAllPasports() {
        return passportService.getAllPassports();
    }

    @GetMapping("/{id}")
    public PassportDTO getPassportById(@PathVariable("id") long id) {
        return passportService.getPassportById(id);
    }

    @PostMapping("/new-passport")
    public PassportDTO addPassport(@RequestBody PassportDTO passport) {
        passportService.addPassport(passport);
        return passport;
    }

    @PutMapping("/{id}/edit")
    public PassportDTO editPassport(@PathVariable("id") long id, @RequestBody PassportDTO passport) {
        passportService.updatePassport(id, passport);
        return passport;
    }

    @DeleteMapping("/{id}")
    public String deletePassport(@PathVariable("id") long id) {
        passportService.deletePassport(id);
        return "Deleted Passport with id " + id;
    }
}
