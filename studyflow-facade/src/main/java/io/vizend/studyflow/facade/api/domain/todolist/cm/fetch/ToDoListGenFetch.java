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
import io.vizend.studyflow.domain.todolist.cm.logic.ToDoListLogic;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(roles = StudyflowRoles.ROLE_DRAMA_OWNER)
public class ToDoListGenFetch<T> extends DynamicFetchRequest<T> {
    /* Gen by Vizend Vista v7.0.0 */
    private String toDoListId;

    public void executeFetch(ToDoListLogic toDoListLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        setResponse(toDoListLogic.findToDoList(toDoListId));
    }

    public void executeDynamicFetch(ToDoListLogic toDoListLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        QueryParams queryParams = getQueryParams();
        setResponse(toDoListLogic.findToDoList(queryParams));
    }

    public void executeDynamicMultiFetch(ToDoListLogic toDoListLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        QueryParams queryParams = getQueryParams();
        Offset offset = getOffset();
        setResponse(toDoListLogic.findToDoLists(queryParams, offset));
    }
}
