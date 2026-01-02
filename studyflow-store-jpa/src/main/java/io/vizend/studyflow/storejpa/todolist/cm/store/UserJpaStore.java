/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.storejpa.todolist.cm.store;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import io.vizend.studyflow.domain.todolist.cm.store.UserStore;
import io.vizend.studyflow.storejpa.todolist.cm.store.repository.UserJpaRepository;
import jakarta.persistence.EntityManager;
import io.vizend.studyflow.domain.todolist.cm.entity.User;
import io.vizend.studyflow.storejpa.todolist.cm.store.jpo.UserJpo;
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
public class UserJpaStore implements UserStore {
    /* Gen by Vizend Vista v7.0.0 */
    private final UserJpaRepository userJpaRepository;
    private final EntityManager entityManager;

    @Override
    public void create(User user) {
        /* Gen by Vizend Vista v7.0.0 */
        UserJpo userJpo = new UserJpo(user);
        userJpaRepository.save(userJpo);
    }

    @Override
    public void createAll(List<User> users) {
        /* Gen by Vizend Vista v7.0.0 */
        if (users == null) {
            return;
        }
        List<UserJpo> userJpos = users.stream().map(UserJpo::new).collect(Collectors.toList());
        userJpaRepository.saveAll(userJpos);
    }

    @Override
    public User retrieve(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        Optional<UserJpo> userJpo = userJpaRepository.findById(id);
        return userJpo.map(UserJpo::toDomain).orElse(null);
    }

    @Override
    public User retrieve(QueryParams queryParams) {
        /* Gen by Vizend Vista v7.0.0 */
        DynamicQuery<UserJpo> query = new JpaDynamicQuery<>(entityManager, queryParams, UserJpo.class);
        UserJpo userJpo = query.findOne();
        return Optional.ofNullable(userJpo).map(jpo -> jpo.toDomain()).orElse(null);
    }

    @Override
    public List<User> retrieveAll(List<String> userIds) {
        /* Gen by Vizend Vista v7.0.0 */
        Iterable<UserJpo> allById = userJpaRepository.findAllById(userIds);
        return UserJpo.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public List<User> retrieveList(QueryParams queryParams, Offset offset) {
        /* Gen by Vizend Vista v7.0.0 */
        DynamicQuery<UserJpo> query = new JpaDynamicQuery<>(entityManager, queryParams, offset, UserJpo.class);
        List<UserJpo> userJpos = query.findAll();
        return Optional.ofNullable(userJpos).map(jpos -> UserJpo.toDomains(jpos)).orElse(new ArrayList<>());
    }

    @Override
    public void update(User user) {
        /* Gen by Vizend Vista v7.0.0 */
        UserJpo userJpo = new UserJpo(user);
        userJpaRepository.save(userJpo);
    }

    @Override
    public void delete(User user) {
        /* Gen by Vizend Vista v7.0.0 */
        userJpaRepository.deleteById(user.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        userJpaRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Vista v7.0.0 */
        Optional<UserJpo> userJpo = userJpaRepository.findById(id);
        return userJpo.isPresent();
    }
}
