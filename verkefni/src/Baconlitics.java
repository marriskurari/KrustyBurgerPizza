/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baconlitics {
	private List<String> fileLines = new ArrayList<>();
	private List<List<String>> actorsOfMovies = new ArrayList<>();
	private String masterBacon = "Bacon, Kevin";

	private void parseLines() throws IOException {
		FileReader fr = new FileReader("src/movies.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null)
			fileLines.add(line);
	}

	private void parseFile() throws IOException {
		parseLines();
		for(String line : fileLines) {
			System.out.println(line);
			String[] movieAndActors = line.split("/");
			List<String> actors = new ArrayList<>(Arrays.asList(movieAndActors).subList(1, movieAndActors.length));
			actorsOfMovies.add(actors);
		}
	}

	private boolean listContains(List list, Object a) {
		for(Object listItem : list)
			if(listItem.equals(a)) return true;
		return false;
	}

	private void addDifferenceFromListToList(List<String> fromList, List<String> toList) {
		for(String s : fromList)
			if(!listContains(toList, s))
				toList.add(s);
	}

	private List<Integer> getSeparation() {
		System.out.println("BACONATOR");
		List<Integer> howManyDegreesOfSeparationFromMasterBacon = new ArrayList<>();
		List<String> actorsCounted = new ArrayList<>();
		actorsCounted.add(masterBacon);
		int i = 0;
		int actorsCounterBefore = 0;
		do {
			System.out.println(actorsCounted.size());
			howManyDegreesOfSeparationFromMasterBacon.add(actorsCounted.size() - actorsCounterBefore);
			actorsCounterBefore = actorsCounted.size();
			List<List<String>> removalList = new ArrayList<>();
			List<String> newActors = new ArrayList<>();
			for(List<String> actorsInMovie : actorsOfMovies) {
				for(String actor : actorsInMovie)
					if(listContains(actorsCounted, actor)) {
						newActors.addAll(actorsInMovie);
						removalList.add(actorsInMovie);
						break;
					}
			}
			addDifferenceFromListToList(newActors, actorsCounted);
			actorsOfMovies.removeAll(removalList);
		} while (actorsCounterBefore != actorsCounted.size());
		for(List<String> actorsInMovie : actorsOfMovies)
			addDifferenceFromListToList(actorsInMovie, actorsCounted);
		howManyDegreesOfSeparationFromMasterBacon.add(actorsCounted.size() - actorsCounterBefore);
		return howManyDegreesOfSeparationFromMasterBacon;
	}

	public static void main(String[] args) throws IOException {
		Baconlitics bacon = new Baconlitics();
		bacon.parseFile();
		List<Integer> baconList = bacon.getSeparation();
		int i = 0;
		for(Integer a : baconList)
			System.out.println(i++ + ": " + a);
	}

}
