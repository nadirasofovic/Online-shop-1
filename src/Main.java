import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> category_name = new HashMap<>();
        HashMap<String, ArrayList<Purchase>> customer_purchases = new HashMap<>();
        HashMap<Float, Item> items_price = new HashMap<>();
        HashMap<String, ArrayList<Float>> customer_name_price = new HashMap<>();
        HashMap<String, Integer> item_quantity = new HashMap<>();

        ArrayList<Inventory> inventories = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Purchase> purchases = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();

        File inputFile1 = new File("items.csv");
        Scanner scanner1 = new Scanner(inputFile1);
        scanner1.nextLine();

        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String parts[] = line.split(",");

            String name = parts[0];
            Integer quantity = Integer.parseInt(parts[2]);
            Inventory inventory = new Inventory(name,quantity);
            inventories.add(inventory);

            String name2 = parts[0];
            Float price = Float.parseFloat(parts[1]);
            Integer quantity2 = Integer.parseInt(parts[2]);
            String category = parts[3];
            Item item = new Item(name2,price,quantity2,category);
            category_name.put(name2,category);

            items.add(item);
            items_price.put(price,item);
        }

        Collections.sort(items);

        File outputFile1 = new File("TopSellingItemsReport.txt");
        FileWriter fw1 = new FileWriter(outputFile1);
        for (Item item : items) {
            fw1.write(item.toString() + '\n');
        }
        fw1.close();

        File inputFile2 = new File("purchases.csv");
        Scanner scanner2 = new Scanner(inputFile2);
        scanner2.nextLine();

        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            String parts[] = line.split(",");
            String customer_name = parts[0];
            String item_name = parts[1];
            Integer quantity = Integer.parseInt(parts[2]);
            Purchase purchase = new Purchase(customer_name,item_name,quantity);
            purchases.add(purchase);

            if (!customer_purchases.containsKey(customer_name))
                customer_purchases.put(customer_name,new ArrayList<>());

            customer_purchases.get(customer_name).add(purchase);

            for (Inventory inventory : inventories) {
                if (item_name.equals(inventory.getName()))
                    inventory.change(quantity);
            }
        }

        for (Purchase purchase : purchases) {
            for (Item item : items) {
                if (purchase.getItemName().equals(item.getName()))
                    purchase.setFinal(item.getPrice());
            }
        }

        for (Purchase purchase : purchases) {
            if (!customer_name_price.containsKey(purchase.getCustomerName()))
                customer_name_price.put(purchase.getCustomerName(), new ArrayList<>());
        }

        for (Purchase purchase : purchases) {
            customer_name_price.get(purchase.getCustomerName()).add(purchase.getFinalPrice());
        }

        for (String s : customer_name_price.keySet()) {
            Float value = 0f;
            for (Float f : customer_name_price.get(s)) {
                value += f;
            }
            customer_name_price.get(s).add(value);
        }

        File outputFile2 = new File("TopCustomersReport.txt");
        FileWriter fw2 = new FileWriter(outputFile2);

        for (String s : customer_name_price.keySet()) {
            fw2.write(s + " " + customer_name_price.get(s).get(customer_name_price.get(s).size() - 1) + "\n");
        }
        fw2.close();

        for (Purchase purchase : purchases) {
            item_quantity.put(purchase.getItemName(), purchase.getQuantity());
        }

        for (String s : category_name.keySet()) {
            Integer i = 0;
            String string = " ";

            for (String s2 : item_quantity.keySet()) {
                if (s.equals(s2)) {
                    i = item_quantity.get(s2);
                    string = category_name.get(s);
                }
            }

            if (i != 0) {
                Category category = new Category(string, Integer.valueOf(i));
                categories.add(category);
            }
        }

        Collections.sort(categories);

        File outputFile3 = new File("CategorySalesReport.txt");
        FileWriter fw3 = new FileWriter(outputFile3);

        for (Category category : categories)
            fw3.write(category.toString() + "\n");
        fw3.close();

        File outputFile4 = new File("CustomerPurchaseHistoryReport.txt");
        FileWriter fw4 = new FileWriter(outputFile4);

        String string = " ";

        for (String s: customer_purchases.keySet()) {
            string = " ";

            Float finalPrice = 0f;

            for (Purchase purchase : customer_purchases.get(s)) {
                finalPrice += purchase.getFinalPrice();

                string+= purchase.getItemName() + " " + purchase.getQuantity() + " " + purchase.getFinalPrice() + " ";
            }
            fw4.write(s + " " + string + " spent a total of " + finalPrice + "\n");
        }
        fw4.close();

        File outputFile5 = new File("InventoryReport.txt");
        FileWriter fw5 = new FileWriter(outputFile5);

        for (Inventory inventory : inventories)
            fw5.write(inventory.toString() + "\n");
        fw5.close();
    }
}