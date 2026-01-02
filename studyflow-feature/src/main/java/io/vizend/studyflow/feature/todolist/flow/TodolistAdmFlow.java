/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.feature.todolist.flow;

import io.vizend.accent.domain.message.dynamic.Operator;
import io.vizend.accent.domain.message.dynamic.QueryParam;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;
import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.ToDoListCdo;
import io.vizend.studyflow.domain.todolist.cm.logic.ToDoListLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@Transactional
// @RequiredArgsConstructor
public class TodolistAdmFlow {
    private ToDoListLogic toDoListLogic;

    public TodolistAdmFlow(ToDoListLogic toDoListLogic) {
        this.toDoListLogic = toDoListLogic;
    }

    public String registerToDoList(String userId) {
        if (existToDoList(userId)) {
            throw new IllegalArgumentException("To-Do List already exists!");
        }

        ToDoListCdo toDoListCdo = new ToDoListCdo();
        toDoListCdo.setUserId(userId);
        return toDoListLogic.registerToDoList(toDoListCdo);
    }

    private boolean existToDoList(String userId) {
        QueryParams queryParams = QueryParams.dynamic(QueryParam.end("userId", Operator.Equal, userId));
        List<ToDoList> existToDos = toDoListLogic.findToDoLists(queryParams, Offset.newUnlimited());
        if (existToDos != null && !existToDos.isEmpty()) {
            return true;
        }
        return false;
    }
}
