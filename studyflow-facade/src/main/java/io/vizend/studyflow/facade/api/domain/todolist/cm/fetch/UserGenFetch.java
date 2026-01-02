/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.api.domain.todolist.cm.fetch;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.studyflow.domain.role.StudyflowRoles;
import io.vizend.accent.domain.message.DynamicFetchRequest;
import io.vizend.studyflow.domain.todolist.cm.logic.UserLogic;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(roles = StudyflowRoles.ROLE_DRAMA_OWNER)
public class UserGenFetch<T> extends DynamicFetchRequest<T> {
    /* Gen by Vizend Vista v7.0.0 */
    private String userId;

    public void executeFetch(UserLogic userLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        setResponse(userLogic.findUser(userId));
    }

    public void executeDynamicFetch(UserLogic userLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        QueryParams queryParams = getQueryParams();
        setResponse(userLogic.findUser(queryParams));
    }

    public void executeDynamicMultiFetch(UserLogic userLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        QueryParams queryParams = getQueryParams();
        Offset offset = getOffset();
        setResponse(userLogic.findUsers(queryParams, offset));
    }
}
