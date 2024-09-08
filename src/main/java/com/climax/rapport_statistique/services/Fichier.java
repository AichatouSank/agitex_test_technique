/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 10:22
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.services;

import com.climax.rapport_statistique.model.Client;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface Fichier {
    List<Client>  lireFichier(InputStream inputStream) throws IOException, CsvValidationException;
}
