package com.hardis.google.hashcode.videos;

import com.hardis.google.hashcode.videos.utils.*;
import org.apache.log4j.Logger;

/**
 * Created by pierrestainton on 25/02/2017.
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        String filename = "me_at_the_zoo";
        String exportPath = "/Users/pierrestainton/Documents/Java/google-hashcode-videos/";

        TreatmentUtils.doTreatmentVersion1(filename, exportPath);
    }

}
