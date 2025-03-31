package org.example;

/**
 * Контейнер для хранения целых чисел
 * Реализован на основе целочисленного массива
 * Поддерживает удаление, добавление, очистку
 * При необходимости автоматические увеличивается размерность
 */
public class Container {

    /**
     * Начальная размерность контейнера
     */
    private static final int INIT_SIZE = 10;

    private int[] items;
    private int size;

    /**
     * Создает пустой контейнер с начальной размерностью по умолчанию
     */
    public Container() {
        this.items = new int[INIT_SIZE];
        this.size = 0;
    }

    /**
     * Увеличивает емкость контейнера в 2 раза при заполнении.
     */
    private void resize() {
        int[] newArray = new int[items.length * 2];
        System.arraycopy(items, 0, newArray, 0, size);
        items = newArray;
    }

    /**
     * Проверяет, выходит ли индекс за границы допустимого диапазона.
     * @param index проверяемый индекс
     * @throws IndexOutOfBoundsException если индекс отрицательный или >= текущего размера
     */
    private void checkOutOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds exception");
        }
    }

    /**
     * Возвращает элемент по указанному индексу.
     * @param index индекс элемента
     * @return элемент под указанным индексом
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    public int get(int index) {
        checkOutOfBounds(index);
        return items[index];
    }

    /**
     * Добавляет элемент в конец контейнера.
     * При необходимости автоматически увеличивает емкость.
     * @param element добавляемый элемент
     */
    public void add(int element) {
        if (size == items.length) {
            resize();
        }
        items[size++] = element;
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Сдвигает последующие элементы влево.
     * @param index индекс удаляемого элемента
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    public int remove(int index) {
        checkOutOfBounds(index);
        int removed = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        size--;
        return removed;
    }

    /**
     * Очищает контейнер, удаляя все элементы.
     * После вызова этого метода контейнер возвращается в начальное состояние
     * с емкостью по умолчанию.
     */
    public void clear() {
        items = new int[INIT_SIZE];
        size = 0;
    }

    /**
     * Возвращает количество элементов в контейнере.
     * @return текущее количество элементов
     */
    public int size() {
        return size;
    }
}