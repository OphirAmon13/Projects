package edu.yu.intro;

import java.util.HashSet;
import java.util.Set;

public enum Patrons{
    Singleton;

    private final Set<Patron> patrons;

    private Patrons(){
        this.patrons = new HashSet<>();
    }

    public void add(Patron patron){
        if(patron == null){
            throw new IllegalArgumentException("Patron cannot be null");
        }
        patrons.add(patron);
    }

    public void clear(){
        patrons.clear();
    }

    public Patron get(String uuid){
        if(uuid == null || uuid.trim().isEmpty()){
            throw new IllegalArgumentException("UUID cannot be null or empty");
        }
        for(Patron patron : patrons){
            if(patron.getID().equals(uuid)){
                return patron;
            }
        }
        return null;
    }

    public int nPatrons(){
        return patrons.size();
    }

    public Set<Patron> byLastNamePrefix(final String prefix){
        if(prefix == null){
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        Set<Patron> matches = new HashSet<>();
        if(prefix.isEmpty()){
            matches.addAll(patrons);
            return matches;
    }
        for(Patron patron : patrons){
            if(patron.getLastName().startsWith(prefix)){
                matches.add(patron);
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        Patron patron1 = new Patron("ophir", "amon", "YU");
        Patron patron2 = new Patron("john", "amin", "random lane");
        Patrons.Singleton.add(patron1);
        Patrons.Singleton.add(patron2);
        System.out.println(Patrons.Singleton.nPatrons());

        String uuid = patron1.getID();
        Patron p = Patrons.Singleton.get(uuid);

        System.out.println(patron1.equals(p));
        System.out.println(patron2.equals(p));

        System.out.println(Patrons.Singleton.byLastNamePrefix(""));

        Patrons.Singleton.clear();
        System.out.println(Patrons.Singleton.nPatrons());

    }
}