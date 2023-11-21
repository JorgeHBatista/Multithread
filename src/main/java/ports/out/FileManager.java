package ports.out;

import city.City;
import city.CityManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager implements Runnable {

    private BufferedWriter writer;
    private final CityManager cityManager;

    public FileManager (String name, CityManager cityManager) {
        this.cityManager = cityManager;
        try {
            this.writer = new BufferedWriter(new FileWriter(name));
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public BufferedWriter getWriter() {
        return this.writer;
    }

    public void write(String message) {
        if (getWriter() != null) {
            try {
                getWriter().write(message);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }

    public void closeFile() {
        try {
            getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        ArrayList<City> cities = cityManager.getCities();
        for (City city: cities) {
            try {
                writer.write(city.toString() + "\n\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.closeFile();
        System.out.println("Thread " + Thread.currentThread().getName() + " finished successfully!");
    }

}