/**
 * Videospiel
 * 
 * @author 6ralfs, 6gooss
 * @version 0.1.0
 *
 */
public class Videospiel implements Medium {
	/**
     * Ein Kommentar zum Medium
     */
    private String _kommentar;

    /**
     * Der Titel des Mediums
     */
    private String _titel;
    
    /**
     * Die Platform des Mediums
     */
    private String _platform;

	/**
	 * Initialisiert eine neues Videospiel mit den gegebenen Daten.
	 *  
	 * @param titel Titel des Videospiels
	 * @param kommentar Kommentar zu dem Videospiel
	 * 
	 * @require titel != null
     * @require kommentar != null
     * @require platform != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getPlatform() == platform
	 */
	public Videospiel(String titel, String kommentar, String platform) {
		 assert titel != null : "Vorbedingung verletzt: titel != null";
	     assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
	     assert platform != null : "Vorbedingung verletzt: platform != null";
	        
		_titel = titel;
		_kommentar = kommentar;
		_platform = platform;
	}

	@Override
	public String getKommentar() {
		return _kommentar;
	}

	@Override
	public String getMedienBezeichnung() {
		return "Videospiel";
	}

	@Override
	public String getTitel() {
		return _titel;
	}

	public String getPlatform() {
		return _platform;
	}
	
	@Override
    public String getFormatiertenString()
    {
		
    	return getTitel() + "\n" + getKommentar() + "\nPlattform: " + getPlatform();
    }

}
