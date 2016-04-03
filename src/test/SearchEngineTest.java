package test;

import controllers.SearchEngine;
import models.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.*;

/**
 * Created by stefa on 4/3/2016.
 */
public class SearchEngineTest {


    private SearchEngine searchEngine;
    private ArrayList<Flight> flightListLondon;;
    private ArrayList<Flight> flightListAprilThird;
    private ArrayList<Flight> flightListAll;
    private ArrayList<Flight> filteredListOne;
    private ArrayList<Flight> filteredListTwo;
    private ArrayList<Flight> filteredListThree;



    @Before
    public void setUp() throws Exception {
        searchEngine = new SearchEngine(new DatabaseRetrieverMock());
        flightListLondon = searchEngine.searchFlightByCriteria("London", "02.02.2016", "Keflavik", "06.06.2016", 10);
        flightListAprilThird = searchEngine.searchFlightByCriteria("Dont Care", "03.04.2016", "Keflavik", "06.06.2016", 5);
        flightListAll = searchEngine.searchFlightByCriteria("No Preference", "Don't care", "Keflavik", "Don't care", 1);
    }

    @After
    public void tearDown() throws Exception {
        flightListLondon.clear();
        flightListAprilThird.clear();
        flightListAll.clear();
    }


    @Test
    public void testFilterWifiFlights() throws Exception{
        ArrayList<Flight> filteredWifiList = searchEngine.filterFlightList(flightListAll,"01.01.2016", "30.12.2016",false,true,false,0);
        for(Flight flight : filteredWifiList){
            assertEquals(true, flight.getPassengerLuxuries().isWifiAvailable());
        }
    }

    @Test
    public void testDescendingOrder() throws Exception{
        ArrayList<Flight> filteredDescendingList = searchEngine.filterFlightList(flightListAll,"01.01.2016", "30.12.2016",false, false, true, 0);
        assertTrue(filteredDescendingList.get(0).getPrice() >= filteredDescendingList.get(filteredDescendingList.size()-1).getPrice());
    }

    @Test
    public void testSagaAvailability() throws Exception{
        ArrayList<Flight>  filteredSagaList = searchEngine.filterFlightList(flightListAll,"01.01.2016", "30.12.2016",true,false,false,0);
        for (Flight flight : filteredSagaList){
            int numAvailableSagaSeats = flight.getNumSagaSeats()-flight.getBookedSagaSeats();
            assertTrue(numAvailableSagaSeats > 0);
        }
    }

    @Test
    public void testWithinDateFrame() throws Exception{
        ArrayList<Flight>  filteredSagaList = searchEngine.filterFlightList(flightListAll,"03.04.2016", "04.04.2016",false,false,false,0);
    }




}