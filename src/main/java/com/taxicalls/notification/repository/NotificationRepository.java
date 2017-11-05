package com.taxicalls.notification.repository;

import com.taxicalls.notification.model.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
