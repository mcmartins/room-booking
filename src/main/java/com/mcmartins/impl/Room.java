package com.mcmartins.impl;

import com.mcmartins.api.Resource;

/**
 * Resource implementation class
 *
 * @author Manuel Martins
 */
public class Room implements Resource {

    private int resourceId;

    public Room(int resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * {@inheritDoc}
     */
    public int getId() {
        return this.resourceId;
    }

    @Override
    public String toString() {
        return String.valueOf(this.resourceId);
    }

    @Override
    public boolean equals(Object obj) {
        return this.resourceId == ((Resource) obj).getId();
    }

    @Override
    public int hashCode() {
        return this.resourceId;
    }
}
