/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.util;

/**
 *
 * @author oalvarez
 */
public class StringManager {

    public static String Left(String text, int length) {
        return (text.length() < length) ? text : text.substring(0, length);
    }

    public static String Right(String text, int length) {
        return (text.length() < length) ? text : text.substring(text.length() - length, length);
    }

    public static String Mid(String text, int start, int end) {
        return (text.length() < end + 1) ? text.substring(start, text.length() - 1) : text.substring(start, end);
    }

    public static String Mid(String text, int start) {
        return (text.length() < start + 1) ? "" : text.substring(start, text.length() - start);
    }
}
