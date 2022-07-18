package bdayparadoxexp;
import java.util.*;
import javax.swing.JOptionPane;


public class BDayParadoxExp {
    
    public static void main(String[] args) {
        //mainProvePercentage(args);
        mainAverageNeeded(args);
    }
    

    public static void mainProvePercentage(String[] args)
    {
        Random r = new Random();
        double duplicatesCounter = 0;
        double sampleSize = 1000000;
        int p;
        p = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of people in the room:"));
        Set<Integer> days = new HashSet<>();
        for (int i = 0; i < sampleSize; i++)
        {
            days.clear();
            for (int j = 0; j < p; j++)
            {
                int n = r.nextInt(365) + 1;
                boolean wasAdded = days.add(n);
                if (!wasAdded)
                {
                    duplicatesCounter++;
                    break;
                }
            }
        }
        double percentChance;
        percentChance = 100 * duplicatesCounter / sampleSize;
        System.out.println("With " + p + " people in a room, there is"
                + " a " + percentChance + "% chance that at least two people"
                + " share a birthday (1 million samples taken).");
        System.out.println("");
    }
    
    public static void mainAverageNeeded(String[] args)
    {
        Random r = new Random();
        double peopleNeeded = 0;
        double totalPeopleNeeded = 0;
        double sampleSize = 1000000;
        Set<Integer> days = new HashSet<>();
        for (int i = 0; i < sampleSize; i++)
        {
            days.clear();
            for (int j = 0; j < 300; j++)
            {
                int n = r.nextInt(365) + 1;
                boolean wasAdded = days.add(n);
                if (!wasAdded)
                {
                    peopleNeeded = j + 1;
                    break;
                }
                
            }
            totalPeopleNeeded += peopleNeeded;
        }
        double averagePeopleNeeded;
        averagePeopleNeeded = totalPeopleNeeded / sampleSize;
        System.out.println("On average, you need " + averagePeopleNeeded + ""
                + " people in a room for at least one birthday to be shared by"
                + " at least two people (1 million samples taken).");
    }
}
