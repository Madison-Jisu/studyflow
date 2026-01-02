/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.storejpa.todolist.cm.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.vizend.studyflow.storejpa.todolist.cm.store.jpo.ToDoListJpo;

public interface ToDoListJpaRepository extends JpaRepository<ToDoListJpo, String> {
    /* Gen by Vizend Vista v7.0.0 */
}
