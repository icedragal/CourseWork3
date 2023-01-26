package me.egorzhuravlev.coursework3.controller;

import me.egorzhuravlev.coursework3.model.SockItem;
import me.egorzhuravlev.coursework3.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public ResponseEntity<?> income(@RequestBody SockItem sockItem) {
        storeService.income(sockItem);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> expenditure(@RequestBody SockItem sockItem) {
        storeService.expenditure(sockItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Integer> count(@RequestParam String color,
                                         @RequestParam float size,
                                         @RequestParam (required = false, defaultValue = "0") int cottonMin,
                                         @RequestParam (required = false, defaultValue = "100") int cottonMax) {
        int available = storeService.count(color, size, cottonMin, cottonMax);
        return ResponseEntity.ok(available);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody SockItem sockItem) {
        storeService.expenditure(sockItem);
        return ResponseEntity.ok().build();
    }
}
