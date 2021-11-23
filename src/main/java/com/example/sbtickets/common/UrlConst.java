package com.example.sbtickets.common;


/**
 * @author CuongNv
 * Khai báo đường dẫn
 */
public class UrlConst {
    /**
     * @author CuongNv
     * Class khai báo URL hệ thống Sbtickets
     */

    /**
     * Home url hệ thống Sbtickets
     */
    public static final String HOME = "/Sbtickets";

    /**
     * API login hệ thống Sbtickets
     */
    public static final String LOGIN_SBTICKETS = HOME + "/login";
    public static final String LOGIN_CUSTOMER = HOME + "/loginCus";
    public static final String REGISTER_CUSTOMER =HOME + "/registerCus";

    /**
     * API getAllDriver CuongNv
     */
    public static final String GET_DRIVER = HOME + "/getDriver";

    public static final String GET_DRIVER_BY_ID = HOME + "/getDriver/{id}";

    /**
     * API find name Driver CuongNv
     */
    public static final String FIND_DRIVER = HOME + "/findDriver";

    public static final String CREATE_DRIVER = HOME + "/createDriver";

    public static final String UPDATE_DRIVER = HOME + "/updateDriver/{id}";

    public static final String DELETE_DRIVER = HOME + "/deleteDriver/{id}";

    public static final String DELETE_DRIVERS = HOME + "/deleteDrivers";

    public static final String EXPORT_EXCEL_ALL_DRIVER = HOME + "/driver/excelAll";

    /**
     * API getAllBus SonPK
     */
    public static final String GET_BUS = HOME + "/getBus";

    public static final String FIND_BUS = HOME + "/findBus";

    public static final String CREATE_BUS = HOME + "/createBus";

    public static final String UPDATE_BUS = HOME + "/updateBus/{id}";

    public static final String DELETE_BUS = HOME + "/deleteBus/{id}";

    /**
     * API find name Line Bus HaLv
     */
    public static final String GET_LINE_BUS = HOME + "/getLineBus";

    public static final String FIND_LINE_BUS = HOME + "/findLineBus";

    public static final String CREATE_LINE_BUS = HOME + "/createLineBus";

    public static final String UPDATE_LINE_BUS = HOME + "/updateLineBus/{id}";

    public static final String DELETE_LINE_BUS = HOME + "/deleteLineBus/{id}";

    public static final String GET_BOOK = HOME + "/getBook";

    public static final String GET_CLOTHES = HOME +"/getClothes";

    public static final String CREATE_CLOTHES = HOME + "/createClothes";

    public static final String GET_CLOTHES_BY_ID = HOME + "/getClothesById/{id}";

    public static final String UPDATE_CLOTHES = HOME + "/updateClothes/{id}";

    public static final String DELETE_CLOTHES = HOME + "/deleteClothes/{id}";

    public static final String FIND_CLOTHES = HOME + "/findClothes";

    public static final String DELETE_CLOTHES_S = HOME + "/deleteClothesS";

    public static final String GET_ELECTRONIC = HOME + "/electronic";

    public static final String GET_SHOE = HOME + "/shoe";
}
