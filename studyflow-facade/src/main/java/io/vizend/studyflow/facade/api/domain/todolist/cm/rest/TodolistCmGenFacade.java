/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.api.domain.todolist.cm.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.studyflow.facade.api.domain.todolist.cm.command.TaskGenCommand;
import io.vizend.accent.domain.message.FetchResponse;
import io.vizend.studyflow.domain.todolist.cm.entity.Task;
import io.vizend.studyflow.facade.api.domain.todolist.cm.fetch.TaskGenFetch;
import java.util.List;
import io.vizend.studyflow.facade.api.domain.todolist.cm.command.ToDoListGenCommand;
import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
import io.vizend.studyflow.facade.api.domain.todolist.cm.fetch.ToDoListGenFetch;
import io.vizend.studyflow.facade.api.domain.todolist.cm.command.UserGenCommand;
import io.vizend.studyflow.domain.todolist.cm.entity.User;
import io.vizend.studyflow.facade.api.domain.todolist.cm.fetch.UserGenFetch;

public interface TodolistCmGenFacade {
    /* Gen by Vizend Vista v7.0.0 */
    CommandResponse registerTask(TaskGenCommand taskGenCommand);
    CommandResponse modifyTask(TaskGenCommand taskGenCommand);
    CommandResponse removeTask(TaskGenCommand taskGenCommand);
    FetchResponse<Task> fetchTask(TaskGenFetch<Task> taskGenFetch);
    FetchResponse<Task> dynamicFetchTask(TaskGenFetch<Task> taskGenFetch);
    FetchResponse<List<Task>> dynamicMultiFetchTask(TaskGenFetch<List<Task>> taskGenFetch);
    CommandResponse registerToDoList(ToDoListGenCommand toDoListGenCommand);
    CommandResponse modifyToDoList(ToDoListGenCommand toDoListGenCommand);
    CommandResponse removeToDoList(ToDoListGenCommand toDoListGenCommand);
    FetchResponse<ToDoList> fetchToDoList(ToDoListGenFetch<ToDoList> toDoListGenFetch);
    FetchResponse<ToDoList> dynamicFetchToDoList(ToDoListGenFetch<ToDoList> toDoListGenFetch);
    FetchResponse<List<ToDoList>> dynamicMultiFetchToDoList(ToDoListGenFetch<List<ToDoList>> toDoListGenFetch);
    CommandResponse registerUser(UserGenCommand userGenCommand);
    CommandResponse modifyUser(UserGenCommand userGenCommand);
    CommandResponse removeUser(UserGenCommand userGenCommand);
    FetchResponse<User> fetchUser(UserGenFetch<User> userGenFetch);
    FetchResponse<User> dynamicFetchUser(UserGenFetch<User> userGenFetch);
    FetchResponse<List<User>> dynamicMultiFetchUser(UserGenFetch<List<User>> userGenFetch);
}
