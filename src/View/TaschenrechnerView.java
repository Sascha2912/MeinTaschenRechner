package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TaschenrechnerView {
    // TaschenRechnerView Attribute
    private JFrame frame;
    private JTextField txt_display;

    private final Font defaultFont = new Font("Arial",Font.BOLD,30);


    JButton btn_addition, btn_subtraction, btn_multiplication, btn_division, btn_equals, btn_seperator, btn_clear, btn_delete, btn_modulo;

    // TaschenRechnerView Konstruktor
    public TaschenrechnerView(){

        // Taschenrechner Hauptfenster Initialisieren
        this.initTaschenRechnerFrame();

        // Textfeld im Hauptfenster initialisieren
        this.initDisplay();

        // ButtonPanel initialisieren
        this.initButtonPanel();

        // SpecialButtonPanel initialisieren
        this.initSpecialButtonPanel();

    }

    // ******************* Attribute definieren *******************

    // Frame (Hauptfenster) definieren
    private void initTaschenRechnerFrame(){
        // Hauptfenster erstellen
        this.frame = new JFrame();

        // Titel des Fensters
        this.frame.setTitle("Taschenrechner Pro");

        // Größe des Fensters definieren
        // Hier haben wir Pixelwerte hardcoded. Solche fest in den Quellcode eingetragene Werte werden als Literale
        // bezeichnet. Oder auch einfach Magic Numbers.
        this.frame.setSize(420,550);

        // setzt die Größenveränderung des Fensters auf false. Das Fenster ist nicht veränderbar in der Größe.
        this.frame.setResizable(false);

        // Definiert das Standardverhalten beim close-event
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Fenster Ausrichtungsschema BorderLayout = Ausrichtung nach Himmelsrichtungen (North, South, East, West)
        this.frame.setLayout(new BorderLayout());

        // Fensterhintergrund gestalten.
        // getContentPane() gibt den Inhaltsbereich des Fensters zurück
        // setBackground() setzt den Hintergrund des Fensters auf die angegebene Farbe
        // new Color() definiert die Farbe mit RGB-Werten hier (Rot 104, Gelb 139, Blau 173)
        this.frame.getContentPane().setBackground(new Color(104, 139, 173));

        // Die Sichtbarkeit des Fensters auf true setzten, sonst wird nichts angezeigt
        this.frame.setVisible(true);
    }

    private void initDisplay(){
        // Textfeld initialisieren
        this.txt_display = new JTextField();

        // Textfeld Schrift anpassung
        this.txt_display.setFont(this.defaultFont);

        // Inhalt des Textfeldes ausrichten
        // setHorizontalAlignment() ausrichtung des Textfeldes auf Horizontal setzen
        // JTextField.RIGHT ausrichtung des Textfeldes auf rechtsbündig setzen
        this.txt_display.setHorizontalAlignment(JTextField.RIGHT);

        // User bearbeitung des Textfeldes auf false setzen
        this.txt_display.setEditable(false);

        // x = Anfang des Textfeldes 50px horizontal von der oberen linken Ecke
        // y = Anfang des Textfeldes 25px vertikal von der oberen linken Ecke
        // width = Breite des Textfeldes hier 300px
        // height = Höhe des Textfeldes hier 50px
        this.txt_display.setBounds(50,25,300,50);

        // *** Das kreierte Panel dem Hauptfenster hinzufügen ***
        // getContentPane() gibt den Inhaltsbereich des Fensters zurück
        // getContentPane().add() fügt ein Panel-Objekt dem Hauptfenster hinzu
        // BorderLayout = ausrichtung-typ nach Himmelsrichtungen. Panel wir oben (North) platziert.
        this.frame.getContentPane().add(this.txt_display, BorderLayout.NORTH);
    }

    private void initButtonPanel(){
        // Neues Panel für die Zahlen
        // Ausrichtung Grid 4 Zeilen und 4 Spalten
        JPanel pnl_buttons = new JPanel(new GridLayout(4, 4));

        // JButton Array initialisieren
        JButton[] numberButtons = new JButton[10];

        // Nummerbuttons über eine for-Schleife erstellen
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.format(String.valueOf(i)));

            // Fokusierbarkeit des Buttons auf false setzten, damit der Fokus auf dem Textfeld bleibt
            numberButtons[i].setFocusable(false);

            // Schrift des Buttons anpassen
            numberButtons[i].setFont(defaultFont);

            // Funktionalität den Buttons hinzufügen
            numberButtons[i].addActionListener(e -> writeToDisplay(e.getActionCommand()));

        }

        // ***** Arithmetics Buttons erstellen *****
        // Additions-Button
        this.btn_addition = new JButton("+");
        this.btn_addition.setFont(defaultFont);
        this.btn_addition.setFocusable(false);


        // Subtractions_Button
        this.btn_subtraction = new JButton("-");
        this.btn_subtraction.setFont(defaultFont);
        this.btn_subtraction.setFocusable(false);


        // Multiply-Button
        this.btn_multiplication = new JButton("*");
        this.btn_multiplication.setFont(defaultFont);
        this.btn_multiplication.setFocusable(false);


        // Divisions-Button
        this.btn_division = new JButton("/");
        this.btn_division.setFont(defaultFont);
        this.btn_division.setFocusable(false);


        // Equals-Button
        this.btn_equals = new JButton("=");
        this.btn_equals.setFont(defaultFont);
        this.btn_equals.setFocusable(false);


        // Seperator-Button
        this.btn_seperator = new JButton(".");
        this.btn_seperator.setFont(defaultFont);
        this.btn_seperator.setFocusable(false);
        this.btn_seperator.addActionListener(e -> writeToDisplay(e.getActionCommand()));


        this.btn_modulo = new JButton("%");
        this.btn_modulo.setFont(defaultFont);
        this.btn_modulo.setFocusable(false);




        // ***** Buttons dem Panel hinzufügen und anordnen von oben Links nach unten Rechts *****

        // Erste Reihe
        pnl_buttons.add(numberButtons[7]);
        pnl_buttons.add(numberButtons[8]);
        pnl_buttons.add(numberButtons[9]);
        pnl_buttons.add(this.btn_division);

        // Zweite Reihe
        pnl_buttons.add(numberButtons[4]);
        pnl_buttons.add(numberButtons[5]);
        pnl_buttons.add(numberButtons[6]);
        pnl_buttons.add(this.btn_multiplication);

        // Dritte Reihe
        pnl_buttons.add(numberButtons[1]);
        pnl_buttons.add(numberButtons[2]);
        pnl_buttons.add(numberButtons[3]);
        pnl_buttons.add(this.btn_subtraction);

        // Vierte Reihe
        pnl_buttons.add(btn_seperator);
        pnl_buttons.add(numberButtons[0]);
        pnl_buttons.add(this.btn_equals);
        pnl_buttons.add(this.btn_addition);

        // ***** Button Panel dem Hauptfenster hinzufügen *****
        this.frame.getContentPane().add(pnl_buttons, BorderLayout.CENTER);
    }

    private void initSpecialButtonPanel(){
        // Neues Panel initialisieren
        JPanel pnl_special_buttons = new JPanel(new FlowLayout());

        // Sichtbarkeit des Panel-Fensters von undurchsichtig auf Transparenz setzen
        // Damit werden Elemente hinter dem Fenster sichtbar
        pnl_special_buttons.setOpaque(false);

        // Delete-Button erstellen
        this.btn_delete = new JButton("DEL");
        this.btn_delete.setFont(defaultFont);
        this.btn_delete.setFocusable(false);
        this.btn_delete.addActionListener(e -> deleteCharacterFromDisplay());

        // Clear-Button erstellen
        this.btn_clear = new JButton("CLR");
        this.btn_clear.setFont(defaultFont);
        this.btn_clear.setFocusable(false);
        /*
        this.btn_clear.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearDisplay();
            }
        });
        */

        // Dieselbe Funktionalität wie die auskommentierte anonyme Klasse als Lambdaausdruck:
        this.btn_clear.addActionListener(e -> clearDisplay());


        // Spezial-Buttons dem Spezial-Button-Panel hinzufügen
        pnl_special_buttons.add(this.btn_delete);
        pnl_special_buttons.add(this.btn_clear);
        pnl_special_buttons.add(this.btn_modulo);

        // Spezial-Button-Panel ins Hauptfenster integrieren
        this.frame.getContentPane().add(pnl_special_buttons, BorderLayout.SOUTH);
    }


    // ***** Methoden für die Buttons definieren *****

    // Textfeld befüllen
    // TODO: frühzeitiger Casten von double zu String...
    public void writeToDisplay(String bntText){


        String text = this.concatInput(bntText);
        this.txt_display.setText(text);

    }

    // Button-Buffer auslesen
    private String concatInput(String bntText){

        String buffer = this.txt_display.getText();

        if(bntText.equals(".")){
            if(buffer.isEmpty()){
                buffer += "0";
            }
            boolean hasDecimalDot = this.validateInput(buffer);
            if(hasDecimalDot){
                return buffer;
            }
        }

        if(buffer != null && buffer.length() < 24){
            buffer += bntText;
        }
        return buffer;
    }

    // Wir prüfen ob der String bereits einen Dezimalpunkt enthält.
    private boolean validateInput(String input){

        return input.contains(".");
    }

    public void clearDisplay(){
        this.txt_display.setText("");
    }

    private void deleteCharacterFromDisplay(){

        String displayText = this.txt_display.getText();

        if(displayText != null && !displayText.isEmpty()){

            this.txt_display.setText(displayText.substring(0,displayText.length() - 1));
        }

    }

    // TODO: Codesmell? - Lieber den Buttons einen public getter geben und die Listener im Controller hinzufügen?
    public void setArithmeticClickListener(ActionListener arithmeticButtonClickListener)
    {
        this.btn_addition.addActionListener(arithmeticButtonClickListener);
        this.btn_subtraction.addActionListener(arithmeticButtonClickListener);
        this.btn_multiplication.addActionListener(arithmeticButtonClickListener);
        this.btn_division.addActionListener(arithmeticButtonClickListener);
        this.btn_equals.addActionListener(arithmeticButtonClickListener);
        this.btn_modulo.addActionListener(arithmeticButtonClickListener);
    }

    public String getTextFromDisplay(){

        return this.txt_display.getText();

    }

    public void showErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this.frame, errorMessage);
    }


}
