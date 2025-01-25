package utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PDFGenerator {

    private static final String PDF_DIR = "pdf";
    private static final float MARGIN = 40f;

    public enum ReportType {
        TRANSAKSI("transaksi"),
        KOMPUTER("komputer"),
        PELANGGAN("pelanggan");

        private final String prefix;

        ReportType(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    private static void createPDFDirectory() {
        File directory = new File(PDF_DIR);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private static String generateFileName(ReportType type) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return String.format("laporan_%s_%s.pdf",
                type.getPrefix(),
                timestamp);
    }

    public static void generatePDF(ReportType type, String title, JTable table) {
        try {
            createPDFDirectory();
            String pdfPath = PDF_DIR + File.separator + generateFileName(type);

            Document document = new Document(PageSize.A4.rotate());
            document.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

            // Add header/footer
            writer.setPageEvent(new PdfPageEventHelper() {
                public void onEndPage(PdfWriter writer, Document document) {
                    try {
                        PdfContentByte cb = writer.getDirectContent();
                        Font footerFont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC);

                        // Add page number
                        String pageText = "Halaman " + writer.getPageNumber();
                        Phrase footer = new Phrase(pageText, footerFont);
                        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                                footer,
                                (document.right() - document.left()) / 2 + document.leftMargin(),
                                document.bottom() - 20, 0);
                    } catch (Exception e) {
                        // Handle error silently
                    }
                }
            });

            document.open();

            // Add title with better formatting
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph titlePara = new Paragraph(title.toUpperCase(), titleFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            titlePara.setSpacingAfter(20);
            document.add(titlePara);

            // Add timestamp with better formatting
            Font timestampFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC);
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
            Paragraph timestamp = new Paragraph("Dibuat pada: " + sdf.format(new Date()), timestampFont);
            timestamp.setAlignment(Element.ALIGN_RIGHT);
            timestamp.setSpacingAfter(20);
            document.add(timestamp);

            // Create PDF table with better styling
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount() - 1);
            pdfTable.setWidthPercentage(100);
            pdfTable.setSpacingBefore(10f);
            pdfTable.setSpacingAfter(10f);

            // Improve header styling
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            for (int i = 1; i < table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i), headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(new BaseColor(51, 51, 51));
                cell.setPadding(8);
                pdfTable.addCell(cell);
            }

            // Improve data styling
            Font dataFont = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 1; j < table.getColumnCount(); j++) {
                    Object value = table.getValueAt(i, j);
                    PdfPCell cell = new PdfPCell(new Phrase(value != null ? value.toString() : "", dataFont));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setPadding(6);
                    cell.setMinimumHeight(25f);

                    // Alternate row colors
                    if (i % 2 == 0) {
                        cell.setBackgroundColor(new BaseColor(240, 240, 240));
                    }

                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable);
            document.close();

            ValidationUtils.showSuccess(null, "PDF berhasil dibuat: " + pdfPath);

            // Confirmation dialog before opening PDF
            int option = JOptionPane.showConfirmDialog(
                    null,
                    "Apakah Anda ingin membuka file PDF sekarang?",
                    "Buka PDF",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    java.awt.Desktop.getDesktop().open(new java.io.File(pdfPath));
                } catch (Exception e) {
                    ValidationUtils.showError(null, "Tidak dapat membuka file PDF: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            ValidationUtils.showError(null, "Error generating PDF: " + e.getMessage());
        }
    }

    // Overloaded method for backward compatibility
    public static void generatePDF(String title, String filename, JTable table) {
        generatePDF(ReportType.TRANSAKSI, title, table);
    }
}
