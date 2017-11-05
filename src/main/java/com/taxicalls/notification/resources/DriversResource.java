package com.taxicalls.notification.resources;

import com.taxicalls.notification.model.Driver;
import com.taxicalls.notification.model.Notification;
import com.taxicalls.notification.model.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.taxicalls.notification.service.NotificationService;
import com.taxicalls.protocol.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("drivers")
public class DriversResource {

    protected static final Logger LOGGER = Logger.getLogger(DriversResource.class.getName());

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(method = RequestMethod.POST)
    public Response chooseDriver(@RequestBody ChooseDriverRequest chooseDriverRequest) {
        LOGGER.log(Level.INFO, "chooseDriver() invoked");
        Notification notification = new Notification();
        notification.setFromEntity(Passenger.class.getSimpleName());
        notification.setFromId(chooseDriverRequest.getPassenger().getId());
        notification.setToEntity(Driver.class.getSimpleName());
        notification.setToId(chooseDriverRequest.getDriver().getId());
        notificationService.createNotification(notification);
        return Response.successful(notification);
    }

}
