import org.example.AvionComercial;
import org.example.AvionPrivado;
import org.example.CalculadorCombustible;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testCalcularCombustible {
    @Test
    public void testCalcularCombustible() {
        AvionComercial avion = new AvionComercial(100, 10);
        CalculadorCombustible calculadorCombustible = CalculadorCombustible.getInstance();
        int resultado = calculadorCombustible.calcularCombustible(avion, 10);
        Assertions.assertEquals(100, resultado);
    }


}
