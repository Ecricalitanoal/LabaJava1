package org.example;

import java.util.Scanner;


/**
 * Класс для демонстрации работы класса контейнера Container через консольное меню
 * Позволяет получать, удалять, добавлять элементы контейнера, а также очищать его
 */
public class App {

    /**
     * Точка входа в программу
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Container container = new Container();
        Scanner cin = new Scanner(System.in);
        boolean flag = true;
        int whatToDo;
        int number, index;

        while (flag) {
            System.out.println("1) Добавить новый элемент\n2) Получить элемент по индексу" +
                    "\n3) Удалить элемент по индексу\n4) Получить все элементы" +
                    "\n5) Размер контейнера;\n6) Очистить контейнер;\n0) Выход\nВыбери действие: ");

            whatToDo = cin.nextInt();

            switch (whatToDo) {
                case 1:
                    System.out.print("Введите число: ");
                    number = cin.nextInt();
                    container.add(number);
                    break;
                case 2:
                    System.out.print("Введите индекс: ");
                    index = cin.nextInt();
                    int element = container.get(index);
                    System.out.println("Элемент: " + element);
                    break;
                case 3:
                    System.out.println("Все элементы:");
                    for (int i = 0; i < container.size(); i++) {
                        System.out.println(container.get(i));
                    }
                    break;
                case 4:
                    System.out.print("Введите индекс: ");
                    index = cin.nextInt();
                    container.remove(index);
                    System.out.println("Успешно удалено");
                    break;
                case 5:
                    System.out.println("Размер контейнера: " + container.size());
                    break;
                case 6:
                    container.clear();
                    System.out.println("Контейнер очищен");
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Введите корректное действие");
            }
        }

        cin.close();
    }
}
