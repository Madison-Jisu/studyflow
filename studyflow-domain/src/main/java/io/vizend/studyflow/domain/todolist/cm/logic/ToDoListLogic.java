/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.todolist.cm.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.studyflow.domain.todolist.cm.store.ToDoListStore;
import io.vizend.studyflow.domain.todolist.cm.optionstore.ToDoListOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.studyflow.domain.todolist.cm.entity.sdo.ToDoListCdo;
import io.vizend.studyflow.domain.todolist.cm.event.ToDoListEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.studyflow.domain.todolist.cm.entity.ToDoList;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.message.dynamic.QueryParams;
import io.vizend.accent.domain.type.Offset;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
@RequiredArgsConstructor
public class ToDoListLogic {
    /* Gen by Vizend Vista v7.0.0 */
    private final ToDoListStore toDoListStore;
    private final ToDoListOptionStore toDoListOptionStore;
    private final EventProxy eventProxy;

    public String registerToDoList(ToDoListCdo toDoListCdo) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoList toDoList = new ToDoList(toDoListCdo);
        if (toDoListCdo.hasAdditionalAttributes()) {
            toDoList.modify(toDoListCdo.getAdditionalAttributes());
        }
        if (toDoListStore.exists(toDoList.getId())) {
            throw new IllegalArgumentException("toDoList already exists. " + toDoList.getId());
        }
        toDoListStore.create(toDoList);
        ToDoListEvent toDoListEvent = ToDoListEvent.newToDoListRegisteredEvent(toDoList, toDoList.getId());
        eventProxy.produceEvent(toDoListEvent);
        return toDoList.getId();
    }

    public List<String> registerToDoLists(List<ToDoListCdo> toDoListCdos) {
        /* Gen by Vizend Vista v7.0.0 */
        return toDoListCdos.stream().map(this::registerToDoList).collect(Collectors.toList());
    }

    public ToDoList findToDoList(String toDoListId) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoList toDoList = toDoListStore.retrieve(toDoListId);
        if (toDoList == null) {
            throw new NoSuchElementException("ToDoList id: " + toDoListId);
        }
        return toDoList;
    }

    public ToDoList findToDoList(QueryParams queryParams) {
        /* Gen by Vizend Vista v7.0.0 */
        return toDoListStore.retrieve(queryParams);
    }

    public List<ToDoList> findToDoLists(QueryParams queryParams, Offset offset) {
        /* Gen by Vizend Vista v7.0.0 */
        return toDoListStore.retrieveList(queryParams, offset);
    }

    public void modifyToDoList(String toDoListId, NameValueList nameValues) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoList toDoList = findToDoList(toDoListId);
        toDoList.modify(nameValues);
        toDoListStore.update(toDoList);
        ToDoListEvent toDoListEvent = ToDoListEvent.newToDoListModifiedEvent(toDoListId, nameValues, toDoList);
        eventProxy.produceEvent(toDoListEvent);
    }

    public void modifyToDoList(ToDoList toDoList) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoList oldToDoList = findToDoList(toDoList.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldToDoList, toDoList);
        if (nameValues.size() > 0) {
            modifyToDoList(toDoList.getId(), nameValues);
        }
    }

    public void removeToDoList(String toDoListId) {
        /* Gen by Vizend Vista v7.0.0 */
        ToDoList toDoList = findToDoList(toDoListId);
        toDoListStore.delete(toDoList);
        ToDoListEvent toDoListEvent = ToDoListEvent.newToDoListRemovedEvent(toDoList, toDoList.getId());
        eventProxy.produceEvent(toDoListEvent);
    }

    public boolean existsToDoList(String toDoListId) {
        /* Gen by Vizend Vista v7.0.0 */
        return toDoListStore.exists(toDoListId);
    }

    public void handleEventForProjection(ToDoListEvent toDoListEvent) {
        /* Gen by Vizend Vista v7.0.0 */
        switch(toDoListEvent.getDataEventType()) {
            case Registered:
                toDoListStore.create(toDoListEvent.getToDoList());
                break;
            case Modified:
                ToDoList toDoList = toDoListStore.retrieve(toDoListEvent.getToDoListId());
                toDoList.modify(toDoListEvent.getNameValues());
                toDoListStore.update(toDoList);
                break;
            case Removed:
                toDoListStore.delete(toDoListEvent.getToDoListId());
                break;
        }
    }
}
