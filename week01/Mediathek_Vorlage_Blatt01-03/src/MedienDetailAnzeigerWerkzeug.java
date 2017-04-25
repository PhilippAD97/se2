import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Ein MedienDetailAnzeigerWerkzeug ist ein Werkzeug um die Details von Medien
 * anzuzeigen.
 * 
 * @author SE2-Team
 * @version SoSe 2017
 */
class MedienDetailAnzeigerWerkzeug
{
    private MedienDetailAnzeigerUI _ui;

    /**
     * Initialisiert ein neues MedienDetailAnzeigerWerkzeug.
     */
    public MedienDetailAnzeigerWerkzeug()
    {
        _ui = new MedienDetailAnzeigerUI();
    }

    /**
     * Setzt die Liste der Medien deren Details angezeigt werden sollen.
     * 
     * @param medien Eine Liste von Medien.
     * 
     * @require (medien != null)
     */
    public void setMedien(List<Medium> medien)
    {
        assert medien != null : "Vorbedingung verletzt: (medien != null)";
        JTextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea();
        
        String outputText = "";
        for (Medium medium : medien)
        {
//        	outputText += medium.getMedienBezeichnung();
//        	outputText += "\n" + medium.getTitel();
//        	outputText += "\n" + medium.getKommentar();
//        	
//        	switch(medium.getMedienBezeichnung())
//        	{
//        		case "DVD":
//        			if (medium instanceof DVD)
//        			{
//        				DVD dvd = (DVD) medium;
//        				outputText += "\nLaufzeit: " + dvd.getLaufzeit() + " min";
//        				outputText += "\n" + dvd.getRegisseur();
//        			}
//        			break;
//        		case "CD":
//        			if (medium instanceof CD)
//        			{
//        				CD cd = (CD) medium;
//        				outputText += "\nSpiellänge: " + cd.getSpiellaenge() + " min";
//        				outputText += "\n" + cd.getInterpret();
//        			}
//        			break;
//        		case "Videospiel":
//        			if (medium instanceof Videospiel)
//        			{
//        				Videospiel game = (Videospiel) medium;
//        				outputText += "\nPlattform: " + game.getPlatform();
//        			}
//        			break;
//    			default:
//    				break;
//        	}
//        	outputText += "\n\n";
        	
        	outputText += medium.getFormatiertenString() + "\n\n";
        }
        
        selectedMedienTextArea.setText(outputText);
    }

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _ui.getUIPanel();
    }
}
