/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.studyflow.domain.todolist.cm.store.UserStore;
import io.vizend.studyflow.domain.todolist.cm.optionstore.UserOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.UserCdo;
import io.vizend.studyflow.domain.todolist.cm.event.UserEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.studyflow.domain.todolist.cm.entity.User;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
@RequiredArgsConstructor
public class UserLogic {
    /* Gen by Vizend Vista v7.0.0 */
    private final UserStore userStore;
    private final UserOptionStore userOptionStore;
    private final EventProxy eventProxy;

    public String registerUser(UserCdo userCdo) {
        /* Gen by Vizend Vista v7.0.0 */
        User user = new User(userCdo);
        if (userCdo.hasAdditionalAttributes()) {
            user.modify(userCdo.getAdditionalAttributes());
        }
        if (userStore.exists(user.getId())) {
            throw new IllegalArgumentException("user already exists. " + user.getId());
        }
        userStore.create(user);
        UserEvent userEvent = UserEvent.newUserRegisteredEvent(user, user.getId());
        eventProxy.produceEvent(userEvent);
        return user.getId();
    }

    public List<String> registerUsers(List<UserCdo> userCdos) {
        /* Gen by Vizend Vista v7.0.0 */
        return userCdos.stream().map(this::registerUser).collect(Collectors.toList());
    }

    public User findUser(String userId) {
        /* Gen by Vizend Vista v7.0.0 */
        User user = userStore.retrieve(userId);
        if (user == null) {
            throw new NoSuchElementException("User id: " + userId);
        }
        return user;
    }

    public User findUser(QueryParams queryParams) {
        /* Gen by Vizend Vista v7.0.0 */
        return userStore.retrieve(queryParams);
    }

    public List<User> findUsers(QueryParams queryParams, Offset offset) {
        /* Gen by Vizend Vista v7.0.0 */
        return userStore.retrieveList(queryParams, offset);
    }

    public void modifyUser(String userId, NameValueList nameValues) {
        /* Gen by Vizend Vista v7.0.0 */
        User user = findUser(userId);
        user.modify(nameValues);
        userStore.update(user);
        UserEvent userEvent = UserEvent.newUserModifiedEvent(userId, nameValues, user);
        eventProxy.produceEvent(userEvent);
    }

    public void modifyUser(User user) {
        /* Gen by Vizend Vista v7.0.0 */
        User oldUser = findUser(user.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldUser, user);
        if (nameValues.size() > 0) {
            modifyUser(user.getId(), nameValues);
        }
    }

    public void removeUser(String userId) {
        /* Gen by Vizend Vista v7.0.0 */
        User user = findUser(userId);
        userStore.delete(user);
        UserEvent userEvent = UserEvent.newUserRemovedEvent(user, user.getId());
        eventProxy.produceEvent(userEvent);
    }

    public boolean existsUser(String userId) {
        /* Gen by Vizend Vista v7.0.0 */
        return userStore.exists(userId);
    }

    public void handleEventForProjection(UserEvent userEvent) {
        /* Gen by Vizend Vista v7.0.0 */
        switch(userEvent.getDataEventType()) {
            case Registered:
                userStore.create(userEvent.getUser());
                break;
            case Modified:
                User user = userStore.retrieve(userEvent.getUserId());
                user.modify(userEvent.getNameValues());
                userStore.update(user);
                break;
            case Removed:
                userStore.delete(userEvent.getUserId());
                break;
        }
    }
}
