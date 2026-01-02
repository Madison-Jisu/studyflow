/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.studyflow.domain.todolist.cm.store.TaskStore;
import io.vizend.studyflow.domain.todolist.cm.optionstore.TaskOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.TaskCdo;
import io.vizend.studyflow.domain.todolist.cm.event.TaskEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.studyflow.domain.todolist.cm.entity.Task;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskLogic {
    /* Gen by Vizend Vista v7.0.0 */
    private final TaskStore taskStore;
    private final TaskOptionStore taskOptionStore;
    private final EventProxy eventProxy;

    public String registerTask(TaskCdo taskCdo) {
        /* Gen by Vizend Vista v7.0.0 */
        Task task = new Task(taskCdo);
        if (taskCdo.hasAdditionalAttributes()) {
            task.modify(taskCdo.getAdditionalAttributes());
        }
        if (taskStore.exists(task.getId())) {
            throw new IllegalArgumentException("task already exists. " + task.getId());
        }
        taskStore.create(task);
        TaskEvent taskEvent = TaskEvent.newTaskRegisteredEvent(task, task.getId());
        eventProxy.produceEvent(taskEvent);
        return task.getId();
    }

    public List<String> registerTasks(List<TaskCdo> taskCdos) {
        /* Gen by Vizend Vista v7.0.0 */
        return taskCdos.stream().map(this::registerTask).collect(Collectors.toList());
    }

    public Task findTask(String taskId) {
        /* Gen by Vizend Vista v7.0.0 */
        Task task = taskStore.retrieve(taskId);
        if (task == null) {
            throw new NoSuchElementException("Task id: " + taskId);
        }
        return task;
    }

    public Task findTask(QueryParams queryParams) {
        /* Gen by Vizend Vista v7.0.0 */
        return taskStore.retrieve(queryParams);
    }

    public List<Task> findTasks(QueryParams queryParams, Offset offset) {
        /* Gen by Vizend Vista v7.0.0 */
        return taskStore.retrieveList(queryParams, offset);
    }

    public void modifyTask(String taskId, NameValueList nameValues) {
        /* Gen by Vizend Vista v7.0.0 */
        Task task = findTask(taskId);
        task.modify(nameValues);
        taskStore.update(task);
        TaskEvent taskEvent = TaskEvent.newTaskModifiedEvent(taskId, nameValues, task);
        eventProxy.produceEvent(taskEvent);
    }

    public void modifyTask(Task task) {
        /* Gen by Vizend Vista v7.0.0 */
        Task oldTask = findTask(task.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldTask, task);
        if (nameValues.size() > 0) {
            modifyTask(task.getId(), nameValues);
        }
    }

    public void removeTask(String taskId) {
        /* Gen by Vizend Vista v7.0.0 */
        Task task = findTask(taskId);
        taskStore.delete(task);
        TaskEvent taskEvent = TaskEvent.newTaskRemovedEvent(task, task.getId());
        eventProxy.produceEvent(taskEvent);
    }

    public boolean existsTask(String taskId) {
        /* Gen by Vizend Vista v7.0.0 */
        return taskStore.exists(taskId);
    }

    public void handleEventForProjection(TaskEvent taskEvent) {
        /* Gen by Vizend Vista v7.0.0 */
        switch(taskEvent.getDataEventType()) {
            case Registered:
                taskStore.create(taskEvent.getTask());
                break;
            case Modified:
                Task task = taskStore.retrieve(taskEvent.getTaskId());
                task.modify(taskEvent.getNameValues());
                taskStore.update(task);
                break;
            case Removed:
                taskStore.delete(taskEvent.getTaskId());
                break;
        }
    }
}
