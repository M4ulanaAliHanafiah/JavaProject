package MyProject.Project1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReservasiBioskop {

    // deklarasi variable dengan nilai tetap
    private static final int JAM_BUKA = 10;
    private static final int JAM_TUTUP = 21;
    private static final DateTimeFormatter FORMAT_TANGGAL = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDateTime waktuSaatIni = LocalDateTime.now();
        LocalTime jamSaatIni = waktuSaatIni.toLocalTime();

        // input data
        System.out.println("=== Aplikasi Reservasi Kursi Bioskop Mini ===");
        System.out.println("Waktu saat ini: " + waktuSaatIni);

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine().trim();

        System.out.print("Pilih jenis kursi (R = Reguler, V = VIP, X = VVIP): ");
        String kodeKursi = input.nextLine().trim().toUpperCase();

        if (nama.isEmpty() || kodeKursi.isEmpty()) {
            System.out.println("Nama dan kode kursi tidak boleh kosong.");
            input.close();
            return;
        }

        // Validasi data
        if (!isWaktuReservasiValid(jamSaatIni)) {
            System.out.println("Reservasi hanya bisa dilakukan antara jam 10:00 - 21:00.");
            input.close();
            return;
        }

        JenisKursi kursi = JenisKursi.fromKode(kodeKursi);
        if (kursi == null) {
            System.out.println("Kode kursi tidak valid!");
            input.close();
            return;
        }

        tampilkanInformasiKursi(kursi);

        System.out.println("Terima kasih, " + nama + ". Kursi " + kursi + " berhasil dipesan.");
        System.out.println("Total harga: Rp " + kursi.getHarga());
        System.out.println("Waktu pemesanan: " + waktuSaatIni.format(FORMAT_TANGGAL));

        input.close();
    }

    private static boolean isWaktuReservasiValid(LocalTime time) {
        return !time.isBefore(LocalTime.of(JAM_BUKA, 0)) &&
               !time.isAfter(LocalTime.of(JAM_TUTUP, 0));
    }

    private static void tampilkanInformasiKursi(JenisKursi kursi) {
        switch (kursi) {
            case VVIP:
                System.out.println("Anda memilih kursi VVIP. Nikmati pengalaman terbaik!");
                break;
            case VIP:
                System.out.println("Anda memilih kursi VIP. Selamat menonton!");
                break;
            case REGULER:
                System.out.println("Anda memilih kursi Reguler.");
                break;
        }
    }

    // ENUM untuk jenis kursi
    private enum JenisKursi {
        REGULER("R", 35000),
        VIP("V", 50000),
        VVIP("X", 75000);

        private final String kode;
        private final int harga;

        JenisKursi(String kode, int harga) {
            this.kode = kode;
            this.harga = harga;
        }

        public int getHarga() {
            return harga;
        }

        public static JenisKursi fromKode(String kode) {
            for (JenisKursi kursi : values()) {
                if (kursi.kode.equalsIgnoreCase(kode)) {
                    return kursi;
                }
            }
            return null;
        }
    }
}
