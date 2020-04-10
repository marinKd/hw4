//MARIN KOCOLLARI ASSIGNMENT 4 MY9

import java.util.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.io.File;
import java.util.Dictionary;
	

class Movie{
	private String title;
	private String[] genreArr;
	private int movieId;
	private int releaseYear;
	public Movie(int movieId, String title, String genre){
		this.movieId=movieId;
		this.title=title;
		//handles movies with multiple genre listings
		if(genre.contains("|")){
			int count=0;
			char charCheck=('|');
			for(int i=0;i<genre.length();i++){
				if(genre.charAt(i) == charCheck){
					count++;
				}
			}
			genreArr = new String[count+1];
			genreArr = genre.split("\\|");

		}
		//handles single genre listings
		else{
			genreArr = new String[1];
			genreArr[0] = genre;
		}
		try{
			releaseYear = Integer.parseInt(title.substring(title.indexOf("(19")+1, title.indexOf(")", title.indexOf("(19")+1)));
		}
		//handles post 2000 release years
		catch(NumberFormatException e){
			try{
				releaseYear = Integer.parseInt(title.substring(title.indexOf("(20")+1, title.indexOf(")", title.indexOf("(20")+1)));
			}
			//handles specific data format error @ 171695
			catch(NumberFormatException f){
				releaseYear = 0;
			}
		}
		catch(StringIndexOutOfBoundsException e){
			releaseYear = 0;
		}
	}
	
	public String getTitle(){
		return title;
	}
	public String[] getGenre(){
		return genreArr;
	}
	public int getId(){
		return movieId;
	}
	public int getreleaseYear(){
		return releaseYear;
	}
	public void setreleaseYear(int releaseYear){
		this.releaseYear=releaseYear;
	}
	public boolean containsGenre(String genre){
		for(int i = 0;i<genreArr.length;i++){
			if(genreArr[i].equalsIgnoreCase(genre)){
				return true;
			}
		}
		return false;
	}
}




