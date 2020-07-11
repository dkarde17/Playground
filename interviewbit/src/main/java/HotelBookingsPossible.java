import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 *
 * Hotel Bookings Possible
 * Asked in:
 * Goldman Sachs
 * Microsoft
 * Problem Description
 *
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 *
 *
 *
 * Input Format
 * First argument is an integer array A containing arrival time of booking.
 * Second argument is an integer array B containing departure time of booking.
 * Third argument is an integer C denoting the count of rooms.
 *
 *
 *
 * Output Format
 * Return True if there are enough rooms for N bookings else return False.
 * Return 0/1 for C programs.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 3, 5]
 *  B = [2, 6, 8]
 *  C = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class HotelBookingsPossible {
    /*
    Idea is that a corresponding pair of arrival and departure will always look like arrive <= depart
    now if we sort both the arrive and depart arrays, we don't need to worry about the relative order of individual departures
    any departure means a room is getting free and any arrival means that a room is getting occupied so you don't necessarily
    need to process corresponding pairs of arrival and departures.
     */
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int a = 0, d = 0;
        int count = 0;
        while(a < arrive.size() && d < depart.size()) {
            int arrival = arrive.get(a);
            int departure = depart.get(d);
            if(arrival < departure) {
                ++count;
                ++a;
            } else if (arrival > departure){
                --count;
                ++d;
            } else {
                ++a;
                ++d;
            }
            if(count > K)
                return false;
            //add increments
        }
        while(a < arrive.size()){
            ++count;
            ++a;
            if(count > K)
                return false;
        }/*
        while(d < depart.size()) {
            --count;
            ++d;
        }*/
        return true;
    }

    public static void main(String[] args) {
        HotelBookingsPossible hotelBookingsPossible = new HotelBookingsPossible();
        int[] a = {1, 2, 3, 4 };
        int[] b = {10, 2, 6, 14 };
        int k = 4;
        ArrayList<Integer> arrive = new ArrayList<>();
        for (int x : a)
            arrive.add(x);
        ArrayList<Integer> depart = new ArrayList<>();
        for (int x : b)
            depart.add(x);
        System.out.println(hotelBookingsPossible.hotel(arrive, depart, k));
    }
}
