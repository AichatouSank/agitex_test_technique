/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 10:45
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.services.servicesImpl;

import com.climax.rapport_statistique.model.Client;
import com.climax.rapport_statistique.services.ChargementFichier;
import com.climax.rapport_statistique.services.Fichier;
import com.climax.rapport_statistique.utils.FichierFactory;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ChargementFichierImpl implements ChargementFichier {
    @Override
    public List<Client> chargerFichier(MultipartFile file) throws IOException {
        String fileType = getFileExtension(file.getOriginalFilename());
        Fichier parser = FichierFactory.getFichierType(fileType);

        try (InputStream inputStream = file.getInputStream()) {
            return parser.lireFichier(inputStream);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        throw new IllegalArgumentException("Fichier sans extension");
    }
}

