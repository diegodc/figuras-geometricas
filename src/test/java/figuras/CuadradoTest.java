package figuras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CuadradoTest {

    private Cuadrado cuadrado1;
    private Cuadrado cuadrado2;
    private Cuadrado cuadrado3;

    @BeforeEach
    void setUp() {
        cuadrado1 = new Cuadrado(1.0);
        cuadrado2 = new Cuadrado(2.0);
        cuadrado3 = new Cuadrado(4.7);
    }

    @Test
    void getSuperficie() {
        assertEquals(1.0, cuadrado1.getSuperficie().doubleValue());
        assertEquals(4.0, cuadrado2.getSuperficie().doubleValue());
        assertEquals(22.09, cuadrado3.getSuperficie(), 0.00001);
    }

    @Test
    void baseAlturaSonIguales() {
        assertEquals(1.0, cuadrado1.getBase().doubleValue());
        assertEquals(2.0, cuadrado2.getBase().doubleValue());
        assertEquals(4.7, cuadrado3.getBase().doubleValue());

        assertEquals(cuadrado1.getAltura(), cuadrado1.getBase());
        assertEquals(cuadrado2.getAltura(), cuadrado2.getBase());
        assertEquals(cuadrado3.getAltura(), cuadrado3.getBase());
    }

    @Test
    void diametroDebeSerNull() {
        assertNull(cuadrado1.getDiametro());
    }

    @Test
    void getTipo() {
        assertEquals("Cuadrado", cuadrado1.getTipo());
    }

}