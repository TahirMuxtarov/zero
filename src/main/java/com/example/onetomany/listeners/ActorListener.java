package com.example.onetomany.listeners;

import com.example.onetomany.entity.Actor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;


//@Slf4j
public class ActorListener {
    private static Log log = LogFactory.getLog(ActorListener.class);

   /* @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Actor actor) {
        if (actor.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + actor.getId());
        }
    }*/

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Actor actor) {
        log.info("[USER AUDIT] add/update/delete complete for user: " + actor.getId());
    }

    @PostLoad
    private void afterLoad(Actor actor) {
        log.info("[USER AUDIT] user loaded from database: " + actor.getId());
    }
}
