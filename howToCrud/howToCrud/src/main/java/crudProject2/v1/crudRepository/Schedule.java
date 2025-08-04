package crudProject2.v1.crudRepository;

import crudProject2.v1.dto.BaseEntity;
import crudProject2.v1.dto.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String scheduleName;
    String scheduleInfo;
    String authorName;
    String password;

    public Schedule() {
    }

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(String scheduleName, String scheduleInfo, String password, String authorName) {

        this.authorName = authorName;
        this.scheduleName = scheduleName;
        this.password = password;
        this.scheduleInfo = scheduleInfo;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Schedule(String scheduleName, String authorName){
        this.authorName = authorName;
        this.scheduleName = scheduleName;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public LocalDateTime getModifiedAt() {
        return super.getModifiedAt();
    }
}
