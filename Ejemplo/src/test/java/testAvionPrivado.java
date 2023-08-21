import org.example.AvionPrivado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testAvionPrivado {
    @Test
    public void testVolar() {
        AvionPrivado avionPrivado = new AvionPrivado(100, 10);
        int resultado = avionPrivado.volar(10);
        Assertions.assertEquals(150, resultado);
    }

    @Test
    public void testGetConsumoCombustible() {
        AvionPrivado avionPrivado = new AvionPrivado(100, 10);
        int resultado = avionPrivado.getConsumoCombustible();
        Assertions.assertEquals(10, resultado);
    }
}
