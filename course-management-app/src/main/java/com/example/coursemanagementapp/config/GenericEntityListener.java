package com.example.coursemanagementapp.config;

import com.example.coursemanagementapp.service.HistoryService;
import jakarta.persistence.PreRemove;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class GenericEntityListener<T> implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @PreRemove
    public void onPreRemove(T entity) {
        log.info("GenericEntityListener: onPreRemove - was called with entity: {}", entity);
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
