import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 */
public class KonsolenVideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "KonsolenVideospiel";
    private static final String SYSTEM = "System";
    private KonsolenVideospiel _KonsolenVideospiel;

    @Before
    public void setUp()
    {
        _KonsolenVideospiel = getMedium();
    }

    @Test
    public void testeKonstruktoren()
    {
        assertEquals(TITEL, _KonsolenVideospiel.getTitel());
        assertEquals(KOMMENTAR, _KonsolenVideospiel.getKommentar());
        assertEquals(SYSTEM, _KonsolenVideospiel.getSystem());
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String KonsolenVideospielBezeichnung = BEZEICHNUNG;
        assertEquals(KonsolenVideospielBezeichnung,
                _KonsolenVideospiel.getMedienBezeichnung());
    }

    protected KonsolenVideospiel getMedium()
    {
        return new KonsolenVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }

    @Test
    public final void testSetKommentar()
    {
        KonsolenVideospiel medium = getMedium();
        medium.setKommentar("Kommentar2");
        assertEquals(medium.getKommentar(), "Kommentar2");
    }

    @Test
    public final void testSetTitel()
    {
        KonsolenVideospiel medium = getMedium();
        medium.setTitel("Titel2");
        assertEquals(medium.getTitel(), "Titel2");
    }

    @Test
    public void testMietgebuehrberechnung()
    {
        assertEquals(_KonsolenVideospiel.berechneMietgebuehr(1),
                new Geldbetrag(200));
        assertEquals(_KonsolenVideospiel.berechneMietgebuehr(3),
                new Geldbetrag(900));
        assertEquals(_KonsolenVideospiel.berechneMietgebuehr(4),
                new Geldbetrag(900));
        assertEquals(_KonsolenVideospiel.berechneMietgebuehr(6),
                new Geldbetrag(1600));
    }

}
