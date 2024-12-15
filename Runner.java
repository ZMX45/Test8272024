public class Runner{
    private static WatchListManager manager;
    public static void main(String[] args){
        manager = new WatchListManager();
        manager.loadData("movieBacklog.txt", "watchedMovies.txt");
        int choice;
        makeChoice();
        manager.saveData("movieBacklog.txt", "watchedMovies.txt");
    }
    
    public static void makeChoice(){
        int choice;
        do{
            
            mainMenu();
            choice = InputValidator.getValidInteger("Choose an option (1-4): ",1,4);
            System.out.println("You chose option: " + choice);
            if(choice < 4){
                menuChoice(choice);
            }
        } while(choice != 4);
     }
    

    public static void menuChoice(int choice){
        if(choice == 1){
            manager.addMovie();
        }
        if(choice == 2){
            manager.watchMovie();
        }
        if(choice == 3){
            manager.viewMovies();
        }
    }
    

    public static void mainMenu(){
        System.out.println("Choose an option.");
        System.out.println("Option 1. Add movie to watchlist.");
        System.out.println("Option 2. Add movie to list of movies watched.");
        System.out.println("Option 3. View movie watchlist.");
        System.out.println("Option 4. Exit.");
    }
}
