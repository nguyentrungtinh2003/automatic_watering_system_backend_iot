package com.TrungTinhBackend.automatic_watering_system_backend_iot.models;

import lombok.Data;

import java.util.List;

@Data
public class ThinkSpeakResponse {

    private Channel channel;
    private List<Feed> feeds;

    @Data
    public static class Channel {
        private Long id;
        private String name;
        private String field1;
        private String field2;
    }

    @Data
    public static class Feed {
        private String created_at;
        private String field1; // Chắc chắn rằng field1 và field2 là kiểu String
        private String field2; // Vì API trả về dữ liệu kiểu chuỗi

        // Không cần getter và setter vì @Data đã tự động tạo chúng
    }
}
