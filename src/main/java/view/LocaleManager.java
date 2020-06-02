package view;

import java.util.Locale;
import java.util.ResourceBundle;

class LocaleManager {
    private static final String BUNDLE_NAME = "messages";
    private final ResourceBundle resourceBundle;

    LocaleManager(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    String getString(String text) {
        return resourceBundle.getString(text);
    }

}
