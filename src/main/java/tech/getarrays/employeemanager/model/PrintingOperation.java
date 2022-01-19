package tech.getarrays.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PrintingOperation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private  String fileUrl;
    private int numberofCopy;
    @ManyToOne//(cascade = CascadeType.ALL
    //OnCascade delete
    //) // default fetch EAGER
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;



    public PrintingOperation(String fileUrl, int numberofCopy, Teacher teacher ) {
        this.fileUrl = fileUrl;
        this.numberofCopy = numberofCopy;

        this.teacher = teacher;
    }

    public PrintingOperation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public int getNumberofCopy() {
        return numberofCopy;
    }

    public void setNumberofCopy(int numberofCopy) {
        this.numberofCopy = numberofCopy;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



    @Override
    public String toString() {
        return "PrintingOperation{" +
                "id=" + id +
                ", fileUrl='" + fileUrl + '\'' +
                ", numberofCopy=" + numberofCopy +
                ", teacher=" + teacher +

                '}';
    }
}
