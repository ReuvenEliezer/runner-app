package com;

public class RunnerApp {

    public static void main(String[] args){
        RunnerParams params = RunnerParams.parseFrom(args);
        new RunnerApp().run(params);
    }

    private void run(RunnerParams params) {
        ReportGroup report = createReport(params);
        report.generateReport(params);
    }

    private ReportGroup createReport(RunnerParams params) {
        ReportGroupType reportGroupType = params.getReportGroupType();
        switch (reportGroupType){
            case A_DAILY :
                return new A_DailyReportGroupImpl();
            case B_DAILY:
//                return  new B_DailyGroupGenerator();
            case A_MONTHLY:
//                return   new A_MonthlyGroupGenerator();
        }
        return new A_DailyReportGroupImpl();
    }
}
