package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// TODO: Quelltextkommentar
public class BarzahlungsWerkzeug
{
    private BarzahlungsWerkzeugUI _ui;
    private boolean _success;
    private int _totalAmount;
    private int _restAmount;

    // TODO: Quelltextkommentar
    public BarzahlungsWerkzeug()
    {
        _ui = new BarzahlungsWerkzeugUI();
        registriereUIAktionen();
    }

    // TODO: Quelltextkommentar
    public void start(int preis)
    {
        _success = false;
        _totalAmount = preis;
        _restAmount = -preis;
        _ui.getPreisLabel().setText(_totalAmount + " Eurocent");
        _ui.getRestbetragLabel().setText(_restAmount + " Eurocent");
        _ui.getOkButton().setEnabled(false);
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

    // TODO: Quelltextkommentar
    private void okButtonWurdeGeklickt()
    {
        _ui.getMainDialog().setVisible(false);
    }

    // TODO: Quelltextkommentar
    private void dismissButtonWurdeGeklickt()
    {
        _ui.reset();
        _ui.getMainDialog().setVisible(false);
    }

    // TODO: Quelltextkommentar
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

        _ui.getInputFeld().setValue(null);
        _ui.getRestbetragLabel().setText(_restAmount + " Eurocent");
        if (_restAmount >= 0)
        {
            _success = true;
            _ui.getOkButton().setEnabled(true);
        }
    }

    // TODO: Quelltextkommentar
    public boolean getSuccess()
    {
        return _success;
    }
}
