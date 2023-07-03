package com.group46.app.controllers;

import com.group46.app.models.Location;
import com.group46.app.models.Route;
import com.group46.app.services.DistanceCalculator;
import com.group46.app.services.TimeCalculator;

import java.util.ArrayList;
import java.util.List;

public class RouteController {
    private DistanceCalculator distanceCalculator;
    private TimeCalculator timeCalculator;

    public RouteController() {
        this.distanceCalculator = new DistanceCalculator();
        this.timeCalculator = new TimeCalculator();
    }

    public List<Route> calculateBestRoutes(Location source, Location destination) {
        List<Route> routes = distanceCalculator.calculateAllRoutes(source, destination);
        for (Route route : routes) {
            int distance = distanceCalculator.calculateDistance(route);
            int arrivalTime = timeCalculator.calculateArrivalTime(route);
            route.setDistance(distance);
            route.setArrivalTime(arrivalTime);
        }
        return routes;
    }
}

