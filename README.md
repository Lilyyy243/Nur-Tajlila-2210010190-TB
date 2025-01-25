# 🖥️ Aplikasi Manajemen Sewa PC
> Dikembangkan oleh Nur Tajlila (2210010190)

## 📋 Deskripsi
Aplikasi desktop yang dirancang khusus untuk mengelola persewaan komputer/PC dengan antarmuka yang user-friendly dan fitur lengkap untuk manajemen data pelanggan, komputer, dan transaksi penyewaan.

## 🌟 Fitur Utama

### 👥 Manajemen Pelanggan
- Input dan edit data pelanggan
- Pencarian data pelanggan
- Cetak laporan data pelanggan
- Validasi format nomor telepon
- Pengelolaan alamat pelanggan

### 💻 Manajemen Komputer
- Pendataan unit komputer
- Detail spesifikasi komputer
- Status ketersediaan unit
- Pencarian unit komputer
- Cetak laporan inventaris

### 📊 Sistem Penyewaan
- Pencatatan transaksi sewa
- Kalkulasi biaya otomatis
- Pemilihan pelanggan dan unit PC
- Penentuan periode sewa
- Cetak bukti transaksi
- Laporan penyewaan

## 🚀 Teknologi

- **Backend:** Java
- **Database:** MySQL
- **IDE:** NetBeans
- **Report:** iText PDF
- **UI:** Java Swing
- **Validasi:** Custom ValidationUtils

## 💻 Preview Aplikasi

### Menu Utama
```java
public class MainMenu extends javax.swing.JFrame {
    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
        // Window closing validation
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    null, "Apakah anda yakin ingin keluar?",
                    "Konfirmasi Keluar", 
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
```

### Contoh Validasi Input
```java
public class ValidationUtils {
    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10,13}");
    }
    
    public static boolean isValidDate(Date start, Date end) {
        return start.before(end);
    }
    
    public static boolean isValidNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
```

### Koneksi Database
```java
public class Koneksi {
    private static Connection conn;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost/db_sewapc";
                String user = "root";
                String password = "";
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return conn;
    }
}
```

### Generate PDF Report
```java
public class PDFGenerator {
    public static void generatePDF(String title, String filename, JTable table) {
        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("pdf/" + filename));
            document.open();
            
            // Add title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph titlePara = new Paragraph(title, titleFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            document.add(titlePara);
            
            // Add table data
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            // ... table generation code ...
            
            document.close();
        } catch (Exception e) {
            System.out.println("Error generating PDF: " + e.getMessage());
        }
    }
}
```

## 📷 Screenshot Aplikasi

### Menu Utama
![Main Menu](screenshots/main_menu.png)

### Form Penyewaan
![Rental Form](screenshots/rental_form.png)

### Laporan PDF
![PDF Report](screenshots/pdf_report.png)

## 📝 Cara Penggunaan

1. **Menu Utama**
   - Pilih menu Pelanggan, Komputer, atau Penyewaan
   - Navigasi antar form yang intuitif

2. **Pengelolaan Data**
   - Tambah data baru dengan form input
   - Edit data existing dengan klik baris tabel
   - Hapus data dengan konfirmasi
   - Cari data dengan fitur pencarian

3. **Transaksi Penyewaan**
   - Pilih pelanggan dari database
   - Pilih unit komputer yang tersedia
   - Set tanggal sewa dan pengembalian
   - Input total biaya sewa
   - Cetak bukti transaksi

4. **Laporan**
   - Generate laporan PDF untuk setiap modul
   - Format laporan yang rapi dan terstruktur
   - Preview laporan sebelum cetak

## 🔒 Keamanan
- Validasi input untuk semua form
- Konfirmasi untuk aksi penting
- Pencegahan duplikasi data

## 📄 Lisensi
© 2025 Nur Tajlila. All rights reserved.

---
💡 Untuk informasi lebih lanjut atau bantuan teknis, silakan hubungi pengembang.
