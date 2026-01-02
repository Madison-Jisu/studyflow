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
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.UserCdo;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.beans.BeanUtils;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.type.NameValue;

@Getter
@Setter
@NoArgsConstructor
public class User extends StageEntity {
    private String username;
    private String password;

    public User(String id, ActorKey requesterKey) {
        super(id, requesterKey);
    }

    public User(UserCdo userCdo) {
        super(userCdo.genId(), userCdo.getRequesterKey());
        BeanUtils.copyProperties(userCdo, this);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static User fromJson(String json) {
        //
        return JsonUtil.fromJson(json, User.class);
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

    public static User sample() {
        //
        return new User(UserCdo.sample());
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }
}
