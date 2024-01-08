package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TaschenrechnerView {
    // TaschenRechnerView Attribute
    private JFrame frame;
    // TODO : Lagere txt_display aus in eine eigene Displayklasse:
    private JTextField txt_display;
    private Display display;
    private SpecialButtonPanel specialButtonPanel;

    public static final Font defaultFont = new Font("Arial",Font.BOLD,30);

    private JButton[] numberButton;

    private JButton btn_addition, btn_subtraction, btn_multiplication, btn_division, btn_equals, btn_seperator, btn_clear, btn_delete;

    private JPanel pnl_buttons;


    // TaschenRechnerView Konstruktor
    public TaschenrechnerView(){

        // Taschenrechner Hauptfenster Initialisieren
        this.initTaschenRechnerFrame();

        // ButtonPanel initialisieren
        this.initButtonPanel();


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

        Container container = this.frame.getContentPane();
        this.display = new Display(container);
        this.specialButtonPanel = new SpecialButtonPanel(container);

        // Die Sichtbarkeit des Fensters auf true setzten, sonst wird nichts angezeigt
        this.frame.setVisible(true);
    }


    private void initButtonPanel(){
        // Neues Panel für die Zahlen
        // Ausrichtung Grid 4 Zeilen und 4 Spalten
        pnl_buttons = new JPanel(new GridLayout(4, 4));

        // JButton Array initialisieren
        numberButton = new JButton[10];

        // Nummerbuttons über eine for-Schleife erstellen
        for(int i = 0; i < 10; i++){
            numberButton[i] = new JButton(String.format(String.valueOf(i)));

            // Fokusierbarkeit des Buttons auf false setzten, damit der Fokus auf dem Textfeld bleibt
            numberButton[i].setFocusable(false);

            // Schrift des Buttons anpassen
            numberButton[i].setFont(defaultFont);

            // Funktionalität den Buttons hinzufügen
            numberButton[i].addActionListener(e -> writeToDisplay(e.getActionCommand()));

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


        // ***** Buttons dem Panel hinzufügen und anordnen von oben Links nach unten Rechts *****

        // Erste Reihe
        pnl_buttons.add(numberButton[7]);
        pnl_buttons.add(numberButton[8]);
        pnl_buttons.add(numberButton[9]);
        pnl_buttons.add(this.btn_division);

        // Zweite Reihe
        pnl_buttons.add(numberButton[4]);
        pnl_buttons.add(numberButton[5]);
        pnl_buttons.add(numberButton[6]);
        pnl_buttons.add(this.btn_multiplication);

        // Dritte Reihe
        pnl_buttons.add(numberButton[1]);
        pnl_buttons.add(numberButton[2]);
        pnl_buttons.add(numberButton[3]);
        pnl_buttons.add(this.btn_subtraction);

        // Vierte Reihe
        pnl_buttons.add(btn_seperator);
        pnl_buttons.add(numberButton[0]);
        pnl_buttons.add(this.btn_equals);
        pnl_buttons.add(this.btn_addition);

        // ***** Button Panel dem Hauptfenster hinzufügen *****
        this.frame.getContentPane().add(pnl_buttons, BorderLayout.CENTER);
    }

    // ***** Methoden für die Buttons definieren *****

    // Textfeld befüllen
    // TODO: frühzeitiger Casten von double zu String...
    public void writeToDisplay(String bntText){


        String text = this.concatInput(bntText);
        this.display.setText(text);

    }

    // Button-Buffer auslesen
    private String concatInput(String bntText){

        String buffer = this.display.getText();

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
        this.display.setText("");
    }

    public Display getDisplay(){
        return this.display;
    }

    public String getTextFromDisplay(){

        return this.display.getText();

    }

/*    private void deleteCharacterFromDisplay(){

        String displayText = this.display.getText();

        if(displayText != null && !displayText.isEmpty()){

            this.display.setText(displayText.substring(0,displayText.length() - 1));
        }

    }*/

    // TODO: Codesmell? - Lieber den Buttons einen public getter geben und die Listener im Controller hinzufügen?
    public void setArithmeticClickListener(ActionListener arithmeticButtonClickListener)
    {
        this.btn_addition.addActionListener(arithmeticButtonClickListener);
        this.btn_subtraction.addActionListener(arithmeticButtonClickListener);
        this.btn_multiplication.addActionListener(arithmeticButtonClickListener);
        this.btn_division.addActionListener(arithmeticButtonClickListener);
        this.btn_equals.addActionListener(arithmeticButtonClickListener);
        specialButtonPanel.getButton(2).addActionListener(arithmeticButtonClickListener);
//
    }

    public void showErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this.frame, errorMessage);
    }

    public SpecialButtonPanel getSpecialButtonPanel(){
        return this.specialButtonPanel;
    }


}
