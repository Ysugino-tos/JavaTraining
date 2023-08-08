package com.s_giken.training.webapp.service;

import java.util.List;
import java.util.Optional;

import com.s_giken.training.webapp.model.Charge;
import com.s_giken.training.webapp.model.ChargeSearchCondition;

public interface ChargeService {
    public List<Charge> findAll();

    public Optional<Charge> findById(int chargeId);// Optionalは引数がNullでも使用できる 曖昧検索に対応するため

    public List<Charge> findByConditions(ChargeSearchCondition memberSearchCondition);

    public void save(Charge charge);

    public void deleteById(int chargeId);
}
