package com.group46.app.models;

public class Route {
    private Location source;
    private Location destination;
    private int distance;
    private int arrivalTime;
    private String intermediateLocation;

    public Route(Location source, Location destination) {
        this.source = source;
        this.destination = destination;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getIntermediateLocation() {
        return intermediateLocation;
    }

    public void setIntermediateLocation(String intermediateLocation) {
        this.intermediateLocation = intermediateLocation;
    }
}
