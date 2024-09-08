/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 10:41
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.utils;

import com.climax.rapport_statistique.services.Fichier;
import com.climax.rapport_statistique.services.servicesImpl.FichierCSV;
import com.climax.rapport_statistique.services.servicesImpl.FichierJSON;
import com.climax.rapport_statistique.services.servicesImpl.FichierXML;

import java.util.HashMap;
import java.util.Map;

public class FileFactory {
    private static final Map<String, Fichier> parsers = new HashMap<>();

    static {
        parsers.put("csv", new FichierCSV());
        parsers.put("json", new FichierJSON());
       parsers.put("xml", new FichierXML());
    }

    public static Fichier getFichierType(String fileType) {
        Fichier parser = parsers.get(fileType.toLowerCase());
        if (parser == null) {
            throw new UnsupportedOperationException("Type de fichier non supporté");
        }
        return parser;
    }
}
