package org.example.labsbackend.models;

import java.time.LocalDateTime;

public class Record {
    private Long id;
    private Long userId;
    private Long categoryId;
    private LocalDateTime createdAt;
    private Double amount;

    public Record() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}

