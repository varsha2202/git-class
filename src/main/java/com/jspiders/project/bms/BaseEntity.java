package com.jspiders.project.bms;

import java.time.LocalDate;

public abstract class BaseEntity {
    private LocalDate createdAt;
    private LocalDate createdBy;
    private LocalDate updatedAt;
    private LocalDate updatedBy;

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LocalDate createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(LocalDate updatedBy) {
        this.updatedBy = updatedBy;
    }
}
