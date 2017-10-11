/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.notifications.sender;

import com.taxicalls.notifications.model.Notification;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author romulo
 */
public class SendNotification implements Runnable {

    public static final int MULTICAST_PORT = 8889;
    public static final String MULTICAST_IP = "225.1.2.3";
    private MulticastSocket multicastSocket;
    private static final Logger LOGGER = Logger.getLogger(SendNotification.class.getName());
    private final Notification notification;

    public SendNotification(Notification notification) {
        this.notification = notification;
        try {
            multicastSocket = new MulticastSocket(MULTICAST_PORT);
            multicastSocket.joinGroup(InetAddress.getByName(MULTICAST_IP));
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Couldn't join multicast group", ex);
        }
    }

    @Override
    public void run() {
        try {
            String message = String.valueOf(this.notification);
            byte[] buffer = message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(MULTICAST_IP), this.multicastSocket.getLocalPort());
            multicastSocket.send(datagramPacket);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Couldn't send message", ex);
        } finally {
            try {
                multicastSocket.leaveGroup(InetAddress.getByName(MULTICAST_IP));
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Couldn't leave group", ex);
            } finally {
                multicastSocket.close();
            }
        }
    }
}
