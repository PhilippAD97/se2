package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.lang.Integer;

/**
 * Ein Geldbetrag
 *
 * @author Fruchtzwerge
 */
public final class Geldbetrag
{
    private final int _eurocent;
    private static final String _currency = "€";

    /**
     * Erzeugt einen neuen Geldbetrag
     *
     * @param eurocent          Der Betrag in Eurocent
     */
    private Geldbetrag(int eurocent)
    {
        _eurocent = eurocent;
    }

    /**
     * Wählt einen Eurowert aus (eurostring).
     *
     * @param eurostring        Der Eurowert als String
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

        // Wenn es Nachkommastellen gibt, versuche sie zu parsen
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
     * @param eurocent          Der Eurocent-Wert als int
     *
     * @require isValid(eurocent)
     */
    public static Geldbetrag parse(int eurocent)
    {
        assert isValid(eurocent) : "Vorbedinung verletzt: isValid(eurocent)";

        return new Geldbetrag(eurocent);
    }

    /**
     * Prüft, ob ein String ein valider Geldbetrag ist
     *
     * @param geldbetrag        Der zu prüfende String
     * @return true, wenn es sich hierbei um einen gültigen Geldbetrag handelt, sonst false
     */
    public static boolean isValid(String geldbetrag)
    {
        return geldbetrag.matches("^(\\d{1,2},\\d{1,2}|,\\d{1,2}|\\d{1,2})$");
    }

    /**
     * Prüft, ob ein Integer ein valider Geldbetrag ist
     *
     * @param geldbetrag        Der zu prüfende Integer
     * @return true, wenn es sich hierbei um einen gültigen Geldbetrag handelt, sonst false
     */
    public static boolean isValid(int geldbetrag)
    {
        return geldbetrag >= 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        // Typzusicherung
        if (obj instanceof Geldbetrag)
        {
            Geldbetrag geldbetrag = (Geldbetrag) obj;
            return geldbetrag.hashCode() == this.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return _eurocent;
    }

    /**
     * Fülle Beträge kleiner 10 mit einer führenden 0 auf.
     * @return Zahl als String
     */
    private String zeroFill(int number)
    {
        if (number < 10) {
            return "0" + number;
        }

        return "" + number;
    }

    /**
     * Gibt den Geldbetrag als formatierten String der Form "EE.CC" zurück
     * @return Der Geldbetrag als String
     */
    public String getString()
    {
        int cent = _eurocent % 100;
        int euro = (_eurocent - cent) / 100;

        // Zerofill Euro
        String zeroFilledEuro = zeroFill(euro);

        // Zerofill Cent
        String zeroFilledCent = zeroFill(cent);

        return zeroFilledEuro + "," + zeroFilledCent;
    }

    /**
     * Gibt den Geldbetrag als Eurocent zurück
     * @return Der Betrag in Eurocent
     */
    public int getAsEurocent()
    {
        return _eurocent;
    }

    /**
     * Addiert einen Geldbetrag
     *
     * @param geldbetrag        Der zu addierende Geldbetrag
     * @return Das Ergebnis der Addition
     */
    public Geldbetrag add(Geldbetrag geldbetrag)
    {
        assert isAdditionPossible(geldbetrag) :
            "Vorbedinung verletzt: isAdditionPossible(geldbetrag)";
        if (geldbetrag.getAsEurocent() == Integer.MAX_VALUE
                || _eurocent == Integer.MAX_VALUE)
        {
            return new Geldbetrag(Integer.MAX_VALUE);
        }
        return new Geldbetrag(_eurocent + geldbetrag.getAsEurocent());
    }

    /**
     * Subtrahiert einen Geldbetrag
     *
     * @param geldbetrag        Der zu subtrahierende Geldbetrag
     * @return Das Ergebnis der Subtraktion
     *
     * @require isSubtractionPossible(geldbetrag)
     */
    public Geldbetrag sub(Geldbetrag geldbetrag)
    {
        assert isSubtractionPossible(geldbetrag) :
            "Vorbedinung verletzt: isSubtractionPossible(geldbetrag)";
        return new Geldbetrag(_eurocent - geldbetrag.getAsEurocent());
    }

    /**
     * Multipliziert mit einer natürlichen Zahl
     *
     * @param n                 Der Faktor
     * @return Das Ergebnis der Multiplikation
     *
     * @require isMultiplicationPossible(n)
     */
    public Geldbetrag multiply(int n)
    {
        assert isMultiplicationPossible(n) :
            "Vorbedinung verletzt: isMultiplicationPossible(n)";
        return new Geldbetrag(_eurocent * n);
    }

    /**
     * Prüft, ob die Addition möglich ist
     *
     * @param other             Der zu addierende Geldbetrag
     * @return true, wenn Addition möglich ist, sonst false
     */
    public boolean isAdditionPossible(Geldbetrag other)
    {
        int otherEurocent = other.getAsEurocent();
        return ((long) this._eurocent + (long) otherEurocent)
                < Integer.MAX_VALUE;
    }

    /**
     * Prüft, ob die Subtraktion möglich ist
     *
     * @param other             Der zu subtrahierdende Geldbetrag
     * @return true, wenn Subtraktion möglich ist, sonst false
     */
    public boolean isSubtractionPossible(Geldbetrag other)
    {
        int otherEurocent = other.getAsEurocent();
        long newValue = (long) this._eurocent - (long) otherEurocent;
        boolean notNegative = newValue >= 0;
        boolean noOverflow = newValue > Integer.MIN_VALUE;

        return notNegative && noOverflow;
    }

    /**
     * Prüft, ob Multiplikation möglich ist
     *
     * @param n                 Der Faktor
     * @return true, wenn Multiplikation möglich ist, sonst false
     */
    public boolean isMultiplicationPossible(int n)
    {
        long newValue = (long) this._eurocent * (long) n;
        return newValue >= 0 && newValue < Integer.MAX_VALUE;
    }

    /**
     * Gibt das Währungszeichen zurück
     * @return Das Währungszeichen
     */
    public static String getCurrency()
    {
        return _currency;
    }

    /**
     * Gibt die Differenz zwischen zwei Geldbeträgen zurück (immer positiv!)
     * @param other             Der andere Geldbetrag
     * @return Einen neuen Geldbetrag, der die Differenz angibt
     */
    public Geldbetrag difference(Geldbetrag other)
    {
        return parse(Math.abs(_eurocent - other.getAsEurocent()));
    }

}