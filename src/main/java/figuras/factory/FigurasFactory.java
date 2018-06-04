package figuras.factory;

import figuras.Circulo;
import figuras.Cuadrado;
import figuras.FiguraGeometrica;
import figuras.Triangulo;

public class FigurasFactory {

    /**
     * Crea una nueva FiguraGeometrica segun el tipo y los parametros dados.
     *
     * Los parametros deben ser numeros positivos.
     *
     * Parametros segun tipo:
     * 'Circulo": {radio} la longitud del radio del circulo
     * 'Cuadrado": {lado} la longitud de los lados del cuadrado
     * 'Circulo": {base} {altura} la longitud de la base y la altura (en ese orden) del triangulo
     *
     * @param tipo el tipo de figura a crear
     * @param parametros parametros de la figura
     * @return la nueva FiguraGeometrica
     */
    public static FiguraGeometrica crear(String tipo, Double... parametros) {

        switch (tipo.toLowerCase()) {
            case "circulo":
                return crearCirculo(parametros);
            case "cuadrado":
                return crearCuadrado(parametros);
            case "triangulo":
                return crearTriangulo(parametros);
            default:
                throw new IllegalArgumentException("Tipo de figura incorrecto");
        }

    }

    private static FiguraGeometrica crearCirculo(Double[] parametros) {
        verificarParametros(1, parametros);

        double diametro = parametros[0];
        return new Circulo(diametro);
    }

    private static FiguraGeometrica crearCuadrado(Double[] parametros) {
        verificarParametros(1, parametros);

        double lado = parametros[0];
        return new Cuadrado(lado);
    }

    private static FiguraGeometrica crearTriangulo(Double[] parametros) {
        verificarParametros(2, parametros);

        double base = parametros[0];
        double altura = parametros[1];
        return new Triangulo(base, altura);
    }

    private static void verificarParametros(int numero, Double[] parametros) {
        verificarNumero(numero, parametros);
        verificarTodosSonPositivos(numero, parametros);
    }

    private static void verificarNumero(int numero, Double[] parametros) {
        if (parametros.length != numero)
            throw new IllegalArgumentException("Numero de parametros incorrectos, se esperan solo " + numero);
    }

    private static void verificarTodosSonPositivos(int numero, Double[] parametros) {
        for (int i = 0; i < numero; i++)
            if (parametros[i] <= 0)
                throw new IllegalArgumentException("Todos los parametros deben ser positivos");
    }

}
