/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.store;

import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
import java.util.List;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;

public interface ToDoListStore {
    /* Gen by Vizend Vista v7.0.0 */
    void create(ToDoList toDoList);
    void createAll(List<ToDoList> toDoLists);
    ToDoList retrieve(String id);
    ToDoList retrieve(QueryParams queryParams);
    List<ToDoList> retrieveAll(List<String> toDoListIds);
    List<ToDoList> retrieveList(QueryParams queryParams, Offset offset);
    void update(ToDoList toDoList);
    void delete(ToDoList toDoList);
    void delete(String id);
    boolean exists(String id);
}
