package com.hardis.google.hashcode.videos.utils;

import com.hardis.google.hashcode.videos.model.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierrestainton on 26/02/2017.
 */
public class CreateCouplesUtils {

    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateCouplesUtils.class);

    private CreateCouplesUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static List<CoupleCacheServerVideo> createCouples(Datas datas) {
        LOGGER.info("Création des couples.");
        List<CoupleCacheServerVideo> coupleCacheServerVideos = new ArrayList<CoupleCacheServerVideo>();

        for(CacheServer cacheServer : datas.getCacheServers()) {
            for(Video video : datas.getVideos()) {
                CoupleCacheServerVideo coupleCacheServerVideo = new CoupleCacheServerVideo(cacheServer, video);
                int coefficient = 0;

                for(Endpoint endpoint : cacheServer.getEndpoints()) {
                    Integer a = endpoint.getRequestsToVideo().get(video.getId());
                    int b = endpoint.getLatency();
                    Integer c = endpoint.getLatencyToCacheServer().get(cacheServer.getId());
                    if(a != null && c != null) {
                        coefficient += a*(b - c);
                    }
                }
                coupleCacheServerVideo.setCoefficient(coefficient);
                coupleCacheServerVideos.add(coupleCacheServerVideo);
            }
        }

        LOGGER.info("Fin de la création des couples.");
        return coupleCacheServerVideos;
    }


}
