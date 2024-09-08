/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 12:56
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.controlleurs;

import com.climax.rapport_statistique.model.Client;
import com.climax.rapport_statistique.services.ChargementFichier;
import com.climax.rapport_statistique.services.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/statistics")
public class StatisticControlleur {
    @Qualifier("lireJson")
    private final StatisticService statisticService;
    private final ChargementFichier chargementFichier;

    @PostMapping()
    public Map<String, Double> calculerMoyenneSalarialeParProfession(@RequestParam("file") MultipartFile file) throws IOException {
        List<Client> clients = chargementFichier.chargerFichier(file); // Lecture du fichier
        return statisticService.moyenneSalarialeParProfession(clients); // Calcul des moyennes
    }
}
