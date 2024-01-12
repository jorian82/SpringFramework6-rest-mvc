package com.ssde.tutorials.restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jra, SSDE, Inc
 * on Sat 1/6/24 at 10:17 PM. rest-mvc
 */
@Builder
@Data
public class CustomerDTO {
    private UUID id;
    private String name;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
