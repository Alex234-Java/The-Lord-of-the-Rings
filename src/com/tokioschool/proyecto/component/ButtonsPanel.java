package com.tokioschool.proyecto.component;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ButtonsPanel extends JPanel{
    public JButton upButton, downButton, deleteButton,fightButton;

    public ButtonsPanel() throws IOException, FontFormatException {
        super();

        initComponents();

        setLayout(new FlowLayout());
        setOpaque(false);

    }

    private void initComponents() throws IOException, FontFormatException {
        upButton =new JButton("Up");
        downButton =new JButton("Down");
        deleteButton =new JButton("Delete");
        fightButton=new JButton("!Fight!");

        upButton.setFont(CharacterCreationPanel.goodFont(14.0f));
        upButton.setActionCommand("up");

        downButton.setFont(CharacterCreationPanel.goodFont(14.0f));
        downButton.setActionCommand("down");

        deleteButton.setFont(CharacterCreationPanel.goodFont(14.0f));
        deleteButton.setActionCommand("delete");


        fightButton.setFont(CharacterCreationPanel.goodFont(20.0f));
        fightButton.setActionCommand("fight");

        add(upButton);
        add(downButton);
        add(deleteButton);
    }

}
