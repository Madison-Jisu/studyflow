/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.storejpa.todolist.cm.optionstore;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import io.vizend.studyflow.domain.todolist.cm.optionstore.UserOptionStore;
import io.vizend.studyflow.storejpa.todolist.cm.optionstore.repository.UserJpaOptionRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Repository
@RequiredArgsConstructor
public class UserJpaOptionStore implements UserOptionStore {
    /* Gen by Vizend Vista v7.0.0 */
    private final UserJpaOptionRepository userJpaOptionRepository;

    private Pageable createPageable(Offset offset) {
        /* Gen by Vizend Vista v7.0.0 */
        if (offset.getSortDirection() != null && offset.getSortingField() != null) {
            return PageRequest.of(offset.page(), offset.limit(), (offset.ascendingSort() ? Sort.Direction.ASC : Sort.Direction.DESC), offset.getSortingField());
        } else {
            return PageRequest.of(offset.page(), offset.limit());
        }
    }
}
