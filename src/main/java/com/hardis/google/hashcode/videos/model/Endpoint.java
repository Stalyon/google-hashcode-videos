package com.hardis.google.hashcode.videos.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Endpoint entity
 *
 * Created by pierrestainton on 25/02/2017.
 */
public class Endpoint {

    private int id;
    private int latency;
    private List<CacheServer> cacheServers;
    private List<Request> requests;
    private Map<Integer, Integer> latencyToCacheServer;


    public Endpoint(int id, int latency) {
        this.id = id;
        this.latency = latency;
        this.cacheServers = new ArrayList<CacheServer>();
        this.requests = new ArrayList<Request>();
        this.latencyToCacheServer = new HashMap<Integer, Integer>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
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

    public Map<Integer, Integer> getLatencyToCacheServer() {
        return latencyToCacheServer;
    }

    public void setLatencyToCacheServer(Map<Integer, Integer> latencyToCacheServer) {
        this.latencyToCacheServer = latencyToCacheServer;
    }

    public void putLantencyToCacheServer(Integer latency, Integer cacheServerId) {
        this.latencyToCacheServer.put(latency, cacheServerId);
    }

}
