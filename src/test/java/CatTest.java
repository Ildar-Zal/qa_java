import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Predator predator = new Feline();
    @Mock
    Cat cat = new Cat(predator);


    @Test
    public void testGetSoundVerify() {
        cat.getSound();
        Mockito.verify(cat).getSound();
    }
    @Test
    public void testGetSoundReturn() {
        Mockito.when(cat.getSound()).thenReturn("Гав");
        Assert.assertEquals("Гав",cat.getSound());

    }
    @Test
    public void testGetFoodReturn() {
        try {
            Mockito.when(cat.getFood()).thenReturn((List.of("Рыба","Молоко","Мясо")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Assert.assertEquals(List.of("Рыба","Молоко","Мясо"),cat.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
