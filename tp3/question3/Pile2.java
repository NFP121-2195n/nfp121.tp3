package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille < 0)
        taille = PileI.CAPACITE_PAR_DEFAUT;
        
        stk = new Stack<T>();
        capacite = taille;
    }

    public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            {throw new PilePleineException();}
        
        this.stk.add(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            {throw new PileVideException();}
            
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        if(estVide()){
            throw new PileVideException();
        }
        
        return stk.peek();
    }
    
    public boolean estVide() {
        // a completer
        return stk.size() == 0;
    }
    
    public boolean estPleine() {
        // a completer
        return stk.size() == capacite();
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
                
        for (int i = stk.size() - 1; i >= 0; i--) {
            sb.append(stk.get(i).toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    
    public boolean equals(Object o) {
        if(o == null) { return false; }
        if(! (o instanceof PileI) ) {return false;}
        
        Pile2 p1 = (Pile2)o;
        if( (p1.taille() != this.taille()) 
                || (p1.capacite() != this.capacite()) )
            { return false; }
        
        for(int i=0; i<this.taille(); i++){
            if( !p1.stk.get(i).equals( this.stk.get(i) ) ){
                return false;
            }
        }
            
        return true;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    public int taille() {
        return stk.size();
    }
    
    public int capacite() {
        return capacite;
    }
} // Pile2