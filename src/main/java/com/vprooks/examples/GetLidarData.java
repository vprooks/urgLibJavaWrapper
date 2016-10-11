package com.vprooks.examples;

import com.sun.jna.NativeLong;
import com.sun.jna.ptr.NativeLongByReference;
import com.vprooks.urgLibJavaWrapper.UrgLib;
import com.vprooks.urgLibJavaWrapper.urg_t;

public class GetLidarData {
    public static void main(String[] args) {
        // Connect to serial device
        int connection_type = UrgLib.urg_connection_type_t.URG_SERIAL;
        String device_name = "/dev/ttyACM0"; // <- platform-specific
        NativeLong baudrate = new NativeLong(115200L);
        // Get reference to the wrapper
        UrgLib lib = UrgLib.INSTANCE;
        // Create instance of the `urg_t` struct
        urg_t urg = new urg_t();

        // Open the library
        int open_result = lib.urg_open(urg, connection_type, device_name, baudrate);
        if (open_result < 0) {
            String err = lib.urg_error(urg);
            throw new RuntimeException("Error connecting to lidar" + err);
        }

        // Get size of the data and allocate the data array
        int max_data_size = lib.urg_max_data_size(urg);
        System.out.format("Max data size: %d x %d", max_data_size, NativeLong.SIZE);
        long[] data = new long[max_data_size * NativeLong.SIZE];

        // create a variable to store time stamps
        NativeLongByReference time_stamp = new NativeLongByReference();

        // Start measurement
        lib.urg_start_measurement(urg, UrgLib.urg_measurement_type_t.URG_DISTANCE, UrgLib.URG_SCAN_INFINITY, 0);
        int CAPTURE_TIMES = 10;
        for (int i = 0; i < CAPTURE_TIMES; i++) {
            // Get distance measurements
            lib.urg_get_distance(urg, data, time_stamp);
            System.out.format("[%d]: %d %d %d ...", time_stamp.getValue().longValue(), data[0], data[1], data[2]);
        }


        // Stop measurement
        lib.urg_stop_measurement(urg);
        // Close the library
        lib.urg_close(urg);
    }
}
