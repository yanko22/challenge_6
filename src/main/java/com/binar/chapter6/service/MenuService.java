//package com.binar.chapter6.service;
//
//import com.binar.chapter6.model.Films;
//import com.binar.chapter6.model.Schedules;
//import com.binar.chapter6.model.Seats;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Scanner;
//
//@Service
//public class MenuService implements CommandLineRunner {
//
//    @Autowired
//    FilmsServiceImpl filmsServiceImpl;
//    @Autowired
//    UsersServiceImpl usersServiceImpl;
//
//    @Override
//    public void run(String... args) throws Exception {
//        mainMenu();
//    }
//
//    public void mainMenu() {
//        System.out.println("+=================================================+");
//        System.out.println("|         Selamat Datang di Aplikasi Kami         |");
//        System.out.println("+=================================================+");
//        System.out.println("|  1. Tampilkan film yang sedang tayang saat ini  |");
//        System.out.println("|  2. Tampilkan jadwal, studio dan harga tiket    |");
//        System.out.println("|  3. Tampilkan kursi yang masih tersedia         |");
//        System.out.println("|  4. Lakukan reservasi tiket                     |");
//        System.out.println("|  0. Keluar Aplikasi                             |");
//        System.out.println("+=================================================+");
//
//        Scanner scan = new Scanner(System.in);
//        System.out.print("=> ");
//        byte input = scan.nextByte();
//        scan.nextLine();
//
//        if (input == 1) {
//            showFilm();
//            System.out.print("Tekan enter untuk balik ke menu utama <_____|");
//            scan.nextLine();
//            mainMenu();
//        }
//        else if (input == 2) {
//            showScheduleStudioTicket();
//            System.out.print("Tekan enter untuk balik ke menu utama <_____|");
//            scan.nextLine();
//            mainMenu();
//        }
//        else if (input == 3) {
//            showAvailableSeat();
//            System.out.print("Tekan enter untuk balik ke menu utama <_____|");
//            scan.nextLine();
//            mainMenu();
//        }
//        else if (input == 4) {
//            ticketReservation();
//            System.out.print("Tekan enter untuk balik ke menu utama <_____|");
//            scan.nextLine();
//            mainMenu();
//        }
//        else if (input == 0) {
//            System.out.println("\u001B[32m" + "===Anda keluar dari aplikasi, terimakasih===" + "\u001B[0m");
//            System.exit(0);
//        }
//        else {
//            System.out.println("\u001B[31m" + "===Pilihan yang anda input tidak tersedia===" + "\u001B[0m");
//            System.out.print("Tekan enter untuk balik ke menu utama <_____|");
//            scan.nextLine();
//            mainMenu();
//        }
//    }
//
//    public void showFilm() {
//        Films films = filmsServiceImpl.getFilm();
//            System.out.format("%d | %s\n",
//                    films.getFilmCode(), films.getFilmName());
//        }
//
//    public void showScheduleStudioTicket() {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Masukkan kode film : ");
//        Integer byCode = scan.nextInt();
//        Schedules schedules = filmsServiceImpl.getScheduleDate();
//        List<Seats> listSeat = filmsServiceImpl.getStudioSeatStatus();
//        for (Seats seats : listSeat) {
//            System.out.format("%s | %s | %s | %s | Rp.%d\n",
//                    schedules.getPlayingDate(), schedules.getStartingTime(), schedules.getEndingTime(), seats.getStudioName(), schedules.getTicketPrice());
//        }
//    }
//
//    public void showAvailableSeat () {
//        List<Seats> availableSeat = filmsServiceImpl.getStudioSeatStatus();
//        for (Seats seats : availableSeat) {
//            System.out.format("%d | %d | %s | %s\n",
//                    seats.getSeatsId(), seats.getSeatNumber(), seats.getStudioName(), seats.getStatus());
//        }
//    }
//
//    public void ticketReservation () {
//        Integer menu;
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Silahkan pilih film yang ingin anda tonton : ");
//        scan.nextLine();
//        showFilm();
//        System.out.print("Silahkan pilih jadwal yang anda inginkan : ");
//        scan.nextLine();
//        showScheduleStudioTicket();
//        System.out.print("Silahkan pilih kursi yang anda inginkan : ");
//        scan.nextLine();
//        System.out.print("Masukkan nomor kursi : ");
//        String seatNumber = scan.nextLine();
//        System.out.print("Masukkan nama studio : ");
//        String studioName = scan.nextLine();
//        filmsServiceImpl.updateStatus(seatNumber, studioName, "not available");
//        System.out.print("Berikut adalah data reservasi tiket anda");
//        //belum jadi
//        System.out.print("Tekan enter untuk balik ke menu utama <_____|");
//        scan.nextLine();
//        mainMenu();
//    }
//}