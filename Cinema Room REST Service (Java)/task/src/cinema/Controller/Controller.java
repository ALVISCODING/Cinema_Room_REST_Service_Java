package cinema.Controller;

import cinema.Entity.Seat;
import cinema.Respon.ReturnSuccessReply;
import cinema.Respon.SeatPurchaseRespond;
import cinema.Respon.SeatResponse;
import cinema.Service.SeatService;
import cinema.Service.SeatServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * This is a rest controller class
 *
 */
@RestController
public class Controller {

    /**
     *  Inject the SeatService dependency using Spring's @Autowired annotation
     *  to establish a connection with the service layer.
     */
    @Autowired
    private SeatService seatService;


    public Controller(){
        this.seatService = new SeatServiceIml();
    }

    /**
     * This method to return all the available seats
     * @return the list of available seat objects
     */
    @GetMapping("/seats")
    public SeatResponse getSeats() {
        return seatService.getAvailableSeats();

    }

    /**
     * To purchase the ticket
     * @param ticketRequest the body contain the row and column number
     * @return the ticket object
     */
    @PostMapping("/purchase")
    public ResponseEntity<SeatPurchaseRespond> purchaseSeat(@RequestBody Seat ticketRequest) {
        Seat ticket = new Seat(ticketRequest.getRow(), ticketRequest.getColumn());
        SeatPurchaseRespond seatPurchaseRespond = seatService.purchaseTicket(ticket);
        return ResponseEntity.ok(seatPurchaseRespond);
    }

    /**
     *
     * @param requestBody the token
     * @return the jsonResponse object  from ReturnSuccessReply class
     */
    @PostMapping("return")
    @ResponseBody
    public ResponseEntity<String> returnTicket(@RequestBody String requestBody){

        JSONObject json = new JSONObject(requestBody);// create json object to store the request body token
        String token = json.getString("token"); // extract the token from json
        ReturnSuccessReply reply = seatService.returnedTicket(token);
        // Converting the ReturnSuccessReply object to a JSONObject using the toJSON() method.
        JSONObject jsonResponse = ReturnSuccessReply.toJSON(reply);
        // Returning a ResponseEntity object with the JSON response as a string in the response body.
        return ResponseEntity.ok(jsonResponse.toString());
    }


    /**
     * To check the parameter password is match "super_secret"
     * @param password the  password to gain access to the details
     * @return the statics of the cinema ticket availability and income
     */
    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam Optional<String> password) {
        if (password.isPresent() && password.get().equals("super_secret")){
            return ResponseEntity.ok(seatService.getStats());
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The password is wrong!");
        }
    }
}



