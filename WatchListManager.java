import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class WatchListManager {
    private ArrayList<String> movieBacklog = new ArrayList<>();
    private String[] watchedMovies = new String[10];
    private int watchedMovieCount = 0;
    public static Scanner kb = new Scanner(System.in);

    public void saveData(String availableFile, String watchedFile){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(availableFile))){
            for(String movie: movieBacklog){
            writer.write(movie);
            writer.newLine();
            }
        } catch(IOException e){
            System.out.println("Error saving available movies. " + e);
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(watchedFile))){
            for(int i = 0; i<watchedMovieCount; i++){
            writer.write(watchedMovies[i]);
            writer.newLine();
            }
        } catch(IOException e){
            System.out.println("Error saving watched movies. " + e);
        }

    }

    public void loadData(String availableFile, String watchedFile){
        try(BufferedReader reader = new BufferedReader(new FileReader(availableFile))){
            String line;
            while((line=reader.readLine()) != null){
                movieBacklog.add(line);
            }
        } catch(IOException e){
            System.out.println("Error loading movie backlog. " + e);
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(watchedFile))){
            String line;
            while((line=reader.readLine()) != null){
                watchedMovies[watchedMovieCount++] = line;
            }
        } catch(IOException e){
            System.out.println("Error loading watched movie list. " + e);
        }
    }

    public void addMovie(){
        System.out.print("What is the name of the movie you want to add to your watchlist?: ");
        String movie = kb.nextLine();
        movieBacklog.add(movie);
    } 

    public void watchMovie() throws IndexOutOfBoundsException{
        if(movieBacklog.isEmpty()){
            System.out.println("Your watchlist is empty.");
            return;
        }

        viewMovies();
        int movieIndex = InputValidator.getValidInteger(
            "Enter the index of the movie you watched: ",0,movieBacklog.size() -1
        );

        if(watchedMovieCount >= watchedMovies.length){
            System.out.println("Watched movie array is full.");
            return;
        }
        watchedMovies[watchedMovieCount++] = movieBacklog.remove(movieIndex);
        System.out.print("Movie watched.");
    }

    public void viewMovies(){
        System.out.println("Movies in your backlog: " + movieBacklog);
        System.out.println("Movies that you have watched: ");
        for(int i = 0; 1 < watchedMovieCount -1; i++){
            System.out.print(watchedMovies[i]);
        }
        System.out.println();
    }
}