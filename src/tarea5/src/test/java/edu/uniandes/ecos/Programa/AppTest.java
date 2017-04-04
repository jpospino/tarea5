package edu.uniandes.ecos.Programa;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testCalculoDistribucion()
    {
        double valorCalculado = App.calculoDistribucion(1.11, 9, 0.00001);
        assertEquals(0.3343, valorCalculado, 0.001);
        
        valorCalculado = App.calculoDistribucion(1.1812, 10, 0.00001);
        assertEquals(0.35571, valorCalculado, 0.001);
        
        valorCalculado = App.calculoDistribucion(2.750, 30, 0.00001);
        assertEquals(0.48886, valorCalculado, 0.001);
    }
}
