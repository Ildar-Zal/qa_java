import example.Feline;
import example.Lion;
import example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest  {
    private String sex;

    public LionTest(String sex){
        this.sex=sex;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
                {"Неизвестно"}
        };
    }

    Predator predator =new Feline();
    @Mock
    Lion lion;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testСonstructor() {
        {
            try {
                lion = new Lion(sex,predator);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
public void testGetKittensVerify(){
    lion.getKittens();
    Mockito.verify(lion).getKittens();
}

    @Test
    public void testDoesHaveManeReturn() {
        Mockito.when(lion.doesHaveMane()).thenReturn(false);
        Assert.assertEquals(false,lion.doesHaveMane());
    }

    @Test
    public void testGetFoodReturn() {
        try {
            Mockito.when(lion.getFood()).thenReturn((List.of("Молоко","Зелень","Салат")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Assert.assertEquals(List.of("Молоко","Зелень","Салат"),lion.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
