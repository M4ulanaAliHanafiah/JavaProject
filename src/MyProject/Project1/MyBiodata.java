package MyProject.Project1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyBiodata {
    public static void main(String[] args) {
        
        // Deklarasi Variable
        String nama, hobi, waktuFormat;
        int umur;

        // Membuat objek Scanner untuk input dari keyboard
        Scanner input = new Scanner(System.in);
        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        // Mengambil data nama, hobi, dan umur dari pengguna
        System.out.println("----------BIODATA----------");
        System.out.print("Nama : ");
        nama = input.nextLine();
        System.out.print("Hobi : ");
        hobi = input.nextLine();
        System.out.print("Umur : ");
        umur = input.nextInt();

        // Memformat waktu menjadi format dd-MM-yyyy
        waktuFormat = waktuSekarang.format(formatter);
        System.out.println("Waktu saat ini: " + waktuFormat);
        

        // Membuat Output
        System.out.println("-------------------------");
        System.out.println("Nama : " + nama);
        System.out.println("Hobi : " + hobi);
        System.out.println("Umur : " + umur + " Tahun");
        System.out.println("Umur tahun depan: " + (umur + 1) + " Tahun");


        input.close();
    }
}
