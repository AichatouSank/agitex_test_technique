/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 11:37
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.services.servicesImpl;

import com.climax.rapport_statistique.model.Client;
import com.climax.rapport_statistique.services.ChargementFichier;
import com.climax.rapport_statistique.services.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {
    @Qualifier("lireJson")
    private final ChargementFichier chargementFichier;
    @Override
    public Map<String, Double> moyenneSalarialeParProfession(List<Client> clientList) throws IOException {
        Map<String, List<Double>> revenusParProfession = new HashMap<>();

        // Agrégation des revenus par profession
        for (Client client : clientList) {
            String profession = client.getProfession();
            double salaire = client.getSalaire();

            revenusParProfession.putIfAbsent(profession, new ArrayList<>());
            revenusParProfession.get(profession).add(salaire);
        }

        // Calcul de la moyenne salariale par profession
        Map<String, Double> moyenneSalarialeParProfession = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : revenusParProfession.entrySet()) {
            String profession = entry.getKey();
            List<Double> revenus = entry.getValue();
            double sommeRevenus = revenus.stream().mapToDouble(Double::doubleValue).sum();
            moyenneSalarialeParProfession.put(profession, sommeRevenus / revenus.size());
        }

        return moyenneSalarialeParProfession;
    }
}
