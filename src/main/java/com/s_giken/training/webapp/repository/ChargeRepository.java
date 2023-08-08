package com.s_giken.training.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s_giken.training.webapp.model.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Integer> {
    /*
     * SprintBootでは、予め用意されているのリポジトリアクセス用のメソッド以外のメソッドを
     * 定義するときに、特殊な命名ルールがあります。詳細は以下の参考先URLを確認して下さい。
     * https://docs.spring.io/spring-data/jpa/docs/1.11.1.RELEASE/reference/html/#
     * jpa.query-methods
     * 
     * 予め用意されているメソッド
     * <S extends T> S save(S entity);
     * T findOne(ID primaryKey);
     * Iterable<T> findAll();
     * Long count();
     * void delete(T entity);
     * boolean exists(ID primaryKey);
     */
    public List<Charge> findByNameLike(String name);
}
