/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.storejpa.todolist.cm.store;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import io.vizend.studyflow.domain.todolist.cm.store.TaskStore;
import io.vizend.studyflow.storejpa.todolist.cm.store.repository.TaskJpaRepository;
import jakarta.persistence.EntityManager;
import io.vizend.studyflow.domain.todolist.cm.entity.Task;
import io.vizend.studyflow.storejpa.todolist.cm.store.jpo.TaskJpo;
import java.util.List;
import java.util.Optional;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.prologue.support.query.jpa.JpaDynamicQuery;
import io.vizend.accent.domain.message.dynamic.DynamicQuery;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import io.vizend.accent.domain.type.Offset;
import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class TaskJpaStore implements TaskStore {
    /* Gen by Vizend Vista v7.0.0 */
    private final TaskJpaRepository taskJpaRepository;
    private final EntityManager entityManager;

    @Override
    public void create(Task task) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskJpo taskJpo = new TaskJpo(task);
        taskJpaRepository.save(taskJpo);
    }

    @Override
    public void createAll(List<Task> tasks) {
        /* Gen by Vizend Vista v7.0.0 */
        if (tasks == null) {
            return;
        }
        List<TaskJpo> taskJpos = tasks.stream().map(TaskJpo::new).collect(Collectors.toList());
        taskJpaRepository.saveAll(taskJpos);
    }

    @Override
    public Task retrieve(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        Optional<TaskJpo> taskJpo = taskJpaRepository.findById(id);
        return taskJpo.map(TaskJpo::toDomain).orElse(null);
    }

    @Override
    public Task retrieve(QueryParams queryParams) {
        /* Gen by Vizend Vista v7.0.0 */
        DynamicQuery<TaskJpo> query = new JpaDynamicQuery<>(entityManager, queryParams, TaskJpo.class);
        TaskJpo taskJpo = query.findOne();
        return Optional.ofNullable(taskJpo).map(jpo -> jpo.toDomain()).orElse(null);
    }

    @Override
    public List<Task> retrieveAll(List<String> taskIds) {
        /* Gen by Vizend Vista v7.0.0 */
        Iterable<TaskJpo> allById = taskJpaRepository.findAllById(taskIds);
        return TaskJpo.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public List<Task> retrieveList(QueryParams queryParams, Offset offset) {
        /* Gen by Vizend Vista v7.0.0 */
        DynamicQuery<TaskJpo> query = new JpaDynamicQuery<>(entityManager, queryParams, offset, TaskJpo.class);
        List<TaskJpo> taskJpos = query.findAll();
        return Optional.ofNullable(taskJpos).map(jpos -> TaskJpo.toDomains(jpos)).orElse(new ArrayList<>());
    }

    @Override
    public void update(Task task) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskJpo taskJpo = new TaskJpo(task);
        taskJpaRepository.save(taskJpo);
    }

    @Override
    public void delete(Task task) {
        /* Gen by Vizend Vista v7.0.0 */
        taskJpaRepository.deleteById(task.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        taskJpaRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        Optional<TaskJpo> taskJpo = taskJpaRepository.findById(id);
        return taskJpo.isPresent();
    }
}
