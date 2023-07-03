package com.group46.app.services;

import com.group46.app.models.Location;
import com.group46.app.models.Route;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.TravelMode;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DistanceCalculator {
    private GeoApiContext context;

    public DistanceCalculator(String apiKey) {
        this.context = new GeoApiContext.Builder().apiKey(apiKey).build();
    }

    public List<Route> calculateAllRoutes(Location source, Location destination) {
        List<Route> routes = new ArrayList<>();

        try {
            DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(context)
                    .origins(source.getLatitude() + "," + source.getLongitude())
                    .destinations(destination.getLatitude() + "," + destination.getLongitude())
                    .mode(TravelMode.DRIVING)
                    .await();

            if (distanceMatrix.rows.length > 0 && distanceMatrix.rows[0].elements.length > 0) {
                DistanceMatrixElement element = distanceMatrix.rows[0].elements[0];
                if (element.status == DistanceMatrixElementStatus.OK) {
                    Route route = new Route(source, destination);
                    route.setDistance(element.distance.inMeters / 1000); // Convert distance to kilometers
                    route.setArrivalTime(calculateArrivalTime());
                    routes.add(route);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return routes;
    }

    public int calculateDistance(Route route) {
        return route.getDistance();
    }

    private int calculateArrivalTime() {
        Instant now = Instant.now();
        Instant plusThirtyMinutes = now.plus(Duration.ofMinutes(30));
        Duration duration = Duration.between(now, plusThirtyMinutes);
        return (int) duration.toMinutes();
    }
}
