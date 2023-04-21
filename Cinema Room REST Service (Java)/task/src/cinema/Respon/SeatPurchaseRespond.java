package cinema.Respon;

import cinema.Entity.Seat;

/**
 * The  response object  when the seat is successfully purchased
 */
public class SeatPurchaseRespond {

    private final String token;
    private final Seat ticket;


    public SeatPurchaseRespond(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }


@Override
public String toString() {
    return "SeatPurchaseRespond{" +
            "token='" + token + '\'' +
            ", ticket=" + ticket +
            '}';
}

    public String toJSONString() {
        return "{" +
                "\"token\":\"" + token + "\"," +
                "\"ticket\":" + ticket.toJSONString() +
                "}";
    }



}



