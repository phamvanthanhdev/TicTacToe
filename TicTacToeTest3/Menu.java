import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Menu {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, musicButtonPanel, helpButtonPanel, quitButtonPanel, backHelpPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font buttonFont = new Font("MV Boli", Font.BOLD, 110);
    Font playNameFont = new Font("Tahoma", Font.PLAIN, 25);
    Font scoreFont = new Font("Tahoma", Font.BOLD, 27);

    JButton startButton, continueButton, musicButton, helpButton, quitButton, backHelpButton;

    JTextArea mainTextArea;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    JButton[] buttons = new JButton[9];
    JPanel tablePanel, titleGamePanel, player1Panel, player2Panel, scorePlay1Panel, scorePlay2Panel, scoreDrawPanel;
    JLabel player1Name, player2Name, score1, score2, scoreDraw;
    
    //Khai báo tictactoe
    boolean player1_turn;
    private int player_First;
	private boolean isOver = false;
	private boolean withComputer = true;

    private int score_1 = 0;
	private int score_2 = 0;
    private int score_draw = 0;

    JPanel modePanel, resultPanel, optionsMenuPanel, optionsChossePanel, changeNamePanel;
    JButton setModeButton, resulButton, optionsButton, resumeButton, soundButtons, homeButton, newGameButton;

    Sound sound = new Sound();
    private boolean isSound = true;
    private boolean isContinue = false;

    JTextField namePlayer1Text, namePlayer2Text;
    JButton changeNameButton, backChangeName;

    JPanel backgroundPanel, playImagePanel, menuImagePanel;
    BufferedImage myPicture;
    JButton playButton, menButton;
    
    Random random = new Random();

    public Menu(){
        window = new JFrame();
        window.setSize(800,900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        con = window.getContentPane();
        sound.musicStart(0);


        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 20, 600, 100);
        titleNamePanel.setBackground(Color.BLACK);

        titleNameLabel = new JLabel("TIC TAC TOE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        backgroundPanel = new JPanel();
        backgroundPanel.setBounds(250,180,300,300);
        backgroundPanel.setBackground(Color.black);
        backgroundPanel.setLayout(new FlowLayout());

		backgroundPanel.setLayout(new FlowLayout());      
        try {
            myPicture = ImageIO.read(new File("UI/backg1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        backgroundPanel.add(picLabel);
        //play
        playImagePanel = new JPanel();
        playImagePanel.setBounds(160,505,100,100);
        playImagePanel.setBackground(Color.black);
        playImagePanel.setLayout(new FlowLayout());

        playButton = new JButton(new ImageIcon("UI/play1.png"));
        playButton.setBackground(Color.black);
        playButton.setFocusPainted(false);
        playButton.setBorder(null);
        playButton.addActionListener(tsHandler);

        playImagePanel.add(playButton);
        // menu
        menuImagePanel = new JPanel();
        menuImagePanel.setBounds(560,500,100,100);
        menuImagePanel.setBackground(Color.black);
        menuImagePanel.setLayout(new FlowLayout());

        menButton = new JButton(new ImageIcon("UI/menu.png"));
        menButton.setBackground(Color.black);
        menButton.setFocusPainted(false);
        menButton.setBorder(null);
        menButton.addActionListener(tsHandler);

        menuImagePanel.add(menButton);
        // start
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,380,200,120);
        startButtonPanel.setBackground(Color.black);


        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);

        startButtonPanel.setLayout(new GridLayout(2,1, 30,30));
        startButtonPanel.add(startButton);
        startButton.addActionListener(tsHandler);

        //continue


        continueButton = new JButton("CONTINUE");
        continueButton.setBackground(Color.black);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);
        continueButton.setFocusPainted(false);

        startButtonPanel.add(continueButton);
        continueButton.addActionListener(tsHandler);

        //music
        musicButtonPanel = new JPanel();
        musicButtonPanel.setBounds(300,520,200,60);
        musicButtonPanel.setBackground(Color.black);


        musicButton = new JButton("SOUND OFF");
        musicButton.setBackground(Color.black);
        musicButton.setForeground(Color.white);
        musicButton.setFont(normalFont);
        musicButton.setFocusPainted(false);

        musicButtonPanel.add(musicButton);
        musicButton.addActionListener(tsHandler);
        
        //help
        helpButtonPanel = new JPanel();
        helpButtonPanel.setBounds(300,590,200,60);
        helpButtonPanel.setBackground(Color.black);


        helpButton = new JButton("HELP");
        helpButton.setBackground(Color.black);
        helpButton.setForeground(Color.white);
        helpButton.setFont(normalFont);
        helpButton.setFocusPainted(false);

        helpButtonPanel.add(helpButton);
        helpButton.addActionListener(tsHandler);

         //quit
         quitButtonPanel = new JPanel();
         quitButtonPanel.setBounds(300,660,200,60);
         quitButtonPanel.setBackground(Color.black);
 
 
         quitButton = new JButton("QUIT GAME");
         quitButton.setBackground(Color.black);
         quitButton.setForeground(Color.white);
         quitButton.setFont(normalFont);
         quitButton.setFocusPainted(false);
 
         quitButtonPanel.add(quitButton);
         quitButton.addActionListener(tsHandler);
        

        for (int i = 0; i < 9; i++) { // khai bao de tranh loi khoi tao
            buttons[i] = new JButton();
        }

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(musicButtonPanel);
        con.add(helpButtonPanel);
        con.add(quitButtonPanel);

        con.add(backgroundPanel);
        con.add(playImagePanel);
        con.add(menuImagePanel);

        startButtonPanel.setVisible(false);
        musicButton.setVisible(false);
        helpButton.setVisible(false);
        quitButton.setVisible(false);
    }

    //Phần đồ họa
    public void createStartGame(){
        backgroundPanel.setVisible(false);
        playImagePanel.setVisible(false);
        menuImagePanel.setVisible(false);

        startButtonPanel.setVisible(true);
        musicButton.setVisible(true);
        helpButton.setVisible(true);
        quitButton.setVisible(true);
    }

    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        musicButtonPanel.setVisible(false);
        helpButtonPanel.setVisible(false);
        quitButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Tic Tac Toe có 2 chế độ : \n - Hai Player và chơi với Máy");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);

        createGameHelp();
    }

    public void createGameHelp(){
        backHelpPanel = new JPanel();
        backHelpPanel.setBounds(300,420,200,60);
        backHelpPanel.setBackground(Color.black);


        backHelpButton = new JButton("BACK");
        backHelpButton.setBackground(Color.black);
        backHelpButton.setForeground(Color.white);
        backHelpButton.setFont(normalFont);
        backHelpButton.setFocusPainted(false);

        backHelpPanel.add(backHelpButton);
        backHelpButton.addActionListener(tsHandler);

        con.add(backHelpPanel);
    }

    public void createBackGameHelp(){
        backHelpPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        titleNameLabel.setText("TIC TAC TOE");
        titleNamePanel.setVisible(true);
        startButtonPanel.setVisible(true);
        musicButtonPanel.setVisible(true);
        helpButtonPanel.setVisible(true);
        quitButtonPanel.setVisible(true);
    }

    public void drawTable(){
        startButtonPanel.setVisible(false);
        musicButtonPanel.setVisible(false);
        helpButtonPanel.setVisible(false);
        quitButtonPanel.setVisible(false);


        tablePanel = new JPanel();
        tablePanel.setBounds(150,160,499,499);
        tablePanel.setBackground(Color.white);
        tablePanel.setLayout(new GridLayout(3,3, 5,5));
        

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
			tablePanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(tsHandler);
            buttons[i].setBorder(null);
            buttons[i].setBackground(Color.black);
        }

        drawPlayer();
        drawScore();
        createSetMode();
        createOptionsMenu();
        con.add(tablePanel);

        createResult();
        resultPanel.setVisible(false);

        again_Game();
        firstTurn();
    }

    public void drawPlayer(){
        player1Panel = new JPanel();
        player1Panel.setBounds(150, 700, 200, 50);
        player1Panel.setBackground(Color.black);

        player1Name = new JLabel("Player (X)");
        player1Name.setForeground(Color.white);
        player1Name.setFont(playNameFont);

        player1Panel.add(player1Name);

        con.add(player1Panel);

        //pl2
        player2Panel = new JPanel();
        player2Panel.setBounds(470, 700, 200, 50);
        player2Panel.setBackground(Color.black);

        player2Name = new JLabel("Computer (O)");
        player2Name.setForeground(Color.white);
        player2Name.setFont(playNameFont);

        player2Panel.add(player2Name);

        con.add(player2Panel);
        
        firstTurn();
    }

    public void drawScore(){

        score_1 = 0;
        score_2 = 0;
        score_draw = 0;

        //pl1
        scorePlay1Panel = new JPanel();
        scorePlay1Panel.setBounds(230, 750, 30, 50);
        scorePlay1Panel.setBackground(Color.black);

        score1 = new JLabel(score_1+"");
        score1.setForeground(Color.white);
        score1.setFont(scoreFont);

        scorePlay1Panel.add(score1);
        con.add(scorePlay1Panel);

        //draw
        scoreDrawPanel = new JPanel();
        scoreDrawPanel.setBounds(385, 750, 30, 50);
        scoreDrawPanel.setBackground(Color.black);

        scoreDraw = new JLabel(score_draw+"");
        scoreDraw.setForeground(Color.white);
        scoreDraw.setFont(scoreFont);

        scoreDrawPanel.add(scoreDraw);
        con.add(scoreDrawPanel);

        //pl2
        scorePlay2Panel = new JPanel();
        scorePlay2Panel.setBounds(550, 750, 30, 50);
        scorePlay2Panel.setBackground(Color.black);

        score2 = new JLabel(score_2 +"");
        score2.setForeground(Color.white);
        score2.setFont(scoreFont);

        scorePlay2Panel.add(score2);
        con.add(scorePlay2Panel);
    }

    public void createSetMode(){
        modePanel = new JPanel();
        modePanel.setBounds(100, 680, 30, 40);
        modePanel.setBackground(Color.black);

        setModeButton = new JButton(new ImageIcon("UI/one_people.png"));
        setModeButton.setBackground(Color.black);
        setModeButton.setFocusPainted(false);
        setModeButton.setBorder(null);

        modePanel.add(setModeButton);
        setModeButton.addActionListener(tsHandler);

        con.add(modePanel);
    }

    public void createOptionsMenu(){
        optionsMenuPanel = new JPanel();
        optionsMenuPanel.setBounds(680, 680, 30, 40);
        optionsMenuPanel.setBackground(Color.black);

        optionsButton = new JButton(new ImageIcon("UI/options_menu.png"));
        optionsButton.setBackground(Color.black);
        optionsButton.setFocusPainted(false);
        optionsButton.setBorder(null);

        optionsMenuPanel.add(optionsButton);
        optionsButton.addActionListener(tsHandler);

        con.add(optionsMenuPanel);
    }

    public void createChooseOptions(){
        optionsButton.setEnabled(false);

        optionsChossePanel = new JPanel();
        optionsChossePanel.setBounds(260,230,300,260);
        optionsChossePanel.setBackground(Color.black);
        optionsChossePanel.setLayout(new GridLayout(5,1, 10,10));

        resumeButton = new JButton("RESUME");
        resumeButton.setBackground(Color.black);
        resumeButton.setForeground(Color.white);
        resumeButton.setFont(normalFont);
        resumeButton.setFocusPainted(false);

        optionsChossePanel.add(resumeButton);
        resumeButton.addActionListener(tsHandler);
        
        //back
        newGameButton = new JButton("NEW GAME");
        newGameButton.setBackground(Color.black);
        newGameButton.setForeground(Color.white);
        newGameButton.setFont(normalFont);
        newGameButton.setFocusPainted(false);

        optionsChossePanel.add(newGameButton);
        newGameButton.addActionListener(tsHandler);

        //sound
        //soundButtons = new JButton(musicButton.getText());
        soundButtons = new JButton("SOUND ON");
        soundButtons.setBackground(Color.black);
        soundButtons.setForeground(Color.white);
        soundButtons.setFont(normalFont);
        soundButtons.setFocusPainted(false);

        optionsChossePanel.add(soundButtons);
        soundButtons.addActionListener(tsHandler);

        //home
        homeButton = new JButton("HOME");
        homeButton.setBackground(Color.black);
        homeButton.setForeground(Color.white);
        homeButton.setFont(normalFont);
        homeButton.setFocusPainted(false);

        optionsChossePanel.add(homeButton);
        homeButton.addActionListener(tsHandler);

        //set NamePlayer
        changeNameButton = new JButton("CHANGE NAME");
        changeNameButton.setBackground(Color.black);
        changeNameButton.setForeground(Color.white);
        changeNameButton.setFont(normalFont);
        changeNameButton.setFocusPainted(false);

        optionsChossePanel.add(changeNameButton);
        changeNameButton.addActionListener(tsHandler);

        con.add(optionsChossePanel);
    }

    public void createChangName(){
        tablePanel.setVisible(false);
        player1Panel.setVisible(false);
        player2Panel.setVisible(false);
        scoreDrawPanel.setVisible(false);
        scorePlay1Panel.setVisible(false);
        scorePlay2Panel.setVisible(false);
        modePanel.setVisible(false);
        optionsMenuPanel.setVisible(false);
        optionsChossePanel.setVisible(false);

        changeNamePanel = new JPanel();
        changeNamePanel.setBounds(300,240,300,260);
        changeNamePanel.setBackground(Color.black);
        changeNamePanel.setLayout(new GridLayout(5,1,15,10));

        JLabel setNamePlayer1 = new JLabel("Enter name 1");
        setNamePlayer1.setFont(scoreFont);
        setNamePlayer1.setForeground(Color.white);

        JLabel setNamePlayer2 = new JLabel("Enter name 2");
        setNamePlayer2.setFont(scoreFont);
        setNamePlayer2.setForeground(Color.white);
        
        namePlayer1Text = new JTextField(player1Name.getText());
        namePlayer1Text.setFont(normalFont);
        namePlayer1Text.setBackground(Color.black);
        namePlayer1Text.setForeground(Color.white);

        namePlayer2Text = new JTextField(player2Name.getText());
        namePlayer2Text.setFont(normalFont);
        namePlayer2Text.setBackground(Color.black);
        namePlayer2Text.setForeground(Color.white);

        backChangeName = new JButton("OK");
        backChangeName.setBackground(Color.black);
        backChangeName.setForeground(Color.white);
        backChangeName.setFont(normalFont);
        backChangeName.setFocusPainted(false);
        backChangeName.addActionListener(tsHandler);

        if(withComputer){
            changeNamePanel.add(setNamePlayer1);
            changeNamePanel.add(namePlayer1Text);
        }else{
            changeNamePanel.add(setNamePlayer1);
            changeNamePanel.add(namePlayer1Text);
            changeNamePanel.add(setNamePlayer2);
            changeNamePanel.add(namePlayer2Text);
        }
        changeNamePanel.add(backChangeName);

        con.add(changeNamePanel);
    }

    public void createBackChangeName(){
        changeNamePanel.setVisible(false);

        tablePanel.setVisible(true);
        player1Panel.setVisible(true);
        player2Panel.setVisible(true);
        scorePlay1Panel.setVisible(true);
        scorePlay2Panel.setVisible(true);
        scoreDrawPanel.setVisible(true);
        modePanel.setVisible(true);
        optionsMenuPanel.setVisible(true);
        optionsButton.setEnabled(true);

        player1Name.setText(namePlayer1Text.getText());
        player2Name.setText(namePlayer2Text.getText());
    }

    public void createBackHome(){
        tablePanel.setVisible(false);
        player1Panel.setVisible(false);
        player2Panel.setVisible(false);
        scoreDrawPanel.setVisible(false);
        scorePlay1Panel.setVisible(false);
        scorePlay2Panel.setVisible(false);
        modePanel.setVisible(false);
        optionsMenuPanel.setVisible(false);
        resultPanel.setVisible(false);

        titleNamePanel.setVisible(true);
        startButtonPanel.setVisible(true);
        musicButtonPanel.setVisible(true);
        helpButtonPanel.setVisible(true);
        quitButtonPanel.setVisible(true);
    }

    public void createResult(){
        resultPanel = new JPanel();
        resultPanel.setBounds(350, 650, 104, 60);
        resultPanel.setBackground(Color.black);

        resulButton = new JButton(new ImageIcon("UI/lose.png"));
        resulButton.setBackground(Color.black);
        resulButton.setFocusPainted(false);
        resulButton.setBorder(null);

        resultPanel.add(resulButton);
        //resulButton.addActionListener(tsHandler);

        con.add(resultPanel);
    }

    //Phần GamePlay

    public void check() {
		//check X win conditions
		boolean check_Draw = true;
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			score_1++;
			check_Draw = false;
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			score_2++;
			check_Draw = false;
			oWins(2,4,6);
		}

		// Xu li draw
		for (int i = 0; i < 9; i++) {
			if(buttons[i].getText() == "") check_Draw = false;
		}
		if(check_Draw == true){
            score_draw++;
			Draws();
		}
	}

    public void Draws(){
		isOver = true;
		for(int i=0;i<9;i++) {
			buttons[i].setForeground(Color.gray);
		}
        resultDraw();
        scoreDraw.setText(score_draw+"");
        sound.playSE(2);
	}

    public void xWins(int a,int b,int c) {
		isOver = true;
		for(int i=0;i<9;i++) {
			//buttons[i].setEnabled(false);
			buttons[i].setForeground(Color.gray);
		}
        buttons[a].setForeground(Color.red);
		buttons[b].setForeground(Color.red);
		buttons[c].setForeground(Color.red);
        resultXwin();
		score1.setText(score_1 + "");
        sound.playSE(2);
	}
	
	public void oWins(int a,int b,int c) {
		isOver = true;
		for(int i=0;i<9;i++) {
			//buttons[i].setEnabled(false);
			buttons[i].setForeground(Color.GRAY);
		}
        buttons[a].setForeground(Color.blue);
		buttons[b].setForeground(Color.blue);
		buttons[c].setForeground(Color.blue);
        resultOwin();
		score2.setText(score_2 + "");
        sound.playSE(2);
	}


    public void again_Game(){
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(true);
			buttons[i].setText("");
			//buttons[i].setBackground(Color.black);
		}

		if(player_First == 1) {
			player1_turn = false;
			player_First = 2;
			
		}else{
			player1_turn = true;
			player_First = 1;
			
		}

        resultPanel.setVisible(false);
	}

    public void firstTurn() {
		if(random.nextInt(2)==0) {
			player1_turn=true;
			player_First = 1;
            player1Name.setForeground(Color.YELLOW);
            player2Name.setForeground(Color.WHITE);
		}
		else {
			player1_turn=false;
			player_First = 2;
            player2Name.setForeground(Color.YELLOW);
            player1Name.setForeground(Color.WHITE);
		}
		if(withComputer && player1_turn == false){
			computer_First();
		}
	}

    // Mức độ ưu tiên Computer hoạt động :
    // Đánh vào ô có thể thắng, đánh vào ô chặn người chơi thắng, đánh vào vị trí quan trọng, đánh random

    public void computer_Turn(){
		if(index_Computer_Wins() != -1){
			int n = index_Computer_Wins();
			buttons[n].setForeground(new Color(0,0,255));
			buttons[n].setText("O");
		}else if(index_Player_Wins() != -1){
			int n = index_Player_Wins();
			buttons[n].setForeground(new Color(0,0,255));
			buttons[n].setText("O");
		}else if(computer_turn_1() != -1){
			int n = computer_turn_1();
			buttons[n].setForeground(new Color(0,0,255));
			buttons[n].setText("O");
		}else{
			computer_random_Turn();
		}
	}

	public void computer_First(){ // Computer danh lan dau tien
		computer_random_Turn();
		player1_turn = true;
	}

	public void computer_random_Turn(){ // Computer danh vao vi tri ngau nhien
		int n;
		do {
		n = random.nextInt(9);
		} while (buttons[n].getText() != "");
	
		buttons[n].setForeground(new Color(0,0,255));
		buttons[n].setText("O");

		check();
	}

	public int computer_turn_1(){ // Computer danh vao vi tri quan trong
		ArrayList <Integer> arr = new ArrayList<>();
		if(buttons[0].getText() == "") arr.add(0);
		if(buttons[2].getText() == "") arr.add(2);
		if(buttons[4].getText() == "") arr.add(4);
		if(buttons[6].getText() == "") arr.add(6);
		if(buttons[8].getText() == "") arr.add(8);

		if(arr.size() == 0) return -1;
		int n = arr.get(random.nextInt(arr.size()));
		return n;
	}

	public int index_Computer_Wins(){ // Danh vao o Computer co the thang
		for (int i = 0; i < 9; i++) {
			if(buttons[i].getText()=="") {
				buttons[i].setText("O");
				if(check_Computer_win())  {
					buttons[i].setText("");
					return i;
				}
				buttons[i].setText("");
			}
		}
		return -1;
	}

	public int index_Player_Wins(){ // Computer danh chan vao o Player co the thang
		for (int i = 0; i < 9; i++) {
			if(buttons[i].getText()=="") {
				buttons[i].setText("X");
				if(check_Player_win())  {
					buttons[i].setText("");
					return i;
				}
				buttons[i].setText("");
			}
		}
		return -1;
	}

	public boolean check_Player_win(){
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			return true;
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
					return true;
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
					return true;
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
					return true;
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
					return true;
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
					return true;
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
					return true;
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
					return true;
		}
		return false;
	}

	public boolean check_Computer_win() {
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			return true;
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			return true;
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			return true;
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			return true;
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			return true;
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			return true;
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			return true;
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			return true;
		}
		return false;
	}

    public void handlerSetMode(){
        if(withComputer){
            withComputer = false;
            setModeButton.setIcon(new ImageIcon("UI/two_people.png"));
            score_1 = 0;
            score_2 = 0;
            score_draw = 0;
            player1Name.setText("Player 1 (X)");
            player2Name.setText("Player 2 (O)");
            score1.setText(score_1+"");
            score2.setText(score_2+"");
            scoreDraw.setText(score_draw+"");
            again_Game();
            firstTurn();
        }else{
            withComputer = true;
            setModeButton.setIcon(new ImageIcon("UI/one_people.png"));
            score_1 = 0;
            score_2 = 0;
            score_draw = 0;
            player1Name.setText("Player (X)");
            player2Name.setText("Computer (O)");
            score1.setText(score_1+"");
            score2.setText(score_2+"");
            scoreDraw.setText(score_draw+"");
            again_Game();
            firstTurn();
        }
    }

    public void resultXwin(){
        resultPanel.setVisible(true);
        if(withComputer){
            resulButton.setIcon(new ImageIcon("UI/win.png"));
        }else{
            resulButton.setIcon(new ImageIcon("UI/win.png"));
        }
    }

    public void resultOwin(){
        resultPanel.setVisible(true);
        if(withComputer){
            resulButton.setIcon(new ImageIcon("UI/lose.png"));
        }else{
            resulButton.setIcon(new ImageIcon("UI/win.png"));
        }
    }

    public void resultDraw(){
        resultPanel.setVisible(true);
        resulButton.setIcon(new ImageIcon("UI/draw.png"));
    }

    public void handleNewGame(){
        tablePanel.setVisible(true);
        optionsButton.setEnabled(true);
            score_1 = 0;
            score_2 = 0;
            score_draw = 0;
            score1.setText(score_1+"");
            score2.setText(score_2+"");
            scoreDraw.setText(score_draw+"");
            again_Game();
            firstTurn();
    }

    public void soundStart(){
        if(isSound){
            isSound = false;
            sound.musicStop();
            musicButton.setText("SOUND ON");
            sound.musicStop();
        }else{
            sound.musicStart(0);
            musicButton.setText("SOUND OFF");
            isSound = true;
        }
    }

    public void soundOptions(){
        if(isSound){
            isSound = false;
            sound.musicStop();
            soundButtons.setText("SOUND ON");
        }else{
            sound.musicStart(0);
            soundButtons.setText("SOUND OFF");
            isSound = true;
        }
    }

    public void handleContinue(){
        startButtonPanel.setVisible(false);
        musicButtonPanel.setVisible(false);
        helpButtonPanel.setVisible(false);
        quitButtonPanel.setVisible(false);

        tablePanel.setVisible(true);
        player1Panel.setVisible(true);
        player2Panel.setVisible(true);
        scorePlay1Panel.setVisible(true);
        scorePlay2Panel.setVisible(true);
        scoreDrawPanel.setVisible(true);
        modePanel.setVisible(true);
        optionsMenuPanel.setVisible(true);
        optionsButton.setEnabled(true);
    }
    
    public void setScoreText(){
        score_1 = 0;
        score_2 = 0;
        score_draw = 0;
        score1.setText(score_1+"");
        score2.setText(score_2+"");
        scoreDraw.setText(score_draw+"");
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == playButton){
                createStartGame();
            }

            if(event.getSource() == startButton){
                sound.musicStop();
                isSound = false;
                //setScoreText();
                withComputer = true;
                drawTable();
            }

            if(event.getSource() == continueButton){
                sound.musicStop();
                if(isContinue){
                    handleContinue();
                }else{
                    drawTable();
                }
            }

            if(event.getSource() == musicButton){
                soundStart();
            }

            if(event.getSource() == helpButton){
                createGameScreen();
            }

            if(event.getSource() == quitButton){
                System.exit(0);
            }

            if(event.getSource() == backHelpButton){
                createBackGameHelp();
            }

            if(event.getSource() == setModeButton){
                sound.playSE(3);
                handlerSetMode();
            }

            if(event.getSource() == optionsButton){
                sound.playSE(3);
                tablePanel.setVisible(false);
                createChooseOptions();
            }

            if(event.getSource() == resumeButton){
                sound.playSE(3);
                optionsChossePanel.setVisible(false);
                tablePanel.setVisible(true);
                optionsButton.setEnabled(true);
            }

            if(event.getSource() == newGameButton){
                sound.playSE(3);
                optionsChossePanel.setVisible(false);
                handleNewGame();
            }

            if(event.getSource() == homeButton){
                //sound.playSE(3);
                sound.musicStop();
                optionsChossePanel.setVisible(false);
                isContinue = true;
                isSound = true;
                musicButton.setText("SOUND OFF");
                sound.musicStart(0);
                createBackHome();
            }

            if(event.getSource() == soundButtons){
                //sound.playSE(3);
                soundOptions();
            }

            if(event.getSource() == changeNameButton){
                createChangName();
            }

            if(event.getSource() == backChangeName){
                createBackChangeName();
            }

            if(withComputer == false){
                for(int i=0;i<9;i++) {
                    if(isOver == false){
                        if(event.getSource()==buttons[i]) {
                            if(player1_turn) {
                                if(buttons[i].getText()=="") {
                                    sound.playSE(1);
                                    buttons[i].setForeground(Color.white);
                                    buttons[i].setText("X");
                                    player1_turn=false;
                                    //textfield.setText("O turn");
                                    check();
                                }
                                //player2.setBackground(new Color(25,25,25));
                                //player1.setBackground(new Color(255,255,255));
                                player2Name.setForeground(Color.YELLOW);
                                player1Name.setForeground(Color.WHITE);
                            }
                            else {
                                if(buttons[i].getText()=="") {
                                    sound.playSE(1);
                                    buttons[i].setForeground(Color.white);
                                    buttons[i].setText("O");
                                    player1_turn=true;
                                    //textfield.setText("X turn");
                                    check();
                                }
                                //player1.setBackground(new Color(25,25,25));
                                //player2.setBackground(new Color(255,255,255));
                                player1Name.setForeground(Color.YELLOW);
                                player2Name.setForeground(Color.WHITE);
                                }
                            }			
                    }else{
                        if(event.getSource()==buttons[i]) {
                            isOver = false;
                            again_Game();
                            //title_panel.remove(textfield);
                            //title_panel.add(title_panel_play1);
                            //title_panel.add(title_panel_play2);
                        }
                    }
                }
            }else{
                    for(int i=0;i<9;i++) {
                        if(isOver == false){
                            if(player1_turn) {
                            if(event.getSource()==buttons[i]) {
                                    if(buttons[i].getText()=="") {
                                        sound.playSE(1);
                                        buttons[i].setForeground(new Color(255,0,0));
                                        buttons[i].setText("X");
                                        
                                        check();
                                    
                                        player1Name.setForeground(Color.YELLOW);
                                        player2Name.setForeground(Color.WHITE);

                                        if(isOver) continue;
                                        
                                        computer_Turn();
                                        check();
                                    }
                                }
                            }else{
                                computer_First();
                            }
                        }else{
                            if(event.getSource()==buttons[i]) {
                                isOver = false;
                                again_Game();
                            }
                        }
                    }
                }
        
        }
    }


    // public static void main(String[] args) {
    //     new Menu();
    // }
}
