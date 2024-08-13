package ru.averpovskii.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import ru.averpovskii.taskmanagement.enums.Priority;
import ru.averpovskii.taskmanagement.enums.Status;

@Getter
@Setter
@Entity
@SQLDelete(sql =
        "UPDATE task_manager.task " +
                "SET deleted_at = current_timestamp " +
                "WHERE id = ?")
@Table(name = "task", schema = "task")
public class TaskEntity extends AbstractCoreEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    private UserEntity executor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity author;
}
