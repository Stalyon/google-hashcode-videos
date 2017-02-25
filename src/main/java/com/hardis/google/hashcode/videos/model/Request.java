package com.hardis.google.hashcode.videos.model;

/**
 * Request entity
 *
 * Created by pierrestainton on 25/02/2017.
 */
public class Request {

    int nbRequests;
    Video video;


    public Request(int nbRequests, Video video) {
        this.nbRequests = nbRequests;
        this.video = video;
    }


    public int getNbRequests() {
        return nbRequests;
    }

    public void setNbRequests(int nbRequests) {
        this.nbRequests = nbRequests;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

}
