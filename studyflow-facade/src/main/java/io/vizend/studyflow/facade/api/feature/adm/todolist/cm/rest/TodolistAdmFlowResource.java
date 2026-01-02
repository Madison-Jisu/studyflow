/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.api.feature.adm.todolist.cm.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.studyflow.domain.role.StudyflowRoles;
import io.vizend.studyflow.feature.todolist.flow.TodolistAdmFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.studyflow.facade.api.feature.adm.todolist.cm.command.RegisterToDoListAdmCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/adm/todolist/cm")
@RequiredArgsConstructor
@AuthorizedRole(groupRoles = StudyflowRoles.GROUP_ROLE_ADMIN)
public class TodolistAdmFlowResource implements TodolistAdmFlowFacade {
    /* Gen by Vizend Vista v7.0.0 */
    private final TodolistAdmFlow todolistAdmFlow;

    @Override
    @PostMapping("/register-to-do-list/command")
    public CommandResponse registerToDoList(@RequestBody RegisterToDoListAdmCommand command) {
        /* Gen by Vizend Vista v7.0.0 */
        command.validate();
        String userId = command.getUserId();
        String entityId = todolistAdmFlow.registerToDoList(userId);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
