package cinema.Service;

import cinema.Respon.ReturnSuccessReply;
import cinema.Respon.SeatPurchaseRespond;
import cinema.Respon.SeatResponse;
import cinema.Entity.Seat;

import java.util.Map;

/**
 * The SeatService interface defines the contract for managing seat reservations in a movie theater.
 * It provides methods for checking seat availability, reserving seats, and getting statistics on seat bookings.
 * Implementations of this interface  provide a way to store and retrieve seat purchase data.
 */
public interface SeatService {
    /**
     *
     * @return all the available Seats object
     */
    SeatResponse getAvailableSeats();

    /**
     * This method is to control the service layer of the purchase respon
     * @param seat the seat object to be purchased
     * @return the seat object if purchased is successes
     */
    SeatPurchaseRespond purchaseTicket(Seat seat);

    /**
     * To allow return a ticket based on the token
     * @param token token that is assigned to the seat/ ticket
     * @return the seat row and column number if successes
     */
    ReturnSuccessReply returnedTicket(String token);


    /**
     * The statistics of the cinema including the income, available seats
     * to the employee only
     * @return
     */
    Map<String, Integer> getStats();
}
