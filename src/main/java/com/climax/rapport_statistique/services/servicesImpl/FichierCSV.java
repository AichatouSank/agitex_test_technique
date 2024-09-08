/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 10:25
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.services.servicesImpl;

import com.climax.rapport_statistique.model.Client;
import com.climax.rapport_statistique.services.Fichier;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("lireCsv")
public class FichierCSV implements Fichier {
    @Override
    public List<Client> lireFichier(InputStream inputStream) throws IOException, CsvValidationException {
        List<Client> clientList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                Client client = new Client();
                client.setNom(line[0]);
                client.setPrenom(line[1]);
                client.setAge(Integer.parseInt(line[2]));
                client.setProfession(line[3]);
                client.setSalaire(Double.parseDouble(line[4]));
                clientList.add(client);
            }
        }
        return clientList;
    }
}
