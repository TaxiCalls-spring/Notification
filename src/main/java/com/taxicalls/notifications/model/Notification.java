/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.notifications.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author romulo
 */
@Entity
@NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sentTime;
    private String fromEntity;
    private Long fromId;
    private String toEntity;
    private Long toId;
    private String content;

    public Notification() {
    }

    public Notification(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public String getFromEntity() {
        return fromEntity;
    }

    public Long getFromId() {
        return fromId;
    }

    public String getToEntity() {
        return toEntity;
    }

    public Long getToId() {
        return toId;
    }

    public String getContent() {
        return content;
    }
}
