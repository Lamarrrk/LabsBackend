package org.example.labsbackend.repositories;
import org.example.labsbackend.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
