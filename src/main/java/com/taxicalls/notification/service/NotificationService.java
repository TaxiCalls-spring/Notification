/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.notification.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxicalls.notification.model.Notification;
import com.taxicalls.notification.repository.NotificationRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author romulo
 */
@Service
public class NotificationService {

    protected static final Logger LOGGER = Logger.getLogger(NotificationService.class.getName());

    @Autowired
    protected NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
        LOGGER.log(Level.INFO, "NotificationRepository says system has {0} accounts", notificationRepository.count());
    }

    @Transactional
    public Notification createNotification(Notification notification) {
        Notification save = notificationRepository.save(notification);
        return save;
    }

    public List<Notification> getNotifications() {
        LOGGER.log(Level.INFO, "getNotifications() invoked");
        List<Notification> notifications = new ArrayList<>();
        Iterable<Notification> findAll = notificationRepository.findAll();
        for (Notification notification : findAll) {
            notifications.add(notification);
        }
        LOGGER.log(Level.INFO, "getNotifications() found {0}", notifications.size());
        return notifications;
    }

    public Notification getNotification(Long id) {
        Notification notification = notificationRepository.findOne(id);
        return notification;
    }

}
