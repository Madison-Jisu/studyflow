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
import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class ToDoListEvent extends DataEvent {
    /* Gen by Vizend Vista v7.0.0 */
    private ToDoList toDoList;
    private String toDoListId;
    private NameValueList nameValues;

    protected ToDoListEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Vista v7.0.0 */
        super(type, entity);
    }

    public static ToDoListEvent newToDoListRegisteredEvent(ToDoList toDoList, String toDoListId) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListEvent event = new ToDoListEvent(DataEventType.Registered, toDoList);
        event.setToDoList(toDoList);
        event.setToDoListId(toDoListId);
        return event;
    }

    public static ToDoListEvent newToDoListModifiedEvent(String toDoListId, NameValueList nameValues, ToDoList toDoList) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListEvent event = new ToDoListEvent(DataEventType.Modified, toDoList);
        event.setToDoListId(toDoListId);
        event.setNameValues(nameValues);
        event.setToDoList(toDoList);
        return event;
    }

    public static ToDoListEvent newToDoListRemovedEvent(ToDoList toDoList, String toDoListId) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListEvent event = new ToDoListEvent(DataEventType.Removed, toDoList);
        event.setToDoList(toDoList);
        event.setToDoListId(toDoListId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static ToDoListEvent fromJson(String json) {
        /* Gen by Vizend Vista v7.0.0 */
        return JsonUtil.fromJson(json, ToDoListEvent.class);
    }
}
