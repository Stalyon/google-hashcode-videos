package com.hardis.google.hashcode.videos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * CacheServer entity
 *
 * Created by pierrestainton on 25/02/2017.
 */
public class CacheServer {

    private int id;
    private int capacityMax;
    private int currentCapacity;
    List<Video> videos;
    List<Endpoint> endpoints;


    public CacheServer(int id, int capacityMax) {
        this.id = id;
        this.capacityMax = capacityMax;
        this.currentCapacity = capacityMax;
        this.videos = new ArrayList<Video>();
        this.endpoints = new ArrayList<Endpoint>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacityMax() {
        return capacityMax;
    }

    public void setCapacityMax(int capacityMax) {
        this.capacityMax = capacityMax;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public void addEndpoint(Endpoint endpoint) {
        this.endpoints.add(endpoint);
    }

}