class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader stdin = new BufferedReader(new FileReader("./data/movies.csv"));
		//lines is ArrayList of lines
		//line is array of line contents
		ArrayList<String[]> lines = new ArrayList<String[]>();
		String[] line = new String[3];
		int keyCounter = 0;
		try{
			line = stdin.readLine().split(",", 3);
			while((line = stdin.readLine().split(",", 3)) != null){
				lines.add(line);
				keyCounter++;
			}
		}
		catch(NullPointerException e){
			System.out.print("");
		}
		//Creating arraylist of all movies
		Movie[] allMovies = new Movie[lines.size()];
		
		//Hashtable of movies released in the past 5 years
		Hashtable<String, ArrayList<Movie>> recentMovies = new Hashtable<String, ArrayList<Movie>>();
		recentMovies.put("Action", new ArrayList<Movie>());
		recentMovies.put("Adventure", new ArrayList<Movie>());
		recentMovies.put("Animation", new ArrayList<Movie>());
		recentMovies.put("Comedy", new ArrayList<Movie>());
		recentMovies.put("Crime", new ArrayList<Movie>());
		recentMovies.put("Children", new ArrayList<Movie>());
		recentMovies.put("Drama", new ArrayList<Movie>());
		recentMovies.put("Documentary", new ArrayList<Movie>());
		recentMovies.put("Romance", new ArrayList<Movie>());
		recentMovies.put("Fantasy", new ArrayList<Movie>());
		recentMovies.put("Sci-fi", new ArrayList<Movie>());
		recentMovies.put("Thriller", new ArrayList<Movie>());
		recentMovies.put("Horror", new ArrayList<Movie>());
		recentMovies.put("Musical", new ArrayList<Movie>());
		recentMovies.put("Mystery", new ArrayList<Movie>());
		recentMovies.put("War", new ArrayList<Movie>());
		recentMovies.put("Western", new ArrayList<Movie>());
		
		
		
		
		
		//Hashtable of all movie ArrayLists by genre
		Hashtable<String, ArrayList<Movie>> movies = new Hashtable<String, ArrayList<Movie>>();
		movies.put("Action", new ArrayList<Movie>());
		movies.put("Adventure", new ArrayList<Movie>());
		movies.put("Animation", new ArrayList<Movie>());
		movies.put("Comedy", new ArrayList<Movie>());
		movies.put("Crime", new ArrayList<Movie>());
		movies.put("Children", new ArrayList<Movie>());
		movies.put("Drama", new ArrayList<Movie>());
		movies.put("Documentary", new ArrayList<Movie>());
		movies.put("Romance", new ArrayList<Movie>());
		movies.put("Fantasy", new ArrayList<Movie>());
		movies.put("Sci-fi", new ArrayList<Movie>());
		movies.put("Thriller", new ArrayList<Movie>());
		movies.put("Horror", new ArrayList<Movie>());
		movies.put("Musical", new ArrayList<Movie>());
		movies.put("Mystery", new ArrayList<Movie>());
		movies.put("War", new ArrayList<Movie>());
		movies.put("Western", new ArrayList<Movie>());
		
		//Placing all Movies in the genre appropriate ArrayLists, and also an all-inclusive ArrayList
		//Also places the movies in ArrayLists belonging to hashtable for movies released less than 5 years ago;
		for(int i = 0; i < lines.size(); i++){
			Movie placeHolder = new Movie(Integer.parseInt(lines.get(i)[0]),lines.get(i)[1],lines.get(i)[2]);
			allMovies[i]=placeHolder;
			if(placeHolder.getreleaseYear()>2015){
				if(placeHolder.containsGenre("Action")){
					recentMovies.get("Action").add(placeHolder);
				}
				if(placeHolder.containsGenre("Adventure")){
					recentMovies.get("Adventure").add(placeHolder);
				}
				if(placeHolder.containsGenre("Animation")){
					recentMovies.get("Animation").add(placeHolder);
				}
				if(placeHolder.containsGenre("Comedy")){
					recentMovies.get("Comedy").add(placeHolder);
				}
				if(placeHolder.containsGenre("Crime")){
					recentMovies.get("Crime").add(placeHolder);
				}
				if(placeHolder.containsGenre("Children")){
					recentMovies.get("Children").add(placeHolder);
				}
				if(placeHolder.containsGenre("Drama")){
					recentMovies.get("Drama").add(placeHolder);
				}
				if(placeHolder.containsGenre("Documentary")){
					recentMovies.get("Documentary").add(placeHolder);
				}
				if(placeHolder.containsGenre("Romance")){
					recentMovies.get("Romance").add(placeHolder);
				}
				if(placeHolder.containsGenre("Fantasy")){
					recentMovies.get("Fantasy").add(placeHolder);
				}
				if(placeHolder.containsGenre("Sci-fi")){
					recentMovies.get("Sci-fi").add(placeHolder);
				}
				if(placeHolder.containsGenre("Thriller")){
					recentMovies.get("Thriller").add(placeHolder);
				}
				if(placeHolder.containsGenre("Horror")){
					recentMovies.get("Horror").add(placeHolder);
				}
				if(placeHolder.containsGenre("Musical")){
					recentMovies.get("Musical").add(placeHolder);
				}
				if(placeHolder.containsGenre("Mystery")){
					recentMovies.get("Mystery").add(placeHolder);
				}
				if(placeHolder.containsGenre("War")){
					recentMovies.get("War").add(placeHolder);
				}
				if(placeHolder.containsGenre("Western")){
					recentMovies.get("Western").add(placeHolder);
				}
			}
			if(placeHolder.containsGenre("Action")){
				movies.get("Action").add(placeHolder);
			}
			if(placeHolder.containsGenre("Adventure")){
				movies.get("Adventure").add(placeHolder);
			}
			if(placeHolder.containsGenre("Animation")){
				movies.get("Animation").add(placeHolder);
			}
			if(placeHolder.containsGenre("Comedy")){
				movies.get("Comedy").add(placeHolder);
			}
			if(placeHolder.containsGenre("Crime")){
				movies.get("Crime").add(placeHolder);
			}
			if(placeHolder.containsGenre("Children")){
				movies.get("Children").add(placeHolder);
			}
			if(placeHolder.containsGenre("Drama")){
				movies.get("Drama").add(placeHolder);
			}
			if(placeHolder.containsGenre("Documentary")){
				movies.get("Documentary").add(placeHolder);
			}
			if(placeHolder.containsGenre("Romance")){
				movies.get("Romance").add(placeHolder);
			}
			if(placeHolder.containsGenre("Fantasy")){
				movies.get("Fantasy").add(placeHolder);
			}
			if(placeHolder.containsGenre("Sci-fi")){
				movies.get("Sci-fi").add(placeHolder);
			}
			if(placeHolder.containsGenre("Thriller")){
				movies.get("Thriller").add(placeHolder);
			}
			if(placeHolder.containsGenre("Horror")){
				movies.get("Horror").add(placeHolder);
			}
			if(placeHolder.containsGenre("Musical")){
				movies.get("Musical").add(placeHolder);
			}
			if(placeHolder.containsGenre("Mystery")){
				movies.get("Mystery").add(placeHolder);
			}
			if(placeHolder.containsGenre("War")){
				movies.get("War").add(placeHolder);
			}
			if(placeHolder.containsGenre("Western")){
				movies.get("Western").add(placeHolder);
			}
		}
		//Problem 1; How many movies under each genre? How many for all data vs 5 years
		
		//alldata
		System.out.println("Complete data set");
		System.out.println(movies.get("Action").size()+" Action movies");
		System.out.println(movies.get("Adventure").size()+" Adventure movies");
		System.out.println(movies.get("Animation").size()+" Animation movies");
		System.out.println(movies.get("Comedy").size()+" Comedy movies");
		System.out.println(movies.get("Crime").size()+" Crime movies");
		System.out.println(movies.get("Children").size()+" Children movies");
		System.out.println(movies.get("Documentary").size()+" Documentary movies");
		System.out.println(movies.get("Drama").size()+" Drama movies");
		System.out.println(movies.get("Romance").size()+" Romance movies");
		System.out.println(movies.get("Fantasy").size()+" Fantasy movies");
		System.out.println(movies.get("Sci-fi").size()+" Sci-fi movies");
		System.out.println(movies.get("Thriller").size()+" Thriller movies");
		System.out.println(movies.get("Horror").size()+" Horror movies");
		System.out.println(movies.get("Musical").size()+" Musical movies");
		System.out.println(movies.get("Mystery").size()+" Mystery movies");
		System.out.println(movies.get("War").size()+" War movies");
		System.out.println(movies.get("Western").size()+" Western movies");
		System.out.println();
		System.out.println();
		System.out.println();
		
		//5years
		System.out.println("Released in the last 5 years");
		System.out.println(recentMovies.get("Action").size()+" Action movies");
		System.out.println(recentMovies.get("Adventure").size()+" Adventure movies");
		System.out.println(recentMovies.get("Animation").size()+" Animation movies");
		System.out.println(recentMovies.get("Comedy").size()+" Comedy movies");
		System.out.println(recentMovies.get("Crime").size()+" Crime movies");
		System.out.println(recentMovies.get("Children").size()+" Children movies");
		System.out.println(recentMovies.get("Documentary").size()+" Documentary movies");
		System.out.println(recentMovies.get("Drama").size()+" Drama movies");
		System.out.println(recentMovies.get("Romance").size()+" Romance movies");
		System.out.println(recentMovies.get("Fantasy").size()+" Fantasy movies");
		System.out.println(recentMovies.get("Sci-fi").size()+" Sci-fi movies");
		System.out.println(recentMovies.get("Thriller").size()+" Thriller movies");
		System.out.println(recentMovies.get("Horror").size()+" Horror movies");
		System.out.println(recentMovies.get("Musical").size()+" Musical movies");
		System.out.println(recentMovies.get("Mystery").size()+" Mystery movies");
		System.out.println(recentMovies.get("War").size()+" War movies");
		System.out.println(recentMovies.get("Western").size()+" Western movies");
		System.out.println("----");
		System.out.println("----");
		System.out.println("----");
		
		
		//Problem 2; How many movies of each genre came out each year

		int actionCount=0;
		int adventureCount=0;
		int animationCount=0;
		int comedyCount=0;
		int crimeCount=0;
		int childrenCount=0;
		int documentaryCount=0;
		int dramaCount=0;
		int romanceCount=0;
		int fantasyCount=0;
		int scifiCount=0;
		int thrillerCount=0;
		int horrorCount=0;
		int musicalCount=0;
		int mysteryCount=0;
		int warCount=0;
		int westernCount=0;
		for(int n=1930;n<=2018;n++){
			for(int i=0;i<movies.get("Action").size();i++){
				
				if(movies.get("Action").get(i).getreleaseYear()==n){
					actionCount++;
				}
			};	
			
			for(int i=0;i<movies.get("Adventure").size();i++){
				
				if(movies.get("Adventure").get(i).getreleaseYear()==n){
						adventureCount++;
					}
			}
		
			for(int i=0;i<movies.get("Animation").size();i++){
				
				if(movies.get("Animation").get(i).getreleaseYear()==n){
					animationCount++;
				}
			}
			for(int i=0;i<movies.get("Comedy").size();i++){
				
				if(movies.get("Comedy").get(i).getreleaseYear()==n){
					comedyCount++;
				}
			}
			for(int i=0;i<movies.get("Crime").size();i++){
				
				if(movies.get("Crime").get(i).getreleaseYear()==n){
					crimeCount++;
				}
			}
			for(int i=0;i<movies.get("Children").size();i++){
				
				if(movies.get("Children").get(i).getreleaseYear()==n){
					childrenCount++;
				}
			}
			for(int i=0;i<movies.get("Documentary").size();i++){
				
				if(movies.get("Documentary").get(i).getreleaseYear()==n){
					documentaryCount++;
				}
			}
			for(int i=0;i<movies.get("Drama").size();i++){
				
				if(movies.get("Drama").get(i).getreleaseYear()==n){
					dramaCount++;
				}
			}
			for(int i=0;i<movies.get("Romance").size();i++){
				
				if(movies.get("Romance").get(i).getreleaseYear()==n){
					romanceCount++;
				}
			}
			for(int i=0;i<movies.get("Fantasy").size();i++){
				
				if(movies.get("Fantasy").get(i).getreleaseYear()==n){
					fantasyCount++;
				}
			}
			for(int i=0;i<movies.get("Sci-fi").size();i++){
				
				if(movies.get("Sci-fi").get(i).getreleaseYear()==n){
					scifiCount++;
				}
			}
			for(int i=0;i<movies.get("Thriller").size();i++){
				
				if(movies.get("Thriller").get(i).getreleaseYear()==n){
					thrillerCount++;
				}
			}
			for(int i=0;i<movies.get("Horror").size();i++){
				
				if(movies.get("Horror").get(i).getreleaseYear()==n){
					horrorCount++;
				}
			}
			for(int i=0;i<movies.get("Musical").size();i++){
				
				if(movies.get("Musical").get(i).getreleaseYear()==n){
					musicalCount++;
				}
			}
			for(int i=0;i<movies.get("Mystery").size();i++){
				
				if(movies.get("Mystery").get(i).getreleaseYear()==n){
					mysteryCount++;
				}
			}
			for(int i=0;i<movies.get("War").size();i++){
				
				if(movies.get("War").get(i).getreleaseYear()==n){
					warCount++;
				}
			}
			for(int i=0;i<movies.get("Western").size();i++){
				
				if(movies.get("Western").get(i).getreleaseYear()==n){
					westernCount++;
				}
			}
		System.out.println();
		System.out.println();
		System.out.println("Released in "+n);
		System.out.println(actionCount+" action movies");
		System.out.println( adventureCount+" adventure  movies");
		System.out.println( animationCount+" animation  movies");
		System.out.println( comedyCount+" comedy  movies");
		System.out.println( crimeCount+" crime  movies");
		System.out.println( childrenCount+" children's  movies");
		System.out.println( documentaryCount+" documentary  movies");
		System.out.println( dramaCount+" drama  movies");
		System.out.println( romanceCount+" romance  movies");
		System.out.println( fantasyCount+" fantasy  movies");
		System.out.println( scifiCount+" sci-fi  movies");
		System.out.println( thrillerCount+" thriller  movies");
		System.out.println( horrorCount+" horror  movies");
		System.out.println( musicalCount+" musical  movies");
		System.out.println( mysteryCount+" mystery  movies");
		System.out.println( warCount+" war  movies");
		System.out.println( westernCount+" western  movies");
		actionCount=0;
		adventureCount=0;
		animationCount=0;
		comedyCount=0;
		crimeCount=0;
		childrenCount=0;
		documentaryCount=0;
		dramaCount=0;
		romanceCount=0;
		fantasyCount=0;
		scifiCount=0;
		thrillerCount=0;
		horrorCount=0;
		musicalCount=0;
		mysteryCount=0;
		warCount=0;
		westernCount=0;
		}
	}
}
