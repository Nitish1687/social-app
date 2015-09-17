package com.nitish.mapper;

/**
 * Created by nsm1211 on 16-09-2015.
 */
public interface Mapper<L,R> {

    R mapToDTO(L r);
    L mapToBean(R r);
}
