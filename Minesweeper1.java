package minesweeper1;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;
import java.util.HashMap;


public class Minesweeper1 implements ActionListener{
    
    // GRAMMES, STILES, ZWES, DEFTEROLEPTA, BOMBES, DISKOLIA, ARXIKES DIASTASEIS
    public static int x = 9;
    public static int y = 9;
    public static int lives = 2;
    public static int mines = 10;
    public static int secondsPassed = 0;
    public static int heigth = 400;
    public static int width = 400;
    public static String difficultyLevel = "Beginner";
    
    // eikonidia SOS na ftiaxtei to path tous
    ImageIcon icon0 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\blank1.jpg.gif");
    Image image0 = icon0.getImage();
    Image newImage0 = image0.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon blanketIcon = new ImageIcon(newImage0);
    
    ImageIcon icon01 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number1.jpg.gif");
    Image image01 = icon01.getImage();
    Image newImage01 = image01.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n1Icon = new ImageIcon(newImage01);
    
    ImageIcon icon02 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number2.jpg.gif");
    Image image02 = icon02.getImage();
    Image newImage02 = image02.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n2Icon = new ImageIcon(newImage02);
    
    ImageIcon icon03 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number3.jpg.gif");
    Image image03 = icon03.getImage();
    Image newImage03 = image03.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n3Icon = new ImageIcon(newImage03);
    
    ImageIcon icon04 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number4.jpg.gif");
    Image image04 = icon04.getImage();
    Image newImage04 = image04.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n4Icon = new ImageIcon(newImage04);
    
    ImageIcon icon05 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number5.jpg.gif");
    Image image05 = icon05.getImage();
    Image newImage05 = image05.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n5Icon = new ImageIcon(newImage05);
    
    ImageIcon icon06 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number6.jpg.gif");
    Image image06 = icon06.getImage();
    Image newImage06 = image06.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n6Icon = new ImageIcon(newImage06);
    
    ImageIcon icon07 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number7.jpg.gif");
    Image image07 = icon07.getImage();
    Image newImage07 = image07.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n7Icon = new ImageIcon(newImage07);
    
    ImageIcon icon08 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number8.jpg.gif");
    Image image08 = icon08.getImage();
    Image newImage08 = image08.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n8Icon = new ImageIcon(newImage08);
    
    ImageIcon icon09 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\flag.jpg.gif");
    Image image09 = icon09.getImage();
    Image newImage09 = image09.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n9Icon = new ImageIcon(newImage09);
    
    ImageIcon icon10 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\number0.jpg.gif");
    Image image10 = icon10.getImage();
    Image newImage10 = image10.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n10Icon = new ImageIcon(newImage10);
    
    ImageIcon icon11 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\opened_mine.jpg.gif");
    Image image11 = icon11.getImage();
    Image newImage11 = image11.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n11Icon = new ImageIcon(newImage11);
    
    ImageIcon icon12 = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\closed_mine.jpg.gif");
    Image image12 = icon12.getImage();
    Image newImage12 = image12.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon n12Icon = new ImageIcon(newImage12);
    
    // XRONOS
    Timer timer;
    TimerTask task;    
    
    final int MINE = 10;
    
    JFrame window;
    
    JPanel panel, panel2;
    
    JButton reset;
    Icon smile;
    
    String epipedoDiskolias, xronos;
    static HashMap<String, String> bathmologia = new HashMap<String, String>();
    
    JLabel seconds, seconds1, minesLeft, minesLeft1, livesLeft, livesLeft1;

    // ARRAYLIST APO KOUMPIA
    JButton[][] buttons;
    
    int counts[][] = new int[x][y];
    
    // TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuGame, menuNewGame, menuScores, menuHelp;
    
    // NEW GAME MENU-ITEMS
    JMenuItem Beginner, Intermediate, Expert, Exit, Infos, LeaderBoard;
    
    // DIMIOURGIA EFARMOGIS
    public Minesweeper1() {
        createWindow();
        createMenuBar();
        createMenuItems();
        createMines();
        
    }
    
    // SYNARTISI BATHMOLOGIAS
    public void Scores() {
        epipedoDiskolias = difficultyLevel;
        xronos = seconds.getText();
        bathmologia.put(epipedoDiskolias, xronos);
    }
    
