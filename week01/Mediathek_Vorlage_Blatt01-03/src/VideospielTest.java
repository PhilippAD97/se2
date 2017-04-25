import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author 6ralfs, 6gooss
 *
 */
public class VideospielTest {
	private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final String PLATFORM = "PS4";
    private Videospiel _videospiel1;
    
	/**
	 * 
	 */
	public VideospielTest() {
		_videospiel1 = getMedium();
	}
	
	@Test
    public void testGetMedienBezeichnung()
    {
        String videospielBezeichnung = BEZEICHNUNG;
        assertEquals(videospielBezeichnung, _videospiel1.getMedienBezeichnung());
    }
	
	@Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _videospiel1.getTitel());
        assertEquals(KOMMENTAR, _videospiel1.getKommentar());
        assertEquals(PLATFORM, _videospiel1.getPlatform());
    }

	protected Videospiel getMedium()
    {
        return new Videospiel(TITEL, KOMMENTAR, PLATFORM);
    }
}
