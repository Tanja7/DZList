import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final String operation[] = {"добавить", "показать", "удалить", "найти"};
    private static ArrayList<String> listShop = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            printOperation();
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                switch (input) {
                    case "1": // добавить покупку в список
                        System.out.println("Какую покупку Вы хотите добавить?");
                        String purchase = scanner.nextLine();
                        listShop.add(purchase);
                        int size = listShop.size();
                        System.out.println("Итого в списке покупок: " + size);
                        break;
                    case "2": // показать список покупок
                        printList();
                        break;
                    case "3": // удаление покупки из списка
                        printList();
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        String purchaseDel = scanner.nextLine();
                        try {
                            int productDel = Integer.parseInt(purchaseDel) - 1;
                            System.out.println("Покупка " + listShop.get(productDel) + " удалена.");
                            listShop.remove(productDel);
                            printList();
                        } catch (NumberFormatException e) {
                            System.out.println("Покупка " + purchaseDel + " удалена.");
                            listShop.remove(purchaseDel);
                            printList();
                        }
                        break;
                    case "4": // поиск покупок по ключевым словам
                        System.out.println("Введите текст для поиска: ");
                        String purchaseFind = scanner.nextLine().toLowerCase();
                        System.out.println("Найдено: ");
                        for (int i = 0; i < listShop.size(); i++) {
                            if (listShop.get(i).toLowerCase().contains(purchaseFind)) {
                                System.out.println((i + 1) + ". " + listShop.get(i));
                            }
                        }
                        break;
                    default:
                        System.out.println("Введен некорректный номер операции!!!");
                        break;
                }
            }
        }
    }

    private static void printOperation() { // печать списка операций
        System.out.println("Выберите операцию: ");
        for (int i = 0; i < operation.length; i++) {
            System.out.println((i + 1) + ". " + operation[i]);
        }
    }

    private static void printList() { // печать списка покупок
        System.out.println("Список покупок: ");
        for (int i = 0; i < listShop.size(); i++) {
            System.out.println((i + 1) + ". " + listShop.get(i));
        }
    }
}
