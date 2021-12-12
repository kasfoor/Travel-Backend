package com.travelbackend.travelbackend.microservices.Destination;

import javax.persistence.*;

@Entity
@Table
public class Destination {
    @Id
    @SequenceGenerator(
            name = "destination_sequence",
            sequenceName = "destination_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "destination_sequence"
    )
    private Long destId;
    private String place;
    private String country;
    private String latitude;
    private String longitude;
    private Long info;
   // private Image image;

    public Destination() {
    }

    public Destination(Long destId, String place, String country, String latitude, String longitude, Long info) {
        this.destId = destId;
        this.place = place;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.info = info;
       // this.image = image;
    }

    public Destination(String place, String country, String latitude, String longitude, Long info) {
        this.place = place;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.info = info;
       // this.image = image;
    }

    public Long getDestId() {
        return destId;
    }

    public String getPlace() {
        return place;
    }

    public String getCountry() {
        return country;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Long getInfo() {
        return info;
    }

//    public Image getImage() {
//        return image;
//    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setInfo(Long info) {
        this.info = info;
    }

//    public void setImage(Image image) {
//        this.image = image;
//    }

    @Override
    public String toString() {
        return "Destination{" +
                "destId=" + destId +
                ", place='" + place + '\'' +
                ", country='" + country + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", info=" + info +
                '}';
    }
}
