package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.lang.Integer;

/**
 * Eurowert
 */
public final class Geldbetrag
{
    final int _eurocent;

    private Geldbetrag(int eurocent)
    {
        _eurocent = eurocent;
    }

    /**
     * Wählt einen Eurowert aus (eurostring).
     *
     * @param eurostring Der Eurowert als String
     *
     * @require isValid(eurostring)
     */
    public static Geldbetrag parse(String eurostring)
    {
        assert isValid(
                eurostring) : "Vorbedingung verletzt: isValid(eurostring)";

        String[] parts = eurostring.split(",");
        int euro;
        int cent = 0;
        try
        {
            euro = Integer.parseInt(parts[0]);
        }
        catch (NumberFormatException e)
        {
            euro = 0;
        }

        // Wenn es Nachkommastellen gibt, versuche zu parsen
        if (parts.length > 1)
        {
            try
            {
                cent = Integer.parseInt(parts[1]);

                // Wenn es nur 1 Nachkommastelle gab, muss cent * 10 gerechnet werden
                if (parts[1].length() < 2)
                {
                    cent *= 10;
                }
            }
            catch (NumberFormatException e)
            {
                cent = 0;
            }
        }

        int totalCent = euro * 100 + cent;
        return new Geldbetrag(totalCent);
    }

    /**
     * Wählt einen Eurowert aus (eurocent).
     *
     * @param eurocent Der Eurocent-Wert als int
     *
     * @require isValid(eurocent)
     */
    public static Geldbetrag parse(int eurocent)
    {
        assert isValid(eurocent) : "Vorbedinung verletzt: isValid(eurocent)";

        return new Geldbetrag(eurocent);
    }

    public static boolean isValid(String geldbetrag)
    {
        return geldbetrag.matches("^(\\d{1,2},\\d{1,2}|,\\d{1,2}|\\d{1,2})$");
    }

    public static boolean isValid(int geldbetrag)
    {
        return geldbetrag > 0;
    }

    @Override public boolean equals(Object obj)
    {
        // Typzusicherung
        if (obj instanceof Geldbetrag)
        {
            Geldbetrag geldbetrag = (Geldbetrag) obj;
            return geldbetrag.getString().equals(this.getString());
        }
        return false;
    }

    @Override public int hashCode()
    {
        return _eurocent;
    }

    public String getString()
    {
        // Zerofill Euro
        String zeroFilledEuro = "" + _eurocent / 100;
        if (zeroFilledEuro.length() < 2)
        {
            zeroFilledEuro = "0" + zeroFilledEuro;
        }

        // Zerofill Cent
        String zeroFilledCent = "" + _eurocent % 100;
        if (zeroFilledCent.length() < 2)
        {
            zeroFilledCent = zeroFilledCent + "0";
        }

        return zeroFilledEuro + "," + zeroFilledCent;
    }

    public int getAsEurocent()
    {
        return _eurocent;
    }

    public Geldbetrag add(Geldbetrag geldbetrag)
    {
        // Return Max Integer, wenn einer der Summanden Max Integer ist
        // TODO: glaube das macht so keinen Sinn
        if (geldbetrag.getAsEurocent() == Integer.MAX_VALUE
                || _eurocent == Integer.MAX_VALUE) {
            return new Geldbetrag(Integer.MAX_VALUE);
        }
        return new Geldbetrag(geldbetrag.getAsEurocent() + _eurocent);
    }

    public Geldbetrag sub(Geldbetrag geldbetrag)
    {
        return new Geldbetrag(geldbetrag.getAsEurocent() - _eurocent);
    }

    public Geldbetrag multiply(int n)
    {
        return new Geldbetrag(_eurocent * n);
    }

}