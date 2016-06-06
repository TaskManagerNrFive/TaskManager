package lv.javaguru.java2.servlet.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by NightStranger on 6/3/2016.
 */
public class AllTasksFilterState {

    private long userId;
    private long teamId;
    private long status;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String formString(List<FilterItem> users, List<FilterItem> teams,
                             List<FilterItem> statuses) {
        String str = "";
        if (userId != 0) str = str + "User: " + getValueFromList(userId, users) + "     ";
        if (teamId != 0) str = str + "Team: " + getValueFromList(teamId, teams) + "     ";
        if (status != 0) str = str + "Status: " + getValueFromList(status, statuses) + "     ";
        if (title.length() > 0) {
            str = str + "Title: " + title + "     ";
        }
        return str.trim();
    }

    public String formStringUser(List<FilterItem> statuses) {
        String str = "";
        if (status != 0) str = str + "Status: " + getValueFromList(status, statuses) + "     ";
        if (title.length() > 0) {
            str = str + "Title: " + title + "     ";
        }
        return str.trim();
    }

    public String getValueFromList(long id, List<FilterItem> list) {
        return list.stream()
                .filter(item -> item.getId() == id)
                .collect(Collectors.toList())
                .get(0)
                .getName();
    }

    public static List<FilterItem> formStatusFilterList() {
        List<FilterItem> currlist = new ArrayList();
        currlist.add(new FilterItem(0L, "--- all ---"));
        currlist.add(new FilterItem(1L, "Not done"));
        currlist.add(new FilterItem(2L, "Done"));
        return currlist;
    }

}
