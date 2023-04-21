package cinema.Entity;

import java.util.Objects;

/**
 * The seat class represent the seat of a cinema
 * Each seat has a row and column number
 * Each seat has a price depends on the number of row
 */
public class Seat {
    int row;
    int column;
    int price = 0;

    public Seat() {
    }

    /**
     * If the row size is larger than or equal 4
     * the price will be $10 else $8
     * @param row the row number of the seat
     * @param column the column number of the seat
     */
    public Seat(int row, int column) {

        this.row = row;
        this.column = column;
        if(this.row<=4 && this.row>=0){
            this.price =10;
        } else if(this.row >4) {
            this.price =8;
        }
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
        return "Ticket{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }

    public String toJSONString() {
        return "Ticket{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat ticket = (Seat) o;
        return row == ticket.row && column == ticket.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }


}
