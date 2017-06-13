package de.uni_hamburg.informatik.swt.se2.kino.services;

import java.util.HashSet;

/**
 * Kann Beobachter registieren und Änderungen melden
 */
abstract public class Beobachtbar
{

    private HashSet<Beobachter> _beobachterSet;

    /**
     * Erzeugt ein neues Exemplar
     */
    Beobachtbar()
    {
        _beobachterSet = new HashSet<Beobachter>();
    }

    /**
     * Fügt einen Beobachter der Liste hinzu
     * @param b     Ein Beobachter
     *
     * @require b != null
     *
     * @ensure istBeobachter(b) == true
     */
    public void setzeBeobachter(Beobachter b)
    {
        assert b != null : "Vorbedingung verletzt: b != null";
        _beobachterSet.add(b);
    }

    /**
     * Entfernt einen Beobachter aus der Liste
     * @param b     Ein Beobachter
     *
     * @require b != null
     *
     * @ensure istBeobachter(b) == false
     */
    public void entferneBeobachter(Beobachter b)
    {
        assert b != null : "Vorbedingung verletzt: b != null";
        _beobachterSet.remove(b);
    }

    /**
     * Prüft ob ein Beobachter registriert ist
     * @param b     Ein Beobachter
     *
     * @require b != null
     */
    public boolean istBeobachter(Beobachter b)
    {
        assert b != null : "Vorbedingung verletzt: b != null";
        return _beobachterSet.contains(b);
    }

    /**
     * Ruft an jedem Beobachter 'beachteAenderung' auf
     */
    protected void meldeAenderung()
    {
        for (Beobachter b : _beobachterSet)
        {
            b.beachteAenderung();
        }
    }
}
