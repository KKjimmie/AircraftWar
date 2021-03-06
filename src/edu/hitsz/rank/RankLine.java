package edu.hitsz.rank;

/**
 * 排行榜数据类
 * @author 柯嘉铭
 */
public class RankLine implements Comparable<RankLine> {
    private String name;
    private int score;
    private String time;

    public RankLine(String name, int score, String time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  name + ',' + score + ',' + time;
    }

    @Override
    public int compareTo(RankLine o) {
        if (this.score != o.score) {
            return - (this.score - o.score);
        }else {
            return this.time.compareTo(o.time);
        }
    }
}
