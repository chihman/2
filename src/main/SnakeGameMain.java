package main;
import Objects.Apple;
import Objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGameMain extends JPanel implements ActionListener {//оконное преложение, создание имплиметс действий игры
    public static JFrame jFrame;
    public static final int SCALE = 32;//8 размер клетки
    public static final int WIDTH = 20;//9 клеток по ширене
    public static final int HEIGHT = 20;//10 по высоте
    public static int speed = 10;//скорость


    Snake s = new Snake(5, 6, 5, 5);//001 создание обьекта
    Apple apple = new Apple(Math.abs((int) (Math.random() * SnakeGameMain.WIDTH - 1)), Math.abs((int) (Math.random() * SnakeGameMain.HEIGHT - 1)));
    Timer timer = new Timer(1000 / speed, this);//таймер обновления экрана

    public SnakeGameMain() {//11 конструктор
        timer.start();
        addKeyListener(new KeyBoard());//включения кей адаптера
        setFocusable(true);
    }

    public void paint(Graphics g) {//12 граф художник
        g.setColor(Color.black);//13 цвет фона
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);//
        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {//15 отрисовка клеток
            g.setColor(Color.black);//рисование линии
            g.drawLine(x, 0, x, HEIGHT * SCALE);//первая линия
        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {//вертикальные линии
            g.setColor(Color.black);
            g.drawLine(0, y, WIDTH * SCALE, y);
        }
        g.setColor(Color.red);//яблоко
        g.fillOval(apple.posX * SCALE + 4, apple.posY * SCALE + 4, SCALE - 8, SCALE - 8);

        g.setColor(Color.WHITE);//голова
        g.fillRect(s.sX[0] * SCALE + 1, s.sY[0] * SCALE + 1, SCALE - 1, SCALE - 1);

        for (int l = 1; l < s.length; l++) {//рисование змеи
            g.setColor(Color.green);//зеленого цвета
            g.fillRect(s.sX[l] * SCALE + 1, s.sY[l] * SCALE + 1, SCALE - 1, SCALE - 1);
//рисование квадратика


        }
    }


    public static void main(String[] args) {
        jFrame = new JFrame("Title");//2 инициализация
        jFrame.setSize(WIDTH * SCALE + 20, HEIGHT * SCALE + 40);//размер окна
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//5 остановка при закрытие
        jFrame.setResizable(false);//6 убрать растягивание
        jFrame.setLocationRelativeTo(null);//3 поцентру

        jFrame.add(new SnakeGameMain());//14в ызов отрисовщика через конструктор

        jFrame.setVisible(true);//4видимый
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {//взаимодествие змеи и яблока

            apple.setRandomPosition();//рандомная позиция
            s.length += 1;// +1 сигмент
        }
        for (int l = 1; l < s.length; l++) {//запрет появления яблока в змее
            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
                apple.setRandomPosition();
            }
            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {//столкновение возможно л
                timer.stop();
                JOptionPane.showInternalMessageDialog(null, "АААААААА!!!");
                jFrame.setVisible(false);
                s.length = 2;
                s.direction = 0;
                apple.setRandomPosition();
                jFrame.setVisible(true);
                timer.start();
            }


        }
        repaint();//отрисовка
    }

    public class KeyBoard extends KeyAdapter {//импортирует кей адаптер
        public void keyPressed(KeyEvent event) {//принимает события клавиатуры
            int key = event.getKeyCode();//преобразует ключ клавиши

            if ((key == KeyEvent.VK_UP) && (s.direction != 2)) s.direction = 0;//вк значение кнопок и значение кнопки не против движения
            if ((key == KeyEvent.VK_DOWN) && (s.direction != 0)) s.direction = 2;
            if ((key == KeyEvent.VK_RIGHT) && (s.direction != 3)) s.direction = 1;
            if ((key == KeyEvent.VK_LEFT) && (s.direction != 1)) s.direction = 3;
        }
    }
}
