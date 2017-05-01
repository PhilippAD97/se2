/**
 * Abstract class for Medium class
 *
 * @author 6ralfs, 6gooss
 * @version 0.1.0
 */
abstract class AbstractMedium implements Medium
{
    protected String _titel;
    protected String _kommentar;

    @Override
    public String getTitel()
    {
        return _titel;
    }

    @Override
    public void setTitel(String titel)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        _titel = titel;
    }

    @Override
    public String getFormatiertenString() {
        return "    " + "Titel: " + _titel + "\n"
                + "    " + "Kommentar: " + _kommentar + "\n";
    }

    @Override
    public abstract String getMedienBezeichnung();

    @Override
    public String getKommentar()
    {
        return _kommentar;
    }

    @Override
    public void setKommentar(String kommentar)
    {
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        _kommentar = kommentar;
    }

    @Override
    public Geldbetrag berechneMietgebuehr(int mietTage)
    {
        assert mietTage > 0 : "Vorbedinung verletzt: mietTage > 0";
        return new Geldbetrag(300 * mietTage);
    }
}