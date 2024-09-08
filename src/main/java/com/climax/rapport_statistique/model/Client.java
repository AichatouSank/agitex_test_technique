/**
 * @author: Aichatou
 * @version 1.0
 * @year: 2024
 * @since: 23:59
 * @Date: 06/09/2024
 */
package com.climax.rapport_statistique.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    private String nom;
    private String prenom;
    private int age;
    private String profession;
    private double salaire;
}
