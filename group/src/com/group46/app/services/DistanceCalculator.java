package com.group46.app.services;

import com.group46.app.models.Location;
import com.group46.app.models.Route;

import java.util.ArrayList;
import java.util.List;

public class DistanceCalculator {
    public List<Route> calculateAllRoutes(Location source, Location destination) {
        List<Route> routes = new ArrayList<>();
        // Implement logic to calculate all possible routes between source and destination
        // Return a list of Route objects representing the routes

        // Sample implementation
        Route route1 = new Route(source, destination);
        Route route2 = new Route(source, destination);
        Route route3 = new Route(source, destination);
        routes.add(route1);
        routes.add(route2);
        routes.add(route3);
        return routes;
    }

    public int calculateDistance(Route route) {
        // Implement logic to calculate the distance for a given route
        // Return the calculated distance

        // Sample implementation
        return 10;
    }
}
