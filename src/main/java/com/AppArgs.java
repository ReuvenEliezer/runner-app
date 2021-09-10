package com;

import picocli.CommandLine.*;

public class AppArgs {

    @Parameters(paramLabel = "Report Group")
    private ReportGroupType reportGroupType;

    @Option(names = {"-d"}, paramLabel = "Report Date")
    private String reportDate;

    @Option(names = {"-r"}, paramLabel = "Report(s)")
    private String reportList;

    public ReportGroupType getReportGroupType() {
        return reportGroupType;
    }

    public String getReportDate() {
        return reportDate;
    }

    public String getReportList() {
        return reportList;
    }

    @Override
    public String toString() {
        return "AppArgs{" +
                "reportGroupType=" + reportGroupType +
                ", reportDate='" + reportDate + '\'' +
                ", reportList='" + reportList + '\'' +
                '}';
    }
}
