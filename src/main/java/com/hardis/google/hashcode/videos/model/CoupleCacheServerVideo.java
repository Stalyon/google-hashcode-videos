package com.hardis.google.hashcode.videos.model;

/**
 * Created by pierrestainton on 25/02/2017.
 */
public class CoupleCacheServerVideo {

    private CacheServer cacheServer;
    private Video video;
    private int coefficient;


    public CoupleCacheServerVideo(CacheServer cacheServer, Video video) {
        this.cacheServer = cacheServer;
        this.video = video;
        this.coefficient = 0;
    }


    public CacheServer getCacheServer() {
        return cacheServer;
    }

    public void setCacheServer(CacheServer cacheServer) {
        this.cacheServer = cacheServer;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void addValueToCoefficient(int value) {
        this.coefficient += value;
    }

    public void substractValueToCoefficient(int value) {
        this.coefficient -= value;
    }

}
