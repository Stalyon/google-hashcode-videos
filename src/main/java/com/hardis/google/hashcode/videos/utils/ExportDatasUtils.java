package com.hardis.google.hashcode.videos.utils;

import com.hardis.google.hashcode.videos.model.CacheServer;
import com.hardis.google.hashcode.videos.model.Datas;
import com.hardis.google.hashcode.videos.model.Video;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;

/**
 * Created by pierrestainton on 26/02/2017.
 */
public class ExportDatasUtils {

    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(ExportDatasUtils.class);

    private ExportDatasUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static Boolean exportsDatas(String filename, Datas datas) {
        LOGGER.info("Export des datas.");

        try {
            File file = new File("/Users/pierrestainton/Documents/Java/google-hashcode-videos/" + filename);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            writer.write(datas.getNbCacheServers() + "\n");
            for(CacheServer cacheServer : datas.getCacheServers()) {
                String line = String.valueOf(cacheServer.getId());

                for(Video video : cacheServer.getVideos()){
                    line += " " + video.getId();
                }
                writer.write(line + "\n");
            }

            writer.flush();
            writer.close();

            LOGGER.info("Fin de l'export des datas.");
            return Boolean.TRUE;
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
            return Boolean.FALSE;
        } catch (IOException e) {
            LOGGER.error(e);
            return Boolean.FALSE;
        }
    }

}
