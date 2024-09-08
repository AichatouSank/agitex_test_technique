/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 10:29
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.services.servicesImpl;

import com.climax.rapport_statistique.model.Client;
import com.climax.rapport_statistique.services.Fichier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Qualifier("lireXml")
public class FichierXML implements Fichier {
    @Override
    public List<Client> lireFichier(InputStream inputStream) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Client[] clientDataArray = objectMapper.readValue(inputStream, Client[].class);
        return List.of(clientDataArray);
    }
}
