package figuras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TrianguloTest {

    private Triangulo unTriangulo;

    @BeforeEach
    void setUp() {
        unTriangulo =  new Triangulo(3.0, 2.0);
    }

    @Test
    void getSuperficie() {
        assertEquals(3.0, unTriangulo.getSuperficie().doubleValue());
    }

    @Test
    void getBase() {
        assertEquals(3.0, unTriangulo.getBase().doubleValue());
    }

    @Test
    void getAltura() {
        assertEquals(2.0, unTriangulo.getAltura().doubleValue());
    }

    @Test
    void diametroDebeSerNull() {
        assertNull(unTriangulo.getDiametro());
    }

    @Test
    void getTipo() {
        assertEquals("Triangulo", unTriangulo.getTipo());
    }

}