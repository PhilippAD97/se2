package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.ArrayList;
import java.util.List;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Mit Hilfe von Vormerkkarten werden beim Vormerken eines Mediums alle relevanten
 * Daten notiert.
 * 
 * @author Fruchtzwerge
 *
 */
public class Vormerkkarte
{

    private final Medium MEDIUM;
    private final int MAX_VORMERKER = 3;
    private List<Kunde> _vormerkerListe = new ArrayList<Kunde>(MAX_VORMERKER);

    /**
     * Erzeugt eine neue Vormerkkarte
     * 
     * @param medium    Das Medium, für welches die Vormerkkarte gilt
     * 
     * @require kunde != null
     */
    public Vormerkkarte(Medium medium)
    {
        assert medium != null : "Vorbedingung verletzt: medium != null";
        MEDIUM = medium;
    }

    /**
     * Erzeugt eine neue Vormerkkarte 
     * und speichert sofort einen Kunden als Vormerker
     * 
     * @param medium    Das Medium, für welches die Vormerkkarte gilt
     * @param kunde     Ein Kunde, welcher dieses Medium vormerken möchte
     * 
     * @require medium != null
     * @require kunde != null
     */
    public Vormerkkarte(Medium medium, Kunde kunde)
    {
        assert medium != null : "Vorbedingung verletzt: medium != null";
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        MEDIUM = medium;
        addVormerker(kunde);
    }

    /**
     * Fügt einen Kunden als Vormerker hinzu
     * @param kunde     Der Kunde, welcher vorgemerkt werden soll
     * 
     * @require kunde != null
     * @require istVormerkbar() == true
     * 
     * @ensure hatKundeVorgemerkt() == true 
     */
    public void addVormerker(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        assert istVormerkbar(
                kunde) != false : "Vorbedingung verletzt: istVormerkbar(kunde) != false";
        _vormerkerListe.add(kunde);
    }

    /**
     * Gibt den ersten Vormerker aus der Liste zurück
     * 
     * @return      Den ersten Vormerker für diese Vormerkkarte
     */
    public Kunde gibErsteVormerkung()
    {
        return _vormerkerListe.get(0);
    }

    /**
     * Gibt die gesamte Vormerkerliste aus
     * @return      Eine Liste an Vormerkungen
     */
    public List<Kunde> gibAlleVormerkungen()
    {
        return _vormerkerListe;
    }

    /**
     * Entfernt den ersten Vormerker aus der Liste
     */
    public void entferneErsteVormerkung()
    {
        // Sonst gibts IndexOutOfBoundsException
        if (_vormerkerListe.size() > 0)
        {
            _vormerkerListe.remove(0);
        }
    }

    /**
     * Prüft, ob eine Vormerkung für einen speziellen Kunden möglich ist
     * 
     * @param kunde     Der Kunde, für den die Überprüfung stattfinden soll
     * @return          true, wenn Vormerkung möglich ist, sonst false
     * 
     * @require kunde != null
     */
    public boolean istVormerkbar(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        // Das Medium ist vormerkbar, wenn der Kunde nicht bereits vorgemerkt hat
        // und die VormerkerListe kleiner als die maximal erlaubte Anzahl an Vormerkern ist
        return (!hatKundeVorgemerkt(kunde)
                && _vormerkerListe.size() < MAX_VORMERKER);
    }

    /**
     * Prüft, ob ein Kunde vorgemerkt hat.
     * 
     * @param kunde  Der Kunde, für den die Überprüfung stattfinden soll
     * @return true, wenn Kunde vorgemerkt hat, sonst false 
     * 
     * @require kunde != null
     */
    public boolean hatKundeVorgemerkt(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        
        for (int i = 0; i < _vormerkerListe.size(); i++)
        {
            if (_vormerkerListe.get(i)
                .equals(kunde))
            {
                // Sobald eine Übereinstimmung gefunden wurde,
                // kann sofort true zurückgegeben werden
                return true;
            }
        }
        return false;
    }

    /**
     * Gibt das Medium für diese Vormerkkarte zurück
     * 
     * @return      Ein Medium
     */
    public Medium getMedium()
    {
        return MEDIUM;
    }
}
