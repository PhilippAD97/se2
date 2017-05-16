package mediathek.medien;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mediathek.fachwerte.Geldbetrag;

/**
 */
public class PCVideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "PCVideospiel";
    private static final String SYSTEM = "System";
    private PCVideospiel _PCVideospiel;

    @Before
    public void setUp()
    {
        _PCVideospiel = getMedium();
    }

    @Test
    public void testeKonstruktoren()
    {
        assertEquals(TITEL, _PCVideospiel.getTitel());
        assertEquals(KOMMENTAR, _PCVideospiel.getKommentar());
        assertEquals(SYSTEM, _PCVideospiel.getSystem());
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String PCVideospielBezeichnung = BEZEICHNUNG;
        assertEquals(PCVideospielBezeichnung,
                _PCVideospiel.getMedienBezeichnung());
    }

    protected PCVideospiel getMedium()
    {
        return new PCVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }

    @Test
    public final void testSetKommentar()
    {
        PCVideospiel medium = getMedium();
        medium.setKommentar("Kommentar2");
        assertEquals(medium.getKommentar(), "Kommentar2");
    }

    @Test
    public final void testSetTitel()
    {
        PCVideospiel medium = getMedium();
        medium.setTitel("Titel2");
        assertEquals(medium.getTitel(), "Titel2");
    }

    @Test
    public void testMietgebuehrberechnung()
    {
        assertEquals(_PCVideospiel.berechneMietgebuehr(7), new Geldbetrag(200));
        assertEquals(_PCVideospiel.berechneMietgebuehr(8), new Geldbetrag(700));
        assertEquals(_PCVideospiel.berechneMietgebuehr(13),
                new Geldbetrag(1200));
        assertEquals(_PCVideospiel.berechneMietgebuehr(18),
                new Geldbetrag(1700));
    }

}
