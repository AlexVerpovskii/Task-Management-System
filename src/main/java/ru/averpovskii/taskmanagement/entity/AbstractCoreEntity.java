package ru.averpovskii.taskmanagement.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractCoreEntity<I extends Serializable> {
    protected Timestamp createdAt;
    protected Timestamp updatedAt;
    protected Timestamp deletedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Timestamp.from(Instant.now());
    }
}
