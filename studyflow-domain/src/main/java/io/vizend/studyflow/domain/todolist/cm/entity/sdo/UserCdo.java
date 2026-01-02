/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.entity.sdo;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.accent.domain.context.StageContext;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCdo extends CreationDataObject {
    private String username;
    private String password;

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

    public static UserCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, UserCdo.class);
    }

    public static UserCdo sample() {
        //
        return new UserCdo();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }
}
