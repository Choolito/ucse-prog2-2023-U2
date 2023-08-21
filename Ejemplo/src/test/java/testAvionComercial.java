import org.example.AvionComercial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testAvionComercial {
    @Test
    public void testVolar() {
        AvionComercial avionComercial = new AvionComercial(100, 10);
        int resultado = avionComercial.volar(10);
        Assertions.assertEquals(100, resultado);
    }

    @Test
    public void testGetConsumoCombustible() {
        AvionComercial avionComercial = new AvionComercial(100, 10);
        int resultado = avionComercial.getConsumoCombustible();
        Assertions.assertEquals(10, resultado);
    }

}
