package com.tokioschool.proyecto.component;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CharacterCreationPanel extends JTabbedPane {
    private JPanel heroesPanel,beastsPanel;
    public TabComponents tabComponentsBeast,tabComponentsHero;

    public CharacterCreationPanel() throws IOException, FontFormatException {
    super();

    initComponents();

    setFont(goodFont(22.0f));
    setBorder(BorderFactory.createBevelBorder(2));
    setMaximumSize(new Dimension(500,300));

    }

    private void initComponents() throws IOException, FontFormatException {

      heroesTab();
      beastsTab();

      addTab("Heroes",heroesPanel);
      addTab("Beasts",beastsPanel);
    }

    private void beastsTab() throws IOException, FontFormatException {
        beastsPanel=new JPanel();
        beastsPanel.setLayout(new GridLayout(5,2));

        tabComponentsBeast=new TabComponents();

        tabComponentsBeast.cbType.addItem("Goblin");
        tabComponentsBeast.cbType.addItem("Orc");

        tabComponentsBeast.btAdd.setActionCommand("addBeast");

        beastsPanel.add(tabComponentsBeast.lbName);
        beastsPanel.add(tabComponentsBeast.tfName);
        beastsPanel.add(tabComponentsBeast.lbType);
        beastsPanel.add(tabComponentsBeast.cbType);
        beastsPanel.add(tabComponentsBeast.lbHealth);
        beastsPanel.add(tabComponentsBeast.tfHealth);
        beastsPanel.add(tabComponentsBeast.lbArmor);
        beastsPanel.add(tabComponentsBeast.tfArmor);
        beastsPanel.add(tabComponentsBeast.btAdd);
        beastsPanel.add(tabComponentsBeast.btReset);

        beastsPanel.setOpaque(false);
    }

    private void heroesTab() throws IOException, FontFormatException {
        heroesPanel=new JPanel();
        heroesPanel.setLayout(new GridLayout(5,2));

        tabComponentsHero=new TabComponents();

        tabComponentsHero.cbType.addItem("Human");
        tabComponentsHero.cbType.addItem("Elf");
        tabComponentsHero.cbType.addItem("Hobbit");

        tabComponentsHero.btAdd.setActionCommand("addHero");

        heroesPanel.add(tabComponentsHero.lbName);
        heroesPanel.add(tabComponentsHero.tfName);
        heroesPanel.add(tabComponentsHero.lbType);
        heroesPanel.add(tabComponentsHero.cbType);
        heroesPanel.add(tabComponentsHero.lbHealth);
        heroesPanel.add(tabComponentsHero.tfHealth);
        heroesPanel.add(tabComponentsHero.lbArmor);
        heroesPanel.add(tabComponentsHero.tfArmor);
        heroesPanel.add(tabComponentsHero.btAdd);
        heroesPanel.add(tabComponentsHero.btReset);
        heroesPanel.setOpaque(false);
    }

    public static Font goodFont(float size) throws IOException, FontFormatException {
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("ringbearer.medium.ttf"));

            return font.deriveFont(size);
    }
}
