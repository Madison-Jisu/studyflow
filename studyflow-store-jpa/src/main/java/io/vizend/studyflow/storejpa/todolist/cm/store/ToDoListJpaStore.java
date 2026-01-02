/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.storejpa.todolist.cm.store;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import io.vizend.studyflow.domain.todolist.cm.store.ToDoListStore;
import io.vizend.studyflow.storejpa.todolist.cm.store.repository.ToDoListJpaRepository;
import jakarta.persistence.EntityManager;
import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
import io.vizend.studyflow.storejpa.todolist.cm.store.jpo.ToDoListJpo;
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
public class ToDoListJpaStore implements ToDoListStore {
    /* Gen by Vizend Vista v7.0.0 */
    private final ToDoListJpaRepository toDoListJpaRepository;
    private final EntityManager entityManager;

    @Override
    public void create(ToDoList toDoList) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListJpo toDoListJpo = new ToDoListJpo(toDoList);
        toDoListJpaRepository.save(toDoListJpo);
    }

    @Override
    public void createAll(List<ToDoList> toDoLists) {
        /* Gen by Vizend Vista v7.0.0 */
        if (toDoLists == null) {
            return;
        }
        List<ToDoListJpo> toDoListJpos = toDoLists.stream().map(ToDoListJpo::new).collect(Collectors.toList());
        toDoListJpaRepository.saveAll(toDoListJpos);
    }

    @Override
    public ToDoList retrieve(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        Optional<ToDoListJpo> toDoListJpo = toDoListJpaRepository.findById(id);
        return toDoListJpo.map(ToDoListJpo::toDomain).orElse(null);
    }

    @Override
    public ToDoList retrieve(QueryParams queryParams) {
        /* Gen by Vizend Vista v7.0.0 */
        DynamicQuery<ToDoListJpo> query = new JpaDynamicQuery<>(entityManager, queryParams, ToDoListJpo.class);
        ToDoListJpo toDoListJpo = query.findOne();
        return Optional.ofNullable(toDoListJpo).map(jpo -> jpo.toDomain()).orElse(null);
    }

    @Override
    public List<ToDoList> retrieveAll(List<String> toDoListIds) {
        /* Gen by Vizend Vista v7.0.0 */
        Iterable<ToDoListJpo> allById = toDoListJpaRepository.findAllById(toDoListIds);
        return ToDoListJpo.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public List<ToDoList> retrieveList(QueryParams queryParams, Offset offset) {
        /* Gen by Vizend Vista v7.0.0 */
        DynamicQuery<ToDoListJpo> query = new JpaDynamicQuery<>(entityManager, queryParams, offset, ToDoListJpo.class);
        List<ToDoListJpo> toDoListJpos = query.findAll();
        return Optional.ofNullable(toDoListJpos).map(jpos -> ToDoListJpo.toDomains(jpos)).orElse(new ArrayList<>());
    }

    @Override
    public void update(ToDoList toDoList) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListJpo toDoListJpo = new ToDoListJpo(toDoList);
        toDoListJpaRepository.save(toDoListJpo);
    }

    @Override
    public void delete(ToDoList toDoList) {
        /* Gen by Vizend Vista v7.0.0 */
        toDoListJpaRepository.deleteById(toDoList.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        toDoListJpaRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        Optional<ToDoListJpo> toDoListJpo = toDoListJpaRepository.findById(id);
        return toDoListJpo.isPresent();
    }
}
