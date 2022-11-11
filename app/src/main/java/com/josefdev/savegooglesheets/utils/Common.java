package com.josefdev.savegooglesheets.utils;

import com.josefdev.savegooglesheets.models.GoogleSheetsResponse;
import com.josefdev.savegooglesheets.models.IGoogleSheets;

public class Common {

    // https://script.google.com/macros/s/AKfycbxEn88z1PfL8EKQSl0SILDmyOOMkVkGIo-aGE4P3_Eau0JSPVBb_lF9ZQeQubQYD1InYA/exec
    //  113S5_OJX1ZLpN4Bsu945keqmTPquBddX0Zt0DmF8jfs


    // public static String BASE_URL = "https://script.google.com/macros/s/AKfycbxGedH2kA6oKVXZfqnxpI1GYUN64bhOtcUXHlPgCOrRzrkLe1hmemYw4CLyxcA055gfvg/";
    // public static String GOOGLE_SHEET_ID = "1iMiaZyx7zKYY-2wncLKm-WSQllWYKBxG_qpx3R3j9pE";

    public static String BASE_URL = "https://script.google.com/macros/s/AKfycbxEn88z1PfL8EKQSl0SILDmyOOMkVkGIo-aGE4P3_Eau0JSPVBb_lF9ZQeQubQYD1InYA/";
    public static String GOOGLE_SHEET_ID = "113S5_OJX1ZLpN4Bsu945keqmTPquBddX0Zt0DmF8jfs";
    public static String SHEET_NAME = "personas";

    public static IGoogleSheets iGSGetMethodClient(String baseUrl) {
        return GoogleSheetsResponse.getClientGetMethod(baseUrl)
                .create(IGoogleSheets.class);
    }
}
