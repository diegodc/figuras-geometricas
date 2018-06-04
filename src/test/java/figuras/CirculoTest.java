package figuras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CirculoTest {

    private Circulo circulo1;
    private Circulo circulo2;
    private Circulo circulo3;

    @BeforeEach
    void setUp() {
        circulo1 = new Circulo(2.0);
        circulo2 = new Circulo(3.5);
        circulo3 = new Circulo(23.9);
    }

    @Test
    void getSuperficie() {
        assertEquals(3.14159, circulo1.getSuperficie(),  0.00001);
        assertEquals(9.62112, circulo2.getSuperficie(),  0.00001);
        assertEquals(448.62728, circulo3.getSuperficie(),  0.00001);

    }

    @Test
    void getDiametro() {
        assertEquals(2.0, circulo1.getDiametro().doubleValue());
        assertEquals(3.5, circulo2.getDiametro().doubleValue());
        assertEquals(23.9, circulo3.getDiametro().doubleValue());
    }

    @Test
    void baseAlturaDebenSerNull() {
        assertNull(circulo1.getAltura());
        assertNull(circulo1.getBase());
    }

    @Test
    void getTipo() {
        assertEquals("Circulo", circulo1.getTipo());
    }

}