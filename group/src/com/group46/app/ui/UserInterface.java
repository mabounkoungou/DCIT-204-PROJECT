package com.group46.app.ui;

import com.group46.app.controllers.RouteController;
import com.group46.app.models.Location;
import com.group46.app.models.Route;

import javax.swing.JOptionPane;
import java.util.List;

public class UserInterface {
    private RouteController routeController;

    public UserInterface() {
        this.routeController = new RouteController();
    }

    public void displayDialogBox() {
        String sourceName = JOptionPane.showInputDialog(null, "Enter source location:");
        String destinationName = JOptionPane.showInputDialog(null, "Enter destination location:");

        if (sourceName != null && destinationName != null) {
            Location source = new Location(sourceName);
            Location destination = new Location(destinationName);

            List<Route> routes = routeController.calculateBestRoutes(source, destination);

            StringBuilder message = new StringBuilder("Best Routes:\n");
            for (Route route : routes) {
                message.append("Source: ").append(route.getSource().getName())
                        .append(" -> Destination: ").append(route.getDestination().getName())
                        .append("\nDistance: ").append(route.getDistance())
                        .append(" km, Arrival Time: ").append(route.getArrivalTime()).append(" min\n");
            }

            JOptionPane.showMessageDialog(null, message.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input provided.");
        }
    }
}
