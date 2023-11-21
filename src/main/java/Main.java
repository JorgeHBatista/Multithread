import city.CityManager;
import ports.in.ConsoleLogger;

public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        consoleLogger.write("Insert the number of cities to store: ");
        int numberOfCities = consoleLogger.askPositiveInt();

        CityManager cityManager = new CityManager(numberOfCities);

        Thread thread1 = new Thread(cityManager);

        thread1.start();

    }
}
