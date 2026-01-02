/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.api.feature.adm.todolist.cm.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.studyflow.facade.api.feature.adm.todolist.cm.command.RegisterToDoListAdmCommand;

public interface TodolistAdmFlowFacade {
    /* Gen by Vizend Vista v7.0.0 */
    CommandResponse registerToDoList(RegisterToDoListAdmCommand command);
}
