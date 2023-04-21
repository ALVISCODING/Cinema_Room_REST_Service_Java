package cinema.Respon;

import cinema.Entity.Seat;

import java.util.List;

/**
 * This is a seat response object that will be return
 * the total number of rows and column of the whole cinema
 * It contains the total number of rows and columns in the theater, as well as an array of available seats
 */
public class SeatResponse {
    private int total_rows;
    private int total_columns;
    //all seat objects available
    private List<Seat> available_tickets;


    public  SeatResponse(int total_rows, int total_columns, List<Seat> available_tickets) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_tickets = available_tickets;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_tickets;
    }

    @Override
    public String toString() {
        return "SeatResponse{" +
                "total_rows=" + total_rows +
                ", total_columns=" + total_columns +
                ", available_tickets=" + available_tickets +
                '}';
    }
}
