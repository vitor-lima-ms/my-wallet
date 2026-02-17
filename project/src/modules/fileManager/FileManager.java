package modules.fileManager;

// Imports.
import java.io.*;
import java.util.ArrayList;
import models.Transaction;
//

public class FileManager {
     public static void saveData(ArrayList<Transaction> transactions) {
        try (
                FileOutputStream fos = new FileOutputStream(
                        "transactions.bin"
                );

                ObjectOutputStream oos = new ObjectOutputStream(fos)
                ) {
            oos.writeObject(transactions);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Transaction> loadData() {
         try (
                 FileInputStream fis = new FileInputStream("transactions.bin");

                 ObjectInputStream ois = new ObjectInputStream(fis)
                 ) {
             ArrayList<Transaction> transactions = (ArrayList<Transaction>) ois.readObject();

             return transactions;
         } catch (ClassNotFoundException | IOException e) {
             e.printStackTrace();

             return new ArrayList<>();
         }
    }

    public static void generateReport() {
        ArrayList<Transaction> transactions = loadData();

        try (
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter("report.csv")
                )
                ) {
            bw.write("Description;Value;Date");

            bw.newLine();

            for (
                    int i = 0;
                    i < transactions.size();
                    i++
            ) {
                Transaction transaction = transactions.get(i);

                bw.write(
                        transaction.getDescription() + ";" +
                           transaction.getValue() + ";" +
                           transaction.getDate()
                );

                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
