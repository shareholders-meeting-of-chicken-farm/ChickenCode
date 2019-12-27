package leetcode_1235;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class solution_momo262_v0 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        JobInfo[] jobInfos = new JobInfo[startTime.length];
        for (int i=0;i<startTime.length;i++) {
            jobInfos[i] = new JobInfo(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobInfos, new Comparator<JobInfo>() {
            @Override
            public int compare(JobInfo o1, JobInfo o2) {
                return o1.end - o2.end;
            }
        });

        int[] scores = new int[jobInfos.length];
        scores[0] = jobInfos[0].profit;

        for (int i=1;i<jobInfos.length;i++) {
            JobInfo currentJob = jobInfos[i];
            int previousIndex = i-1;

            while (previousIndex>=0) {
                if (currentJob.start >= jobInfos[previousIndex].end) {
                    break;
                }
                previousIndex--;
            }
            if (previousIndex < 0 ) {
                scores[i] = Math.max(scores[i-1],jobInfos[i].profit);
            } else {
                scores[i] = Math.max(scores[i-1],jobInfos[i].profit + scores[previousIndex]);
            }
        }
        return scores[jobInfos.length - 1];
    }

    private class JobInfo {
        private int start;
        private int end;
        private int profit;

        public JobInfo(int start,int end,int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
