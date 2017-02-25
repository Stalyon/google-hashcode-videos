package com.hardis.google.hashcode.videos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Endpoint entity
 *
 * Created by pierrestainton on 25/02/2017.
 */
public class Endpoint {

    private int id;
    private List<CacheServer> cacheServers;
    private List<Request> requests;


    public Endpoint(int id) {
        this.id = id;
        this.cacheServers = new ArrayList<CacheServer>();
        this.requests = new ArrayList<Request>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }

}
