package net.devbay.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FAMILY")
public class Family implements Serializable{

    private long id;
    private int familyMembersAmount;
    private Chair chair;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFamilyMembersAmount() {
        return familyMembersAmount;
    }

    public void setFamilyMembersAmount(int familymembers) {
        this.familyMembersAmount = familymembers;
    }

    @OneToOne
    @JoinColumn(name = "CHAIRID")
    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;

        Family family = (Family) o;

        if (familyMembersAmount != family.familyMembersAmount) return false;
        if (id != family.id) return false;
        if (chair != null ? !chair.equals(family.chair) : family.chair != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + familyMembersAmount;
        result = 31 * result + (chair != null ? chair.hashCode() : 0);
        return result;
    }
}
