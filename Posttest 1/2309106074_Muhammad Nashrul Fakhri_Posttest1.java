import java.util.ArrayList;
import java.util.Scanner;

class Flight {
    String departureTime;
    String arrivalTime;
    String airlineName;
    String airlineType;
    String departureLocation;
    String arrivalLocation;

    public Flight(String departureTime, String arrivalTime, String airlineName, String airlineType, String departureLocation, String arrivalLocation) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airlineName = airlineName;
        this.airlineType = airlineType;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    @Override
    public String toString() {
        return "Jadwal Penerbangan: " + departureTime + " - " + arrivalTime + "\n" +
               "Pesawat: " + airlineName + " (" + airlineType + ")\n" +
               "Rute: " + departureLocation + " -> " + arrivalLocation;
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

        flights.add(new Flight(departureTime, arrivalTime, airlineName, airlineType, departureLocation, arrivalLocation));
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
        if (flights.isEmpty()) {
            System.out.println("Tidak ada jadwal yang bisa diubah.");
            return;
        }
        viewFlights();
        System.out.print("Pilih nomor jadwal yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index >= 0 && index < flights.size()) {
            System.out.print("Masukkan Jam Berangkat Baru: ");
            flights.get(index).departureTime = scanner.nextLine();
            System.out.print("Masukkan Nama Pesawat Baru: ");
            flights.get(index).airlineName = scanner.nextLine();
            System.out.println("Jadwal berhasil diperbarui.");
        } else {
            System.out.println("Nomor tidak valid.");
        }
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