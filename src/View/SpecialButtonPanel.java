package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

public class SpecialButtonPanel {

    // private Container container;
    private JPanel specialButtonPanel;

    public SpecialButtonPanel(Container container){

        this.createSpecialButtons(container);

    }

    private void createSpecialButtons(Container container){

        specialButtonPanel = new JPanel();
        specialButtonPanel.setLayout(new GridLayout(1, 3, 15 ,0));

        specialButtonPanel.setBorder(new EmptyBorder(10,10,10,10));
        specialButtonPanel.setOpaque(false);

        JButton btn_clear = new JButton("CLR");
        btn_clear.setFont(TaschenrechnerView.defaultFont);
        btn_clear.setFocusable(false);
        // btn_clear.addActionListener(e -> frame.clearDisplay());

        JButton btn_delete = new JButton("DEL");
        btn_delete.setFont(TaschenrechnerView.defaultFont);
        btn_delete.setFocusable(false);

        JButton btn_modulo = new JButton("MOD");
        btn_modulo.setFont(TaschenrechnerView.defaultFont);
        btn_modulo.setFocusable(false);

        specialButtonPanel.add(btn_clear);
        specialButtonPanel.add(btn_delete);
        specialButtonPanel.add(btn_modulo);


        container.add(specialButtonPanel, BorderLayout.SOUTH);

    }

    public JButton getButton(int index) {
        return Arrays.stream(specialButtonPanel.getComponents()).filter(c -> c instanceof JButton).toArray(JButton[]::new)[index];
    }



}
