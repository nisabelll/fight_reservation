import java.util.ArrayList;
import java.util.List;

public class FlightReservationSystem<T extends Flight> {
    private List<T> flights;  // Uçuşları tutacak liste

    public FlightReservationSystem() {
        flights = new ArrayList<>();  // Listeyi başlatıyoruz
    }

    // Uçuş ekleme
    public void addFlight(T flight) {
        flights.add(flight);
    }

    // Mevcut uçuşları görüntüleme
    public void displayAvailableFlights() {
        if (flights.isEmpty()) {
            System.out.println("No available flights at the moment.");
        } else {
            System.out.println("Available flights:");
            for (T flight : flights) {
                flight.displayFlightDetails();
                System.out.println(); // Boş satır ekliyoruz
            }
        }
    }

    // Uçuş rezervasyonu yapma (örnek metot)
    public void bookFlight(String flightNumber, User user) {
        for (T flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                System.out.println(user.getFullName() + " booked flight: " + flightNumber);
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    // Uçuş iptal etme (örnek metot)
    public void cancelFlight(String flightNumber) {
        flights.removeIf(flight -> flight.getFlightNumber().equals(flightNumber));
        System.out.println("Flight " + flightNumber + " has been cancelled.");
    }

    // Uçuş detaylarını görüntüleme (eklenmiş uçuşlar için)
    public void displayFlightDetails() {
        if (flights.isEmpty()) {
            System.out.println("No flights have been booked yet.");
        } else {
            for (T flight : flights) {
                flight.displayFlightDetails();
            }
        }
    }
}
