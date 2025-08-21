import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        Самостоятельная работа:
        */
        System.out.println("Set / HashSet");
        /*
        - Создание множества
          Создайте HashSet<String>, добавьте 5 слов и выведите все элементы
        * */
        System.out.println("Создание множества");
        HashSet<String> strSet = new HashSet<>(List.of("Test", "python", "Java", "Jabki", "Tusa", "Pivchanskiy"));
        System.out.println(strSet);
        /*
        - Проверка на наличие элемента
          Проверьте, содержится ли слово "java" в множестве
         */
        System.out.println("Проверка на наличие элемента \"java\"");
        System.out.println("В множестве " + (strSet.contains("java") ? "есть элемент" : "нету элемента") + " java");
        /*
        - Удаление элемента
          Удалите слово "python" из множества (если оно есть)
        */
        System.out.println("Удаление элемента \"python\"");
        strSet.remove("python");
        System.out.println(strSet);
        /*
        - Подсчёт уникальных
          Дан список строк с повторами. Добавьте их в HashSet и выведите количество уникальных слов
        */
        System.out.println("Подсчёт уникальных");
        List<String> nonUnqStr = new ArrayList<>(List.of("baltika", "prazecka", "kozel", "baltika", "chernovar"));
        strSet.addAll(nonUnqStr);
        System.out.println("Кол-во уникальных: " + strSet.size());

        System.out.println("Map / HashMap");
        /*
        - Создание и вывод Map
          Создайте HashMap<String, Integer> с названиями предметов и оценками. Выведите все пары ключ-значение
        */
        System.out.println("Создание и вывод Map.");
        HashMap<String, Integer> lessonGrades = new HashMap<>();
        lessonGrades.put("Math", 5);
        lessonGrades.put("Physics", 4);
        lessonGrades.put("History", 5);
        lessonGrades.put("Russian Language", 3);
        for (HashMap.Entry<String, Integer> grade : lessonGrades.entrySet()) {
            System.out.println("Предмет: " + grade.getKey() + " балл " + grade.getValue());
        }
        /*
        - Получение значения по ключу
          Выведите значение по ключу "Math".
        */
        System.out.println("Получение значения по ключу.");
        System.out.println("Оценка по математике: " + lessonGrades.get("Math"));
        /*
        - Изменение значения
          Измените значение по ключу "English" на 5
        */
        System.out.println("Изменение значения.");
        // без проверки просто данный метод его добавит
        if (lessonGrades.containsKey("English")) {
            lessonGrades.put("English", 5);
        }
        System.out.println(lessonGrades);
        /*
        - Проверка наличия ключа
          Проверьте, есть ли в мапе ключ "History"
        */
        System.out.println("Проверка наличия ключа.");
        if (lessonGrades.containsKey("History")) {
            System.out.println("В школе учат \"History\".");
        }
        /*
        - Удаление ключа
          Удалите ключ "Physics" из мапы
        */
        System.out.println("Удаление ключа.");
        lessonGrades.remove("Physics");
        System.out.println(lessonGrades);
        /*
        - Рейтинг студентов
        Дан Map<String, Integer> (имя студента → балл). Верните имя студента с максимальным баллом
        */
        System.out.println("Рейтинг студентов.");
        HashMap<String, Integer> students = new HashMap<>();
        students.put("Васян", 55);
        students.put("Петручо", 64);
        students.put("Джозефина", 75);
        students.put("Максон", 33);
        students.put("Иванидзе", 75);
        int maxRating = Collections.max(students.values());
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue().equals(maxRating)) { // Use .equals() for object comparison
                System.out.println("Лучший студент: " + entry.getKey());
            }
        }
        /*
        - Словарь синонимов
          Создайте Map<String, Set<String>> — ключ: слово, значение: набор синонимов. Реализуйте метод addSynonym(String word, String synonym)
        */
        System.out.println("Словарь синонимов.");
        Map<String, Set<String>> synon = new HashMap<>();
        synon.put("дорога", new HashSet<>(List.of("путь", "тропа", "трасса")));
        synon.put("дом", new HashSet<>(List.of("жилище", "дворец")));
        System.out.println(synon);
        addSynonum(synon, "дом", "хата");
        System.out.println(synon);
    }
    /*
    - Анаграммы
      Напишите метод areAnagrams(String a, String b), который возвращает true, если строки состоят из одинаковых символов
      (используйте Map<Character, Integer>).
    */

    /**
     * Определяет являются ли строчки анаграммами.
     *
     * @param str1 - первая строка
     * @param str2 - вторая строка
     * @return - истина если анаграммы, иначе нет
     */
    public static boolean anagramOrNot(String str1, String str2) {
        Map<Character, Long> str1Map = str1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> str2Map = str2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (str2Map.equals(str1Map)) {
            return true;
        }
        return false;
    }
    /*
    - Поиск дубликатов с помощью Set
      Напишите метод hasDuplicates(List<Integer> list) — возвращает true, если в списке есть дубликаты
    */

    /**
     * Проверяет дупликаты
     *
     * @param list - список интов
     * @return - есть там дупликаты или нет.
     */
    public static boolean hasDuplicates(List<Integer> list) {
        HashSet<Integer> hash = new HashSet<>(list);
        if (hash.size() != list.size()) {
            return true;
        }
        return false;
    }

    /**
     * Добавляет синоним в набор
     *
     * @param set   - набор с типом ключ, и набор по ключу
     * @param word  - слово (ключ)
     * @param synon - синоним
     */
    public static void addSynonum(Map<String, Set<String>> set, String word, String synon) {
        Set<String> synSet = set.get(word);
        synSet.add(synon);
        set.put(word, synSet);
    }
}
