package fr.poulet4j.gui.saveturn;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import fr.poulet4j.gui.Controler;
import fr.poulet4j.gui.OneTurnImageBuilder;
import fr.poulet4j.gui.gamemap.BackgroundBuilderGameMap;
import fr.poulet4j.save.SaveTurn;

public class BackgroundBuilderSaveTurn implements OneTurnImageBuilder<SaveTurn> {

    BackgroundBuilderGameMap builder;

    public BackgroundBuilderSaveTurn() {
        builder = new BackgroundBuilderGameMap();
    }

    public BufferedImage build(final SaveTurn saveTurn) {
        return builder.build(saveTurn.data);
    }

    public JPanel getControlPanel(Controler controler) {
        return null;
    }

}
