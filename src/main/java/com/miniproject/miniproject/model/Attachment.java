package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "Attachment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    @Column(name = "attachmentId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "fileUrl")
    private String fileUrl;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "uploadAt")
    private Timestamp uploadAt;

    //Realationship
}
