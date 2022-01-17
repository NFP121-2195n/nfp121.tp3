package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0) taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine()) throw new PilePleineException();
        
        nombre ++;
        if(estVide()) {stk = new Maillon(o, null);}
        else {
            Maillon maill = new Maillon(o, stk);
            stk = maill;
        }
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        
        nombre --;
        Maillon maillon_a_enleve = stk;
        stk = stk.suivant();
        return maillon_a_enleve.element();
    }

    public Object sommet() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return stk.element();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk == null;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite == nombre;
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        String str = "[";
                
        //[a, b] [b, c] [c, d] [d, e] [e, null] --> [a, b, c, d, e]
        if(stk!=null){
            Maillon current_maillon = stk;
            String str_to_add = current_maillon.element().toString();
            str += str_to_add;
            int i =0;
            while(current_maillon.suivant() != null){
                i++;
                Maillon next = current_maillon.suivant();
                current_maillon = next;
                str+= ", ";
                str_to_add = current_maillon.element().toString();
                str+= str_to_add;
            }
        }
        
        
        return str+"]";
    }

    public boolean equals(Object o) {
        if(! (o instanceof Pile4)) return false;
        
        Pile4 p2 = (Pile4)o;
        if(p2.capacite!=this.capacite) return false;
        if(p2.nombre!=this.nombre) return false;
        
        Maillon next1 = stk;
        Maillon next2 = p2.stk;
        
        while(next1.suivant()!=null){
            
            if(next1.element().equals(next2.element())){ return true; }
            
            next2 = next2.suivant();
            next1 = next1.suivant();
        }
        
        return false;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}