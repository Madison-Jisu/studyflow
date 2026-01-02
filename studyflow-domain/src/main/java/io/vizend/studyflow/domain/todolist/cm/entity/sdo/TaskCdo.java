/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.entity.sdo;

import io.vizend.studyflow.domain.todolist.cm.entity.vo.TaskType;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.accent.domain.context.StageContext;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCdo extends CreationDataObject {
    private String toDoListId;
    private String description;
    private LocalDate dueDate;
    private int estimatedTimeMinute;
    private String courseName;
    private TaskType taskType;

    @Override
    public String genId() {
        //
        return super.genId();
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static TaskCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, TaskCdo.class);
    }

    public static TaskCdo sample() {
        //
        return new TaskCdo();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }
}
