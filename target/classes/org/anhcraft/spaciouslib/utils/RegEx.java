package org.anhcraft.spaciouslib.utils;

import java.util.regex.Pattern;

/**
 * A utility class which has useful RegEx checkers
 */
public enum RegEx {
    JSON("^(\\{)(|.*)(\\})$"),
    URL("^(https?|ftp|file):(\\/{1,})((?!-)([-a-zA-Z0-9]{1,})(?<!-))\\.((?!-)([-a-zA-Z0-9]{1,})).*$"),
    EMAIL("^[A-Za-z0-9\\.\\-\\_]+@[A-Za-z0-9\\-\\_]+\\.[A-Za-z0-9\\-\\_]+$"),
    REAL_NUMBER("(^(-|\\+|)[0-9]+$)|(^(-|\\+|)[0-9]+\\.[0-9]+$)"),
    POSITIVE_REAL_NUMBER("(^(\\+|)[0-9]+$)|(^(\\+|)[0-9]+\\.[0-9]+$)"),
    NEGATIVE_REAL_NUMBER("(^-[0-9]+$)|(^-[0-9]+\\.[0-9]+$)"),
    INTEGER("^(-|\\+|)[0-9]+$"),
    POSITIVE_INTEGER("^(\\+|)[0-9]+$"),
    NEGATIVE_INTEGER("^-[0-9]+$"),
    UUID("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"),

    // https://stackoverflow.com/a/25969006
    IP_V4("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"),

    // https://stackoverflow.com/a/17871737
    IP_V6("(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))");

    private String regex;

    RegEx(String regex){
         this.regex = regex;
    }

    public String getRegEx(){
        return this.regex;
    }

    /**
     * Checks does the given string match the RegEx
     * @param str the string
     * @return true if matches
     */
    public boolean matches(String str){
        return Pattern.compile(this.regex).matcher(str).matches();
    }
}
