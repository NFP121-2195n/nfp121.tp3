package question1;

public class PileTest extends junit.framework.TestCase {
    private Pile p1,p2,p3,p6,p1_2, p_default;
    
    /**
     * Constructeur de la classe-test PileTest
     */
    public PileTest() {
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p1 = new Pile(1);
        p2 = new Pile(2);
        p3 = new Pile(3);
        p6 = new Pile(6);
        p1_2 = new Pile(1);
        p_default = new Pile();
    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
    }

    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */

    public void testEncourageant(){
        assertTrue(true);
    }
    
    public void test_estVide(){
        //est Vide
        assertTrue("p1 est vide?",p1.estVide());
        assertTrue("p2 est vide?",p2.estVide());
        assertTrue("p3 est vide?",p3.estVide());
        assertTrue("p6 est vide?",p6.estVide());
        assertTrue("p1_2 est vide?",p1_2.estVide());
        assertTrue("p_default est vide?",p_default.estVide());
        
        try
        {
            p1.empiler(1);
            p2.empiler(2);
            p3.empiler(3);
            p6.empiler(6);
            p1_2.empiler(1);
            p_default.empiler(5);
        }
        catch (question1.PilePleineException ppe)
        {
            ppe.printStackTrace();
        }
        
        assertFalse(p1.estVide());
        assertFalse(p2.estVide());
        assertFalse(p3.estVide());
        assertFalse(p6.estVide());
        assertFalse(p1_2.estVide());
        assertFalse(p_default.estVide());
    }
    
    public void test_empiler_estPleine_toString(){
        try
        {
            p1.empiler(1);
            p2.empiler(new PolygoneRegulier(1,1));
            p2.empiler("abc");
            p3.empiler(p1);
            p6.empiler(6);
            p1_2.empiler(1);
            p_default.empiler(5);
            p_default.empiler(4);
            p_default.empiler(3);
            p_default.empiler(2);
            p_default.empiler(1);
        }
        catch (question1.PilePleineException ppe)
        {
            ppe.getMessage();
        }
        
        assertTrue("p1 est pleine?",p1.estPleine());
        assertTrue("p2 est pleine?",p2.estPleine());
        assertFalse("p3 est pleine?",p3.estPleine());
        assertFalse("p6 est pleine?",p6.estPleine());
        assertTrue("p1_2 est pleine?",p1_2.estPleine());
        assertTrue("p1 est pleine?",p_default.estPleine());
        
        assertEquals("p1 to string",p1.toString(), "[1]");
        assertEquals("p2 to string",p2.toString(), "[abc, <1,1>]");
        assertEquals("p3 to string", p3.toString(), "[[1]]");
        assertEquals("p6 to string", p6.toString(), "[6]");
        assertEquals("p1_2 to string", p1_2.toString(), "[1]");
        assertEquals("p_default to string", p_default.toString(), "[1, 2, 3, 4, 5]");
        
        
        
    }
}
