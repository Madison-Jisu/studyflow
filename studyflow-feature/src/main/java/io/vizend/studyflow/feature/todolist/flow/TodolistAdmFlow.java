/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.feature.todolist.flow;

import io.vizend.studyflow.domain.todolist.cm.entity.sdo.ToDoListCdo;
import io.vizend.studyflow.domain.todolist.cm.logic.ToDoListLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
// @RequiredArgsConstructor
public class TodolistAdmFlow {
    private ToDoListLogic toDoListLogic;

    public TodolistAdmFlow(ToDoListLogic toDoListLogic) {
        this.toDoListLogic = toDoListLogic;
    }






    public String registerToDoList(String userId) {
        ToDoListCdo toDoListCdo = new ToDoListCdo();
        toDoListCdo.setUserId(userId);

        return toDoListLogic.registerToDoList(toDoListCdo);
    }
}
