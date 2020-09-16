package com.example.sultanride;

public class RecyclerViewModel {

    Integer vehicleimage;
    String vehiclename;

    public RecyclerViewModel(Integer vehicleimage, String vehiclename) {
        this.vehicleimage = vehicleimage;
        this.vehiclename = vehiclename;
    }

    public Integer getVehicleimage() {
        return vehicleimage;
    }

    public void setVehicleimage(Integer vehicleimage) {
        this.vehicleimage = vehicleimage;
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename;
    }
}
