package utils;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.util.Date;

public class ValidationUtils {
    
    public static boolean isEmptyField(JTextField field) {
        return field.getText().trim().isEmpty();
    }
    
    public static boolean isEmptyField(JTextArea area) {
        return area.getText().trim().isEmpty();
    }
    
    public static boolean isValidPhone(String phone) {
        return phone.matches("^[0-9]{10,13}$");
    }
    
    public static boolean isValidNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isValidDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) return false;
        return date2.after(date1);
    }
    
    public static void showError(java.awt.Component parent, String message) {
        javax.swing.JOptionPane.showMessageDialog(
            parent,
            message,
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    
    public static void showSuccess(java.awt.Component parent, String message) {
        javax.swing.JOptionPane.showMessageDialog(
            parent,
            message,
            "Sukses",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    }
}
