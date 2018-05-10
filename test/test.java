import Objects.Snake;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by graf-31 on 10.05.2018.
 */
public class test {
    @Test
    public void testCreate(){
        Snake snake = new Snake(7,7,8,7);
        Assert.assertEquals(7, snake.sX[0]);
        Assert.assertEquals(7, snake.sY[0]);
        Assert.assertEquals(8, snake.sX[1]);
        Assert.assertEquals(7, snake.sY[1]);
    }

    @Test
    public void testMove(){
        Snake snake = new Snake(8,7,7,7);
        snake.move();
        Assert.assertEquals(9, snake.sX[0]);
        Assert.assertEquals(7, snake.sY[0]);
        Assert.assertEquals(8, snake.sX[1]);
        Assert.assertEquals(7, snake.sY[1]);
    }
}
