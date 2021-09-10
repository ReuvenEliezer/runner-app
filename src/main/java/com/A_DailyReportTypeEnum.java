package com;

public enum A_DailyReportTypeEnum implements ReportType {
    T1(T1_Report.class, "T1_Report");
//    T2(T2_Report.class,"T2_Report");


    private Class<? extends ReportGenerator> reportClass;
    private String reportName;

    A_DailyReportTypeEnum(Class<? extends ReportGenerator > reportClass, String reportName) {
        this.reportClass = reportClass;
        this.reportName = reportName;
    }

    @Override
    public String getReportName() {
        return reportName;
    }

    @Override
    public Class<? extends ReportGenerator> getReportClass() {
        return reportClass;
    }
}
