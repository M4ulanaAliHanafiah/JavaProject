package MyProject.Project1;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Project1 {

    public static void main(String[] args) {

        // Deklarasi Variable
        String nama, hobi, waktuFormat;
        int umur;

        // Membuat objek Scanner untuk input dari keyboard
        Scanner inputData = new Scanner(System.in);
        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        // Mengambil data nama, hobi, dan umur dari pengguna
        System.out.println("----------BIODATA----------");
        System.out.print("Nama : ");
        nama = inputData.nextLine();
        System.out.print("Hobi : ");
        hobi = inputData.nextLine();
        System.out.print("Umur : ");
        umur = inputData.nextInt();
        waktuFormat = waktuSekarang.format(formatter);
        System.out.println("Waktu saat ini: " + waktuFormat);
        

        // Membuat Output
        System.out.println("-------------------------");
        System.out.println("Nama : " + nama);
        System.out.println("Hobi : " + hobi);
        System.out.println("Umur : " + umur + " Tahun");
        System.out.println("Umur tahun depan: " + (umur + 1) + " Tahun");


        inputData.close();
    }
}