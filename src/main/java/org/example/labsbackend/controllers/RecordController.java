package org.example.labsbackend.controllers;

import org.example.labsbackend.models.Record;
import org.example.labsbackend.services.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<Record> createRecord(@Valid @RequestBody Record record) {
        Record createdRecord = recordService.createRecord(record);
        return ResponseEntity.ok(createdRecord);
    }

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable Long id) {
        Record record = recordService.getRecordById(id);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}



