package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @JoinColumn(name = "empCar")
   private Long id;
   @OneToOne(mappedBy = "empCar")
   private User user;
   public User getUser() {
     return user;
  }

   public void setUser(User user) {
      this.user = user;
   }
   @Column(name = "model")
   private String model;

   @Column(name = "email")
   private String series;

   public Car() {}

   @Override
   public String toString() {
      return "Car{" +
              "model='" + model + "'" +
              ", series='" + series + "'" +
              '}';
   }

   public Car(String model, String email) {
      this.model = model;
      this.series = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getSeries() {
      return series;
   }

   public void setSeries(String email) {
      this.series = email;
   }
}
