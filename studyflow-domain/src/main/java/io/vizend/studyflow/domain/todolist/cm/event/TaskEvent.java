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
import io.vizend.studyflow.domain.todolist.cm.entity.Task;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class TaskEvent extends DataEvent {
    /* Gen by Vizend Vista v7.0.0 */
    private Task task;
    private String taskId;
    private NameValueList nameValues;

    protected TaskEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Vista v7.0.0 */
        super(type, entity);
    }

    public static TaskEvent newTaskRegisteredEvent(Task task, String taskId) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskEvent event = new TaskEvent(DataEventType.Registered, task);
        event.setTask(task);
        event.setTaskId(taskId);
        return event;
    }

    public static TaskEvent newTaskModifiedEvent(String taskId, NameValueList nameValues, Task task) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskEvent event = new TaskEvent(DataEventType.Modified, task);
        event.setTaskId(taskId);
        event.setNameValues(nameValues);
        event.setTask(task);
        return event;
    }

    public static TaskEvent newTaskRemovedEvent(Task task, String taskId) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskEvent event = new TaskEvent(DataEventType.Removed, task);
        event.setTask(task);
        event.setTaskId(taskId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static TaskEvent fromJson(String json) {
        /* Gen by Vizend Vista v7.0.0 */
        return JsonUtil.fromJson(json, TaskEvent.class);
    }
}
