/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 11:37
 * @Date: 08/09/2024
 */
package com.climax.rapport_statistique.services;

import com.climax.rapport_statistique.model.Client;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface StatisticService {
    Map<String, Double> moyenneSalarialeParProfession(List<Client> clientList) throws IOException;
}
