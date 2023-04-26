import java.util.*;

public class Main {
    public static void main(String[] args) {
        startProgram();
    }

    /**
     * Первая задача
     */
    static void task1() {
        //        Пусть дан произвольный список целых чисел, удалить из него четные числа
        List<Integer> list1 = createListArbitraryNumber();
        removeEvenNumbers(list1);
    }

    /**
     * Метод удаления четных чисел из списка
     */
    static List<Integer> removeEvenNumbers(List<Integer> inputList) {
        System.out.println("Содержимое списка до удаления элементов: " + inputList);
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) % 2 == 0) {
                inputList.remove(i);
                i--;
            }
        }
        System.out.println("Содержимое списка после удаления элементов:" + inputList);
        return inputList;
    }

    /**
     * Метод создания списка произвольный чисел
     */
    static List<Integer> createListArbitraryNumber() {
        Random random = new Random();
        int size;
        int maxValue;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер списка: ");
        size = scanner.nextInt();

        System.out.print("Введите максимальный размер числа, которое будет в списке: ");
        maxValue = scanner.nextInt();

        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(1, maxValue));
        }
        return result;
    }

    /**
     * Вторая задача
     */
    static void task2() {
        //    Задан целочисленный список ArrayList. Найти минимальное,
        //    максимальное и среднее арифметическое из этого списка. Collections.max()
        List<Integer> list1 = createListArbitraryNumber();
        System.out.println(list1);
        searchMinMaxElement(list1);
        searchAverage(list1);
    }

    /**
     * Метод поиска минимального и максимального элемента без сохранения в переменную.
     */
    static void searchMinMaxElement(List<Integer> inputList) {
        System.out.printf("Минимальное значение в списке: %d \n", Collections.min(inputList));
        System.out.printf("Максимальное значение в списке: %d \n", Collections.max(inputList));
    }

    /**
     * Метод поиска среднего арифметического числа списка
     */
    static void searchAverage(List<Integer> inputList) {
        double sum = 0;
        for (Integer element : inputList) {
            sum += element;
        }
        System.out.printf("Среднее арифметическое число списка: %.2f", sum / inputList.size());
    }

    static void task3() {
        //Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
        // Вывести название каждой планеты и количество его повторений в списке.
        List<ListPlanets> listPlanets = new ArrayList<>();
        fillListPlanets(listPlanets, 10);
        repCounting(listPlanets);
    }


    /**
     * Метод заполняет список названиями планет
     *
     * @param iteration количество итераций, которые будут совершаться для
     *                  рандомного добавления названий в список планет
     */
    static void fillListPlanets(List<ListPlanets> listPlanets, int iteration) {
        Random random = new Random();
        //Первый цикл заполняет список всеми планетами. Конечно можно прописать и в ручную, но я решил сделать так.
        for (int i = 1; i <= 9; i++) {
            switch (i) {
                case 1 -> listPlanets.add(ListPlanets.MERCURY);
                case 2 -> listPlanets.add(ListPlanets.VENUS);
                case 3 -> listPlanets.add(ListPlanets.EARTH);
                case 4 -> listPlanets.add(ListPlanets.MARS);
                case 5 -> listPlanets.add(ListPlanets.JUPITER);
                case 6 -> listPlanets.add(ListPlanets.SATURN);
                case 7 -> listPlanets.add(ListPlanets.URANUS);
                case 8 -> listPlanets.add(ListPlanets.NEPTUNE);
                case 9 -> listPlanets.add(ListPlanets.PLUTO);
            }
        }
        //Второй цикл рандомно добавляет планеты в список, так интереснее будет проверять на повторяющиеся
        //значения
        for (int i = 0; i < iteration; i++) {
            int randomNumber = random.nextInt(1, 9);
            switch (randomNumber) {
                case 1 -> listPlanets.add(ListPlanets.MERCURY);
                case 2 -> listPlanets.add(ListPlanets.VENUS);
                case 3 -> listPlanets.add(ListPlanets.EARTH);
                case 4 -> listPlanets.add(ListPlanets.MARS);
                case 5 -> listPlanets.add(ListPlanets.JUPITER);
                case 6 -> listPlanets.add(ListPlanets.SATURN);
                case 7 -> listPlanets.add(ListPlanets.URANUS);
                case 8 -> listPlanets.add(ListPlanets.NEPTUNE);
                case 9 -> listPlanets.add(ListPlanets.PLUTO);
            }
        }
    }


    /**
     * Метод поиска повторений планет в списке
     */
    static void repCounting(List<ListPlanets> listPlanets) {
        for (ListPlanets planet : listPlanets) {
            System.out.println(planet + ": " + Collections.frequency(listPlanets, planet));
        }
    }

/**
 * Запуск задач
 * */
    static void startProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Здравствуйте, Константин!) введите число в соответствии с номером задачи, которую хотите проверить
                """);
        boolean flag = false;
        while (!flag){
            System.out.println("""
      
                № 1 - Задача на удаление четных чисел из списка
                № 2 - Задача на поиск минимального, минимального элементов в списке а так же
                     поиск среднего арифметического числа в списке
                № 3 - Список планет
                № 0 - Закрытие программы
                """);
            System.out.print("Введите номер задачи: ");
            int inputValue = scanner.nextInt();
            if (inputValue < 0 || inputValue > 3) {
                System.out.println("Некорректный ввод!");
            } else {
                switch (inputValue) {
                    case 1 -> task1();
                    case 2 -> task2();
                    case 3 -> task3();
                    case 0 -> {
                        System.out.println("Закрытие программы");
                        flag = true;
                    }
                }
            }
        }
    }
}


/**
 * Список планет
 */
enum ListPlanets {
    MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE, PLUTO
}
