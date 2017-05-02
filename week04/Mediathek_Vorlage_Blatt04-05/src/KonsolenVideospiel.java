/**
 * 
 */

/**
 * @author 6ralfs, 6gooss
 *
 */
public class KonsolenVideospiel extends AbstractVideospiel
{

    /**
     * Initialisiert ein neues KonsolenVideospiel.
     * 
     * @param titel Der Titel des Spiels
     * @param kommentar Ein Kommentar zum Spiel
     * @param system Die Bezeichnung des System
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getSystem() == system
     */
    public KonsolenVideospiel(String titel, String kommentar, String system)
    {
        super(titel, kommentar, system);
    }

    @Override
    public String getMedienBezeichnung()
    {
        return "KonsolenVideospiel";
    }

    @Override
    public int getPreisNachTagen(int mietTage)
    {
        return (int) (Math.floor(mietTage / 3.0) * 700);
    }

}
