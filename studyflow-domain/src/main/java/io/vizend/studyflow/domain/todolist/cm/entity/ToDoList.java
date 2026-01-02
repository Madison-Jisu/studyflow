/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.ToDoListCdo;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.beans.BeanUtils;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.type.NameValue;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ToDoList extends StageEntity {

    private String userId;

    transient private List<Task> tasks; // ignore

    public ToDoList(String id, ActorKey requesterKey) {
        super(id, requesterKey);
    }

    public ToDoList(ToDoListCdo toDoListCdo) {
        super(toDoListCdo.genId(), toDoListCdo.getRequesterKey());
        BeanUtils.copyProperties(toDoListCdo, this);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static ToDoList fromJson(String json) {
        //
        return JsonUtil.fromJson(json, ToDoList.class);
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

    public static ToDoList sample() {
        //
        return new ToDoList(ToDoListCdo.sample());
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }
}
