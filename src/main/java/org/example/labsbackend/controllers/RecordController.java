package org.example.labsbackend.controllers;

import org.example.labsbackend.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/record")
public class RecordController {
    private final Map<Long, Record> records = new HashMap<>();

    @PostMapping
    public String createRecord(@RequestBody Record record) {
        record.setCreatedAt(LocalDateTime.now());
        records.put(record.getId(), record);
        return "Record created successfully!";
    }

    @GetMapping("/{recordId}")
    public Record getRecord(@PathVariable Long recordId) {
        return records.getOrDefault(recordId, null);
    }

    @DeleteMapping("/{recordId}")
    public String deleteRecord(@PathVariable Long recordId) {
        records.remove(recordId);
        return "Record deleted successfully!";
    }

    @GetMapping
    public Collection<Record> getRecordsByParams(
            @RequestParam(required = false) Long UserID,
            @RequestParam(required = false) Long CategoryID
    ) {
        if (UserID == null && CategoryID == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Потрібно вказати хоча б один параметр: UserID або CategoryID");
        }

        return records.values().stream()
                .filter(record -> (UserID == null || record.getUserId().equals(UserID)) &&
                        (CategoryID == null || record.getCategoryId().equals(CategoryID)))
                .toList();
    }
}




