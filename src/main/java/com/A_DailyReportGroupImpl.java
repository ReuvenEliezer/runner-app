package com;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

public class A_DailyReportGroupImpl extends AbstractReportGroup<A_DailyReportTypeEnum> {
    @Override
    public void generateReport(RunnerParams params) {
        Set<A_DailyReportTypeEnum> matchingReports = getMatchingReports(EnumSet.allOf(A_DailyReportTypeEnum.class), params);

        generateReport(params.getLocalDate(),matchingReports);

    }


}
