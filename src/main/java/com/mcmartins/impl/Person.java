package com.mcmartins.impl;

import com.mcmartins.api.User;

/**
 * User implementation class
 *
 * @author Manuel Martins
 */
public class Person implements User {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
