package entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @auther lyh
 * @create 2023-07-07
 */
public class homework {
    public Integer hno;
    public Integer tno;
    public Integer sno;
    private LocalDateTime deadlineTime;
    private String content;
    private Integer score;

    public Integer getHno() {
        return hno;
    }

    public homework setHno(Integer hno) {
        this.hno = hno;
        return this;
    }

    public Integer getTno() {
        return tno;
    }

    public homework setTno(Integer tno) {
        this.tno = tno;
        return this;
    }

    public Integer getSno() {
        return sno;
    }

    public homework setSno(Integer sno) {
        this.sno = sno;
        return this;
    }

    public LocalDateTime getDeadlineTime() {
        return deadlineTime;
    }

    public homework setDeadlineTime(LocalDateTime deadlineTime) {
        this.deadlineTime = deadlineTime;
        return this;
    }

    public String getContent() {
        return content;
    }

    public homework setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public homework setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        return "homework{" +
                "hno=" + hno +
                ", tno=" + tno +
                ", sno=" + sno +
                ", deadlineTime=" + deadlineTime +
                ", content='" + content + '\'' +
                ", score=" + score +
                '}';
    }
}
