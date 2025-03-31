package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности класса Container
 * Содержит unit-тесты для всех основных операций контейнера
 */
public class AppTest {

    /**
     * Тестирует корректность добавления и получения элементов
     * Проверяет, что добавленные элементы сохраняются в правильном порядке
     */
    @Test
    public void testAddElementsAndGetByIndex() {
        Container container = new Container();
        container.add(100);
        container.add(2);
        container.add(-313);

        assertEquals(100, container.get(0));
        assertEquals(2, container.get(1));
        assertEquals(-313, container.get(2));
    }

    /**
     * Тестирует автоматическое расширение контейнера при добавлении большого количества элементов
     * Проверяет, что контейнер корректно увеличивает свой размер
     */
    @Test
    public void testContainerAutoResizeWhenAddingManyElements() {
        Container container = new Container();
        for(int i = 0; i < 24; i++){
            container.add(i);
        }
        assertEquals(24, container.size());
    }

    /**
     * Тестирует корректность работы метода size()
     * Проверяет изменение размера контейнера после добавления элементов
     */
    @Test
    public void testContainerSizeAfterAddingElements() {
        Container container = new Container();
        assertEquals(0, container.size());

        container.add(1);
        container.add(1);
        container.add(1);
        container.add(1);

        assertEquals(4, container.size());
    }

    /**
     * Тестирует удаление элементов из контейнера
     * Проверяет возвращаемое значение и изменение размера контейнера
     */
    @Test
    public void testRemoveElementFromContainer() {
        Container container = new Container();
        container.add(99);
        container.add(50);
        container.add(45);

        assertEquals(99, container.remove(0));
        assertEquals(2, container.size());
    }

    /**
     * Тестирует очистку контейнера
     * Проверяет, что после очистки контейнер становится пустым
     */
    @Test
    public void testClearContainer() {
        Container container = new Container();
        container.add(1);
        container.add(1);
        container.add(10);
        assertEquals(3, container.size());

        container.clear();
        assertEquals(0, container.size());
    }

    /**
     * Тестирует обработку недопустимого индекса при получении элемента
     * Проверяет возникновение исключения IndexOutOfBoundsException
     */
    @Test
    public void testGetElementWithInvalidIndexThrowsException() {
        Container container = new Container();
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> container.get(1),
                "Ожидается IndexOutOfBoundsException");
    }

    /**
     * Тестирует обработку недопустимого индекса при удалении элемента
     * Проверяет возникновение исключения IndexOutOfBoundsException
     */
    @Test
    public void testRemoveElementWithInvalidIndexThrowsException() {
        Container container = new Container();
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> container.remove(1),
                "Ожидается IndexOutOfBoundsException");
    }

    /**
     * Тестирует механизм расширения контейнера
     * Проверяет корректность работы после превышения начального размера
     */
    @Test
    public void testContainerResizeMechanism() {
        Container container = new Container();
        for (int i = 0; i < 20; i++) {
            container.add(i);
        }
        assertEquals(20, container.size());
        assertEquals(19, container.get(19));
    }
}