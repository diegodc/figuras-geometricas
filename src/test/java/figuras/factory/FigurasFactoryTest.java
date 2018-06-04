package figuras.factory;

import figuras.Circulo;
import figuras.Cuadrado;
import figuras.FiguraGeometrica;
import figuras.Triangulo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FigurasFactoryTest {

    @Test
    void construccionCirculos() {
        verificarCirculo(2.0, 3.141592);
        verificarCirculo(47.0, 1734.944542);
        verificarCirculo(16.4, 211.240690);
    }

    @Test
    void construccionCuadrados() {
        verificarCuadrado(2.9, 8.41);
        verificarCuadrado(10.5, 110.25);
        verificarCuadrado(0.35, 0.1225);
    }

    @Test
    void construccionTriangulos() {
        verificarTriangulo(3.4, 5.1, 8.67);
        verificarTriangulo(2.75, 10.06, 13.8325);
        verificarTriangulo(21.3, 47.92, 510.348);
    }

    @Test
    void elTipoSeComparaCaseInsensitive() {
        FiguraGeometrica circulo = FigurasFactory.crear("cIrCuLo", 1.0);
        assertEquals("Circulo", circulo.getTipo());
    }

    @Test
    void elTipoDeFiguraDebeSerCorrecto() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> FigurasFactory.crear("incorrecto", 1.0));
        assertEquals("Tipo de figura incorrecto", exception.getMessage());
    }

    @Test
    void noPermiteParametrosNoPositivos() {
        arrojaExcepcionParametrosNoPositivos(() -> FigurasFactory.crear("cuadrado", 0.0));
        arrojaExcepcionParametrosNoPositivos(() -> FigurasFactory.crear("cuadrado", -0.3));

        arrojaExcepcionParametrosNoPositivos(() -> FigurasFactory.crear("circulo", 0.0));
        arrojaExcepcionParametrosNoPositivos(() -> FigurasFactory.crear("circulo", -0.3));

        arrojaExcepcionParametrosNoPositivos(() -> FigurasFactory.crear("triangulo", -0.3, 1.0));
        arrojaExcepcionParametrosNoPositivos(() -> FigurasFactory.crear("triangulo", 1.0, 0.0));
        arrojaExcepcionParametrosNoPositivos(() -> FigurasFactory.crear("triangulo", 0.0, 1.0));
    }

    @Test
    void elNumeroDeParametrosDebeSerCorrecto() {
        arrojaExcepcionNumeroParametros(1, () -> FigurasFactory.crear("cuadrado", 1.0, 2.0));
        arrojaExcepcionNumeroParametros(1, () -> FigurasFactory.crear("cuadrado"));

        arrojaExcepcionNumeroParametros(1, () -> FigurasFactory.crear("circulo", 1.0, 2.0, 3.0));
        arrojaExcepcionNumeroParametros(1, () -> FigurasFactory.crear("circulo"));

        arrojaExcepcionNumeroParametros(2, () -> FigurasFactory.crear("triangulo", 1.0));
        arrojaExcepcionNumeroParametros(2, () -> FigurasFactory.crear("triangulo", 1.0, 2.0, 3.0));
        arrojaExcepcionNumeroParametros(2, () -> FigurasFactory.crear("triangulo"));
    }

    private void verificarCirculo(double diametro, double superficie) {
        FiguraGeometrica figura = FigurasFactory.crear("circulo", diametro);

        assertTrue(figura instanceof Circulo);
        assertEquals(diametro, figura.getDiametro().doubleValue());
        assertEquals(superficie, figura.getSuperficie(), 0.000001);
    }

    private void verificarCuadrado(double lado, double superficie) {
        FiguraGeometrica figura = FigurasFactory.crear("cuadrado", lado);

        assertTrue(figura instanceof Cuadrado);
        assertEquals(lado, figura.getBase().doubleValue());
        assertEquals(superficie, figura.getSuperficie(), 0.000001);
    }

    private void verificarTriangulo(double base, double altura, double superficie) {
        FiguraGeometrica figura = FigurasFactory.crear("triangulo", base, altura);

        assertTrue(figura instanceof Triangulo);
        assertEquals(base, figura.getBase().doubleValue());
        assertEquals(altura, figura.getAltura().doubleValue());
        assertEquals(superficie, figura.getSuperficie(), 0.000001);
    }

    private void arrojaExcepcionParametrosNoPositivos(Executable action) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Todos los parametros deben ser positivos", exception.getMessage());
    }

    private void arrojaExcepcionNumeroParametros(int numero, Executable action) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Numero de parametros incorrectos, se esperan solo " + numero, exception.getMessage());
    }

}