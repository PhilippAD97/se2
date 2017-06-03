package de.uni_hamburg.informatik.swt.se2.kino.services;

import java.util.HashSet;

/**
 * Kann Beobachter registieren und Änderungen melden
 */
abstract public class Beobachtbar
{

    private HashSet<Beobachter> _beobachter;

    /**
     * Erzeugt ein neues Exemplar
     */
    protected Beobachtbar()
    {
        _beobachter = new HashSet<Beobachter>();
    }

    /**
     * Fügt einen Beobachter der Liste hinzu
     * @param b     Ein Beobachter
     */
    public void setzeBeobachter(Beobachter b)
    {
        _beobachter.add(b);
    }

    /**
     * Entfernt einen Beobachter aus der Liste
     * @param b     Ein Beobachter
     */
    public void entferneBeobachter(Beobachter b)
    {
        _beobachter.remove(b);
    }

    /**
     * Ruft an jedem Beobachter 'beachteAenderung' auf
     */
    protected void meldeAenderung()
    {
        for (Beobachter b : _beobachter)
        {
            b.beachteAenderung();
        }
    }
}
