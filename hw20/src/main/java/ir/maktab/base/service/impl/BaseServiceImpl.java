package ir.maktab.base.service.impl;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.base.entity.BaseEntity;
import ir.maktab.base.service.BaseService;
import jakarta.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseDao<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        try {
            transaction.begin();
            repository.save(e);
            transaction.commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            transaction.rollback();
        }
        return e;
    }


    @Override
    public E update(E e) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        repository.update(e);
        transaction.commit();
        return e;
    }

    @Override
    public void delete(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.delete(e);
        repository.getEntityManager().getTransaction().commit();

    }

    @Override
    public E findById(ID id) {
        if (isExistsById(id))
            return repository.findById(id);
        else return null;
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean isExistsById(ID id) {
        return repository.isExistsById(id);
    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }
}