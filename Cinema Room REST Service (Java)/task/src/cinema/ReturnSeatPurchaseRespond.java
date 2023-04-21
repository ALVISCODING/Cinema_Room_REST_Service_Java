package cinema;

import cinema.Entity.Seat;

public class ReturnSeatPurchaseRespond {

    private  String token;
    private Seat ticket;


    public ReturnSeatPurchaseRespond(String token, Seat ticket) {
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



