package com.tokioschool.proyecto;

import com.tokioschool.proyecto.component.CharacterCreationPanel;
import com.tokioschool.proyecto.component.CharacterListPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ApplicationView extends JFrame {

    CharacterCreationPanel tabbedPanel;
    CharacterListPanel listPanel;
    JLabel background;
    JMenuBar menu;
    JMenuItem gameRestart, gameExitFullScreen,gameEnterFullScreen;

    public ApplicationView() {
        setTitle("Batalla por la Tierra Media");
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);

        initComponents();

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        }

        public void initComponents () {
            initMenuBar();

            try {
                tabbedPanel = new CharacterCreationPanel();
                listPanel=new CharacterListPanel();

            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }

            setBackgroundImage();


            getContentPane().add(background);
            background.add(tabbedPanel);
            background.add(listPanel);

        }

        private void initMenuBar(){
            menu=new JMenuBar();
            JMenu menuGame =new JMenu("Game");
            gameRestart=new JMenuItem("Restart");
            gameExitFullScreen =new JMenuItem("Exit fullscreen");
            gameEnterFullScreen=new JMenuItem("Enter fullscreen");

            gameRestart.setActionCommand("restart");
            gameEnterFullScreen.setActionCommand("enter");
            gameExitFullScreen.setActionCommand("exit");

            menuGame.add(gameRestart);
            menuGame.add(gameEnterFullScreen);
            menuGame.add(gameExitFullScreen);

            menu.add(menuGame);
            setJMenuBar(menu);
        }

        private void setBackgroundImage(){
        ImageIcon img=new ImageIcon("Background.jpg");
        background=new JLabel("good",img,SwingConstants.CENTER);
        background.setBounds(0,0,1080,720);
        background.setLayout(new BoxLayout(background,BoxLayout.Y_AXIS));
        }


    }
