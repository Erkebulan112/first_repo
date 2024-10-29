package com.erkosh.controllers;

import com.erkosh.dto.UniverDTO;
import com.erkosh.services.UniverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/univers")
public class UniverController {

    private final UniverService univerService;

    public UniverController(UniverService univerService) {
        this.univerService = univerService;
    }

    @GetMapping
    public List<UniverDTO> getUniver() {
        return univerService.getAllUnivers();
    }

    @GetMapping("/{id}")
    public UniverDTO getUniverById(@PathVariable("id") long id) {
        return univerService.getUniverById(id);
    }

    @PostMapping("/new-univer")
    public UniverDTO createUniver(@RequestBody UniverDTO univer) {
        univerService.addUniver(univer);
        return univer;
    }

    @PatchMapping("/{id}/edit")
    public UniverDTO updateUniver(@PathVariable("id") long id, @RequestBody UniverDTO univer) {
        univerService.updateUniver(id, univer);
        return univer;
    }

    @DeleteMapping("/{id}")
    public void deleteUniver(@PathVariable("id") long id) {
        univerService.deleteUniver(id);
    }
}
