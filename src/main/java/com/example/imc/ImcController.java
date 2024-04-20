package com.example.imc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class ImcController {
    float age;
    float taille;
    float tailleImc;
    float poids;
    float poidsIdeal;
    float Imc;
    float IMG;
    @FXML
    private Button ButtonFemme;

    @FXML
    private Button ButtonHomme;

    @FXML
    private TextField Age_Text;

    @FXML
    private TextField EtatSante_Text;

    @FXML
    private TextField Imc_Text;


    @FXML
    private TextField PoidsIdeal_Text;

    @FXML
    private TextField Poids_Text;

    @FXML
    private TextField Taille_Text;

    @FXML
    private TextField MasseGraisse_Text;


    @FXML
    void FemmeButtonClick(ActionEvent event) {
        IMG = (float) ((1.20 * Imc) + (0.23 * age) - 5.4);
        poidsIdeal = (float) (taille - 100 - ((taille - 150) /2.5 ));
    }

    @FXML
    void HommeButtonClick(ActionEvent event) {
        IMG = (float) ((1.20 * Imc) + (0.23 * age) - 10.8 - 5.4);
        poidsIdeal = taille - 100 - ((taille - 150) /4 );
    }

    @FXML
    void CalculerImc(ActionEvent event) {
         age = Float.parseFloat(Age_Text.getText());
         taille = Float.parseFloat(Taille_Text.getText());
         poids = Float.parseFloat(Poids_Text.getText());
         tailleImc = taille / 100;

         Imc = poids / (tailleImc * tailleImc);

         //IMG = (float) ((1.20 * Imc) + (0.23 * age) - 10.8 - 5.4);

         //poidsIdeal = taille - 100 - ((taille - 150) /4 );


        Imc_Text.setText(String.valueOf(Imc));
        if (Imc < 16.5) {
            EtatSante_Text.setText("Maigreur extrême – dénutrition");
        } else if (Imc < 18.5) {
            EtatSante_Text.setText("Maigreur");
        } else if (Imc < 25) {
            EtatSante_Text.setText("Corpulence normale");
        } else if (Imc < 30) {
            EtatSante_Text.setText("Surpoids ou Pré-obésité");
        } else if (Imc < 35) {
            EtatSante_Text.setText("Obésité modérée (classe I)");
        } else if (Imc < 40) {
            EtatSante_Text.setText("Obésité sévère (classe II)");
        }else {
            EtatSante_Text.setText("Obésité morbide (classe III)");
        }

        MasseGraisse_Text.setText(IMG + "%");
        PoidsIdeal_Text.setText(String.valueOf(poidsIdeal));

    }
}