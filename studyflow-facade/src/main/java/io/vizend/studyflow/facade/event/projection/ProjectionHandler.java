/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.event.projection;

import io.vizend.studyflow.domain.todolist.cm.logic.TaskLogic;
import io.vizend.accent.domain.message.DataEvent;
import io.vizend.studyflow.domain.todolist.cm.event.TaskEvent;
import io.vizend.studyflow.domain.todolist.cm.event.ToDoListEvent;
import io.vizend.studyflow.domain.todolist.cm.logic.ToDoListLogic;
import io.vizend.studyflow.domain.todolist.cm.event.UserEvent;
import io.vizend.studyflow.domain.todolist.cm.logic.UserLogic;

public class ProjectionHandler {
    private final TaskLogic taskLogic; // Gen by Vizend Vista v7.0.0
    private final ToDoListLogic toDoListLogic;
    private final UserLogic userLogic;

    public ProjectionHandler(TaskLogic taskLogic, ToDoListLogic toDoListLogic, UserLogic userLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        this.taskLogic = taskLogic;
        this.toDoListLogic = toDoListLogic;
        this.userLogic = userLogic;
    }

    public void handle(DataEvent event) {
        /* Gen by Vizend Vista v7.0.0 */
        String classFullName = event.getClass().getName();
        String eventName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
        switch(eventName) {
            case "TaskEvent":
                TaskEvent taskEvent = (TaskEvent) event;
                taskLogic.handleEventForProjection(taskEvent);
                break;
        }
    }
}
