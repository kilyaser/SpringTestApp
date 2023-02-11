package com.arcadag.SpringQuizApp.dtos;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReportDto {
    List<ReportItem> reportItems;
    public ReportDto() {
        this.reportItems = new ArrayList<>();
    }

}
