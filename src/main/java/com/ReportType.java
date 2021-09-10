package com;

public interface ReportType {
    String getReportName();
    Class<? extends ReportGenerator> getReportClass();
}
