package mediathek.medien;
/**
 * 
 */

/**
 * @author 6ralfs, 6gooss
 *
 */
public class PCVideospiel extends AbstractVideospiel
{

    /**
     * Initialisiert ein neues PCVideospiel.
     * 
     * @param titel Der Titel des Spiels
     * @param kommentar Ein Kommentar zum Spiel
     * @param system Die Bezeichnung des System
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getSystem() == system
     */
    public PCVideospiel(String titel, String kommentar, String system)
    {
        super(titel, kommentar, system);
    }

    @Override
    public String getMedienBezeichnung()
    {
        return "PCVideospiel";
    }

    @Override
    public int getPreisNachTagen(int mietTage)
    {
        mietTage -= 7;
        return (int) (Math.ceil(mietTage / 5.0) * 500);
    }

}