    // SYNARTISI DIMIOURGIAS PARATHIROU
    public void createWindow() {
        // SMILY-FACE GIA EPANEKKINISI PAIXNIDIOU
        ImageIcon icon = new ImageIcon("C:\\Users\\amend\\Desktop\\minesweeper_button_icons\\smily_face.jpg.gif");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_AREA_AVERAGING);
        smile = new ImageIcon(newImage);
        reset = new JButton(smile);
        reset.setBorderPainted(false);
        reset.setFocusPainted(false);
        reset.setBorder(new EmptyBorder(0,0,0,0));
        reset.addActionListener(this);
        
        // DEFTEROLEPTA
        seconds1 = new JLabel("Seconds:");
        seconds1.setBorder(new EmptyBorder(0,0,0,5));
        seconds = new JLabel("0");
        seconds.setBorder(new EmptyBorder(0,0,0,20));
        
        // ZWES
        livesLeft1 = new JLabel("Lives:");
        livesLeft1.setBorder(new EmptyBorder(0,0,0,5));
        livesLeft = new JLabel("2");
        livesLeft.setBorder(new EmptyBorder(0,0,0,20));

        // NARKES
        minesLeft1 = new JLabel("Mines:");
        minesLeft1.setBorder(new EmptyBorder(0,20,0,0));
        minesLeft = new JLabel(mines + "");
        minesLeft.setBorder(new EmptyBorder(0,5,0,0));
        
