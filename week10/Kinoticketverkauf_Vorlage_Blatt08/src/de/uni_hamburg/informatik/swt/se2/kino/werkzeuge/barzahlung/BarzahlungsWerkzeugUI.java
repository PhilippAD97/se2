package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

/**
 * Die UI des {@link BarzahlungsWerkzeug}.
 *
 * @author Fruchtzwerge
 * @version SoSe 2017
 */
class BarzahlungsWerkzeugUI
{
    // Die Widgets, aus denen das UI sich zusammensetzt
    private JDialog _hauptModal;
    private JLabel _preisLabel;
    private JFormattedTextField _inputFeld;
    private JLabel _restbetragLabel;
    private JLabel _bezahlterbetragLabel;
    private JButton _okButton;
    private JButton _dismissButton;

    /**
     * Erzeugt ein neues Exemplar
     */
    BarzahlungsWerkzeugUI()
    {
        _hauptModal = erzeugeModal();
    }

    /**
     * Erstellt das Modal mit den Widgets.
     *
     * @return Das fertige Modal
     */
    private JDialog erzeugeModal()
    {
        Color backgroundColor = new Color (20,20,20);
        Color inputBackgroundColor = new Color (50,50,50);

        // Create JDialog as modal
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Barzahlung");

        // Set Layout, Border and Size
        dialog.setLayout(new GridLayout(5, 1, 4, 0));
        dialog.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialog.setSize(220, 220);
        dialog.getRootPane().setBackground(backgroundColor);
        dialog.getRootPane().setForeground(Color.white);

        // Preis-Panel
        JPanel preisPanel = new JPanel();
        preisPanel.setLayout(new GridLayout(1, 2));
        JLabel preisLabelKey = new JLabel("Preis:");
        preisLabelKey.setForeground(Color.white);
        preisPanel.add(preisLabelKey);
        _preisLabel = new JLabel();
        _preisLabel.setForeground(Color.white);
        preisPanel.add(_preisLabel);
        dialog.add(preisPanel);
        preisPanel.setBackground(backgroundColor);

        // Text-Input
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        //formatter.setCommitsOnValidEdit(true);
        _inputFeld = new JFormattedTextField(formatter);
        _inputFeld.setOpaque(true);
        _inputFeld.setBackground(inputBackgroundColor);
        _inputFeld.setForeground(Color.white);
        dialog.add(_inputFeld);

        // Restbetrag-Panel
        JPanel restbetragPanel = new JPanel();
        restbetragPanel.setLayout(new GridLayout(1, 2));
        JLabel restbetragLabelKey = new JLabel("Restbetrag:");
        restbetragLabelKey.setForeground(Color.white);
        restbetragPanel.add(restbetragLabelKey);
        _restbetragLabel = new JLabel();
        _restbetragLabel.setForeground(Color.white);
        restbetragPanel.add(_restbetragLabel);
        restbetragPanel.setBackground(backgroundColor);
        dialog.add(restbetragPanel);
        
        // bezahlter Betrag panel
        JPanel bezahlterbetragPanel = new JPanel();
        bezahlterbetragPanel.setLayout(new GridLayout(1, 2));
        bezahlterbetragPanel.add(new JLabel("Bezahlt:"));
        _bezahlterbetragLabel = new JLabel();
        bezahlterbetragPanel.add(_bezahlterbetragLabel);
        dialog.add(bezahlterbetragPanel);

        // OK / Abbrechen - Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        _okButton = new JButton("OK");
        _okButton.setEnabled(false);
        _dismissButton = new JButton("Abbrechen");
        buttonPanel.add(_dismissButton);
        buttonPanel.add(_okButton);
        dialog.add(buttonPanel);
        buttonPanel.setBackground(backgroundColor);

        // Center on display
        dialog.setLocationRelativeTo(null);

        return dialog;
    }

    /**
     * Gibt das komplette Modal zurück
     * @return Das Haupt-Modal
     */
    JDialog getMainDialog()
    {
        return _hauptModal;
    }

    /**
     * Gibt das Preis-Label zurück
     * @return Das Preis-Label
     */
    JLabel getPreisLabel()
    {
        return _preisLabel;
    }

    /**
     * Gibt das Input-Feld zurück
     * @return Das Input-Feld
     */
    JFormattedTextField getInputFeld()
    {
        return _inputFeld;
    }

    /**
     * Gibt das Restbetrag-Label zurück
     * @return Das Restbetrag-Label
     */
    JLabel getRestbetragLabel()
    {
        return _restbetragLabel;
    }

    /**
     * Gibt das bezahlterBetrag Label zurück
     * @return Das bezahlte Betrag Label
     */
    JLabel getBezahlterbetragLabel()
    {
        return  _bezahlterbetragLabel;
    }
    
   
    /**
     * Gibt den OK-Button zurück
     * @return Der OK-Button
     */
    JButton getOkButton()
    {
        return _okButton;
    }

    /**
     * Gibt den Abbrechen-Button zurück
     * @return Der Abbrechen-Button
     */
    JButton getDismissButton()
    {
        return _dismissButton;
    }

    /**
     * Setzt die Label und das Inputfeld zurück (leer)
     */
    void reset()
    {
        _preisLabel.setText("");
        _inputFeld.setValue(null);
        _restbetragLabel.setText("");
        _bezahlterbetragLabel.setText("");
    }
}
