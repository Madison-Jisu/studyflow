/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.store;

import io.vizend.studyflow.domain.todolist.cm.entity.User;
import java.util.List;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;

public interface UserStore {
    /* Gen by Vizend Vista v7.0.0 */
    void create(User user);
    void createAll(List<User> users);
    User retrieve(String id);
    User retrieve(QueryParams queryParams);
    List<User> retrieveAll(List<String> userIds);
    List<User> retrieveList(QueryParams queryParams, Offset offset);
    void update(User user);
    void delete(User user);
    void delete(String id);
    boolean exists(String id);
}
