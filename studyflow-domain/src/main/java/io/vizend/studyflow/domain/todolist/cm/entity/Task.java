/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.entity;

import io.vizend.studyflow.domain.todolist.cm.entity.vo.TaskType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.TaskCdo;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.beans.BeanUtils;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.type.NameValue;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Task extends StageEntity {
    private String toDoListId;
    private String description;
    private LocalDate dueDate;
    private int estimatedTimeMinute;
    private String courseName;
    private TaskType taskType;

    public Task(String id, ActorKey requesterKey) {
        super(id, requesterKey);
    }

    public Task(TaskCdo taskCdo) {
        super(taskCdo.genId(), taskCdo.getRequesterKey());
        BeanUtils.copyProperties(taskCdo, this);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static Task fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Task.class);
    }

    @Override
    protected void modifyAttributes(NameValueList nameValues) {
        //
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch(nameValue.getName().trim()) {
                default ->
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }

    public static Task sample() {
        //
        return new Task(TaskCdo.sample());
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }
}
