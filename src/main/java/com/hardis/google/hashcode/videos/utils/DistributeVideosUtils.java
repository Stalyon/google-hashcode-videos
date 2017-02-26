package com.hardis.google.hashcode.videos.utils;

import com.hardis.google.hashcode.videos.model.CoupleCacheServerVideo;
import com.hardis.google.hashcode.videos.model.Datas;
import com.hardis.google.hashcode.videos.model.Video;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by pierrestainton on 26/02/2017.
 */
public class DistributeVideosUtils {

    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(DistributeVideosUtils.class);

    private DistributeVideosUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static Datas distributeVideos(Datas datas, List<CoupleCacheServerVideo> coupleCacheServerVideos) {
        LOGGER.info("Distribution des vidéos.");

        for(CoupleCacheServerVideo coupleCacheServerVideo : coupleCacheServerVideos) {
            Video video = coupleCacheServerVideo.getVideo();
            int currentCapacity = coupleCacheServerVideo.getCacheServer().getCurrentCapacity();
            if(coupleCacheServerVideo.getCoefficient() > 0 && currentCapacity > video.getSize()) {
                datas.getCacheServers().get(coupleCacheServerVideo.getCacheServer().getId()).addVideo(video);
                datas.getCacheServers().get(coupleCacheServerVideo.getCacheServer().getId()).setCurrentCapacity(currentCapacity - video.getSize());
            }
        }

        LOGGER.info("Fin de la distribution des vidéos.");
        return datas;
    }
}
