import com.inventario.model.Producto;
import com.inventario.service.ProductoServiceTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PerfulandiaTest {

    @Autowired
    private ProductoServiceTest productoService;

    @Test
    void testCrearProducto() {
        Producto producto = new Producto("Perfume Oscuro", 15000);
        Producto resultado = productoService.crearProducto(producto);
        assertNotNull(resultado.getId(), "El ID del producto no debería ser nulo");
    }
}