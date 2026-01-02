/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.event;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.message.DataEvent;
import io.vizend.studyflow.domain.todolist.cm.entity.User;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class UserEvent extends DataEvent {
    /* Gen by Vizend Vista v7.0.0 */
    private User user;
    private String userId;
    private NameValueList nameValues;

    protected UserEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Vista v7.0.0 */
        super(type, entity);
    }

    public static UserEvent newUserRegisteredEvent(User user, String userId) {
        /* Gen by Vizend Vista v7.0.0 */
        UserEvent event = new UserEvent(DataEventType.Registered, user);
        event.setUser(user);
        event.setUserId(userId);
        return event;
    }

    public static UserEvent newUserModifiedEvent(String userId, NameValueList nameValues, User user) {
        /* Gen by Vizend Vista v7.0.0 */
        UserEvent event = new UserEvent(DataEventType.Modified, user);
        event.setUserId(userId);
        event.setNameValues(nameValues);
        event.setUser(user);
        return event;
    }

    public static UserEvent newUserRemovedEvent(User user, String userId) {
        /* Gen by Vizend Vista v7.0.0 */
        UserEvent event = new UserEvent(DataEventType.Removed, user);
        event.setUser(user);
        event.setUserId(userId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static UserEvent fromJson(String json) {
        /* Gen by Vizend Vista v7.0.0 */
        return JsonUtil.fromJson(json, UserEvent.class);
    }
}
