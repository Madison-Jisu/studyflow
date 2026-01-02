/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.store;

import io.vizend.studyflow.domain.todolist.cm.entity.Task;
import java.util.List;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;

public interface TaskStore {
    /* Gen by Vizend Vista v7.0.0 */
    void create(Task task);
    void createAll(List<Task> tasks);
    Task retrieve(String id);
    Task retrieve(QueryParams queryParams);
    List<Task> retrieveAll(List<String> taskIds);
    List<Task> retrieveList(QueryParams queryParams, Offset offset);
    void update(Task task);
    void delete(Task task);
    void delete(String id);
    boolean exists(String id);
}
