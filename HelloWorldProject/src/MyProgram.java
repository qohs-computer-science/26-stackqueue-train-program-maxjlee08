/*
 * TODO: Maxwell Lee
 * TODO: 1/17/26
 * TODO: Period: 4
 * TODO: This program uses queues and stacks to sort train cars, send trains out, and say what leaves or stays at the station
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	static Queue<Train> inspect = new LinkedList<>();

	static Stack<Train> trackA = new Stack<>();
	static Stack<Train> trackB = new Stack<>();	
	static Stack<Train> trackC = new Stack<>();
	static Stack<Train> trackD = new Stack<>();
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	
		Scanner in = new Scanner(System.in);
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			in = new Scanner (f);
			String name = in.nextLine();
			System.out.println(name);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return;
		}

		Queue<Train> trackStart = new LinkedList<>();
		Queue<String> engine1 = new LinkedList<>();
		
		int weightA = 0, weightB = 0, weightC = 0;
		








		while(in.hasNextLine()){
			String line = in.nextLine();
		

		if(line.equals("END")){
			break;
		}

		if(line.startsWith("ENG")){
			String engineID = line;
			String city = in.nextLine();
			engine1.add(engineID);
			engine1.add(city);
		}
		else if (line.startsWith("CAR")){
			String name = line;
			String product = in.nextLine();
			String origin = in.nextLine();
			String destination = in.nextLine();
			int weight = Integer.parseInt(in.nextLine());
			int miles = Integer.parseInt(in.nextLine());
			
			Train newCar = new Train(name, product, origin, destination, weight, miles);
			trackStart.add(newCar);
		}
	}

	while(!trackStart.isEmpty()){
		Train car = trackStart.remove();

		if(car.getMiles() > 700){
			inspect.add(car); 
		} else{
			if(car.getDestination().equals("Trenton")){
				if(weightA + car.getWeight() > limitTrackA){
					depart(trackA, "ENG00000", "Trenton");
					weightA = 0;
				}
				trackA.push(car);
				weightA += car.getWeight();
			} else if(car.getDestination().equals("Charlotte")){
				if(weightB + car.getWeight() > limitTrackB){
					depart(trackB, "ENG00000", "Charlotte");
					weightB = 0;
				}
				trackB.push(car);
				weightB += car.getWeight();
			} else if(car.getDestination().equals("Baltimore")){
				if(weightC + car.getWeight() > limitTrackC){
					depart(trackC, "ENG00000", "Baltimore");
					weightC = 0;
				}
				trackC.push(car);
				weightC += car.getWeight();
			}
			 else{
				trackD.push(car);
			}
		}
	}


	Queue<Train> tempInspect = new LinkedList<>(inspect);
	//inspect.clear();
	while(!tempInspect.isEmpty()){
		Train car = tempInspect.remove();
		car.resetMiles();

		if(car.getDestination().equals("Trenton")){
			trackA.push(car);
			}
		else if(car.getDestination().equals("Charlotte")){
			trackB.push(car);
			}
		else if(car.getDestination().equals("Baltimore")){
			trackC.push(car);
			}
		else{
			trackD.push(car);
			}
		}
		

		while(!engine1.isEmpty()){
			String engineID = engine1.remove();
			String city = engine1.remove();

			if(city.equals("Trenton")){
				depart(trackA, engineID, city);
			} else if(city.equals("Charlotte")){
				depart(trackB, engineID, city);
			} else if(city.equals("Baltimore")){
				depart(trackC, engineID, city);
			} else{
				depart(trackD, engineID, city);
			}
			
		}

		if(!trackA.isEmpty())
			depart(trackA, "ENG00000", "Trenton");
		
		if(!trackB.isEmpty())
			depart(trackB, "ENG00000", "Charlotte");
		
		if(!trackC.isEmpty())
			depart(trackC, "ENG00000", "Baltimore");
		
		if(!trackD.isEmpty())
			depart(trackD, "ENG00000", "Other Destinations");
		
		status();
		
	}



		private static void depart(Stack<Train> track, String engineID, String city){
			if(track.isEmpty()){
				return;
			}
			System.out.println(engineID + " leaving for " + city + " with the following cars:");
			while(!track.isEmpty()){
				track.pop().printCar();
			}
		}	

		public static void status(){
			System.out.println("-----Station Status-----");
			

			System.out.println("Cars waiting for Trenton:");
			for(Train car : trackA){
				car.printCar();
			}
			System.out.println("Cars waiting for Charlotte:");
			for(Train car : trackB){
				car.printCar();
			}
			System.out.println("Cars waiting for Baltimore:");
			for(Train car : trackC){
				car.printCar();
			}
			System.out.println("Cars waiting for Other Destinations:");
			for(Train car : trackD){
				car.printCar();
			}
			System.out.println("Cars waiting for Inspection:");
			for(Train car : inspect){
				car.printCar();
			}
		}

		

		

		

		

	}
		

	


