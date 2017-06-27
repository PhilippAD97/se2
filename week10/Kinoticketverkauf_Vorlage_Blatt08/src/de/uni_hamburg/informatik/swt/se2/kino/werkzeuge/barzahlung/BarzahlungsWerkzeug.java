package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Mit diesem Werkzeug findet die Barbezahlung statt.
 *
 * @author Fruchtzwerge
 * @version SoSe 2017
 */
public class BarzahlungsWerkzeug
{
    private BarzahlungsWerkzeugUI _ui;
    private boolean _success;
    private int _totalAmount;
    private int _restAmount;

    /**
     * Erzeugt ein neues Exemplar
     */
    public BarzahlungsWerkzeug()
    {
        _ui = new BarzahlungsWerkzeugUI();
        registriereUIAktionen();
    }

    /**
     * Startet den Barzahlungsprozess
     * @param preis Der zu zahlende Preis
     */
    public void start(int preis)
    {
        _success = false;
        _totalAmount = preis;
        _restAmount = -preis;
        _ui.getPreisLabel().setText(_totalAmount + " Eurocent");
        _ui.getRestbetragLabel().setText(_restAmount + " Eurocent");
        _ui.getOkButton().setEnabled(false);
        _ui.getInputFeld().requestFocus();
        _ui.getMainDialog().setVisible(true);
    }

    /**
     * Verbindet die fachlichen Aktionen mit den Interaktionselementen der
     * graphischen Benutzungsoberfläche.
     */
    private void registriereUIAktionen()
    {
        // OK-Button Click
        _ui.getOkButton().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                okButtonWurdeGeklickt();
            }
        });

        // Dismiss-Button Click
        _ui.getDismissButton().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                dismissButtonWurdeGeklickt();
            }
        });

        // Window close
        _ui.getMainDialog().addWindowListener(new WindowAdapter()
        {
            @Override public void windowClosed(WindowEvent e)
            {
                dismissButtonWurdeGeklickt();
            }

            @Override public void windowClosing(WindowEvent e)
            {
                dismissButtonWurdeGeklickt();
            }
        });

        // Input submit
        _ui.getInputFeld().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                betragWurdeEingegeben();
            }
        });
    }

    /**
     * Reagiert darauf, wenn der OK-Button geklickt wurde.
     */
    private void okButtonWurdeGeklickt()
    {
        _ui.getMainDialog().setVisible(false);
    }

    /**
     * Reagiert darauf, wenn der Abbrechen-Button geklickt wurde.
     */
    private void dismissButtonWurdeGeklickt()
    {
        _success = false;
        _ui.reset();
        _ui.getMainDialog().setVisible(false);
    }

    /**
     * Reagiert darauf, wenn ein Betrag in das Eingabefeld
     * eingegeben wurde.
     */
    private void betragWurdeEingegeben()
    {
        try
        {
            _restAmount += Integer.parseInt(_ui.getInputFeld().getText());
        }
        catch (NumberFormatException err)
        {
            // TODO: handle Error
        }

        // Reset InputField
        _ui.getInputFeld().setValue(null);

        // Update label text
        _ui.getRestbetragLabel().setText(_restAmount + " Eurocent");

        // Set _success variable to true in case >100% has been paid
        if (_restAmount >= 0)
        {
            _success = true;

            // Activate OK-Button
            _ui.getOkButton().setEnabled(true);
        }
    }

    /**
     * Gibt den Erfolgs-Zustand des Bezahlvorgangs zurück
     * @return Der Erfolgs-Zustand
     */
    public boolean getSuccess()
    {
        return _success;
    }
}
