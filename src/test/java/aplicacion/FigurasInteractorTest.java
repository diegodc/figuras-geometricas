package aplicacion;

import aplicacion.persistencia.RepositorioFigura;
import figuras.Circulo;
import figuras.Cuadrado;
import figuras.FiguraGeometrica;
import figuras.Triangulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FigurasInteractorTest {

    private RepositorioFigura mockRepositorio;
    private FigurasInteractor interactor;

    @BeforeEach
    void setUp() {
        mockRepositorio = mock(RepositorioFigura.class);
        interactor = new FigurasInteractor(mockRepositorio);
    }

    @Test
    void ingresarFigura() {
        FiguraGeometrica figura = interactor.ingresarFigura(getRequest());

        verificarFigura(figura);

        verify(mockRepositorio).persistirFigura(figura);
        verifyNoMoreInteractions(mockRepositorio);
    }

    @Test
    void getFiguraPorId() {
        String id = "id-1";
        FiguraGeometrica figura = new Circulo(3.8);
        when(mockRepositorio.buscarPorId(id)).thenReturn(figura);

        assertSame(figura, interactor.getFiguraPorId(id));

        verify(mockRepositorio).buscarPorId(id);
        verifyNoMoreInteractions(mockRepositorio);
    }

    @Test
    void getFiguras() {
        List<FiguraGeometrica> figuras = getListaFiguras();

        when(mockRepositorio.buscarTodas()).thenReturn(figuras);

        assertSame(figuras, interactor.getFiguras());

        verify(mockRepositorio).buscarTodas();
        verifyNoMoreInteractions(mockRepositorio);

    }

    private FiguraRequest getRequest() {
        Double[] parametros = {2.5};
        return new FiguraRequest("cuadrado", parametros);
    }

    private void verificarFigura(FiguraGeometrica figura) {
        assertNull(figura.getDiametro());
        assertEquals(6.25, figura.getSuperficie().doubleValue());
        assertEquals(2.5, figura.getBase().doubleValue());
        assertEquals(2.5, figura.getAltura().doubleValue());
        assertEquals("Cuadrado", figura.getTipo());
    }

    private List<FiguraGeometrica> getListaFiguras() {
        List<FiguraGeometrica> lista = new ArrayList<>();
        lista.add(new Cuadrado(1.2));
        lista.add(new Circulo(3.4));
        lista.add(new Triangulo(5.6, 7.8));
        return lista;
    }

}