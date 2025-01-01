package org.example.labsbackend.services;

import org.example.labsbackend.models.Record;
import org.example.labsbackend.repositories.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Record getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}

