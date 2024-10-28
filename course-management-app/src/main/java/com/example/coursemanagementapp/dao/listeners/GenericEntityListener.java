package com.example.coursemanagementapp.dao.listeners;

import com.example.coursemanagementapp.service.HistoryService;
import jakarta.persistence.PreRemove;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class GenericEntityListener<T> implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @PreRemove
    public void onPreRemove(T entity) {
        HistoryService historyService = applicationContext.getBean(HistoryService.class);
        Long entityId = getEntityId(entity);
        String entityName = entity.getClass().getSimpleName();
        historyService.deleteAllByEntityIdAndEntityType(entityId, entityName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        GenericEntityListener.applicationContext = applicationContext;
    }

    private Long getEntityId(T entity) {
        try {
            return (Long) entity.getClass().getMethod("getId").invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve entity ID", e);
        }
    }
}
