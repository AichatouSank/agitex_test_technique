/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 10:53
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.controlleurs;

import com.climax.rapport_statistique.model.Client;
import com.climax.rapport_statistique.services.ChargementFichier;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("api/v1/chargement")
@RequiredArgsConstructor
@RestController
public class ChargementFichierControlleur {
//    @Qualifier("lireJson")
//    private final ChargementFichier chargementFichier;
//    @PostMapping
//    public List<Client> chargerListeClients(@RequestParam("file") MultipartFile file) throws IOException {
//        return chargementFichier.chargerFichier(file);
//    }
}
