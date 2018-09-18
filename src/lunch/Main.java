package src.lunch;

import src.aircrafts.AircraftFactory;
import src.aircrafts.Flyable;
import src.excaptions.WeatherExcaptions;
import src.weather.WeatherTower;
//import src.lunch.Writter;

import java.io.*;

class Main{

    public static void main(String[] args){

        for(int i = 0; i < args.length; i++)
        {
            System.out.println("i " + i+ " = " + args[i]);
        }

        int times;
        String FILENAME = "scenario.txt";
        final String OUTPUTFILE_NAME = "simulation.txt";
        BufferedReader br = null;
        Writter writter = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            writter = new Writter(OUTPUTFILE_NAME);

            AircraftFactory aircraftFactory = new AircraftFactory();
            WeatherTower wt = new WeatherTower();

            times = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null)
            {
                String []inputParams = line.split(" ");
                Flyable flyable = aircraftFactory.newAircraft(inputParams[0], inputParams[1], Integer.parseInt(inputParams[2]), Integer.parseInt(inputParams[3]), Integer.parseInt(inputParams[4]));
                flyable.registerTower(wt);

            }
            wt.simulateWeatherChanges(times);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        catch (WeatherExcaptions weatherExcaptions) {
            weatherExcaptions.printStackTrace();
        } 
        finally {

            try {
                br.close();
                writter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
