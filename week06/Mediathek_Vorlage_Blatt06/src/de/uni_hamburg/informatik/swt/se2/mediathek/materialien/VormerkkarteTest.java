package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;

public class VormerkkarteTest
{
    private Vormerkkarte _karte;
    private Kunde _kunde1;
    private Kunde _kunde2;
    private Kunde _kunde3;
    private Kunde _kunde4;
    private Medium _medium;

    public VormerkkarteTest()
    {
        _kunde1 = new Kunde(new Kundennummer(123456), "ich", "du");
        _kunde2 = new Kunde(new Kundennummer(123457), "er", "sie");
        _kunde3 = new Kunde(new Kundennummer(123458), "es", "wir");
        _kunde4 = new Kunde(new Kundennummer(123458), "ihr", "sie");
        _medium = new CD("bar", "baz", "foo", 123);
        _karte = new Vormerkkarte(_medium);
    }

    @Test
    public void testeKonstruktor() throws Exception
    {
        // Teste, ob das Medium richtig gesetzt wurde
        assertEquals(_medium, _karte.getMedium());
    }
    
    @Test
    public void testeIstVormerkbar()
    {
        // Versuche, mit dem selben Kunden 2-mal vorzumerken
        _karte.addVormerker(_kunde1);
        assertEquals(_karte.istVormerkbar(_kunde1), false);
        
        // Versuche, einen 4ten Kunden vorzumerken
        _karte.addVormerker(_kunde2);
        _karte.addVormerker(_kunde3);
        assertEquals(_karte.istVormerkbar(_kunde4), false);
    }
    
    @Test
    public void testeVormerken()
    {
        // Erstmal alle Vormerkungen löschen
        _karte.entferneErsteVormerkung();
        _karte.entferneErsteVormerkung();
        _karte.entferneErsteVormerkung();
        
        // Füge 3 Vormerkungen hinzu und teste,
        // ob die erste Vormerkung auch tatsächlich die erste Vormerkung war
        _karte.addVormerker(_kunde4);
        _karte.addVormerker(_kunde2);
        _karte.addVormerker(_kunde3);
        assertEquals(_karte.gibErsteVormerkung() ,_kunde4);
    }
}
