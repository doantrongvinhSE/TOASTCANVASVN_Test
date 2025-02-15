package com.doanvinh.test.api.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BookDelReq {
    @NotNull
    private List<Long> ids;
}
