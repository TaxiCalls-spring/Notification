package com.taxicalls.notification.resources;

import com.taxicalls.notification.model.Driver;
import com.taxicalls.notification.model.Notification;
import com.taxicalls.notification.model.Passenger;
import com.taxicalls.notification.model.Trip;

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
@RequestMapping("trips")
public class TripsResource {

    protected static final Logger LOGGER = Logger.getLogger(TripsResource.class.getName());

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(method = RequestMethod.POST)
    public Response createTrip(@RequestBody Trip trip) {
        LOGGER.log(Level.INFO, "createTrip() invoked");
        Notification notification = new Notification();
        notification.setFromEntity(Driver.class.getSimpleName());
        notification.setFromId(trip.getDriver().getId());
        notification.setToEntity(Passenger.class.getSimpleName());
        for (Passenger passenger : trip.getPassengers()) {
            notification.setToId(passenger.getId());
            notificationService.createNotification(notification);
        }
        return Response.successful(notification);
    }

}
