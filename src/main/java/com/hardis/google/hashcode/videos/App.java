package com.hardis.google.hashcode.videos;

import com.hardis.google.hashcode.videos.model.CoupleCacheServerVideo;
import com.hardis.google.hashcode.videos.model.Datas;
import com.hardis.google.hashcode.videos.utils.CreateCouplesUtils;
import com.hardis.google.hashcode.videos.utils.DistributeVideosUtils;
import com.hardis.google.hashcode.videos.utils.ExportDatasUtils;
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

        String filename = "kittens";
        Datas datas = ImportDatasUtils.importDatas(filename + ".in");
        List<CoupleCacheServerVideo> couples = CreateCouplesUtils.createCouples(datas);

        Collections.sort(couples, new Comparator<CoupleCacheServerVideo>() {
            public int compare(CoupleCacheServerVideo o1, CoupleCacheServerVideo o2) {
                if (o1.getCoefficient() == o2.getCoefficient())
                    return 0;
                return o1.getCoefficient() < o2.getCoefficient() ? 1 : -1;
            }
        });

        datas = DistributeVideosUtils.distributeVideos(datas, couples);
        Boolean exitStatus = ExportDatasUtils.exportsDatas(filename + ".out", datas);

        if(exitStatus) {
            LOGGER.info("Fin du programme, le fichier output a été généré avec succès.");
        } else {
            LOGGER.info("Fin du programme, un problème est survenu durant l'export.");
        }
    }

}
