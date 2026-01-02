/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.facade.api.domain.todolist.cm.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.vizend.studyflow.domain.todolist.cm.logic.TaskLogic;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.studyflow.facade.api.domain.todolist.cm.command.TaskGenCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.accent.domain.message.FetchResponse;
import io.vizend.studyflow.domain.todolist.cm.entity.Task;
import io.vizend.studyflow.facade.api.domain.todolist.cm.fetch.TaskGenFetch;
import io.vizend.studyflow.domain.todolist.cm.logic.ToDoListLogic;
import io.vizend.studyflow.facade.api.domain.todolist.cm.command.ToDoListGenCommand;
import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
import io.vizend.studyflow.facade.api.domain.todolist.cm.fetch.ToDoListGenFetch;
import io.vizend.studyflow.domain.todolist.cm.logic.UserLogic;
import io.vizend.studyflow.facade.api.domain.todolist.cm.command.UserGenCommand;
import io.vizend.studyflow.domain.todolist.cm.entity.User;
import io.vizend.studyflow.facade.api.domain.todolist.cm.fetch.UserGenFetch;

@RestController
@RequestMapping("/domain/todolist/cm")
public class TodolistCmGenResource implements TodolistCmGenFacade {
    private final TaskLogic taskLogic;
    private final ToDoListLogic toDoListLogic;
    private final UserLogic userLogic;

    public TodolistCmGenResource(TaskLogic taskLogic, ToDoListLogic toDoListLogic, UserLogic userLogic) {
        /* Gen by Vizend Vista v7.0.0 */
        this.taskLogic = taskLogic;
        this.toDoListLogic = toDoListLogic;
        this.userLogic = userLogic;
    }

    @Override
    @PostMapping("/task/register/command")
    public CommandResponse registerTask(@RequestBody TaskGenCommand taskGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        if (taskGenCommand.isMultiCdo()) {
            List<String> entityIds = taskLogic.registerTasks(taskGenCommand.getTaskCdos());
            taskGenCommand.setResponse(entityIds);
        } else {
            String entityId = taskLogic.registerTask(taskGenCommand.getTaskCdo());
            taskGenCommand.setResponse(entityId);
        }
        return taskGenCommand.getResponse();
    }

    @Override
    @PostMapping("/task/modify/command")
    public CommandResponse modifyTask(@RequestBody TaskGenCommand taskGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        taskLogic.modifyTask(taskGenCommand.getTaskId(), taskGenCommand.getNameValues());
        taskGenCommand.setResponse(taskGenCommand.getTaskId());
        return taskGenCommand.getResponse();
    }

    @Override
    @PostMapping("/task/remove/command")
    public CommandResponse removeTask(@RequestBody TaskGenCommand taskGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        taskLogic.removeTask(taskGenCommand.getTaskId());
        taskGenCommand.setResponse(new CommandResponse(taskGenCommand.getTaskId()));
        return taskGenCommand.getResponse();
    }

    @Override
    @PostMapping("/task/fetch")
    public FetchResponse<Task> fetchTask(@RequestBody TaskGenFetch<Task> taskGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        taskGenFetch.executeFetch(taskLogic);
        return taskGenFetch.getResponse();
    }

    @Override
    @PostMapping("/task/dynamic-single/fetch")
    public FetchResponse<Task> dynamicFetchTask(@RequestBody TaskGenFetch<Task> taskGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        taskGenFetch.executeDynamicFetch(taskLogic);
        return taskGenFetch.getResponse();
    }

    @Override
    @PostMapping("/task/dynamic-multi/fetch")
    public FetchResponse<List<Task>> dynamicMultiFetchTask(@RequestBody TaskGenFetch<List<Task>> taskGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        taskGenFetch.executeDynamicMultiFetch(taskLogic);
        return taskGenFetch.getResponse();
    }

    @Override
    @PostMapping("/to-do-list/register/command")
    public CommandResponse registerToDoList(@RequestBody ToDoListGenCommand toDoListGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        if (toDoListGenCommand.isMultiCdo()) {
            List<String> entityIds = toDoListLogic.registerToDoLists(toDoListGenCommand.getToDoListCdos());
            toDoListGenCommand.setResponse(entityIds);
        } else {
            String entityId = toDoListLogic.registerToDoList(toDoListGenCommand.getToDoListCdo());
            toDoListGenCommand.setResponse(entityId);
        }
        return toDoListGenCommand.getResponse();
    }

