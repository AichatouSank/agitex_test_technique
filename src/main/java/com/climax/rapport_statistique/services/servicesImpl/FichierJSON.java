/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 10:28
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.services.servicesImpl;

import com.climax.rapport_statistique.model.Client;
import com.climax.rapport_statistique.services.Fichier;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("lireJson")
public class FichierJSON implements Fichier {
    @Override
    public List<Client> lireFichier(InputStream inputStream) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Client[] clientDataArray = objectMapper.readValue(inputStream, Client[].class);
        return List.of(clientDataArray);
    }
}
