package com.taxicalls.notifications.resource;

import com.taxicalls.notifications.model.Notification;
import com.taxicalls.notifications.model.Passenger;
import com.taxicalls.notifications.repository.NotificationsRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationsResource {

    private static final Logger LOGGER = Logger.getLogger(NotificationsResource.class.getName());

    @Autowired
    protected NotificationsRepository notificationsRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/checkNotifications")
    public Collection<Notification> chooseDriver(Object user) {
        Collection<Notification> notifications = new ArrayList<>();
        for (Notification notification : notificationsRepository.findAll()) {
            notifications.add(notification);
        }
        return notifications;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/chooseDriver")
    public Notification chooseDriver(Passenger passenger) {
        Notification notification = new Notification();
        Notification save = notificationsRepository.save(notification);
        return save;
    }

}
