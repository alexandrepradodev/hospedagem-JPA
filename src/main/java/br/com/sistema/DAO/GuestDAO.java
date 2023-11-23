package br.com.sistema.DAO;

import br.com.sistema.model.Guest;

import javax.persistence.EntityManager;
import java.util.List;

public class GuestDAO {
    private EntityManager entityManager;

    public GuestDAO() {
    }

    public GuestDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Guest guest) {
        entityManager.persist(guest);
    }

    public Guest getGuestPerId(Long id) {
        String jpql = "SELECT g FROM Guest g WHERE id = :id";
        return entityManager
                .createQuery(jpql, Guest.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    public List<Guest> getAllGuests() {
        String jpql = "SELECT g FROM Guest g";

        return entityManager
                .createQuery(jpql, Guest.class)
                .getResultList();
    }
}
