/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.storejpa.todolist.cm.store.jpo;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import io.vizend.accent.store.jpa.StageEntityJpo;
import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
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
@Table(name = "TO_DO_LIST")
public class ToDoListJpo extends StageEntityJpo {
    /* Gen by Vizend Vista v7.0.0 */
    private String userId;

    public ToDoListJpo(ToDoList toDoList) {
        /* Gen by Vizend Vista v7.0.0 */
        super(toDoList);
        BeanUtils.copyProperties(toDoList, this);
    }

    public ToDoList toDomain() {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoList toDoList = new ToDoList(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, toDoList);
        return toDoList;
    }

    public static List<ToDoList> toDomains(List<ToDoListJpo> toDoListJpos) {
        /* Gen by Vizend Vista v7.0.0 */
        return toDoListJpos.stream().map(ToDoListJpo::toDomain).collect(Collectors.toList());
    }

    public static Page<ToDoList> toDomains(Page<ToDoListJpo> toDoListJposPage) {
        /* Gen by Vizend Vista v7.0.0 */
        List<ToDoListJpo> toDoListJpos = toDoListJposPage.getContent();
        List<ToDoList> toDoLists = toDomains(toDoListJpos);
        return new PageImpl<>(toDoLists, toDoListJposPage.getPageable(), toDoListJposPage.getTotalElements());
    }

    public static Slice<ToDoList> toDomains(Slice<ToDoListJpo> toDoListJposSlice) {
        /* Gen by Vizend Vista v7.0.0 */
        List<ToDoListJpo> toDoListJpos = toDoListJposSlice.getContent();
        List<ToDoList> toDoLists = toDomains(toDoListJpos);
        return new SliceImpl<>(toDoLists, toDoListJposSlice.getPageable(), toDoListJposSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static ToDoListJpo sample() {
        /* Gen by Vizend Vista v7.0.0 */
        return new ToDoListJpo(ToDoList.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Vista v7.0.0 */
        System.out.println(sample());
    }
}
