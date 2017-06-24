package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
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
    private JButton _okButton;
    private JButton _dismissButton;

    // TODO: Quelltextkommentar
    BarzahlungsWerkzeugUI()
    {
        _hauptModal = erzeugeModal();
    }

    /**
     * Erstellt das Modal mit den Widgets.
     */
    private JDialog erzeugeModal()
    {
        // Create JDialog as modal
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Barzahlung");

        // Set Layout, Border and Size
        dialog.setLayout(new GridLayout(4, 1, 4, 0));
        dialog.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialog.setSize(220, 220);

        // Preis-Panel
        JPanel preisPanel = new JPanel();
        preisPanel.setLayout(new GridLayout(1, 2));
        preisPanel.add(new JLabel("Preis:"));
        _preisLabel = new JLabel();
        preisPanel.add(_preisLabel);
        dialog.add(preisPanel);

        // Text-Input
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        _inputFeld = new JFormattedTextField(formatter);
        dialog.add(_inputFeld);

        // Restbetrag-Panel
        JPanel restbetragPanel = new JPanel();
        restbetragPanel.setLayout(new GridLayout(1, 2));
        restbetragPanel.add(new JLabel("Restbetrag:"));
        _restbetragLabel = new JLabel();
        restbetragPanel.add(_restbetragLabel);
        dialog.add(restbetragPanel);

        // OK / Abbrechen - Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        _okButton = new JButton("OK");
        _okButton.setEnabled(false);
        _dismissButton = new JButton("Abbrechen");
        buttonPanel.add(_dismissButton);
        buttonPanel.add(_okButton);
        dialog.add(buttonPanel);

        // Center on display
        dialog.setLocationRelativeTo(null);

        return dialog;
    }

    // TODO: Quelltextkommentar
    public JDialog getMainDialog()
    {
        return _hauptModal;
    }

    // TODO: Quelltextkommentar
    public JLabel getPreisLabel()
    {
        return _preisLabel;
    }

    // TODO: Quelltextkommentar
    public JFormattedTextField getInputFeld()
    {
        return _inputFeld;
    }

    // TODO: Quelltextkommentar
    public JLabel getRestbetragLabel()
    {
        return _restbetragLabel;
    }

    // TODO: Quelltextkommentar
    public JButton getOkButton()
    {
        return _okButton;
    }

    // TODO: Quelltextkommentar
    public JButton getDismissButton()
    {
        return _dismissButton;
    }
    
    // TODO: Quelltextkommentar
    public void reset()
    {
        _preisLabel.setText("");
        _inputFeld.setValue(null);
        _restbetragLabel.setText("");
    }
}
