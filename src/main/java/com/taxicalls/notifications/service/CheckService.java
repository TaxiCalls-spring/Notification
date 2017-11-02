/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.notifications.service;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxicalls.notifications.model.Notification;
import java.util.Collection;
import com.taxicalls.notifications.repository.NotificationRepository;
import com.taxicalls.notifications.resources.CheckNotificationsRequest;

/**
 *
 * @author romulo
 */
@Service
public class CheckService {

    protected static final Logger LOGGER = Logger.getLogger(CheckService.class.getName());

    @Autowired
    protected NotificationRepository notificationRepository;

    @Autowired
    public CheckService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
        LOGGER.log(Level.INFO, "NotificationRepository says system has {0} accounts", notificationRepository.count());
    }

    public Collection<Notification> checkNotifications(CheckNotificationsRequest checkNotificationsRequest) {
        LOGGER.log(Level.INFO, "checkNotifications() invoked");
        Long id = checkNotificationsRequest.getId();
        String entity = checkNotificationsRequest.getEntity();
        Collection<Notification> notifications = new ArrayList<>();
        for (Notification notification : notificationRepository.findAll()) {
            if (notification.getToEntity().equals(entity) && notification.getToId().equals(id)) {
                notifications.add(notification);
            }
        }
        return notifications;
    }

}
