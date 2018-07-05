public class Store {


    private Customers[] customersList;
    private Movie[] moviesList;

    Store(int value) {
        moviesList = new Movie[value];
        customersList = new Customers[value];
    }

    void addCustomers(Customers customers, int index){
        customersList[index] = customers;
    }
    void addMovie(Movie movie, int index) {
        moviesList[index] = movie;
    }

    public void showCustomer(int i) {

        customersList[i].showCustomers();
        System.out.println();
    }

    public void showCustomers() {
        for (int i = 0; i < customersList.length; i++) {
            customersList[i].showCustomers();
            System.out.println();
        }
    }

    public void showMov(int i) {

            moviesList[i].showMovie();
            System.out.println();
    }

    public void showStore() {
        for (int i = 0; i < moviesList.length; i++) {
            moviesList[i].showMovie();
            System.out.println();
        }
    }

    public boolean checkExist(String title) {
        for (int i = 0; i < moviesList.length; i++) {
            if (moviesList[i].checkTitle(title)) {
                return true;
            }
        }
        return false;
    }

    public int idExist(String title) {
        for (int i = 0; i < moviesList.length; i++) {
            if (moviesList[i].checkTitle(title)) {
                return i;
            }
        }
        return -1;
    }

    public void movieRent(String title) {
        int index = idExist(title);
        if (index != -1) {
            if (moviesList[index].checkAvailability()) {
                System.out.println("Film został już wypożyczony!.");
            } else {
                moviesList[index].rent();
                moviesList[index].showMovie();
            }
        } else {
            System.out.println("Niestety, wybrany film jest niedostępny :(");
        }
    }

    public void returnMovie(String title) {
        int index = idExist(title);
        if (index != -1) {
            moviesList[index].giveBack();
        } else {
            System.out.println("Niestety, takiego filmu nie ma w naszej wypożyczalni!");
        }
    }

}
