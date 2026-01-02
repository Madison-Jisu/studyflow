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
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.ToDoListCdo;
import java.util.List;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(roles = StudyflowRoles.ROLE_DRAMA_OWNER)
public class ToDoListGenCommand extends CommandRequest {
    /* Gen by Vizend Vista v7.0.0 */
    private ToDoListCdo toDoListCdo;
    private List<ToDoListCdo> toDoListCdos;
    private boolean multiCdo;
    private String toDoListId;
    private NameValueList nameValues;

    @Override
    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static ToDoListGenCommand newRegisterToDoListCommand(ToDoListCdo toDoListCdo) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListGenCommand command = new ToDoListGenCommand();
        command.setToDoListCdo(toDoListCdo);
        return command;
    }

    public static ToDoListGenCommand newRegisterToDoListCommand(List<ToDoListCdo> toDoListCdos) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListGenCommand command = new ToDoListGenCommand();
        command.setToDoListCdos(toDoListCdos);
        command.setMultiCdo(true);
        return command;
    }

    public static ToDoListGenCommand newModifyToDoListCommand(String toDoListId, NameValueList nameValues) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListGenCommand command = new ToDoListGenCommand();
        command.setToDoListId(toDoListId);
        command.setNameValues(nameValues);
        return command;
    }

    public static ToDoListGenCommand newRemoveToDoListCommand(String toDoListId) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoListGenCommand command = new ToDoListGenCommand();
        command.setToDoListId(toDoListId);
        return command;
    }

    public static ToDoListGenCommand fromJson(String json) {
        /* Gen by Vizend Vista v7.0.0 */
        return JsonUtil.fromJson(json, ToDoListGenCommand.class);
    }

    public static ToDoListGenCommand sampleForRegister() {
        /* Gen by Vizend Vista v7.0.0 */
        return newRegisterToDoListCommand(ToDoListCdo.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Vista v7.0.0 */
        System.out.println(sampleForRegister());
    }
}