        panel2 = new JPanel();
        panel2.add(seconds1);
        panel2.add(seconds);
        panel2.add(livesLeft1);
        panel2.add(livesLeft);
        panel2.add(reset);
        panel2.add(minesLeft1);
        panel2.add(minesLeft);
        
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                secondsPassed++;
                seconds.setText(secondsPassed + "");
            }
        };

        startClock();
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(x,y));
        buttons = new JButton[x][y];
        
        for (int a=0; a<buttons.length; a++) {
            for (int b=0; b<buttons[0].length; b++) {
                buttons[a][b] = new JButton();
                buttons[a][b].addActionListener(this);
                buttons[a][b].setIcon(blanketIcon);
                buttons[a][b].setBorderPainted(false);
                buttons[a][b].setFocusPainted(false);
                buttons[a][b].setBorder(new EmptyBorder(0,0,0,0));
                final int finalB = b;
                final int finalA = a;
                buttons[a][b].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            mineFlagger(finalA, finalB);
                        }
                    }
                });
                panel.add(buttons[a][b]);                
            }
        }
        
        // DIMIOURGIA PARATHIROU
        window = new JFrame("Minesweeper");       
        window.setSize(width, heigth);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        
        window.add(panel2, BorderLayout.NORTH);
        window.add(panel, BorderLayout.CENTER);
    }
    
    // PROSTHIKI ENDEIKSIS GIA PITHANES NARKES
    public void mineFlagger(int x, int y) {
        if(buttons[x][y].getIcon() == n9Icon) {
            buttons[x][y].setIcon(blanketIcon);
            mines++;
            minesLeft.setText(mines + "");
        } else if (buttons[x][y].getIcon() == blanketIcon){
            buttons[x][y].setIcon(n9Icon);
            mines--;
            minesLeft.setText(mines + "");
        }
    }
    
    // ROLOI
    public void startClock() {
        timer.scheduleAtFixedRate(task,1000,1000);
    }
    
    // DIMIOURGIA MENU
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        
        menuGame = new JMenu("Game");
        menuBar.add(menuGame);
        
        menuNewGame = new JMenu("New Game");
        menuGame.add(menuNewGame);
        
        menuScores = new JMenu("Scores");
        menuBar.add(menuScores);
        
        menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);
    }
    
    // DIMIOURGIA MENU-ITEMS
    public void createMenuItems() {
        Beginner = new JMenuItem("Beginner");
        Beginner.addActionListener(this);
        Beginner.setActionCommand("Beginner");
        menuNewGame.add(Beginner);
        
        Intermediate = new JMenuItem("Intermediate");
        Intermediate.addActionListener(this);
        Intermediate.setActionCommand("Intermediate");
        menuNewGame.add(Intermediate);
        
        Expert = new JMenuItem("Expert");
        Expert.addActionListener(this);
        Expert.setActionCommand("Expert");
        menuNewGame.add(Expert);
        
        Exit = new JMenuItem("Exit");
        Exit.addActionListener(this);
        Exit.setActionCommand("Exit");
        menuGame.add(Exit);
        
        Infos = new JMenuItem("Infos");
        Infos.addActionListener(this);
        Infos.setActionCommand("Infos");
        menuHelp.add(Infos);
        
        LeaderBoard = new JMenuItem("LeaderBoard");
        LeaderBoard.addActionListener(this);
        LeaderBoard.setActionCommand("LeaderBoard");
        menuScores.add(LeaderBoard);
        
    }
    
    // DIMIOURGIA BOMBWN
    public void createMines() {
        counts = new int [x][y];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x=0; x<counts.length; x++) {
            for (int y=0; y<counts[0].length; y++) {
                list.add(x*100+y);
            }         
        }
        counts = new int[x][y];
        
        for (int a = 0; a<mines; a++) {
            int choice = (int)(Math.random() * list.size());
            counts[list.get(choice) / 100][list.get(choice) % 100] = MINE;
            list.remove(choice);
        }
        
        // ANATHESI ARITHMWN STA KOUTIA DIPLA APO BOMBES
        for (int x = 0; x<counts.length; x++) {
            for (int y = 0; y<counts[0].length; y++) {
                if (counts[x][y] != MINE) {
                    int neighborcount = 0;
                    if (x > 0 && y > 0 && counts[x-1][y-1] == MINE) { // koutaki panw aristera
                        neighborcount++;
                    }
                    if (y > 0 && counts[x][y-1] == MINE) { // koutaki aristera
                        neighborcount++;
                    }
                    if (x < (counts.length - 1) && y > 0 && counts[x+1][y-1] == MINE) { 
                        neighborcount++;
                    }
                    if (x > 0 && counts[x-1][y] == MINE) {
                        neighborcount++;
                    }
                    if (x <(counts.length - 1) && counts[x+1][y] == MINE) {
                        neighborcount++;
                    }
                    if (x > 0 && y < (counts[0].length - 1) && counts[x-1][y+1] == MINE) {
                        neighborcount++;
                    }
                    if ( y < (counts[0].length - 1) && counts[x][y+1] == MINE) {
                        neighborcount++;
                    }
                    if (x <(counts.length - 1) && y <(counts[0].length - 1) && counts[x+1][y+1] == MINE) { 
                        neighborcount++;
                    }                   
                    
                    counts[x][y] = neighborcount;
                }
            }
        }
        
    }
    
    // EKKATHARISI MIDENIKWN
    public void clearZeros(ArrayList<Integer> toClear) {
        if (toClear.size() == 0) {
            return;
        } else {
            int x = toClear.get(0) /100;
            int y = toClear.get(0) % 100;
            toClear.remove(0);
                if (x > 0 && y > 0 && buttons[x-1][y-1].getIcon() == blanketIcon) {
                    switch(counts[x-1][y-1]) {
                        case 1 : buttons[x-1][y-1].setIcon(n1Icon); break;
                        case 2 : buttons[x-1][y-1].setIcon(n2Icon); break;
                        case 3 : buttons[x-1][y-1].setIcon(n3Icon); break;
                        case 4 : buttons[x-1][y-1].setIcon(n4Icon); break;
                        case 5 : buttons[x-1][y-1].setIcon(n5Icon); break;
                        case 6 : buttons[x-1][y-1].setIcon(n6Icon); break;
                        case 7 : buttons[x-1][y-1].setIcon(n7Icon); break;
                        case 8 : buttons[x-1][y-1].setIcon(n8Icon); break;
                    }
                    if (counts[x-1][y-1] == 0) {
                        buttons[x-1][y-1].setIcon(n10Icon);
                        toClear.add((x-1) * 100 + (y-1));
                    }
                }
                if (y > 0 && buttons[x][y-1].getIcon() == blanketIcon) {
                    switch(counts[x][y-1]) {
                        case 1 : buttons[x][y-1].setIcon(n1Icon); break;
                        case 2 : buttons[x][y-1].setIcon(n2Icon); break;
                        case 3 : buttons[x][y-1].setIcon(n3Icon); break;
                        case 4 : buttons[x][y-1].setIcon(n4Icon); break;
                        case 5 : buttons[x][y-1].setIcon(n5Icon); break;
                        case 6 : buttons[x][y-1].setIcon(n6Icon); break;
                        case 7 : buttons[x][y-1].setIcon(n7Icon); break;
                        case 8 : buttons[x][y-1].setIcon(n8Icon); break;
                    }
                    if (counts[x][y-1] == 0) {
                        buttons[x][y-1].setIcon(n10Icon);
                        toClear.add(x * 100 + (y-1));
                    }
                }
                if (x < (counts.length -1) && y > 0 && buttons[x+1][y-1].getIcon() == blanketIcon) {
                    switch(counts[x+1][y-1]) {
                        case 1 : buttons[x+1][y-1].setIcon(n1Icon); break;
                        case 2 : buttons[x+1][y-1].setIcon(n2Icon); break;
                        case 3 : buttons[x+1][y-1].setIcon(n3Icon); break;
                        case 4 : buttons[x+1][y-1].setIcon(n4Icon); break;
                        case 5 : buttons[x+1][y-1].setIcon(n5Icon); break;
                        case 6 : buttons[x+1][y-1].setIcon(n6Icon); break;
                        case 7 : buttons[x+1][y-1].setIcon(n7Icon); break;
                        case 8 : buttons[x+1][y-1].setIcon(n8Icon); break;
                    }
                    if (counts[x+1][y-1] == 0) {
                        buttons[x+1][y-1].setIcon(n10Icon);
                        toClear.add((x+1) * 100 + (y-1));
                    }
                }
                if (x > 0 && buttons[x-1][y].getIcon() == blanketIcon) {
                    switch(counts[x-1][y]) {
                        case 1 : buttons[x-1][y].setIcon(n1Icon); break;
                        case 2 : buttons[x-1][y].setIcon(n2Icon); break;
                        case 3 : buttons[x-1][y].setIcon(n3Icon); break;
                        case 4 : buttons[x-1][y].setIcon(n4Icon); break;
                        case 5 : buttons[x-1][y].setIcon(n5Icon); break;
                        case 6 : buttons[x-1][y].setIcon(n6Icon); break;
                        case 7 : buttons[x-1][y].setIcon(n7Icon); break;
                        case 8 : buttons[x-1][y].setIcon(n8Icon); break;
                    }
                    if (counts[x-1][y] == 0) {
                        buttons[x-1][y].setIcon(n10Icon);
                        toClear.add((x-1) * 100 + y);
                    }
                }
                if (x < (counts.length -1) && buttons[x+1][y].getIcon() == blanketIcon) {
                    switch(counts[x+1][y]) {
                        case 1 : buttons[x+1][y].setIcon(n1Icon); break;
                        case 2 : buttons[x+1][y].setIcon(n2Icon); break;
                        case 3 : buttons[x+1][y].setIcon(n3Icon); break;
                        case 4 : buttons[x+1][y].setIcon(n4Icon); break;
                        case 5 : buttons[x+1][y].setIcon(n5Icon); break;
                        case 6 : buttons[x+1][y].setIcon(n6Icon); break;
                        case 7 : buttons[x+1][y].setIcon(n7Icon); break;
                        case 8 : buttons[x+1][y].setIcon(n8Icon); break;
                    }
                    if (counts[x+1][y] == 0) {
                        buttons[x+1][y].setIcon(n10Icon);
                        toClear.add((x+1) * 100 + y);
                    }
                }
                if (x > 0 && y < (counts[0].length -1) && buttons[x-1][y+1].getIcon() == blanketIcon) {
                    switch(counts[x-1][y+1]) {
                        case 1 : buttons[x-1][y+1].setIcon(n1Icon); break;
                        case 2 : buttons[x-1][y+1].setIcon(n2Icon); break;
                        case 3 : buttons[x-1][y+1].setIcon(n3Icon); break;
                        case 4 : buttons[x-1][y+1].setIcon(n4Icon); break;
                        case 5 : buttons[x-1][y+1].setIcon(n5Icon); break;
                        case 6 : buttons[x-1][y+1].setIcon(n6Icon); break;
                        case 7 : buttons[x-1][y+1].setIcon(n7Icon); break;
                        case 8 : buttons[x-1][y+1].setIcon(n8Icon); break;
                    }
                    if (counts[x-1][y+1] == 0) {
                        buttons[x-1][y+1].setIcon(n10Icon);
                        toClear.add((x-1) * 100 + (y+1));
                    }
                }
                if (y < (counts[0].length -1) && buttons[x][y+1].getIcon() == blanketIcon) {
                    switch(counts[x][y+1]) {
                        case 1 : buttons[x][y+1].setIcon(n1Icon); break;
                        case 2 : buttons[x][y+1].setIcon(n2Icon); break;
                        case 3 : buttons[x][y+1].setIcon(n3Icon); break;
                        case 4 : buttons[x][y+1].setIcon(n4Icon); break;
                        case 5 : buttons[x][y+1].setIcon(n5Icon); break;
                        case 6 : buttons[x][y+1].setIcon(n6Icon); break;
                        case 7 : buttons[x][y+1].setIcon(n7Icon); break;
                        case 8 : buttons[x][y+1].setIcon(n8Icon); break;
                    }
                    if (counts[x][y+1] == 0) {
                        buttons[x][y+1].setIcon(n10Icon);
                        toClear.add(x * 100 + (y+1));
                    }
                }
                if (x < (counts.length -1) && y < (counts[0].length -1) && buttons[x+1][y+1].getIcon() == blanketIcon) {
                    switch(counts[x+1][y+1]) {
                        case 1 : buttons[x+1][y+1].setIcon(n1Icon); break;
                        case 2 : buttons[x+1][y+1].setIcon(n2Icon); break;
                        case 3 : buttons[x+1][y+1].setIcon(n3Icon); break;
                        case 4 : buttons[x+1][y+1].setIcon(n4Icon); break;
                        case 5 : buttons[x+1][y+1].setIcon(n5Icon); break;
                        case 6 : buttons[x+1][y+1].setIcon(n6Icon); break;
                        case 7 : buttons[x+1][y+1].setIcon(n7Icon); break;
                        case 8 : buttons[x+1][y+1].setIcon(n8Icon); break;
                    }
                    if (counts[x+1][y+1] == 0) {
                        buttons[x+1][y+1].setIcon(n10Icon);
                        toClear.add((x+1) * 100 + (y+1));
                    }
                }
            }
            clearZeros(toClear);
    }
    
    // XASIMO ZWIS
    public void loseALife() {
        lives--;
        livesLeft.setText(lives + "");
        if (lives <= 0) {
            task.cancel();
            lostGame();            
        }
    }
    
    // TERMATISMOS PAIXNIDIOU ME ITTA
    public void lostGame() {
        for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    if (buttons[x][y].getIcon() == blanketIcon) {
                        if (counts[x][y] != MINE) {
                            switch(counts[x][y]) {
                                case 0 : buttons[x][y].setIcon(n10Icon); break;
                                case 1 : buttons[x][y].setIcon(n1Icon); break;
                                case 2 : buttons[x][y].setIcon(n2Icon); break;
                                case 3 : buttons[x][y].setIcon(n3Icon); break;
                                case 4 : buttons[x][y].setIcon(n4Icon); break;
                                case 5 : buttons[x][y].setIcon(n5Icon); break;
                                case 6 : buttons[x][y].setIcon(n6Icon); break;
                                case 7 : buttons[x][y].setIcon(n7Icon); break;
                                case 8 : buttons[x][y].setIcon(n8Icon); break;
                            }
                        } else {
                            buttons[x][y].setIcon(n12Icon);
                        }
                    }
                }
        }
        JOptionPane.showMessageDialog(null, "IT LOOKS LIKE YOU LOST!"
                + "\nBETTER LUCK NEXT TIME!", "LOSS", 1);
    }
    
    //TERMATISMOS PAIXNIDIOU ME NIKI
    public void winGame() {
        boolean win = true;
        for (int x = 0; x<counts.length; x++) {
            for (int y = 0; y<counts[0].length; y++) {
                if (counts[x][y] != MINE && buttons[x][y].getIcon() == blanketIcon) {
                    win = false;
                }
            }
        }
        if (win == true) {
            task.cancel();
            JOptionPane.showMessageDialog(null, "YOU WON THE GAME!"
                + "\nCONGRATULATIONS!", "WIN", 1);
            
            Scores();
        }
    }
    
    // ANATHESI ENTOLWN STA KOUMPIA KAI TA MENU-ITEMS
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(Infos)) {
            JOptionPane.showMessageDialog(null, "CREATOR: ALEXANDROS MENTOUDAKIS"
                + "\nAM: TP5066"
                + "\nDATE: WEDNESDAY 29/12/2021"
                + "\nAPPNAME: MINESWEEPER"
                + "\nTYPE OF APP: PC GAME"
                + "\nCURRENT-VERSION: 1.0", "INFORMATIONS", 1);
        }
        
        if (e.getSource().equals(Exit)) {
            System.exit(0);
        }
        
        // PINAKAS BATHMOLOGIAS
        if (e.getSource().equals(LeaderBoard)) {
            if (bathmologia.size() <= 0) {
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: - "
                        + "\nDifficulty: Intermediate     Time: - "
                        + "\nDifficulty: Expert     Time: - "
                    , "Best Scores", 1);
            } else if (bathmologia.get("Beginner") != null && bathmologia.get("Intermediate") != null && bathmologia.get("Expert") != null){
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: "+ bathmologia.get("Beginner") + " seconds"
                        + "\nDifficulty: Intermediate     Time: "+ bathmologia.get("Intermediate") + " seconds"
                        + "\nDifficulty: Expert     Time: "+ bathmologia.get("Expert") + " seconds"
                    , "Best Scores", 1);     
            } else if (bathmologia.get("Beginner") != null && bathmologia.get("Intermediate") == null && bathmologia.get("Expert") == null){
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: "+ bathmologia.get("Beginner") + " seconds"
                        + "\nDifficulty: Intermediate     Time: -"
                        + "\nDifficulty: Expert     Time: -"
                    , "Best Scores", 1);
            } else if (bathmologia.get("Beginner") != null && bathmologia.get("Intermediate") != null && bathmologia.get("Expert") == null){
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: "+ bathmologia.get("Beginner") + " seconds"
                        + "\nDifficulty: Intermediate     Time: "+ bathmologia.get("Intermediate") + " seconds"
                        + "\nDifficulty: Expert     Time: -"
                    , "Best Scores", 1);
            } else if (bathmologia.get("Beginner") != null && bathmologia.get("Intermediate") == null && bathmologia.get("Expert") != null){
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: "+ bathmologia.get("Beginner") + " seconds"
                        + "\nDifficulty: Intermediate     Time: -"
                        + "\nDifficulty: Expert     Time: "+ bathmologia.get("Expert") + " seconds"
                    , "Best Scores", 1);
            } else if (bathmologia.get("Beginner") == null && bathmologia.get("Intermediate") != null && bathmologia.get("Expert") == null){
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: -"
                        + "\nDifficulty: Intermediate     Time: "+ bathmologia.get("Intermediate") + " seconds"
                        + "\nDifficulty: Expert     Time: -"
                    , "Best Scores", 1);
            } else if (bathmologia.get("Beginner") == null && bathmologia.get("Intermediate") == null && bathmologia.get("Expert") != null){
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: -"
                        + "\nDifficulty: Intermediate     Time: -"
                        + "\nDifficulty: Expert     Time: "+ bathmologia.get("Expert") + " seconds"
                    , "Best Scores", 1);
            } else if (bathmologia.get("Beginner") == null && bathmologia.get("Intermediate") == null && bathmologia.get("Expert") != null){
                JOptionPane.showMessageDialog(null, "Difficulty: Beginner     Time: "+ bathmologia.get("Beginner") + " seconds"
                        + "\nDifficulty: Intermediate     Time: -"
                        + "\nDifficulty: Expert     Time: "+ bathmologia.get("Expert") + " seconds"
                    , "Best Scores", 1);
            }   
        }
        
        // ARXARIOS
        if (e.getSource().equals(Beginner)) {
            difficultyLevel = "Beginner";
            x = 9;
            y = 9;
            width = 400;
            heigth = 400;
            secondsPassed = 0;
            mines = 10;
            lives = 2;
            
            window.setVisible(false);
            task.cancel();
            Minesweeper1 minesweeper1 = new Minesweeper1();
            
            
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setIcon(blanketIcon);
                    minesLeft.setText(mines + "");
                    livesLeft.setText(lives + "");
                    seconds.setText(secondsPassed + "");
                }
            }
            createMines();
            lives = 2;
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setText("");
                }
            }          
        }
        
        // METRIOS
        if (e.getSource().equals(Intermediate)) {
            difficultyLevel = "Intermediate";
            x = 16;
            y = 16;
            heigth = 650;
            width = 700;
            secondsPassed = 0;
            lives = 2;
            mines = 30;
            
            window.setVisible(false);
            task.cancel();
            Minesweeper1 minesweeper1 = new Minesweeper1();
            
            
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setIcon(blanketIcon);
                    secondsPassed = 0;
                    livesLeft.setText(lives + "");
                    minesLeft.setText(mines + "");
                    seconds.setText(secondsPassed + "");
                }
            }
            createMines();
            lives = 2;
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setText("");
                }
            }
        }
        
        // DISKOLOS
        if (e.getSource().equals(Expert)) {
            difficultyLevel = "Expert";
            x = 30;
            y = 16;
            heigth = 650;
            width = 750;
            secondsPassed = 0;
            lives = 2;
            mines = 50;
            
            window.setVisible(false);
            task.cancel();
            Minesweeper1 minesweeper1 = new Minesweeper1();
            
            
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setIcon(blanketIcon);
                    secondsPassed = 0;
                    livesLeft.setText(lives + "");
                    minesLeft.setText(mines + "");
                    seconds.setText(secondsPassed + "");
                }
            }
            createMines();
            lives = 2;
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setText("");
                }
            }
        }
        
        // EPANEKINISI ARXARIOS
        if (e.getSource().equals(reset)) {
            if (difficultyLevel == "Beginner") {
                timer.cancel();
                secondsPassed = 0;
                timer = new Timer();
                task = new TimerTask() {
                    public void run() {
                        secondsPassed++;
                        seconds.setText(secondsPassed + "");
                    }
                };

                startClock();
                
                heigth = 400;
                width = 400;
                mines = 10;
                lives = 2;
                livesLeft.setText(lives + "");
                minesLeft.setText(mines + "");
                seconds.setText(secondsPassed + "");
                
            // EPANEKINISI METRIOS
            } else if (difficultyLevel == "Intermediate") {
                timer.cancel();
                secondsPassed = 0;
                timer = new Timer();
                task = new TimerTask() {
                    public void run() {
                        secondsPassed++;
                        seconds.setText(secondsPassed + "");
                    }
                };

                startClock();
                
                heigth = 450;
                width = 450;
                mines = 30;
                lives = 2;
                livesLeft.setText(lives + "");
                minesLeft.setText(mines + "");
                seconds.setText(secondsPassed + "");
                
            // EPANEKINISI DISKOLOS
            } else if (difficultyLevel == "Expert") {
                timer.cancel();
                secondsPassed = 0;
                timer = new Timer();
                task = new TimerTask() {
                    public void run() {
                        secondsPassed++;
                        seconds.setText(secondsPassed + "");
                    }
                };

                startClock();
                heigth = 780;
                width = 900;
                mines = 50;
                lives = 2;
                livesLeft.setText(lives + "");
                minesLeft.setText(mines + "");
                seconds.setText(secondsPassed + "");
            }
            
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setIcon(blanketIcon);
                }
            }
            createMines();
            lives = 2;
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    buttons[x][y].setText("");
                }
            }            
        } else {
            for (int x = 0; x<buttons.length; x++) {
                for (int y = 0; y<buttons[0].length; y++) {
                    if (e.getSource().equals(buttons[x][y]) && buttons[x][y].getIcon() == blanketIcon) {
                        if (counts[x][y] == MINE) {
                            buttons[x][y].setIcon(n11Icon);
                            mines--;
                            minesLeft.setText(mines + "");                            
                            loseALife();
                        } else if(counts[x][y] == 0) {
                            buttons[x][y].setIcon(n10Icon);
                            ArrayList<Integer> toClear = new ArrayList<Integer>();
                            toClear.add(x*100+y);
                            clearZeros(toClear);
                            winGame();
                        }
                        else {
                            switch(counts[x][y]) {
                                case 1 : buttons[x][y].setIcon(n1Icon); break;
                                case 2 : buttons[x][y].setIcon(n2Icon); break;
                                case 3 : buttons[x][y].setIcon(n3Icon); break;
                                case 4 : buttons[x][y].setIcon(n4Icon); break;
                                case 5 : buttons[x][y].setIcon(n5Icon); break;
                                case 6 : buttons[x][y].setIcon(n6Icon); break;
                                case 7 : buttons[x][y].setIcon(n7Icon); break;
                                case 8 : buttons[x][y].setIcon(n8Icon); break;
                            }
                            winGame();
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // EKKINISI EFARMOGIS
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Minesweeper1();
            }
        });
    }
}