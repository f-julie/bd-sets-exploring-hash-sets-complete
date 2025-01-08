package com.amazon.ata.hashingset.partsmanager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartManager {
    // HashSet is Collection class to hold unique elements - no duplicates
    // HashSets will be discussed in the next session
    // HashSet determine hashCode for an object and use that hashCode to store it in the set
    // if a hashCode collision occurs (the hashCode being stored is already in the HashSet)
    // HashSet will determine if the objects are equal, if they are not it does NOT the second object

    private int NUMPARTS = 10; // Number of elements in the array
    private Set<DevicePart> deviceParts = new HashSet<>(); // Does not allow duplicates

    // In order to keep duplicate in the event of a collision, we store the parts
    // in an array of ArrayList<DevicePart>, instead of HashSet

    // To define an array: datatype[] name = new datatype[number-of-elements]

    List<DevicePart>[] parts = new ArrayList[NUMPARTS]; // Array of 10 ArrayList<DevicePart>

    // Modified to store duplicate hashcode parts in an array of ArrayLists
    public void addDevicePart(DevicePart devicePart) {
        // Add the part to the HashSet - does not allow duplicates
        // Leaving in for comparison purposes
        boolean isAdded = deviceParts.add(devicePart);

        // Adding a DevicePart to the ArrayList element in the array
        // 1. Find the HashCode for the DevicePart
        int hashCode = devicePart.hashCode();

        // 2. Determine the index for the array based on the HashCode (use modulus operator %)
        // Math.abs() to get absolute value of the index in case it's negative
        int partIndex = Math.abs(hashCode % NUMPARTS); // Modulus of a value and size of array = index

        // OR combine the above two lines
        // int partIndex = Math.abs(devicePart.hashCode() % NUMPARTS);

        // 3. Store the DevicePart in the ArrayList of the element at the index indicated by the HashCode

        if (parts[partIndex] != null) { // Do we already have an ArrayList at that element in the array?
            parts[partIndex].add(devicePart); // Yes - add the new DevicePart to the ArrayList at that element
        } else { // No - create an ArrayList for the element and add the new DevicePart to it
            parts[partIndex] = new ArrayList<DevicePart>();
            parts[partIndex].add(devicePart);
        }
        return; // not required - added to stop in the debugger if we want to
    }

    public void printDeviceParts() {
        for (DevicePart devicePart: deviceParts) {
            System.out.println(devicePart);
        }
    }
}
