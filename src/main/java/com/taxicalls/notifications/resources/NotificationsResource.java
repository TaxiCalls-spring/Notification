package com.taxicalls.notifications.resources;

import com.taxicalls.notifications.model.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.taxicalls.notifications.service.NotificationService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("notifications")
public class NotificationsResource {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Notification createNotification(Notification notification) {
        return notificationService.createNotification(notification);
    }

    @RequestMapping("/")
    public List<Notification> getNotifications() {
        return notificationService.getNotifications();
    }

    @RequestMapping(value = "/{id}")
    public Notification getNotification(@PathVariable("id") Integer id) {
        return notificationService.getNotification(id);
    }

}
