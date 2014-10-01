package net.devbay;

import net.devbay.entity.Chair;
import net.devbay.entity.Family;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Launcher {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("devbay-test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        // or you can simply write entityManager.getTransaction.begin(); and the same to close the transaction.
        entityTransaction.begin();

        Chair chair = new Chair();
        chair.setLegsAmount(3);
        entityManager.persist(chair);

        Family family = new Family();
        family.setFamilyMembersAmount(5);
        family.setChair(chair);
        entityManager.persist(family);

        entityTransaction.commit();

        Family checkEntity = entityManager.find(Family.class,family.getId());

        System.out.println("Family " + checkEntity.getId() + " with " + checkEntity.getFamilyMembersAmount() +
                " members " + "contains a chair " + checkEntity.getChair().getId() + " with " + checkEntity.getChair().getLegsAmount()
                + " legs.");

        entityManager.close();
        entityManagerFactory.close();
    }
}
