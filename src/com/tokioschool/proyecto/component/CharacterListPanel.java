package com.tokioschool.proyecto.component;

import com.tokioschool.proyecto.domain.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;


public class CharacterListPanel extends JPanel {

    private JScrollPane areaTextScrollPane;
    private JPanel beastsPanel,heroesPanel;
    public JList<Hero> heroList;
    public JList<Beast>beastList;
    public DefaultListModel<Hero> dlmHeroes;
    public DefaultListModel<Beast> dlmBeasts;
    public ButtonsPanel buttonsPanelHeroes,buttonsPanelBeasts;
    public JTextArea text;

    public CharacterListPanel() throws IOException, FontFormatException {

        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setOpaque(false);
        setMaximumSize(new Dimension(1080,500));

        initComponents();
    }

    private void initComponents() throws IOException, FontFormatException {
        heroesListInit();
        beastListInit();
        textAreaInit();

        add(heroesPanel,BorderLayout.WEST);
        add(beastsPanel,BorderLayout.EAST);
        add(buttonsPanelHeroes.fightButton,BorderLayout.SOUTH);
        add(areaTextScrollPane,BorderLayout.CENTER);




    }

    private void heroesListInit() throws IOException, FontFormatException {
        buttonsPanelHeroes=new ButtonsPanel();
        heroesPanel=new JPanel();
        JScrollPane heroesScrollPane;
        heroList=new JList<>();
        dlmHeroes=new DefaultListModel<>();

        buttonsPanelHeroes.upButton.setActionCommand("upHero");
        buttonsPanelHeroes.downButton.setActionCommand("downHero");
        buttonsPanelHeroes.deleteButton.setActionCommand("deleteHero");

        heroList.setModel(dlmHeroes);
        heroList.setFont(CharacterCreationPanel.goodFont(16.0f));
        heroList.setBackground(Color.LIGHT_GRAY);

        heroesScrollPane =new JScrollPane(heroList);
        heroesScrollPane.setPreferredSize(new Dimension(300,200));
        heroesScrollPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        heroesScrollPane.setOpaque(false);

        heroesPanel.setLayout(new BoxLayout(heroesPanel,BoxLayout.Y_AXIS));
        heroesPanel.add(heroesScrollPane);
        heroesPanel.add(buttonsPanelHeroes);
        heroesPanel.setOpaque(false);
        heroesPanel.setBackground(Color.lightGray);
        heroesPanel.setBorder(new TitledBorder(new EmptyBorder(1,1,1,1),"Heroes Army",
                TitledBorder.LEFT, TitledBorder.TOP,CharacterCreationPanel.goodFont(24.0f),Color.WHITE));


    }

    private void beastListInit() throws IOException, FontFormatException {
        buttonsPanelBeasts=new ButtonsPanel();
        beastsPanel=new JPanel();
        JScrollPane beastsScrollPane;
        beastList=new JList<>();
        dlmBeasts=new DefaultListModel<>();

        buttonsPanelBeasts.upButton.setActionCommand("upBeast");
        buttonsPanelBeasts.downButton.setActionCommand("downBeast");
        buttonsPanelBeasts.deleteButton.setActionCommand("deleteBeast");

        beastList.setModel(dlmBeasts);
        beastList.setFont(CharacterCreationPanel.goodFont(16.0f));
        beastList.setBackground(Color.LIGHT_GRAY);

        beastsScrollPane =new JScrollPane(beastList);
        beastsScrollPane.setPreferredSize(new Dimension(300,200));
        beastsScrollPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        beastsScrollPane.setOpaque(false);


        beastsPanel.setLayout(new BoxLayout(beastsPanel,BoxLayout.Y_AXIS));
        beastsPanel.add(beastsScrollPane);
        beastsPanel.add(buttonsPanelBeasts);
        beastsPanel.setOpaque(false);
        beastsPanel.setBorder(new TitledBorder(new EmptyBorder(1,1,1,1),"Beasts Army",
                TitledBorder.RIGHT,TitledBorder.TOP,CharacterCreationPanel.goodFont(24.0f),Color.WHITE));



    }

    private void textAreaInit() throws IOException, FontFormatException {
        text=new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(CharacterCreationPanel.goodFont(20.0f));
        text.setEditable(false);
        text.setBackground(Color.LIGHT_GRAY);

        areaTextScrollPane=new JScrollPane(text);
        areaTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        areaTextScrollPane.setMaximumSize(new Dimension(1000,200));
        areaTextScrollPane.setOpaque(false);
        areaTextScrollPane.setBorder(new TitledBorder(new EmptyBorder(1,1,1,1),"The Battle",
                TitledBorder.CENTER,TitledBorder.TOP,CharacterCreationPanel.goodFont(28.0f),Color.RED));


    }

    public void reset(){
        dlmHeroes.clear();
        dlmBeasts.clear();
        text.setText("");
    }



}
