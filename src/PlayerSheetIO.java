import java.io.*;
public class PlayerSheetIO
{
    public static void savePlayerSheetToFile(PlayerSheet sheet, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(sheet);
            System.out.println("Player sheet saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving player sheet: " + e.getMessage());
        }
    }

    public static PlayerSheet loadPlayerSheetFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            PlayerSheet sheet = (PlayerSheet) ois.readObject();
            System.out.println("Player sheet loaded from " + filename);
            return sheet;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading player sheet: " + e.getMessage());
            return null;
        }
    }


}
