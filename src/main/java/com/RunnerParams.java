package com;

import picocli.CommandLine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class RunnerParams {

    private ReportGroupType reportGroupType;
    private LocalDate localDate;
    private Set<String> reports;


    public static RunnerParams parseFrom(String[] args) {
        AppArgs appArgs = new AppArgs();
        try {
            new CommandLine(appArgs).parseArgs(args);
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid arguments", e);
        }

        RunnerParams params = new RunnerParams();

        params.reportGroupType = appArgs.getReportGroupType();

        ReportGroupType reportGroupType = params.getReportGroupType();

        String reportDateArgs = appArgs.getReportDate();
        switch (reportGroupType) {
            case A_DAILY:
                params.setLocalDate(reportDateArgs != null ? LocalDate.parse(reportDateArgs, DateTimeFormatter.ofPattern("dd-MM-yyyy")) : LocalDate.now());
                break;
            case A_MONTHLY:
                break;
        }
        return params;
    }

    public ReportGroupType getReportGroupType() {
        return reportGroupType;
    }

    public void setReportGroupType(ReportGroupType reportGroupType) {
        this.reportGroupType = reportGroupType;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Set<String> getReports() {
        return reports;
    }

    public void setReports(Set<String> reports) {
        this.reports = reports;
    }
}
