package com.taxicalls.notification.resources;

import com.taxicalls.notification.model.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.taxicalls.notification.service.NotificationService;
import com.taxicalls.protocol.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("notifications")
public class NotificationsResource {

    protected static final Logger LOGGER = Logger.getLogger(NotificationsResource.class.getName());

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(method = RequestMethod.POST)
    public Response createNotification(@RequestBody Notification notification) {
        LOGGER.log(Level.INFO, "createNotification() invoked");
        Notification createNotification = notificationService.createNotification(notification);
        return Response.successful(createNotification);
    }

    @RequestMapping
    public Response getNotifications() {
        return Response.successful(notificationService.getNotifications());
    }

    @RequestMapping(value = "/{id}")
    public Response getNotification(@PathVariable("id") Long id) {
        Notification notification = notificationService.getNotification(id);
        if (notification == null) {
            return Response.notFound();
        }
        return Response.successful(notification);
    }

}
