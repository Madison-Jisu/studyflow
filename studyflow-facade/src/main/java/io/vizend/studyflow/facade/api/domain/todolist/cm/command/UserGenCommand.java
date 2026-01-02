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
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.UserCdo;
import java.util.List;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(roles = StudyflowRoles.ROLE_DRAMA_OWNER)
public class UserGenCommand extends CommandRequest {
    /* Gen by Vizend Vista v7.0.0 */
    private UserCdo userCdo;
    private List<UserCdo> userCdos;
    private boolean multiCdo;
    private String userId;
    private NameValueList nameValues;

    @Override
    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static UserGenCommand newRegisterUserCommand(UserCdo userCdo) {
        /* Gen by Vizend Vista v7.0.0 */
        UserGenCommand command = new UserGenCommand();
        command.setUserCdo(userCdo);
        return command;
    }

    public static UserGenCommand newRegisterUserCommand(List<UserCdo> userCdos) {
        /* Gen by Vizend Vista v7.0.0 */
        UserGenCommand command = new UserGenCommand();
        command.setUserCdos(userCdos);
        command.setMultiCdo(true);
        return command;
    }

    public static UserGenCommand newModifyUserCommand(String userId, NameValueList nameValues) {
        /* Gen by Vizend Vista v7.0.0 */
        UserGenCommand command = new UserGenCommand();
        command.setUserId(userId);
        command.setNameValues(nameValues);
        return command;
    }

    public static UserGenCommand newRemoveUserCommand(String userId) {
        /* Gen by Vizend Vista v7.0.0 */
        UserGenCommand command = new UserGenCommand();
        command.setUserId(userId);
        return command;
    }

    public static UserGenCommand fromJson(String json) {
        /* Gen by Vizend Vista v7.0.0 */
        return JsonUtil.fromJson(json, UserGenCommand.class);
    }

    public static UserGenCommand sampleForRegister() {
        /* Gen by Vizend Vista v7.0.0 */
        return newRegisterUserCommand(UserCdo.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Vista v7.0.0 */
        System.out.println(sampleForRegister());
    }
}
