import Objects.Snake;
import org.junit.Assert;
import org.junit.Test;


public class Test1 {
    @Test
    public void case1() {

        Snake s = new Snake(0, 1, 0, 0);//001 создание обьекта
        s.growthTail();
        s.move();
        Assert.assertEquals(0, s.sX[0]);
        Assert.assertEquals(2, s.sY[0]);
        Assert.assertEquals(0, s.sX[1]);
        Assert.assertEquals(1, s.sY[1]);
        Assert.assertEquals(0, s.sX[2]);
        Assert.assertEquals(0, s.sY[2]);
    }
    @Test
    public void case2() {

        Snake s = new Snake(0, 1, 0, 0);//001 создание обьекта
        s.move();
        Assert.assertEquals(0, s.sX[0]);
        Assert.assertEquals(2, s.sY[0]);
        Assert.assertEquals(0, s.sX[1]);
        Assert.assertEquals(1, s.sY[1]);
    }
//    @Test
//    public void move_on_eat_apple
}
