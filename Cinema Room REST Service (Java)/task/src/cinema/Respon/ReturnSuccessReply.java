package cinema.Respon;

import org.json.JSONObject;

/**
 * To return a specific jason format of when the ticket is successfully return
 */
public class ReturnSuccessReply {
        private int row;
        private int column;
        private int price;



        public ReturnSuccessReply(int row, int column, int price) {
            this.row = row;
            this.column = column;
            this.price = price;

        }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    @Override
        public String toString() {
            return "ReturnedTicket{" +
                    "row=" + row +
                    ", column=" + column +
                    ", price=" + price +
                    '}';
        }

    /**
     * Converts a ReturnSuccessReply object to a JSONObject with "returned_ticket" key and its corresponding values.
     * @param reply the ReturnSuccessReply object to be converted
     * @return a JSONObject representation of the ReturnSuccessReply object
     */
    public static JSONObject toJSON(ReturnSuccessReply reply) {
        JSONObject obj = new JSONObject();
        JSONObject returnedTicketObj = new JSONObject();
        returnedTicketObj.put("row", reply.getRow());
        returnedTicketObj.put("column", reply.getColumn());
        returnedTicketObj.put("price", reply.getPrice());
        obj.put("returned_ticket", returnedTicketObj);
        return obj;
    }
    }
