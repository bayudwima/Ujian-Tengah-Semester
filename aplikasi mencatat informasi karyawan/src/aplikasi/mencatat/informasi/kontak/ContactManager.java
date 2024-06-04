/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.mencatat.informasi.kontak;

/**
 *
 * @author Wija
 */
import java.util.Scanner;

class Contact {
    private String nama;
    private String id_karyawan;
    private String jabatan;
    private String umur;

    public Contact(String nama, String id_karyawan, String jabatan, String umur) {
        this.nama = nama;
        this.id_karyawan = id_karyawan;
        this.jabatan = jabatan;
        this.umur = umur;
    }

    public String getnama() {
        return nama;
    }

    public String getid_karyawan() {
        return id_karyawan;
    }

    public String getjabatan() {
        return jabatan;
    }

    public String getumur () {
        return umur;
    }

    public void setnama(String nama) {
        this.nama = nama;
    }

    public void setid_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public void setjabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setUmur (String umur) {
        this.umur = umur;
    }
}

public class ContactManager {
    private static final int MAX_CONTACTS = 100;
    private Contact[] contacts;
    private int numContacts;

    public ContactManager() {
        contacts = new Contact[MAX_CONTACTS];
        numContacts = 0;
    }

    public void addContact(Contact contact) {
        if (numContacts < MAX_CONTACTS) {
            contacts[numContacts++] = contact;
            System.out.println("Data Kontak Karyawan Sudah Ditambahkan!");
        } else {
            System.out.println("Data Kontak Karyawan !");
        }
    }

    public void displayContacts() {
        for (int i = 0; i < numContacts; i++) {
            System.out.println("Contact " + (i + 1));
            System.out.println("Nama: " + contacts[i].getnama());
            System.out.println("id_karyawan: " + contacts[i].getid_karyawan());
            System.out.println("jabatan: " + contacts[i].getjabatan());
            System.out.println("umur: " + contacts[i].getumur());
            System.out.println("-------------------------");
        }
    }

    public void modifyContact(int index, Contact newContact) {
        if (index >= 0 && index < numContacts) {
            contacts[index] = newContact;
            System.out.println("Data Kontak Karyawan Sudah Berubah!");
        } else {
            System.out.println("Data Kontak Karyawan Eror!");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < numContacts) {
            for (int i = index; i < numContacts - 1; i++) {
                contacts[i] = contacts[i + 1];
            }
            numContacts--;
            System.out.println("Data Kontak Karyawan Sudah Dihapuskan!");
        } else {
            System.out.println("Data Kontak Karyawan Eror!");
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Data Kontak Karyawan PT. XXX:");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Lihat Kontak");
            System.out.println("3. Ubah Kontak");
            System.out.println("4. Hapus Kontak");
            System.out.println("5. Kembali");
            System.out.print("Masukan Pilihan Anda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Masukan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukan ID Karyawan: ");
                    String id_karyawan = scanner.nextLine();
                    System.out.print("Masukan Jabatan: ");
                    String jabatan = scanner.nextLine();
                    System.out.print("Masukan Umur: ");
                    String umur = scanner.nextLine();
                    Contact newContact = new Contact(nama, id_karyawan, jabatan, umur);
                    contactManager.addContact(newContact);
                    break;
                case 2:
                    contactManager.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukan Data Kontak Yang Akan Diubah: ");
                    int modifyIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline character
                    System.out.print("Masukan Nama: ");
                    String newNama = scanner.nextLine();
                    System.out.print("Masukan ID Karyawan: ");
                    String newId_karyawan = scanner.nextLine();
                    System.out.print("Masukan Jabatan: ");
                    String newJabatan = scanner.nextLine();
                    System.out.print("Masukan Umur: ");
                    String newUmur= scanner.nextLine();
                    Contact modifiedContact = new Contact(newNama, newId_karyawan, newJabatan, newUmur);
                    contactManager.modifyContact(modifyIndex, modifiedContact);
                    break;
                case 4:
                    System.out.print("Masukan Data Yang Akan Dihapus: ");
                    int deleteIndex = scanner.nextInt();
                    contactManager.deleteContact(deleteIndex);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Kembali Data Kontak Karyawan...");
                    break;
                default:
                    System.out.println("Masukan Pilihan.");
                    break;
            }
        }

        scanner.close();
    }
}
