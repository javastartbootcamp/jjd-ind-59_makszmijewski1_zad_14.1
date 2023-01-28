import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<Integer> numbers = main.readAndCreateList("liczby.txt");
        Collections.sort(numbers);
        Set<Integer> set = new LinkedHashSet<>(numbers);
        for (Integer integer : set) {
            System.out.println(integer + " - liczba wystąpień " + Collections.frequency(numbers, integer));
        }
    }

    private List<Integer> readAndCreateList(String s) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku");
        }
        return numbers;
    }

}
