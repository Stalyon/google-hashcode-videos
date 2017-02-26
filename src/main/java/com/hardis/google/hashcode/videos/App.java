package com.hardis.google.hashcode.videos;

import com.hardis.google.hashcode.videos.model.Datas;
import com.hardis.google.hashcode.videos.utils.ImportDatasUtils;
import org.apache.log4j.Logger;


/**
 * Created by pierrestainton on 25/02/2017.
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        LOGGER.info("Lancement du programme.");

        Datas datas = ImportDatasUtils.importDatas("example.in");
    }

}
