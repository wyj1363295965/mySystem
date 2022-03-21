package com.tik.mysystem.system.entity;

import lombok.Data;

import java.util.List;

@Data
public class MyGeneric<M, N, S, T> {


    private String type;

    private M name;

    private List<N> bean;

    private S age;

    private T sex;
}
