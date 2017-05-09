package mediathek.services;
import java.io.FileWriter;
import java.io.IOException;

import mediathek.materialien.Verleihkarte;
import mediathek.medien.Medium;

/**
 * VerleihProtokolierer ist eine Klasse, die Methoden zur Protokollierung von Verleih-Operationen.
 * 
 * @author 6gooss, 6ralfs
 * @version SoSe 2017
 */
public class VerleihProtokollierer
{
    /**
     * Schreibt ereignis auf die Konsole
     * @param ereignis Rückgabe / Ausleihe
     * @param verleihkarte
     * 
     * @require ereignis != null
     * @require ereignis.length() != 0
     * @require verleihkarte != null
     */
    public static void protokolliere(String ereignis, Verleihkarte verleihkarte) throws ProtokollierException
    {
        assert ereignis != null : "Vorbedingung verletzt: eregnis != null";
        assert ereignis
            .length() != 0 : "Vorbedingung verletzt: eregnis.length() != 0";
        assert verleihkarte != null : "Vorbedingung verletzt: verleihkarte != null";

        Medium medium = verleihkarte.getMedium();
        String logStatement = ereignis + ": " + medium.getTitel() + " ("
                + medium.getMedienBezeichnung() + ")\n";

        try (FileWriter fileWriter = new FileWriter("./protokoll.txt", true);)
        {
            fileWriter.write(logStatement);
            fileWriter.append(System.getProperty("line.separator"));
        }
        catch (IOException e)
        {
            throw new ProtokollierException("Konnte Datei nicht schreiben");
        }
    }
}
