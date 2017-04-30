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
    public abstract String getFormatiertenString();

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
}