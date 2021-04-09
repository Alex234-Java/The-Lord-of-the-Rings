package com.tokioschool.proyecto.component;

import com.tokioschool.proyecto.Exceptions.ArmorTooBigException;
import com.tokioschool.proyecto.domain.*;
import com.tokioschool.proyecto.domain.Character;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.tokioschool.proyecto.component.CharacterCreationPanel.goodFont;

public class TabComponents {
    public JLabel lbName, lbType, lbHealth, lbArmor;
    public JTextField tfName, tfHealth, tfArmor;
    public JComboBox<String> cbType;
    public JButton btAdd, btReset;

    TabComponents() throws IOException, FontFormatException {
        lbName = new JLabel("Name:");
        lbName.setFont(goodFont(16.0f));
        lbType = new JLabel("Type:");
        lbType.setFont(goodFont(16.0f));
        lbHealth = new JLabel("Health:");
        lbHealth.setFont(goodFont(16.0f));
        lbArmor = new JLabel("Armor:");
        lbArmor.setFont(goodFont(16.0f));

        tfName = new JTextField();
        tfName.setFont(goodFont(16.0f));
        tfHealth = new JTextField();
        tfHealth.setFont(goodFont(18.0f));
        tfArmor = new JTextField();
        tfArmor.setFont(goodFont(18.0f));

        cbType = new JComboBox<>();
        cbType.setFont(goodFont(16.0f));

        btAdd = new JButton("Add");
        btAdd.setFont(goodFont(16.0f));
        btReset = new JButton("Reset");
        btReset.setActionCommand("reset");
        btReset.setFont((goodFont(16.0f)));

    }

    public void verifyText() {
        String regex = "^\\d";
        if (tfName.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Name can't be empty", "Name", JOptionPane.INFORMATION_MESSAGE);
        if (tfHealth.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Health can't be empty", "Health", JOptionPane.INFORMATION_MESSAGE);
        if (!tfHealth.getText().matches(regex))
            JOptionPane.showMessageDialog(null, "Health must be a number", "Health", JOptionPane.INFORMATION_MESSAGE);
        if (tfArmor.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Armor can't be empty", "Armor", JOptionPane.INFORMATION_MESSAGE);
        if (!tfArmor.getText().matches(regex))
            JOptionPane.showMessageDialog(null, "Armor must be a number between 0 and 85", "Armor", JOptionPane.INFORMATION_MESSAGE);
    }

    public void reset() {
        tfName.setText("");
        tfHealth.setText("");
        tfArmor.setText("");
        cbType.setSelectedIndex(0);
    }

    public Character getCharacterFromTab() {
        Character character = null;

        try {
            if (Integer.parseInt(tfArmor.getText()) > 85) {
                throw new ArmorTooBigException();
            }

            switch (cbType.getSelectedItem().toString()) {
                case "Human":
                    character = new Human(tfName.getText(), Integer.parseInt(tfHealth.getText()), Integer.parseInt(tfArmor.getText()));
                    break;
                case "Hobbit":
                    character = new Hobbit(tfName.getText(), Integer.parseInt(tfHealth.getText()), Integer.parseInt(tfArmor.getText()));
                    break;
                case "Elf":
                    character = new Elf(tfName.getText(), Integer.parseInt(tfHealth.getText()), Integer.parseInt(tfArmor.getText()));
                    break;
                case "Orc":
                    character = new Orc(tfName.getText(), Integer.parseInt(tfHealth.getText()), Integer.parseInt(tfArmor.getText()));
                    break;
                case "Goblin":
                    character = new Goblin(tfName.getText(), Integer.parseInt(tfHealth.getText()), Integer.parseInt(tfArmor.getText()));
                    break;
            }
        } catch (NumberFormatException e) {
            verifyText();
        }catch(ArmorTooBigException e){
            JOptionPane.showMessageDialog(null, "Armor must be a number between 0 and 85", "Armor", JOptionPane.INFORMATION_MESSAGE);
        }

            return character;
        }

    }

