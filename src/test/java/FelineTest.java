import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class FelineTest {
    private int number;
    private String family;
    public FelineTest(int number, String family){
        this.number=number;
        this.family = family;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getNumberAndFamily() {
        return new Object[][]{
                {2,"Животное"},
                {4,"Неживотное"},
        };
    }
    @Mock
    Feline feline = new Feline();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetKittensVerify() {
        feline.getKittens(2);
        Mockito.verify(feline).getKittens(number);
    }

    @Test
    public void testGetFamilyCount() {
        feline.getKittens();
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(number)).getKittens();
    }

    @Test
    public void testGetKittensAny() {
        feline.getKittens(1);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
    }

    @Test
    public void testGetFamilyReturn() {
        Mockito.when(feline.getFamily()).thenReturn("Животное");
        Assert.assertEquals(family,feline.getFamily());

    }

    @Test
    public void testGetKittensReturn() {
        Mockito.when(feline.getKittens(10)).thenReturn(2);
        Assert.assertEquals(number,feline.getKittens(10));
    }
}