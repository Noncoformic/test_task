import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Калькулятор запущен: Введите уравнение!");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        }catch (Exception e){
            System.out.println("throws Exception //" + e.getMessage());
        }finally {
            scanner.close();
        }





    }
    private static String calc(String input) throws Exception {
        input = input.trim();

        String[] words = input.split(" ");

        if (words.length != 3) {
            throw new Exception("Не верный формат уровнения! Пример: a + b");
        }
        int a = parseNumber(words[0]);
        int b = parseNumber(words[2]);

        char operator = words[1].charAt(0);

        int result = operation(a, b, operator);

        return String.valueOf(result);
    }

    // Метод для выполнения операций
    private static int operation (int a, int b, char operator)throws Exception{
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    throw new Exception("Нельзя делить на ноль! p.s. даже если хочется");
                }
                yield a / b;
            }
            default -> throw new Exception("Неизвестный тип операции");
        };
    }
    // Метод для проверики и парсинга чисел
    private static int parseNumber (String str) throws Exception {
        int number ;
        try {
            number = Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new Exception("Не верное число");
        }
        if (number < 1 || number > 10) {
            throw new Exception("Число выходит за рамки условий");
        }
        return number;
    }
}