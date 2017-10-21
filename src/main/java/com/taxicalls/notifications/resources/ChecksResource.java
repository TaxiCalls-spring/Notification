package com.taxicalls.notifications.resources;

import com.taxicalls.notifications.model.Notification;
import com.taxicalls.notifications.service.CheckService;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checks")
public class ChecksResource {

    @Autowired
    protected CheckService checkService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Collection<Notification> checkNotifications(Integer id) {
        return checkService.checkNotifications(id);
    }
}
