import java.util.ArrayList;
import java.util.Scanner;

// inharitance superclass pada flight berfungsi mewariskan kelas hasil keturunan yang lain
class Flight {
    private String departureTime;
    private String arrivalTime;
    private String airlineName;
    private String airlineType;
    private String departureLocation;
    private String arrivalLocation;

    public Flight(String departureTime, String arrivalTime, String airlineName, String airlineType, String departureLocation, String arrivalLocation) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airlineName = airlineName;
        this.airlineType = airlineType;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public String toString() {
        return "Jadwal Penerbangan: " + departureTime + " - " + arrivalTime + "\n" +
               "Pesawat: " + airlineName + " (" + airlineType + ")\n" +
               "Rute: " + departureLocation + " -> " + arrivalLocation;
    }
}

// inharitance subclass pada commrtcialflight berfungsi menghasilkan keturunan dari kelas lain
class CommercialFlight extends Flight {
    private int passengerCapacity;

    public CommercialFlight(String departureTime, String arrivalTime, String airlineName, String airlineType, String departureLocation, String arrivalLocation, int passengerCapacity) {
        super(departureTime, arrivalTime, airlineName, airlineType, departureLocation, arrivalLocation);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe: Komersial\nKapasitas Penumpang: " + passengerCapacity;
    }
}

// inharitance subclass pada privateflight berfungsi menghasilkan keturunan dari kelas lain
class PrivateFlight extends Flight {
    private String owner;

    public PrivateFlight(String departureTime, String arrivalTime, String airlineName, String airlineType, String departureLocation, String arrivalLocation, String owner) {
        super(departureTime, arrivalTime, airlineName, airlineType, departureLocation, arrivalLocation);
        this.owner = owner;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe: Pribadi\nPemilik: " + owner;
    }
}

public class FlightManagement {
    static ArrayList<Flight> flights = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nManajemen Penerbangan Pesawat");
            System.out.println("1. Tambah Jadwal Pesawat");
            System.out.println("2. Lihat Jadwal Pesawat");
            System.out.println("3. Ubah Jadwal Pesawat");
            System.out.println("4. Hapus Jadwal Pesawat");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    viewFlights();
                    break;
                case 3:
                    updateFlight();
                    break;
                case 4:
                    deleteFlight();
                    break;
                case 5:
                    System.out.println("Anda telah keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    static void addFlight() {
        System.out.println("Pilih jenis penerbangan:");
        System.out.println("1. Komersial");
        System.out.println("2. Pribadi");
        System.out.print("Pilihan: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Masukkan Jam Berangkat: ");
        String departureTime = scanner.nextLine();
        System.out.print("Masukkan Jam Tiba: ");
        String arrivalTime = scanner.nextLine();
        System.out.print("Masukkan Nama Pesawat: ");
        String airlineName = scanner.nextLine();
        System.out.print("Masukkan Tipe Pesawat: ");
        String airlineType = scanner.nextLine();
        System.out.print("Masukkan Lokasi Keberangkatan: ");
        String departureLocation = scanner.nextLine();
        System.out.print("Masukkan Lokasi Kedatangan: ");
        String arrivalLocation = scanner.nextLine();

        if (typeChoice == 1) {
            System.out.print("Masukkan Kapasitas Penumpang: ");
            int passengerCapacity = scanner.nextInt();
            flights.add(new CommercialFlight(departureTime, arrivalTime, airlineName, airlineType, departureLocation, arrivalLocation, passengerCapacity));
        } else if (typeChoice == 2) {
            System.out.print("Masukkan Nama Pemilik: ");
            String owner = scanner.nextLine();
            flights.add(new PrivateFlight(departureTime, arrivalTime, airlineName, airlineType, departureLocation, arrivalLocation, owner));
        } else {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        System.out.println("Jadwal pesawat berhasil ditambahkan.");
    }

    static void viewFlights() {
        if (flights.isEmpty()) {
            System.out.println("Tidak ada jadwal penerbangan.");
            return;
        }
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". " + flights.get(i));
        }
    }

    static void updateFlight() {
        System.out.println("Fitur update belum tersedia untuk subclass.");
    }

    static void deleteFlight() {
        if (flights.isEmpty()) {
            System.out.println("Tidak ada jadwal yang bisa dihapus.");
            return;
        }
        viewFlights();
        System.out.print("Pilih nomor jadwal yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < flights.size()) {
            flights.remove(index);
            System.out.println("Jadwal berhasil dihapus.");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }
}
