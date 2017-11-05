package com.taxicalls.notification.resources;

import com.taxicalls.notification.service.CheckService;
import com.taxicalls.protocol.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checks")
public class ChecksResource {

    @Autowired
    protected CheckService checkService;

    @RequestMapping(method = RequestMethod.POST)
    public Response checkNotifications(@RequestBody CheckNotificationsRequest checkNotificationsRequest) {
        return Response.successful(checkService.checkNotifications(checkNotificationsRequest));
    }
}
