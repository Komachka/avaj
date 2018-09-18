package src.lunch;

import src.aircrafts.AircraftFactory;
import src.aircrafts.Flyable;
import src.excaptions.*;
import java.text.ParseException;
import src.weather.WeatherTower;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;
import java.io.*;

class Main{

    public static void main(String[] args){

        final String FILENAME = "scenario.txt";
        final String OUTPUTFILE_NAME = "simulation.txt";
        int times;
        BufferedReader br = null;
        Writter writter = null;
        String line;

        
        try {
                if(args.length != 1){
                    throw new InputDataExcaption("The input argument is not equals 1");
                } 
                if (!args[0].toLowerCase().equals(FILENAME)) {
                    throw new InputDataExcaption("The input file name is not " + FILENAME);
                }

                br = new BufferedReader(new FileReader(FILENAME));
                writter = new Writter(OUTPUTFILE_NAME);

                AircraftFactory aircraftFactory = new AircraftFactory();
                WeatherTower wt = new WeatherTower();
                times = Integer.parseInt(br.readLine()); 
                while ((line = br.readLine()) != null)
                {
                    String []inputParams = line.split(" +");
                    if (inputParams.length != 5)
                        throw new WeatherExcaptions("Input parameters in 1 line more than have to");
                    Flyable flyable = aircraftFactory.newAircraft(inputParams[0], inputParams[1], Integer.parseInt(inputParams[2]), Integer.parseInt(inputParams[3]), Integer.parseInt(inputParams[4]));
                    flyable.registerTower(wt);

                }
                wt.simulateWeatherChanges(times);

            } 
        catch (NumberFormatException e)
        {
            System.out.println("There is some error \n" + e.toString());
        }

        catch (FileNotFoundException e) {
            System.out.println("There is some error \n" + e.toString()); 
        }   
        catch (UnsupportedEncodingException e) {
            System.out.println("There is some error \n" + e.toString());
        } 
        catch (IOException e) {
            System.out.println("There is some error \n" + e.toString());
        } 
        catch (WeatherExcaptions e) {
            System.out.println("There is some error \n" + e.toString());
        } 
        catch (InputDataExcaption e) {
            System.out.println("There is some error \n" + e.toString());
        }
        catch (java.lang.Exception e)
        {
            System.out.println("There is some error \n" + e.toString());   
        }
        finally {

            try {
                br.close();
                writter.close();
            } catch (IOException e) {
            } catch (NullPointerException e)
            {
                //System.out.println(e.toString());
            }
        }


    }
}
