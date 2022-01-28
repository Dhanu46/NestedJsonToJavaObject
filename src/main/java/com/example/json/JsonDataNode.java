package com.example.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonDataNode {

    @JsonProperty("destination_addresses")
    private List<String> destinationAddress;
    @JsonProperty("origin_addresses")
    private List<String> originAddresses;
    @JsonProperty("status")
    private String status;
    @JsonProperty("rows")
    private List<Row> rows;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    static class Row {
        @JsonProperty("elements")
        private List<Element> elements;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Data
        static class Element {
            @JsonProperty("distance")
            private Distance distance;

            @JsonProperty("status")
            private String status;

            @JsonIgnoreProperties(ignoreUnknown = true)
            @Data
            static class Distance {

                @JsonProperty("text")
                private String Text;

                @JsonProperty("value")
                private int Value;

                @JsonProperty("duration")
                private Duration duration;

                @JsonIgnoreProperties(ignoreUnknown = true)
                @Data
                static class Duration {
                    @JsonProperty("text")
                    private String Text;

                    @JsonProperty("value")
                    private int Value;

                }
            }
        }
    }
}
