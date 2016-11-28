package br.com.cwi.crescer.repository;

import java.util.List;

public interface iDao<T, ID> {

    void insert(T t);

    T find(ID id);
    
    List<T> findAll();
    
    List<T> findByName(String nome);

    void delete(T t);
}
