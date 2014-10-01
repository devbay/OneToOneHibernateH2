package net.devbay.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CHAIR")
public class Chair implements Serializable{

    private long id;
    private int legsAmount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAIRID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLegsAmount() {
        return legsAmount;
    }

    public void setLegsAmount(int legsAmount) {
        this.legsAmount = legsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chair)) return false;

        Chair chair = (Chair) o;

        if (id != chair.id) return false;
        if (legsAmount != chair.legsAmount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + legsAmount;
        return result;
    }
}
