package com.amazon.ata.hashingset.partsmanager;

import java.util.HashSet;
import java.util.Set;

public class PartManager {
    // HashSet is Collection class to hold unique elements - no duplicates
    // HashSets will be discussed in the next session
    // HashSet determine hashCode for an object and use that hashCode to store it in the set
    // if a hashCode collision occurs (the hashCode being stored is already in the HashSet)
    // HashSet will determine if the objects are equal, if they are not it does NOT the second object
    private Set<DevicePart> deviceParts = new HashSet<>();

    public void addDevicePart(DevicePart devicePart) {
        boolean isAdded = deviceParts.add(devicePart);
    }

    public void printDeviceParts() {
        for (DevicePart devicePart: deviceParts) {
            System.out.println(devicePart);
        }
    }
}
