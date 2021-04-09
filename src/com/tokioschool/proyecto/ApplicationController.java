package com.tokioschool.proyecto;

import com.tokioschool.proyecto.domain.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class ApplicationController implements ActionListener, MouseListener {
    private Army<Hero> heroesArmy;
    private Battle<Hero, Beast> battle;
    private Army<Beast> beastsArmy;
    private ApplicationView view;

    ApplicationController(ApplicationView view) {
        this.view = view;
        heroesArmy=new Army<>();
        beastsArmy=new Army<>();
        addActionListeners(this);
    }

    public void addActionListeners(ActionListener actionListener) {
        view.tabbedPanel.tabComponentsHero.btAdd.addActionListener(actionListener);
        view.tabbedPanel.tabComponentsBeast.btAdd.addActionListener(actionListener);
        view.tabbedPanel.tabComponentsHero.btReset.addActionListener(actionListener);
        view.tabbedPanel.tabComponentsBeast.btReset.addActionListener(actionListener);

        view.listPanel.buttonsPanelHeroes.upButton.addActionListener(actionListener);
        view.listPanel.buttonsPanelBeasts.upButton.addActionListener(actionListener);
        view.listPanel.buttonsPanelHeroes.downButton.addActionListener(actionListener);
        view.listPanel.buttonsPanelBeasts.downButton.addActionListener(actionListener);
        view.listPanel.buttonsPanelHeroes.deleteButton.addActionListener(actionListener);
        view.listPanel.buttonsPanelBeasts.deleteButton.addActionListener(actionListener);
        view.listPanel.buttonsPanelHeroes.fightButton.addActionListener(actionListener);

        view.gameRestart.addActionListener(actionListener);
        view.gameExitFullScreen.addActionListener(actionListener);
        view.gameEnterFullScreen.addActionListener(actionListener);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        Beast valorBeast,beast;
        Hero valorHero,hero;
        switch (command) {
            case "addHero":
                hero = (Hero) view.tabbedPanel.tabComponentsHero.getCharacterFromTab();
                heroesArmy.add(hero);
                view.listPanel.dlmHeroes.addElement(hero);
                view.tabbedPanel.tabComponentsHero.reset();
                break;
            case "addBeast":
                beast = (Beast) view.tabbedPanel.tabComponentsBeast.getCharacterFromTab();
                beastsArmy.add(beast);
                view.listPanel.dlmBeasts.addElement(beast);
                view.tabbedPanel.tabComponentsBeast.reset();
                break;
            case "reset":
                view.tabbedPanel.tabComponentsHero.reset();
                view.tabbedPanel.tabComponentsBeast.reset();
                break;
            case "upHero":
                if (view.listPanel.heroList.getSelectedIndex() > 0) {
                    valorHero = view.listPanel.dlmHeroes.get(view.listPanel.heroList.getSelectedIndex() - 1);

                    heroesArmy.setPosition(valorHero,view.listPanel.heroList.getSelectedIndex());
                    heroesArmy.setPosition(view.listPanel.heroList.getSelectedValue(),view.listPanel.heroList.getSelectedIndex()-1);

                    view.listPanel.dlmHeroes.set(view.listPanel.heroList.getSelectedIndex() - 1, view.listPanel.heroList.getSelectedValue());
                    view.listPanel.dlmHeroes.set(view.listPanel.heroList.getSelectedIndex(), valorHero);
                }
                break;
            case "upBeast":
                if (view.listPanel.beastList.getSelectedIndex() > 0) {
                    valorBeast = view.listPanel.dlmBeasts.get(view.listPanel.beastList.getSelectedIndex() - 1);

                    beastsArmy.setPosition(valorBeast,view.listPanel.beastList.getSelectedIndex());
                    beastsArmy.setPosition(view.listPanel.beastList.getSelectedValue(),view.listPanel.beastList.getSelectedIndex()-1);

                    view.listPanel.dlmBeasts.set(view.listPanel.beastList.getSelectedIndex() - 1, view.listPanel.beastList.getSelectedValue());
                    view.listPanel.dlmBeasts.set(view.listPanel.beastList.getSelectedIndex(), valorBeast);
                }
                break;
            case "downHero":
                if (view.listPanel.heroList.getSelectedIndex() < view.listPanel.heroList.getLastVisibleIndex()) {
                    valorHero = view.listPanel.dlmHeroes.get(view.listPanel.heroList.getSelectedIndex() + 1);

                    heroesArmy.setPosition(valorHero,view.listPanel.heroList.getSelectedIndex());
                    heroesArmy.setPosition(view.listPanel.heroList.getSelectedValue(),view.listPanel.heroList.getSelectedIndex()+1);

                    view.listPanel.dlmHeroes.set(view.listPanel.heroList.getSelectedIndex() + 1, view.listPanel.heroList.getSelectedValue());
                    view.listPanel.dlmHeroes.set(view.listPanel.heroList.getSelectedIndex(), valorHero);
                }
                break;
            case "downBeast":
                if (view.listPanel.beastList.getSelectedIndex() < view.listPanel.beastList.getLastVisibleIndex()) {
                    valorBeast = view.listPanel.dlmBeasts.get(view.listPanel.beastList.getSelectedIndex() + 1);

                    beastsArmy.setPosition(valorBeast,view.listPanel.beastList.getSelectedIndex());
                    beastsArmy.setPosition(view.listPanel.beastList.getSelectedValue(),view.listPanel.beastList.getSelectedIndex()+1);

                    view.listPanel.dlmBeasts.set(view.listPanel.beastList.getSelectedIndex() + 1, view.listPanel.beastList.getSelectedValue());
                    view.listPanel.dlmBeasts.set(view.listPanel.beastList.getSelectedIndex(), valorBeast);
                }
                break;

            case "deleteHero":
                try {
                    heroesArmy.remove(view.listPanel.heroList.getSelectedValue());
                    view.listPanel.dlmHeroes.remove(view.listPanel.heroList.getSelectedIndex());
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "The list is empty", "", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "deleteBeast":
                try {
                    beastsArmy.remove(view.listPanel.beastList.getSelectedValue());
                    view.listPanel.dlmBeasts.remove(view.listPanel.beastList.getSelectedIndex());
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "The list is empty", "", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "fight":
                if (heroesArmy.getSize() == 0 || beastsArmy.getSize() == 0) {
                    JOptionPane.showMessageDialog(null, "There are no armies", "You can't have a war without armies", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                battle = new Battle<>(heroesArmy, beastsArmy);
                view.listPanel.text.setText(battle.printFight());
                view.listPanel.dlmHeroes.clear();
                view.listPanel.dlmBeasts.clear();
                break;
            case "restart":
                view.tabbedPanel.tabComponentsHero.reset();
                view.tabbedPanel.tabComponentsBeast.reset();
                view.listPanel.reset();
                heroesArmy.reset();
                beastsArmy.reset();
                break;
            case "exit":
                view.dispose();
                view.setUndecorated(false);
                view.setVisible(true);
                break;
            case "enter":
                view.dispose();
                view.setUndecorated(true);
                view.setExtendedState(MAXIMIZED_BOTH);
                view.setVisible(true);
                break;
        }




        }


    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}


