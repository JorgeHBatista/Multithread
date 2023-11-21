package city;

public class City implements City2030 {

    private final String name;
    private final int population;
    private final double surface;

    public City(String name, int population, double surface) {
        this.name = name;
        this.population = population;
        this.surface = surface;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public double getSurface() {
        return surface;
    }

    @Override
    public int getNewPopulation() {
        return (int) (this.getPopulation() * 0.9);
    }

    @Override
    public double getNewSurface() {
        return this.getSurface() + 10000;
    }

    @Override
    public String toString() {
        return  "City " + this.getName() + ":\n" +
                "Population: " + this.getPopulation() + "\n" +
                "Surface: " + this.getSurface() + "\n" +
                "New population: " + this.getNewPopulation() + "\n" +
                "New surface: " + this.getNewSurface();
    }

}
