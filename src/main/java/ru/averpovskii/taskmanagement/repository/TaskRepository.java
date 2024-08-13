package ru.averpovskii.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.averpovskii.taskmanagement.entity.TaskEntity;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, Long>, CrudRepository<TaskEntity, Long>,
        JpaSpecificationExecutor<TaskEntity> {
}
