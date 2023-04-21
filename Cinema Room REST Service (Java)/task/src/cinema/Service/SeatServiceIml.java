package cinema.Service;

import cinema.Respon.ReturnSuccessReply;
import cinema.Respon.SeatPurchaseRespond;
import cinema.Respon.SeatResponse;
import cinema.Entity.Seat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

/**
 * To control all the business operations
 */
@Service
public class SeatServiceIml implements SeatService {
    private int totalRows= 9; // default size of the row
    private int totalColumn = 9;// default size of the column
    private Set<Seat> bookedTicket = new HashSet<>();// store purchased ticket object
    private Map<String, Seat>ticketRecord = new HashMap<>();// store purchased ticket object and its token
    private List<Seat> availableTickets;// all the available seats

    /**
     * generate the initial list of all available seats
     */
    public SeatServiceIml(){
        availableTickets = new ArrayList<>();

        // add all the seats object into the list
       for(int row =1 ; row <= totalRows; row++){
           for (int column =1; column<=totalColumn; column++  ){
               availableTickets.add(new Seat(row,column));
           }
       }
    }

    /**
     *
     * @return the list if all available seats object
     */
    @Override
    public SeatResponse getAvailableSeats() {
        //list of seat object to return
        List<Seat> available = new ArrayList<>();

        //if the seat not in the purchased record add to the available list
      for(Seat s : availableTickets){
          if(!bookedTicket.contains(s)){
              available.add(s);
          }
      }
        //
        return new SeatResponse(totalRows,totalColumn,available);
    }

    /**
     * When the purchase is successful , a UUID token will be assigned to that seat object and add to the record
     * this method control the purchase business logic
     * @param ticket the seat object to be purchased
     * @return the seat purchase respond object
     */
    @Override
    public SeatPurchaseRespond purchaseTicket(Seat ticket) {
        //the input data is not correct
        if (ticket.getRow() < 1 || ticket.getRow() > totalRows || ticket.getColumn() < 1 || ticket.getColumn() > totalColumn) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or a column is out of bounds!");
        }

        Seat temp = new Seat(ticket.getRow(), ticket.getColumn());
        //check if the input seat object is already purchase
        if (bookedTicket.contains(ticket)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        }
        bookedTicket.add(temp); // add the newly booked seat to the set
        //generate a UUID token for the seat object
        String token = UUID.randomUUID().toString();

        //add to the purchase record
        ticketRecord.put(token,temp);

        //return the SeatPurchaseRespond object
        return new SeatPurchaseRespond(token,temp);
    }

    /**
     * To remove the purchased ticket based on the input token
     * @param token token that is assigned to the seat/ ticket
     * @return the ReturnSuccessReply object
     */
    @Override
    public ReturnSuccessReply returnedTicket(String token){
        Seat temp ;
        //check if the token is in the record of not
        if(ticketRecord.containsKey(token)){
            temp = ticketRecord.get(token);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong token!");
        }
        //remove the seat object from the purchased record
        ticketRecord.remove(token);
        bookedTicket.remove(temp);
        return new ReturnSuccessReply(temp.getRow(),temp.getColumn(),temp.getPrice());
    }

    /**
     * @return the statistics of the available seats, number of purchased tickets and current income
     */
    @Override
    public Map<String, Integer> getStats() {
        Map<String, Integer> stats = new HashMap<>();

        int totalIncome = bookedTicket.stream()
                .mapToInt(Seat::getPrice)
                .sum();

        int availableSeats  = this.availableTickets.size()-bookedTicket.size();

        stats.put("current_income", totalIncome);
        stats.put("number_of_available_seats", availableSeats);
        stats.put("number_of_purchased_tickets", bookedTicket.size());

        return stats;
    }


}
