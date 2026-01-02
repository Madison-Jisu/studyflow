/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.api.feature.adm.todolist.cm.command;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.studyflow.domain.role.StudyflowRoles;
import io.vizend.accent.domain.message.CommandRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AuthorizedRole(roles = StudyflowRoles.ROLE_ADMIN_MANAGER)
public class RegisterToDoListAdmCommand extends CommandRequest {
    private String userId;

    public void validate() {
        //
        Assert.hasText(userId, "'userId' is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Vista v7.0.0*/
        return toPrettyJson();
    }

    public static RegisterToDoListAdmCommand fromJson(String json) {
        /*Gen by Vizend Vista v7.0.0*/
        return JsonUtil.fromJson(json, RegisterToDoListAdmCommand.class);
    }

    public static RegisterToDoListAdmCommand sample() {
        /* FIXME : User Implementation */
        return new RegisterToDoListAdmCommand();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Vista v7.0.0*/
        System.out.println(sample().toPrettyJson());
    }
}
