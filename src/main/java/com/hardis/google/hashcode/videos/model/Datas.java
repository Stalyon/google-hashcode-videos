package com.hardis.google.hashcode.videos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Datas entity
 *
 * Created by pierrestainton on 25/02/2017.
 */
public class Datas {

    int nbVideos;
    int nbEndpoints;
    int nbRequestDescriptions;
    int nbCacheServers;
    List<CacheServer> cacheServers;
    List<Endpoint> endpoints;
    List<Video> videos;


    public Datas() {
        this.cacheServers = new ArrayList<CacheServer>();
        this.endpoints = new ArrayList<Endpoint>();
        this.videos = new ArrayList<Video>();
    }


    public int getNbVideos() {
        return nbVideos;
    }

    public void setNbVideos(int nbVideos) {
        this.nbVideos = nbVideos;
    }

    public int getNbEndpoints() {
        return nbEndpoints;
    }

    public void setNbEndpoints(int nbEndpoints) {
        this.nbEndpoints = nbEndpoints;
    }

    public int getNbRequestDescriptions() {
        return nbRequestDescriptions;
    }

    public void setNbRequestDescriptions(int nbRequestDescriptions) {
        this.nbRequestDescriptions = nbRequestDescriptions;
    }

    public int getNbCacheServers() {
        return nbCacheServers;
    }

    public void setNbCacheServers(int nbCacheServers) {
        this.nbCacheServers = nbCacheServers;
    }

    public List<CacheServer> getCacheServers() {
        return cacheServers;
    }

    public void setCacheServers(List<CacheServer> cacheServers) {
        this.cacheServers = cacheServers;
    }

    public void addCacheServer(CacheServer cacheServer) {
        this.cacheServers.add(cacheServer);
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

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }

}
