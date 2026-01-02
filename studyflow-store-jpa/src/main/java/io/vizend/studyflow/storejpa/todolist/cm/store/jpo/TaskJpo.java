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
import java.time.LocalDate;
import io.vizend.studyflow.domain.todolist.cm.entity.vo.TaskType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import io.vizend.studyflow.domain.todolist.cm.entity.Task;
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
@Table(name = "TASK")
public class TaskJpo extends StageEntityJpo {
    /* Gen by Vizend Vista v7.0.0 */
    private String toDoListId;
    private String description;
    private LocalDate dueDate;
    private int estimatedTimeMinute;
    private String courseName;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    public TaskJpo(Task task) {
        /* Gen by Vizend Vista v7.0.0 */
        super(task);
        BeanUtils.copyProperties(task, this);
    }

    public Task toDomain() {
        /* Gen by Vizend Vista v7.0.0 */
        Task task = new Task(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, task);
        return task;
    }

    public static List<Task> toDomains(List<TaskJpo> taskJpos) {
        /* Gen by Vizend Vista v7.0.0 */
        return taskJpos.stream().map(TaskJpo::toDomain).collect(Collectors.toList());
    }

    public static Page<Task> toDomains(Page<TaskJpo> taskJposPage) {
        /* Gen by Vizend Vista v7.0.0 */
        List<TaskJpo> taskJpos = taskJposPage.getContent();
        List<Task> tasks = toDomains(taskJpos);
        return new PageImpl<>(tasks, taskJposPage.getPageable(), taskJposPage.getTotalElements());
    }

    public static Slice<Task> toDomains(Slice<TaskJpo> taskJposSlice) {
        /* Gen by Vizend Vista v7.0.0 */
        List<TaskJpo> taskJpos = taskJposSlice.getContent();
        List<Task> tasks = toDomains(taskJpos);
        return new SliceImpl<>(tasks, taskJposSlice.getPageable(), taskJposSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Vista v7.0.0 */
        return toJson();
    }

    public static TaskJpo sample() {
        /* Gen by Vizend Vista v7.0.0 */
        return new TaskJpo(Task.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Vista v7.0.0 */
        System.out.println(sample());
    }
}
