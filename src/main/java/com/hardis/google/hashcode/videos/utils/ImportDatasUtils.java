package com.hardis.google.hashcode.videos.utils;

import com.hardis.google.hashcode.videos.model.*;

import java.io.*;

import org.apache.log4j.Logger;

/**
 * Created by pierrestainton on 25/02/2017.
 */
public class ImportDatasUtils {

    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(ImportDatasUtils.class);

    private ImportDatasUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static Datas importDatas(String filename) {
        LOGGER.info("Import des datas.");

        try {
            Datas datas = new Datas();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getSystemResourceAsStream(filename)));

            String line;
            Boolean isFirstBloc = Boolean.TRUE;
            Boolean isSecondBloc = Boolean.TRUE;
            Boolean isThirdBloc = Boolean.TRUE;
            Boolean isEndpointHeader = Boolean.TRUE;
            int countEndpointsBloc = 0;
            int countEndpointsLine = 0;

            while ((line = reader.readLine()) != null) {
                if (isFirstBloc) {
                    String values[] = line.split(" ");

                    datas.setNbVideos(Integer.parseInt(values[0]));
                    datas.setNbEndpoints(Integer.parseInt(values[1]));
                    datas.setNbRequestDescriptions(Integer.parseInt(values[2]));
                    datas.setNbCacheServers(Integer.parseInt(values[3]));

                    for(int i = 0; i < datas.getNbCacheServers(); i++) {
                        datas.addCacheServer(new CacheServer(i, Integer.parseInt(values[4])));
                    }

                    isFirstBloc = Boolean.FALSE;
                } else if (isSecondBloc) {
                    String values[] = line.split(" ");

                    for(int i=0; i<datas.getNbVideos(); i++) {
                        datas.addVideo(new Video(i, Integer.parseInt(values[i])));
                    }

                    isSecondBloc = Boolean.FALSE;
                } else if(isThirdBloc){
                    String values[] = line.split(" ");

                    if(isEndpointHeader) {
                        Endpoint endpoint = new Endpoint(countEndpointsBloc, Integer.parseInt(values[0]));
                        datas.addEndpoint(endpoint);
                        datas.getCacheServers().get(0).addEndpoint(endpoint);
                        countEndpointsLine = Integer.parseInt(values[1]);

                        if(countEndpointsLine != 0) {
                            isEndpointHeader = Boolean.FALSE;
                        } else if(countEndpointsBloc == datas.getNbEndpoints() -1) {
                            isThirdBloc = Boolean.FALSE;
                        }
                    } else {
                        datas.getEndpoints().get(countEndpointsBloc).getLatencyToCacheServer()
                                .put(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                        countEndpointsLine--;

                        if(countEndpointsLine == 0 && countEndpointsBloc < datas.getNbEndpoints()) {
                            countEndpointsBloc++;
                            isEndpointHeader = Boolean.TRUE;
                        } else if(countEndpointsLine == 0) {
                            isThirdBloc = Boolean.FALSE;
                        }
                    }
                } else {
                    String values[] = line.split(" ");

                    datas.getEndpoints().get(Integer.parseInt(values[1]))
                            .putRequestToVideo(Integer.parseInt(values[2]), Integer.parseInt(values[0]));
                }
            }
            LOGGER.info("Fin de l'import des datas.");
            return datas;
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        return null;
    }

}
