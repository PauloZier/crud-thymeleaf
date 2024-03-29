package br.com.standard.util;

import javax.swing.text.MaskFormatter;

public class TextUtils {

    private TextUtils() {

    }

    public static String removeMasks(String text) {

        if (text == null || text.isEmpty() || text.isBlank())
            return "";

        return text.replaceAll("[^0-9a-zA-Zà-úÀ-Ú]", "");
    }

    public static String maskText(String text, String mask) {

        try {

            MaskFormatter formatter = new MaskFormatter(mask);

            formatter.setValueContainsLiteralCharacters(false);

            return formatter.valueToString(text);

        } catch (Exception ex) {

            return text;

        }
    }

    public static String maskPhone(String text) {

        text = removeMasks(text);

        switch (text.length()) {

        case 10:
            return maskText(text, "(##) ####-####");

        case 11:
            return maskText(text, "(##) #####-####");

        default:
            return text;
        }

    }

    public static String maskCep(String text) {

        text = removeMasks(text);

        if (text.length() == 8)
            return maskText(text, "#####-###");

        return text;
    }
}
