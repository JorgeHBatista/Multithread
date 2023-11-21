package city;

import ports.in.ConsoleLogger;
import ports.out.FileManager;

import java.util.ArrayList;

public class CityManager implements Runnable {

    private final int numberOfCities;
    private String[][] dataCities;
    private ArrayList<City> cities;

    public CityManager(int numberOfCities) {
        this.numberOfCities = numberOfCities;
        this.dataCities = new String[numberOfCities][3];
        this.cities = new ArrayList<City>();
    }

    public int getNumberOfCities() {
        return numberOfCities;
    }

    public ArrayList<City> getCities() {
        return this.cities;
    }

    public void createCities() {
        for (int i = 0; i < this.getNumberOfCities(); i++) {
            cities.add(new City(dataCities[i][0], Integer.parseInt(dataCities[i][1]), Double.parseDouble(dataCities[i][2])));
        }
        System.out.println("Cities created successfully!");
    }

    public void obtainDataCities() {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        for (int i = 0; i < this.getNumberOfCities(); i++) {
            consoleLogger.write("Insert the name for the city number " + (i + 1));
            dataCities[i][0] = consoleLogger.askString();
            consoleLogger.write("Insert the population for " + dataCities[i][0]);
            dataCities[i][1] = String.valueOf(consoleLogger.askPositiveInt());
            consoleLogger.write("Insert the surface for " + dataCities[i][0]);
            dataCities[i][2] = String.valueOf(consoleLogger.askDouble());
        }
        consoleLogger.write("Data from cities inserted successfully!");
    }

    @Override
    public void run() {
        obtainDataCities();
        createCities();
        System.out.println("Thread " + Thread.currentThread().getName() + " finished successfully!");
        FileManager fileManager = new FileManager("Info_cities.txt", this);
        Thread thread2 = new Thread(fileManager);
        thread2.start();
    }
}
