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

    private final Medium _medium;
    private final int MAX_VORMERKER = 3;
    private List<Kunde> _vormerkerListe = new ArrayList<Kunde>(MAX_VORMERKER);
    
    /**
     * Erzeugt eine neue Vormerkkarte
     * 
     * @param medium    Das Medium, für welches die Vormerkkarte gilt
     */
    public Vormerkkarte(Medium medium)
    {
        assert medium != null : "Vorbedingung verletzt: medium != null";
        _medium = medium;
    }
    
    /**
     * Erzeugt eine neue Vormerkkarte 
     * und speichert sofort einen Kunden als Vormerker
     * 
     * @param medium    Das Medium, für welches die Vormerkkarte gilt
     * @param kunden    Ein Kunde, welcher dieses Medium vormerken möchte
     */
    public Vormerkkarte(Medium medium, Kunde kunde)
    {
        assert medium != null : "Vorbedingung verletzt: medium != null";
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        _medium = medium;
        addVormerker(kunde);
    }
    
    /**
     * Fügt einen Kunden als Vormerker hinzu
     * @param kunde     Der Kunde, welcher vormerkt werden soll
     * 
     * @require kunde != null
     * @require istVormerkbar() == true
     * 
     * @ensure hatKundeVorgemerkt() == true 
     */
    public void addVormerker(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        assert istVormerkbar(kunde) != false : "Vorbedingung verletzt: istVormerkbar(kunde) != false";
        _vormerkerListe.add(kunde);
    }
    
    /**
     * Gibt den ersten Vormerker aus der Liste zurück
     * 
     * @return      Den ersten Vormerker für diese Vormerkkarte
     */
    public Kunde gibErsteVormerkung() {
        return _vormerkerListe.get(0);
    }
    
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
     */
    public boolean istVormerkbar(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        // Das Medium ist vormerkbar, wenn der Kunde nicht bereits vorgemerkt hat
        // und die VormerkerListe kleiner als die maximal erlaubte Anzahl an Vormerkern ist
        return (!hatKundeVorgemerkt(kunde) && _vormerkerListe.size() < MAX_VORMERKER);
    }
    
    // TODO Auslagern in den Verleihservice
    public boolean hatKundeVorgemerkt(Kunde kunde)
    {
        for (int i = 0; i < _vormerkerListe.size(); i++)
        {
            if (_vormerkerListe.get(i).equals(kunde))
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
    public Medium getMedium() {
        return _medium;
    }
}
