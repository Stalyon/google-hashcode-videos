package com.hardis.google.hashcode.videos;

import com.hardis.google.hashcode.videos.model.CoupleCacheServerVideo;
import com.hardis.google.hashcode.videos.model.Datas;
import com.hardis.google.hashcode.videos.utils.CreateCouplesUtils;
import com.hardis.google.hashcode.videos.utils.ImportDatasUtils;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by pierrestainton on 25/02/2017.
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        LOGGER.info("Lancement du programme.");

        Datas datas = ImportDatasUtils.importDatas("example.in");
        List<CoupleCacheServerVideo> couples = CreateCouplesUtils.createCouples(datas);

        Collections.sort(couples, new Comparator<CoupleCacheServerVideo>() {
            public int compare(CoupleCacheServerVideo o1, CoupleCacheServerVideo o2) {
                if (o1.getCoefficient() == o2.getCoefficient())
                    return 0;
                return o1.getCoefficient() < o2.getCoefficient() ? 1 : -1;
            }
        });

        LOGGER.info("Fin du programme.");
    }

}
