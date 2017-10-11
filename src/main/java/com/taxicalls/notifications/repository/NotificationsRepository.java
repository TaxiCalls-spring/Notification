package com.taxicalls.notifications.repository;

import com.taxicalls.notifications.model.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationsRepository extends CrudRepository<Notification, Integer> {

}
