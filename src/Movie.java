public class Movie {
    private String director;
    private String title;
    private String category;
    private String production;
    private int year;
    private int lenght;

    Movie(String director,
            String title,
            String category,
            String production,
            int year,
            int lenght) {
        this.director = director;
        this.title = title;
        this.category = category;
        this.production = production;
        this.year = year;
        this.lenght = lenght;
        this.rented = false;
    }

    private boolean rented;

    public boolean checkAvailability() {
        return rented;
    }

    public void rent() {
        rented = true;
    }

    public void giveBack() {
        rented = false;
    }

    public void showMovie() {
        System.out.println("Tytuł: " + title);
        System.out.println("Reżyser: " + director);
        System.out.println("Kategoria: " + category);
        System.out.println("Produkcja: " + production);
        System.out.println("Rok: " + year);
        System.out.println("Długość filmu: " + lenght);
    }

    public boolean checkTitle(String title) {
        return this.title == title;
    }

}
