/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.api.domain.todolist.cm.command;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.studyflow.domain.role.StudyflowRoles;
import io.vizend.accent.domain.message.CommandRequest;
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.TaskCdo;
import java.util.List;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(roles = StudyflowRoles.ROLE_DRAMA_OWNER)
public class TaskGenCommand extends CommandRequest {
    /* Gen by Vizend Vista v7.0.0 */
    private TaskCdo taskCdo;
    private List<TaskCdo> taskCdos;
    private boolean multiCdo;
    private String taskId;
    private NameValueList nameValues;

    @Override
    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static TaskGenCommand newRegisterTaskCommand(TaskCdo taskCdo) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskGenCommand command = new TaskGenCommand();
        command.setTaskCdo(taskCdo);
        return command;
    }

    public static TaskGenCommand newRegisterTaskCommand(List<TaskCdo> taskCdos) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskGenCommand command = new TaskGenCommand();
        command.setTaskCdos(taskCdos);
        command.setMultiCdo(true);
        return command;
    }

    public static TaskGenCommand newModifyTaskCommand(String taskId, NameValueList nameValues) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskGenCommand command = new TaskGenCommand();
        command.setTaskId(taskId);
        command.setNameValues(nameValues);
        return command;
    }

    public static TaskGenCommand newRemoveTaskCommand(String taskId) {
        /* Gen by Vizend Vista v7.0.0 */
        TaskGenCommand command = new TaskGenCommand();
        command.setTaskId(taskId);
        return command;
    }

    public static TaskGenCommand fromJson(String json) {
        /* Gen by Vizend Vista v7.0.0 */
        return JsonUtil.fromJson(json, TaskGenCommand.class);
    }

    public static TaskGenCommand sampleForRegister() {
        /* Gen by Vizend Vista v7.0.0 */
        return newRegisterTaskCommand(TaskCdo.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Vista v7.0.0 */
        System.out.println(sampleForRegister());
    }
}
