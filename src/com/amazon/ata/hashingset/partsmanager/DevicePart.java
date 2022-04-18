package com.amazon.ata.hashingset.partsmanager;

import java.util.List;
import java.util.Objects;

public class DevicePart {
    private String manufacturer;           // Read-only - no setters - immutable
    private String manufacturersPartNumber;// Read-only - no setters - immutable
    private String partName;
    private List<AmazonDevice> devicesUsedIn;

    public DevicePart (String manufacturer, String manufacturersPartNumber, String partName, List<AmazonDevice> devicesUsedIn) {
        this.manufacturer = manufacturer;
        this.manufacturersPartNumber = manufacturersPartNumber;
        this.partName = partName;
        this.devicesUsedIn = devicesUsedIn;
    }

    public String getPartName() {
        return partName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturersPartNumber() {
        return manufacturersPartNumber;
    }

    public List<AmazonDevice> getDevicesUsedIn() {
        return devicesUsedIn;
    }

    public void setPartName (String partName) {
        this.partName = partName;
    }

    public void setDevicesUsedIn(List<AmazonDevice> devicesUsedIn) {
        this.devicesUsedIn = devicesUsedIn;
    }

    public void addDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.add(amazonDevice);
    }

    public void removeDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.remove(amazonDevice);
    }

    @Override
    public String toString() {
        return "DevicePart{" +
                "manufacturer='" + manufacturer + '\'' +
                ", manufacturersPartNumber='" + manufacturersPartNumber + '\'' +
                ", partName='" + partName + '\'' +
                ", devicesUsedIn=" + devicesUsedIn +
                '}';
    }

    // Since there is no equals() nor hashCode() method for this class
    // Java will the Object class equals() and  hashCode()methods when it needs them
    // The object class equals() and hashCode() methods use the location of the objects
    // NOT the content of the objects so two objects can never be equal because they cannot
    // be in the same location and two objects will generate the same hashCode even if their
    // mutable data is different
    // objects are equal is their content is the same and they should generate different hashCodes
    //    if their immutable data is different.
    // This is why we use equals() method to compare two Strings instead of ==
    // equals() compares of the String whereas == compares their locations

    @Override  //Optional - tells the compiler to be sure this is a correct override
               //           same method-name, same parameters, compatible-return-type
    public boolean equals(Object o) {                 // Receives an generic object
        System.out.println("---- .equals()   method for DevicePart class run ----");
        if (this == o) return true;                   // if the object being compared is the same as the object being compared to, they're equal
        if (!(o instanceof DevicePart)) return false; // If the object being compared is not same the same class, they're not equal
        DevicePart that = (DevicePart) o;             // Instantiate an object of this class from the generic object we are passed
        // Compare the contents of the two objects
        return getManufacturer().equals(that.getManufacturer()) && getManufacturersPartNumber().equals(that.getManufacturersPartNumber());
    }

    @Override
    public int hashCode() {
        System.out.println("---- .hashCode() method for DevicePart class run ----");
        // Use the Java hash() to create hash code for the object
        // ONly include immutable member variables
        return Objects.hash(getManufacturer(), getManufacturersPartNumber());
    }
}
