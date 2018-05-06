
package Objects;
import main.*;
public class Snake {

    public int length = 2;//длинна змеи
    public int direction = 2;//движение

    public int sX[] = new int[300];//массив змеи по х
    public int sY[] = new int[300];

    public Snake(int x1, int y1, int x2, int y2) {//конструктор начальные координаты
        sX[0] = x1;
        sX[1] = x2;
        sY[0] = y1;
        sY[1] = y2;
    }

    public void move() {//движение
        for (int l = length; l > 0; l--) {//движение последующих клеток за головой
            sX[1] = sX[l - 1];//присвоение предыдущего элемента
            sY[1] = sY[l - 1];
        }


        //up
        if (direction == 0) sY[0]--;//напрвление движение кнопки, изменение координаты
        //down
        if (direction == 2) sY[0]++;
        //right
        if (direction == 1) sX[0]++;
        //left
        if (direction == 3) sX[0]--;


        if (sX[0] > SnakeGameMain.WIDTH - 1) sX[0] = 0;//выход за пределы экрана если у головы больше высоты
        if (sX[0] < 0) sX[0] = SnakeGameMain.WIDTH - 1;
        if (sY[0] > SnakeGameMain.HEIGHT - 1) sY[0] = 0;
        if (sY[0] < 0) sY[0] = SnakeGameMain.HEIGHT - 1;
    }
}
