package de.uni_hamburg.informatik.swt.se2.kino.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.datumsauswaehler.DatumAuswaehlWerkzeug;

public class BeobachtbarTest extends Beobachtbar
{

    private DatumAuswaehlWerkzeug _datumAuswaehlWerkzeug = new DatumAuswaehlWerkzeug();

    Beobachter _beobachter = new Beobachter()
    {
        @Override
        public void beachteAenderung()
        {

        }
    };

    @Test
    public void TesteBeobachterHinzufuegen()
    {

        _datumAuswaehlWerkzeug.setzeBeobachter(_beobachter);

        assertTrue(_datumAuswaehlWerkzeug.istBeobachter(_beobachter));
    }

    @Test
    public void TesteBeobachterEntfernen()
    {

        _datumAuswaehlWerkzeug.setzeBeobachter(_beobachter);
        _datumAuswaehlWerkzeug.entferneBeobachter(_beobachter);

        assertFalse(_datumAuswaehlWerkzeug.istBeobachter(_beobachter));
    }

}
