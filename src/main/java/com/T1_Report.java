package com;

import java.time.LocalDate;

public class T1_Report implements ReportGenerator {
    @Override
    public String getReportType() {
        return A_DailyReportTypeEnum.T1.getReportName();
    }

    @Override
    public boolean isEnable() {
        return true;
    }

    @Override
    public void generateReport(LocalDate localDate) {
        System.out.println("generateReport: " +this.getClass().getSimpleName());
    }
}