    @Override
    @PostMapping("/to-do-list/modify/command")
    public CommandResponse modifyToDoList(@RequestBody ToDoListGenCommand toDoListGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        toDoListLogic.modifyToDoList(toDoListGenCommand.getToDoListId(), toDoListGenCommand.getNameValues());
        toDoListGenCommand.setResponse(toDoListGenCommand.getToDoListId());
        return toDoListGenCommand.getResponse();
    }

    @Override
    @PostMapping("/to-do-list/remove/command")
    public CommandResponse removeToDoList(@RequestBody ToDoListGenCommand toDoListGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        toDoListLogic.removeToDoList(toDoListGenCommand.getToDoListId());
        toDoListGenCommand.setResponse(new CommandResponse(toDoListGenCommand.getToDoListId()));
        return toDoListGenCommand.getResponse();
    }

    @Override
    @PostMapping("/to-do-list/fetch")
    public FetchResponse<ToDoList> fetchToDoList(@RequestBody ToDoListGenFetch<ToDoList> toDoListGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        toDoListGenFetch.executeFetch(toDoListLogic);
        return toDoListGenFetch.getResponse();
    }

    @Override
    @PostMapping("/to-do-list/dynamic-single/fetch")
    public FetchResponse<ToDoList> dynamicFetchToDoList(@RequestBody ToDoListGenFetch<ToDoList> toDoListGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        toDoListGenFetch.executeDynamicFetch(toDoListLogic);
        return toDoListGenFetch.getResponse();
    }

    @Override
    @PostMapping("/to-do-list/dynamic-multi/fetch")
    public FetchResponse<List<ToDoList>> dynamicMultiFetchToDoList(@RequestBody ToDoListGenFetch<List<ToDoList>> toDoListGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        toDoListGenFetch.executeDynamicMultiFetch(toDoListLogic);
        return toDoListGenFetch.getResponse();
    }

    @Override
    @PostMapping("/user/register/command")
    public CommandResponse registerUser(@RequestBody UserGenCommand userGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        if (userGenCommand.isMultiCdo()) {
            List<String> entityIds = userLogic.registerUsers(userGenCommand.getUserCdos());
            userGenCommand.setResponse(entityIds);
        } else {
            String entityId = userLogic.registerUser(userGenCommand.getUserCdo());
            userGenCommand.setResponse(entityId);
        }
        return userGenCommand.getResponse();
    }

    @Override
    @PostMapping("/user/modify/command")
    public CommandResponse modifyUser(@RequestBody UserGenCommand userGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        userLogic.modifyUser(userGenCommand.getUserId(), userGenCommand.getNameValues());
        userGenCommand.setResponse(userGenCommand.getUserId());
        return userGenCommand.getResponse();
    }

    @Override
    @PostMapping("/user/remove/command")
    public CommandResponse removeUser(@RequestBody UserGenCommand userGenCommand) {
        /* Gen by Vizend Vista v7.0.0 */
        userLogic.removeUser(userGenCommand.getUserId());
        userGenCommand.setResponse(new CommandResponse(userGenCommand.getUserId()));
        return userGenCommand.getResponse();
    }

    @Override
    @PostMapping("/user/fetch")
    public FetchResponse<User> fetchUser(@RequestBody UserGenFetch<User> userGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        userGenFetch.executeFetch(userLogic);
        return userGenFetch.getResponse();
    }

    @Override
    @PostMapping("/user/dynamic-single/fetch")
    public FetchResponse<User> dynamicFetchUser(@RequestBody UserGenFetch<User> userGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        userGenFetch.executeDynamicFetch(userLogic);
        return userGenFetch.getResponse();
    }

    @Override
    @PostMapping("/user/dynamic-multi/fetch")
    public FetchResponse<List<User>> dynamicMultiFetchUser(@RequestBody UserGenFetch<List<User>> userGenFetch) {
        /* Gen by Vizend Vista v7.0.0 */
        userGenFetch.executeDynamicMultiFetch(userLogic);
        return userGenFetch.getResponse();
    }
}
