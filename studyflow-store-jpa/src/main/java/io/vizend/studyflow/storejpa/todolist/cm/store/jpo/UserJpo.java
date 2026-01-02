/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.storejpa.todolist.cm.store.jpo;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import io.vizend.accent.store.jpa.StageEntityJpo;
import io.vizend.studyflow.domain.todolist.cm.entity.User;
import org.springframework.beans.BeanUtils;
import io.vizend.accent.util.json.JsonUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class UserJpo extends StageEntityJpo {
    /* Gen by Vizend Vista v7.0.0 */
    private String username;
    private String password;

    public UserJpo(User user) {
        /* Gen by Vizend Vista v7.0.0 */
        super(user);
        BeanUtils.copyProperties(user, this);
    }

    public User toDomain() {
        /* Gen by Vizend Vista v7.0.0 */
        User user = new User(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, user);
        return user;
    }

    public static List<User> toDomains(List<UserJpo> userJpos) {
        /* Gen by Vizend Vista v7.0.0 */
        return userJpos.stream().map(UserJpo::toDomain).collect(Collectors.toList());
    }

    public static Page<User> toDomains(Page<UserJpo> userJposPage) {
        /* Gen by Vizend Vista v7.0.0 */
        List<UserJpo> userJpos = userJposPage.getContent();
        List<User> users = toDomains(userJpos);
        return new PageImpl<>(users, userJposPage.getPageable(), userJposPage.getTotalElements());
    }

    public static Slice<User> toDomains(Slice<UserJpo> userJposSlice) {
        /* Gen by Vizend Vista v7.0.0 */
        List<UserJpo> userJpos = userJposSlice.getContent();
        List<User> users = toDomains(userJpos);
        return new SliceImpl<>(users, userJposSlice.getPageable(), userJposSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static UserJpo sample() {
        /* Gen by Vizend Vista v7.0.0 */
        return new UserJpo(User.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Vista v7.0.0 */
        System.out.println(sample());
    }
}
